package junit.supplier;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.junit.experimental.theories.ParametersSuppliedBy;

@Retention(RetentionPolicy.RUNTIME)
@ParametersSuppliedBy(CnpjSupplier.class)
public @interface CNPJ {
    boolean formated() default false;
    int qty() default 100;
}