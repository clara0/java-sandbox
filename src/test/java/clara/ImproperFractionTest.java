package clara;

import org.junit.Test;

import static org.junit.Assert.*;

public class ImproperFractionTest {

    @Test
    public void improperFractionTest() {
        ImproperFraction improperFraction = new ImproperFraction(null, 1, 2, 4);
        assertEquals(1, improperFraction.getWholeNumber());
        assertEquals(2, improperFraction.getNumerator());
        assertEquals(4, improperFraction.getDenominator());

        int newWholeNum = 12;
        improperFraction.setWholeNumber(newWholeNum);
        assertEquals(newWholeNum, improperFraction.getWholeNumber());

        int newNumerator = 3;
        improperFraction.setNumerator(newNumerator);
        assertEquals(newNumerator, improperFraction.getNumerator());

        int newDenominator = 10;
        improperFraction.setDenominator(newDenominator);
        assertEquals(newNumerator, improperFraction.getNumerator());

        try {
            improperFraction.setDenominator(0);
            fail("Unexpected argument: 0");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    @Test
    public void testOperations() {
        ImproperFraction improperFraction = new ImproperFraction(null, 1, 2, 4);
        ImproperFraction improperFraction1 = new ImproperFraction(null, 1, 1, 4);
        ImproperFraction improperFraction2 = new ImproperFraction("-", 1, 3, 4);
        ImproperFraction improperFraction3 = new ImproperFraction("-", 0, 3, 4);
        ImproperFraction improperFraction4 = new ImproperFraction(null, 2, 3, 4);
        ImproperFraction improperFraction5 = new ImproperFraction(null, 1, 1, 2);
        Fraction fraction = new Fraction(null, 5, 4);
        Fraction fraction1 = new Fraction(null, 7, 4);

        assertEquals(improperFraction4, improperFraction.add(improperFraction1));
        improperFraction4.setWholeNumber(0);
        improperFraction4.setNumerator(0);
        assertEquals(improperFraction5, improperFraction.add(improperFraction4));

        improperFraction4.setWholeNumber(0);
        improperFraction4.setNumerator(1);
        improperFraction4.setDenominator(4);
        assertEquals(improperFraction4, improperFraction.subtract(improperFraction1));
        improperFraction1.setNumerator(4);
        improperFraction4.setWholeNumber(0);
        improperFraction4.setSign("-");
        improperFraction4.setNumerator(1);
        improperFraction4.setDenominator(2);
        assertEquals(improperFraction4, improperFraction.subtract(improperFraction1));

        improperFraction4.setSign(null);
        improperFraction4.setWholeNumber(3);
        improperFraction4.setNumerator(0);
        improperFraction4.setDenominator(1);
        assertEquals(improperFraction4, improperFraction.multiply(improperFraction1));
        improperFraction4.setWholeNumber(1);
        improperFraction4.setNumerator(5);
        improperFraction4.setDenominator(16);
        assertEquals(improperFraction4, improperFraction2.multiply(improperFraction3));

        improperFraction4.setWholeNumber(0);
        improperFraction4.setNumerator(3);
        improperFraction4.setDenominator(4);
        assertEquals(improperFraction4, improperFraction.divide(improperFraction1));

        assertEquals(fraction1, fraction.add(improperFraction));

        fraction1.setNumerator(3);
        assertEquals(fraction1, fraction.subtract(improperFraction));

        fraction1.setNumerator(5);
        fraction1.setDenominator(8);
        assertEquals(fraction1, fraction.multiply(improperFraction));

        fraction1.setNumerator(5);
        fraction1.setDenominator(2);
        assertEquals(fraction1, fraction.divide(improperFraction));
    }

    @Test
    public void testOverrides() {
        ImproperFraction improperFraction = new ImproperFraction(null, 0, 2, 10);
        Fraction fraction = new Fraction(null, 3, 10);
        Fraction fraction1 = new Fraction(null, 1, 2);

        assertEquals(fraction1, improperFraction.add(fraction));

        improperFraction.setWholeNumber(1);
        fraction1.setNumerator(3);
        assertEquals(fraction1, improperFraction.add(fraction));

        fraction1.setNumerator(9);
        fraction1.setDenominator(10);
        assertEquals(fraction1, improperFraction.subtract(fraction));

        fraction.setNumerator(14);
        fraction1.setNumerator(-2);
        fraction1.setSign("-");
        assertEquals(fraction1, improperFraction.subtract(fraction));

        fraction1.setNumerator(42);
        fraction1.setDenominator(25);
        fraction1.setSign(null);
        assertEquals(fraction1, improperFraction.multiply(fraction));

        fraction1.setNumerator(6);
        fraction1.setDenominator(7);
        assertEquals(fraction1, improperFraction.divide(fraction));
    }

    @Test
    public void testMisc() {
        ImproperFraction improperFraction = new ImproperFraction(null, 2, 3, 5);
        ImproperFraction improperFraction1 = new ImproperFraction(null, 2, 5, 5);
        ImproperFraction improperFraction2 = new ImproperFraction(null, 3, 0, 5);
        Fraction fraction = new Fraction(null, 13, 5);

        assertEquals(improperFraction2, improperFraction1.simplify());

        improperFraction1.setWholeNumber(2);
        improperFraction1.setNumerator(6);
        improperFraction1.setDenominator(10);
        assertEquals(improperFraction, improperFraction1.simplify());

        assertEquals(2.6, improperFraction.convertToDecimal(), 0.01);
        assertEquals(3.0, improperFraction2.convertToDecimal(), 0.01);

        assertEquals(fraction, improperFraction.convertToFraction());
    }

}
