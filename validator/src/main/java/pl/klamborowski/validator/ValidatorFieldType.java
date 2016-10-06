package pl.klamborowski.validator;

import java.util.regex.Pattern;

public interface ValidatorFieldType {
    Pattern getValidationPattern();

    int getErrorResId();
}
