package junit.supplier;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.experimental.theories.ParameterSignature;
import org.junit.experimental.theories.ParameterSupplier;
import org.junit.experimental.theories.PotentialAssignment;

public class BooleanSupplier extends ParameterSupplier {
    @Override
    public List<PotentialAssignment> getValueSources(ParameterSignature sig) throws Throwable {
        List<PotentialAssignment> list = new ArrayList<>();
        Bln annotation = sig.getAnnotation(Bln.class);
        for (int i = 0; i < annotation.qty(); i++) {
            list.add(PotentialAssignment.forValue("boolean", new Random().nextBoolean()));
        }
        return list;
    }
}