package junit.supplier;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.experimental.theories.ParameterSignature;
import org.junit.experimental.theories.ParameterSupplier;
import org.junit.experimental.theories.PotentialAssignment;

public class FloatSupplier extends ParameterSupplier {
    @Override
    public List<PotentialAssignment> getValueSources(ParameterSignature sig) throws Throwable {
        List<PotentialAssignment> list = new ArrayList<>();
        Flt annotation = sig.getAnnotation(Flt.class);
        float value;
        for (int i = 0; i < annotation.qty();) {
            if (annotation.value().length == 0) {
                value = new Random().nextFloat();
            } else {
                value = annotation.value()[i % annotation.value().length];
            }
            if (value >= annotation.min() && value <= annotation.max()) {
                list.add(PotentialAssignment.forValue("float", value));
                i++;
            }
        }
        return list;
    }
}