package junit.supplier;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.junit.experimental.theories.ParametersSuppliedBy;

@Retention(RetentionPolicy.RUNTIME)
@ParametersSuppliedBy(IntegerSupplier.class)
public @interface Int {
    int min() default Integer.MIN_VALUE;
    int max() default Integer.MAX_VALUE;
    int[] value() default {};
    int qty() default 100;
}