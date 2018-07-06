package junit.supplier;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.junit.experimental.theories.ParametersSuppliedBy;

@Retention(RetentionPolicy.RUNTIME)
@ParametersSuppliedBy(BigIntegerSupplier.class)
public @interface BigInt {
    String min();
    String max();
    String[] value() default {};
    int qty() default 100;
}