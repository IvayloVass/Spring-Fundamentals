package bg.softuni.spring.fundamentals.mobileLeLe.models.validation;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = UniqueUsernameValidation.class)
public @interface UniqueUsername {

    String message() default "Username is already occupied";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
