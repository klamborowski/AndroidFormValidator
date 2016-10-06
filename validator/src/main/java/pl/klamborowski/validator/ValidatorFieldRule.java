package pl.klamborowski.validator;

import java.util.regex.Pattern;

public interface ValidatorFieldRule {
    Pattern getValidationPattern();

    int getErrorResId();
}
