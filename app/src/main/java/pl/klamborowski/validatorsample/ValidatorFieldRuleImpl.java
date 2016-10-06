package pl.klamborowski.validatorsample;

import java.util.regex.Pattern;

import pl.klamborowski.validator.ValidatorFieldRule;

public enum ValidatorFieldRuleImpl implements ValidatorFieldRule {
    EMPTINESS {
        @Override
        public Pattern getValidationPattern() {
            return Pattern.compile("(\\s*\\S+\\s*)+");
        }

        @Override
        public int getErrorResId() {
            return R.string.validator_emptiness;
        }
    }, EMAIL {
        @Override
        public Pattern getValidationPattern() {
            return Pattern
                    .compile("^([\\w-]+(?:\\.[\\w-]+)*)@((?:[\\w-]+\\.)*\\w[\\w-]{0,85})\\.([a-z]{2,6}(?:\\.[a-z]{2})?)$");
        }

        @Override
        public int getErrorResId() {
            return R.string.validator_email_error;
        }
    }, PHONE_NUMBER {
        @Override
        public Pattern getValidationPattern() {
            return Pattern.compile("(^([+][0-9]{1,2}){0,1}([ ]{0,1}[0-9]{3}){3}$)*");
        }

        @Override
        public int getErrorResId() {
            return R.string.validator_phone_number_error;
        }
    }
}
