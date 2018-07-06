package junit.supplier;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.experimental.theories.ParameterSignature;
import org.junit.experimental.theories.ParameterSupplier;
import org.junit.experimental.theories.PotentialAssignment;

public class IntegerSupplier extends ParameterSupplier {
    @Override
    public List<PotentialAssignment> getValueSources(ParameterSignature sig) throws Throwable {
        List<PotentialAssignment> list = new ArrayList<>();
        Int annotation = sig.getAnnotation(Int.class);
        int value;
        for (int i = 0; i < annotation.qty();) {
            if (annotation.value().length == 0) {
                value = new Random().nextInt();
            } else {
                value = annotation.value()[i % annotation.value().length];
            }
            if (value >= annotation.min() && value <= annotation.max()) {
                list.add(PotentialAssignment.forValue("int", value));
                i++;
            }
        }
        return list;
    }
}