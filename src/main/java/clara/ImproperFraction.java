package clara;

public class ImproperFraction extends Fraction{

    private int wholeNumber;

    public ImproperFraction(int wholeNumber, int numerator, int denominator) {
        super(numerator, denominator);
        this.wholeNumber = wholeNumber;
    }

    public ImproperFraction add(ImproperFraction other) {
        if (getDenominator() == other.getDenominator()) {
            return new ImproperFraction(wholeNumber + other.wholeNumber, getNumerator() + other.getNumerator(), getDenominator() + other.getDenominator());
        }

        int i = getLCM(getDenominator(), other.getDenominator());
        int newNumerator1 = getNumerator() * i;
        int newNumerator2 = other.getNumerator() * i;
        return new ImproperFraction(wholeNumber + other.wholeNumber,newNumerator1 + newNumerator2, i);
    }

    public int getWholeNumber() {
        return wholeNumber;
    }

    public void setWholeNumber(int wholeNumber) {
        this.wholeNumber = wholeNumber;
    }
}
