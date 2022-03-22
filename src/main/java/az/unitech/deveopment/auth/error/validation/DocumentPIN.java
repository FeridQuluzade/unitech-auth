package az.unitech.deveopment.auth.error.validation;

import az.unitech.deveopment.auth.error.validation.ErrorMessages;
import az.unitech.deveopment.auth.error.validation.Patterns;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Pattern;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Pattern(regexp = Patterns.DocumentPIN, message = ErrorMessages.DocumentPIN)
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Constraint(validatedBy = {})
public @interface DocumentPIN {

    String message() default ErrorMessages.DocumentPIN;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
