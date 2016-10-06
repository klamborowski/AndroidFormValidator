package pl.klamborowski.validatorsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pl.klamborowski.validator.Validator;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.input_name)
    EditText inputName;
    @BindView(R.id.input_email)
    EditText inputEmail;
    @BindView(R.id.input_phone)
    EditText inputPhone;
    @BindView(R.id.validate_btn)
    Button   validateBtn;

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
                .addField(inputName, ValidatorFieldTypeImpl.EMPTINESS)
                .addField(inputName, ValidatorFieldTypeImpl.EMPTINESS)
                .addField(inputName, ValidatorFieldTypeImpl.EMPTINESS)
                .build();
    }

    @OnClick(R.id.validate_btn)
    void validate() {
        validator.validateFields();
    }
}
