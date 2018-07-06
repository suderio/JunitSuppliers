package junit.supplier;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.junit.experimental.theories.ParametersSuppliedBy;

@Retention(RetentionPolicy.RUNTIME)
@ParametersSuppliedBy(BigDecimalSupplier.class)
public @interface BigDcm {
    String min();
    String max();
    String[] value() default {};
    int precision() default 2;
    int qty() default 100;
}