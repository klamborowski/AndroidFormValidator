package pl.klamborowski.validator;

import android.support.design.widget.TextInputLayout;
import android.widget.EditText;

import java.util.HashMap;
import java.util.Map;

public class Validator {
    private Map<EditText, ValidatorFieldType[]> fieldsForValidation = new HashMap<>();

    private Validator(Builder builder) {
        addInputsForValidation(builder.fieldsForValidation);
    }

    public void addInputForValidation(EditText editText, ValidatorFieldType... fieldType) {
        this.fieldsForValidation.put(editText, fieldType);
    }

    public void addInputsForValidation(Map<EditText, ValidatorFieldType[]> fieldsForValidation) {
        this.fieldsForValidation.putAll(fieldsForValidation);
    }

    /**
     * @return true if all fields have correct values
     */
    public boolean validateFields() {
        return validateFields(true);
    }

    public boolean validateFields(boolean showErrors) {
        boolean success = true;

        for (EditText editText : fieldsForValidation.keySet()) {
            success &= validateField(editText, showErrors);
        }
        return success;
    }

    public boolean validateField(EditText editText) {
        return validateField(editText, true);
    }

    public boolean validateField(EditText editText, boolean showErrors) {
        TextInputLayout parent = null;
        if (showErrors) {
            if (editText.getParent() instanceof TextInputLayout) {
                parent = (TextInputLayout) editText.getParent();
                parent.setErrorEnabled(false);
            }
            editText.setError(null);
        }

        ValidatorFieldType[] validatorFieldTypes = fieldsForValidation.get(editText);
        if (validatorFieldTypes == null) {
            return true;
        }
        for (ValidatorFieldType validatorFieldType : validatorFieldTypes) {
            if (!validatorFieldType.getValidationPattern().matcher(editText.getText()).matches()) {
                if (showErrors) {
                    if (parent != null) {
                        parent.setError(editText.getContext().getString(validatorFieldType.getErrorResId()));
                    } else {
                        editText.setError(editText.getContext().getString(validatorFieldType.getErrorResId()));
                    }
                }
                return false;
            }
        }
        return true;
    }

    public static final class Builder {

        private Map<EditText, ValidatorFieldType[]> fieldsForValidation;

        public Builder() {
            fieldsForValidation = new HashMap<>();
        }

        public Builder addField(EditText editText, ValidatorFieldType... fieldType) {
            fieldsForValidation.put(editText, fieldType);
            return this;
        }


        public Validator build() {
            return new Validator(this);
        }
    }

}
