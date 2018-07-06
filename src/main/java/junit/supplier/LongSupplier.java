package junit.supplier;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.experimental.theories.ParameterSignature;
import org.junit.experimental.theories.ParameterSupplier;
import org.junit.experimental.theories.PotentialAssignment;

public class LongSupplier extends ParameterSupplier {
    @Override
    public List<PotentialAssignment> getValueSources(ParameterSignature sig) throws Throwable {
        List<PotentialAssignment> list = new ArrayList<>();
        Lng annotation = sig.getAnnotation(Lng.class);
        long value;
        for (int i = 0; i < annotation.qty();) {
            if (annotation.value().length == 0) {
                value = new Random().nextLong();
            } else {
                value = annotation.value()[i % annotation.value().length];
            }
            if (value >= annotation.min() && value <= annotation.max()) {
                list.add(PotentialAssignment.forValue("long", value));
                i++;
            }
        }
        return list;
    }
}