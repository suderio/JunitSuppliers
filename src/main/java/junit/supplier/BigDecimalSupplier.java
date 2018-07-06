package junit.supplier;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.junit.experimental.theories.ParameterSignature;
import org.junit.experimental.theories.ParameterSupplier;
import org.junit.experimental.theories.PotentialAssignment;

import com.mifmif.common.regex.Generex;

public class BigDecimalSupplier extends ParameterSupplier {
    @Override
    public List<PotentialAssignment> getValueSources(ParameterSignature sig) throws Throwable {
        List<PotentialAssignment> list = new ArrayList<>();
        BigDcm annotation = sig.getAnnotation(BigDcm.class);
        String min = annotation.min();
        String max = annotation.max();
        String expression = "[0-9]{" + min.split("\\.")[0].length() + "," + max.split("\\.")[0].length() + "}";
        Generex generex = new Generex(expression);
        BigDecimal value;
        BigDecimal biMin;
        BigDecimal biMax;
        MathContext mc = new MathContext(annotation.precision(), RoundingMode.HALF_UP);
        try {
            biMin = new BigDecimal(min, mc);
            biMax = new BigDecimal(max, mc);
            for (int i = 0; i < annotation.qty();) {
                if (annotation.value().length == 0) {
                    value = new BigDecimal(generex.random());
                } else {
                    value = new BigDecimal(annotation.value()[i % annotation.value().length]);
                }
                if (value.min(biMin).equals(biMin) && value.max(biMax).equals(biMax)) {
                    list.add(PotentialAssignment.forValue("BigInteger", value));
                    i++;
                }
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e);
        }
        return list;
    }
}