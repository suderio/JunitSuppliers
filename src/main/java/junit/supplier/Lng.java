package junit.supplier;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.junit.experimental.theories.ParametersSuppliedBy;

@Retention(RetentionPolicy.RUNTIME)
@ParametersSuppliedBy(LongSupplier.class)
public @interface Lng {
    long min() default Long.MIN_VALUE;
    long max() default Long.MAX_VALUE;
    long[] value() default {};
    int qty() default 100;
}