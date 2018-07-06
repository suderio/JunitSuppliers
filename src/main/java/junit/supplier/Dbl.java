package junit.supplier;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.junit.experimental.theories.ParametersSuppliedBy;

@Retention(RetentionPolicy.RUNTIME)
@ParametersSuppliedBy(DoubleSupplier.class)
public @interface Dbl {
    double min() default Double.MIN_VALUE;
    double max() default Double.MAX_VALUE;
    double[] value() default {};
    int qty() default 100;
}