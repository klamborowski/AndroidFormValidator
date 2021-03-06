package pl.klamborowski.validatorsample;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pl.klamborowski.validator.Validator;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.input_name)
    TextInputEditText inputName;
    @BindView(R.id.input_email)
    TextInputEditText inputEmail;
    @BindView(R.id.input_phone)
    TextInputEditText inputPhone;
    @BindView(R.id.validate_btn)
    Button            validateBtn;

    private Validator validator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setupValidator();
    }

    private void setupValidator() {
        validator = new Validator.Builder()
                .addField(inputName, ValidatorFieldRuleImpl.EMPTINESS)
                .addField(inputEmail, ValidatorFieldRuleImpl.EMPTINESS, ValidatorFieldRuleImpl.EMAIL)
                .addField(inputPhone, ValidatorFieldRuleImpl.EMPTINESS, ValidatorFieldRuleImpl.PHONE_NUMBER)
                .build();
    }

    @OnClick(R.id.validate_btn)
    void validate() {
        validator.validateFields();
    }
}
