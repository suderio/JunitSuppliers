package junit.supplier;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.junit.experimental.theories.ParameterSignature;
import org.junit.experimental.theories.ParameterSupplier;
import org.junit.experimental.theories.PotentialAssignment;

import com.mifmif.common.regex.Generex;

public class StringSupplier extends ParameterSupplier {
    @Override
    public List<PotentialAssignment> getValueSources(ParameterSignature sig) throws Throwable {
        List<PotentialAssignment> list = new ArrayList<>();
        Str annotation = sig.getAnnotation(Str.class);
        Generex generex = new Generex(annotation.regex());
        Pattern pattern = Pattern.compile(annotation.regex());
        List<String> values = new ArrayList<>();
        for (int i = 0; i < annotation.value().length; i++) {
            if (pattern.matcher(annotation.value()[i]).matches()) {
                values.add(annotation.value()[i]);
            }
        }
        String value;
        for (int i = 0; i < annotation.qty(); i++) {
            if (annotation.value().length == 0) {
                value = generex.random();
            } else {
                value = values.get(i % values.size());
            }
            list.add(PotentialAssignment.forValue("string", value));
        }
        return list;
    }
}
