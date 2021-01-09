package clara;

import org.junit.Test;

import static org.junit.Assert.*;

public class FractionTest {

    @Test
    public void fraction() {
        Fraction fraction = new Fraction(12, 12);
        Fraction fraction1 = new Fraction(1, 2);
        Fraction fraction2 = new Fraction(2, 2);
        Fraction fraction3 = new Fraction(3, 2);

        assertTrue(fraction.toString().contains("12/12"));

        assertEquals(12, fraction.getNumerator());
        assertEquals(12, fraction.getDenominator());

        int newNumerator = 12;
        fraction.setNumerator(newNumerator);
        assertEquals(fraction.getNumerator(), newNumerator);

        int newDenominator = 24;
        fraction.setDenominator(newDenominator);
        assertEquals(fraction.getDenominator(), newDenominator);

        assertEquals(fraction.simplify(), fraction1);

        assertEquals(fraction1.add(fraction2), fraction3);
        assertEquals(fraction3.subtract(fraction1), fraction2);
        assertEquals(fraction1.multiply(fraction2), new Fraction(2, 4));
        assertEquals(fraction1.divide(fraction3), new Fraction(2, 6));

        assertEquals(0.5, fraction1.convertToDecimal(), 1e-15);
        assertEquals(1.0, fraction2.convertToDecimal(), 1e-15);

        try {
            fraction.setDenominator(0);
            fail("Unexpected argument: " + 0);
        } catch (IllegalArgumentException e) {
            // expected
        }

        try {
            Fraction fraction4 = new Fraction(12, 0);
            fail("Unexpected argument: " + 0);
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
}
