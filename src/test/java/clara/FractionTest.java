package clara;

import org.junit.Test;

import static org.junit.Assert.*;

public class FractionTest {

    @Test
    public void setterTest() {
        Fraction fraction = new Fraction(12, 12);
        Fraction fraction1 = new Fraction(1, 2);

        int newNumerator = 12;
        fraction.setNumerator(newNumerator);
        assertEquals(fraction.getNumerator(), newNumerator);

        int newDenominator = 24;
        fraction.setDenominator(newDenominator);
        assertEquals(fraction.getDenominator(), newDenominator);

        assertEquals(fraction.simplify(), fraction1);

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

    @Test
    public void getterTest() {
        Fraction fraction = new Fraction(12, 12);
        assertEquals(12, fraction.getNumerator());
        assertEquals(12, fraction.getDenominator());
    }

    @Test
    public void basicOperationsTest() {
        Fraction fraction1 = new Fraction(1, 2);
        Fraction fraction2 = new Fraction(2, 2);
        Fraction fraction3 = new Fraction(3, 2);

        assertEquals(fraction1.add(fraction2), fraction3);
        assertEquals(fraction3.subtract(fraction1), fraction2);
        assertEquals(fraction1.multiply(fraction2), new Fraction(2, 4));
        assertEquals(fraction1.divide(fraction3), new Fraction(2, 6));
    }

    @Test
    public void simplifyTest() {
        Fraction fraction = new Fraction(6, 12);
        Fraction fraction1 = new Fraction(1, 2);
        Fraction fraction2 = new Fraction(2, 2);
        Fraction fraction3 = new Fraction(3, 2);

        assertEquals(fraction.simplify(), fraction1);
        assertEquals(fraction1.simplify(), fraction1);
        assertEquals(fraction2.simplify(), new Fraction(1, 1));
        assertEquals(fraction3.simplify(), fraction3);
    }

    @Test
    public void convertToDecimalTest() {
        Fraction f1 = new Fraction(1, 5);
        assertEquals(0.2, f1.convertToDecimal(), 0.000000003);

        f1.setNumerator(2);
        f1.setDenominator(2);
        assertEquals(1.0, f1.convertToDecimal(), 0.000000003);

        f1.setNumerator(1);
        f1.setDenominator(2);
        assertEquals(0.5, f1.convertToDecimal(), 0.000000003);
    }
}
