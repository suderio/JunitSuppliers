package junit.supplier;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.junit.experimental.theories.ParameterSignature;
import org.junit.experimental.theories.ParameterSupplier;
import org.junit.experimental.theories.PotentialAssignment;

import com.mifmif.common.regex.Generex;

public class BigIntegerSupplier extends ParameterSupplier {
    @Override
    public List<PotentialAssignment> getValueSources(ParameterSignature sig) throws Throwable {
        List<PotentialAssignment> list = new ArrayList<>();
        BigInt annotation = sig.getAnnotation(BigInt.class);
        String min = annotation.min();
        String max = annotation.max();
        String expression = "[0-9]{" + min.length() + "," + max.length() + "}";
        Generex generex = new Generex(expression);
        BigInteger value;
        BigInteger biMin;
        BigInteger biMax;
        try {
            biMin = new BigInteger(min);
            biMax = new BigInteger(max);
            for (int i = 0; i < annotation.qty();) {
                if (annotation.value().length == 0) {
                    value = new BigInteger(generex.random());
                } else {
                    value = new BigInteger(annotation.value()[i % annotation.value().length]);
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