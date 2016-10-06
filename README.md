**Android Form Validator**

## Usage

Implement  ValidatorFieldRule i.e.:

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
        }
    }

Build your validator parring editTexts and ValidatorFieldRule (one or many):

    Validator validator = new Validator.Builder()
                .addField(inputName, ValidatorFieldRuleImpl.EMPTINESS)
                .addField(inputEmail, ValidatorFieldRuleImpl.EMPTINESS, ValidatorFieldRuleImpl.EMAIL, (..))
                .build();
                
And validate your form with

    validator.validateFields();



##Setup

**Maven**

    <dependency>
        <groupId>pl.klamborowski</groupId>
        <artifactId>validator</artifactId>
        <version>0.1.2</version>
        <type>aar</type>
    </dependency>
    
**Gradle**

    repositories {
        jcenter()
    }
    dependencies {
        compile 'pl.klamborowski:validator:0.1.2'
    }