package junit.supplier;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.junit.experimental.theories.ParametersSuppliedBy;

@Retention(RetentionPolicy.RUNTIME)
@ParametersSuppliedBy(StringSupplier.class)
public @interface Str {
    String regex() default ".*";
    String[] value() default {};
    int qty() default 100;
}