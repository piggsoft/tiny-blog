package com.piggsoft.tinyblog.validater;

import org.hibernate.validator.internal.util.Contracts;
import org.hibernate.validator.internal.util.logging.Log;
import org.hibernate.validator.internal.util.logging.LoggerFactory;
import org.hibernate.validator.internal.util.scriptengine.ScriptEvaluator;
import org.hibernate.validator.internal.util.scriptengine.ScriptEvaluatorFactory;

import javax.script.ScriptException;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Map;

import static org.hibernate.validator.internal.util.CollectionHelper.newHashMap;
import static org.hibernate.validator.internal.util.logging.Messages.MESSAGES;

public class PropertyScriptAssertValidator implements ConstraintValidator<PropertyScriptAssert, Object> {

    private static final Log log = LoggerFactory.make();

    private String script;
    private String languageName;
    private String alias;
    private String property;
    private String message;
    private ScriptEvaluator scriptEvaluator;

    @Override
    public void initialize(PropertyScriptAssert constraintAnnotation) {
        validateParameters(constraintAnnotation);

        this.script = constraintAnnotation.script();
        this.languageName = constraintAnnotation.lang();
        this.alias = constraintAnnotation.alias();
        this.property = constraintAnnotation.property();
        this.message = constraintAnnotation.message();
        this.scriptEvaluator = getScriptEvaluator(languageName);
    }

    private ScriptEvaluator getScriptEvaluator(String languageName) {
        try {
            ScriptEvaluatorFactory evaluatorFactory = ScriptEvaluatorFactory.getInstance();
            return evaluatorFactory.getScriptEvaluatorByLanguageName(languageName);
        } catch (ScriptException e) {
            throw log.getCreationOfScriptExecutorFailedException(languageName, e);
        }
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {

        Object evaluationResult;
        Map<String, Object> bindings = newHashMap();
        bindings.put(alias, value);
        try {
            evaluationResult = scriptEvaluator.evaluate(script, bindings);
        } catch (ScriptException e) {
            throw log.getErrorDuringScriptExecutionException(script, e);
        }

        if (evaluationResult == null) {
            throw log.getScriptMustReturnTrueOrFalseException(script);
        }
        if (!(evaluationResult instanceof Boolean)) {
            throw log.getScriptMustReturnTrueOrFalseException(
                    script,
                    evaluationResult,
                    evaluationResult.getClass().getCanonicalName()
            );
        }

        if (Boolean.FALSE.equals(evaluationResult)) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext
                    .buildConstraintViolationWithTemplate(message)
                    .addPropertyNode(property)
                    .addConstraintViolation();
        }

        return Boolean.TRUE.equals(evaluationResult);
    }

    private void validateParameters(PropertyScriptAssert constraintAnnotation) {
        Contracts.assertNotEmpty(constraintAnnotation.script(), MESSAGES.parameterMustNotBeEmpty("script"));
        Contracts.assertNotEmpty(constraintAnnotation.lang(), MESSAGES.parameterMustNotBeEmpty("lang"));
        Contracts.assertNotEmpty(constraintAnnotation.property(), MESSAGES.parameterMustNotBeEmpty("property"));
    }
}  