package junit.supplier;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.junit.experimental.theories.ParametersSuppliedBy;

@Retention(RetentionPolicy.RUNTIME)
@ParametersSuppliedBy(FloatSupplier.class)
public @interface Flt {
    float min() default Float.MIN_VALUE;
    float max() default Float.MAX_VALUE;
    float[] value() default {};
    int qty() default 100;
}