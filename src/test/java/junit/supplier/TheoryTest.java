package junit.supplier;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.regex.Pattern;

import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeFalse;
import static org.junit.Assume.assumeTrue;

@RunWith(Theories.class)
public class TheoryTest {
    @Theory
    public void testIntA(@Int(min = 0, max = 100000000) int a, @Int(min = 0, max = 100000000) int b) {
        assumeTrue(a >= b);
        assertThat(Math.max(a, b), is(a));
    }

    @Theory
    public void testIntegerB(@Int(min = 0, max = 1000000000) Integer a, @Int(min = 0, max = 1000000000) Integer b) {
        assumeTrue(b >= a);
        assertThat(Math.max(a, b), is(b));
    }

    @Theory
    public void testLongA(@Lng(min = 0, max = 1000000000000000000L) long a,
            @Lng(min = 0, max = 1000000000000000000L) long b) {
        assumeTrue(a >= b);
        assertThat(Math.max(a, b), is(a));
    }

    @Theory
    public void testLongB(@Lng(min = 0, max = 1000000000000000000L) Long a,
            @Lng(min = 0, max = 1000000000000000000L) Long b) {
        assumeTrue(b >= a);
        assertThat(Math.max(a, b), is(b));
    }

    @Theory
    public void testFloatA(@Flt(min = 0, max = 100000000) float a, @Flt(min = 0, max = 100000000) float b) {
        assumeTrue(a >= b);
        assertThat(Math.max(a, b), is(a));
    }

    @Theory
    public void testFloatB(@Flt(min = 0, max = 100000000) Float a, @Flt(min = 0, max = 100000000) Float b) {
        assumeTrue(b >= a);
        assertThat(Math.max(a, b), is(b));
    }

    @Theory
    public void testDoubleA(@Dbl(qty = 200) double a, @Dbl(qty = 200) double b) {
        assumeTrue(a >= b);
        assertThat(Math.max(a, b), is(a));
    }

    @Theory
    public void testDoubleB(@Dbl(qty = 200) Double a, @Dbl(qty = 200) Double b) {
        assumeTrue(b >= a);
        assertThat(Math.max(a, b), is(b));
    }

    @Theory
    public void testBigIntegerA(@BigInt(min = "0", max = "300000000000000000000") BigInteger a,
            @BigInt(min = "0", max = "300000000000000000000") BigInteger b) {
        assumeTrue(a.min(b).equals(a));
        assertThat(a.max(b), is(b));
    }

    @Theory
    public void testBigIntegerB(@BigInt(min = "0", max = "300000000000000000000") BigInteger a,
            @BigInt(min = "0", max = "300000000000000000000") BigInteger b) {
        assumeTrue(a.min(b).equals(b));
        assertThat(a.max(b), is(a));
    }

    @Theory
    public void testBigDecimalA(@BigDcm(min = "-10.0", max = "300000000000000000000") BigDecimal a,
            @BigDcm(min = "-50.000", max = "300000000000000000000") BigDecimal b) {
        assumeTrue(a.min(b).equals(a));
        assertThat(a.max(b), is(b));
    }

    @Theory
    public void testBigDecimalB(@BigDcm(min = "0", max = "300000000000000000000") BigDecimal a,
            @BigDcm(min = "0", max = "300000000000000000000", precision = 5) BigDecimal b) {
        assumeTrue(a.min(b).equals(b));
        assertThat(a.max(b), is(a));
    }

    @Theory
    public void testBooleanTrue(@Bln boolean test) {
        assumeTrue(test);
        assertTrue(test);
    }

    @Theory
    public void testBooleanFalse(@Bln boolean test) {
        assumeFalse(test);
        assertFalse(test);
    }

    @Theory
    public void testArrayContains(@Str({"test", "1", ""}) String test) {
        assumeTrue(test.length() == 1);
        assertTrue("1".equals(test));
    }
    
    @Theory
    public void testArrayContainsWithRegex(@Str(regex = "[0-9]", value={"test", "1", ""}) String test) {
        assertTrue("1".equals(test));
    }

    @Theory
    public void testArrayContainsNot(@Str({"test", "1", ""}) Object test) {
        assumeFalse(test.toString().length() == 0);
        assertFalse("0".equals(test));
    }
    
    @Theory
    public void testStringOk(@Str(regex = "[A-Z][a-z]*") String nome) {
        assertTrue(Pattern.matches("[A-Z][a-z]*", nome));
    }

    @Theory
    public void testStringNotOk(@Str(regex = "[A-Z][a-z]*") String nome) {
        assertFalse(Pattern.matches("[0-9]*", nome));
    }
}
