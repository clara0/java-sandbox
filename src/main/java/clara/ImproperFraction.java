package clara;

public class ImproperFraction extends Fraction {
    private int wholeNumber;

    public ImproperFraction(String sign, int wholeNumber, int numerator, int denominator) {
        super(sign, numerator, denominator);
        this.wholeNumber = wholeNumber;
    }

    public int getWholeNumber() {
        return wholeNumber;
    }

    public void setWholeNumber(int wholeNumber) {
        this.wholeNumber = wholeNumber;
    }

    @Override
    public String toString() {
        return "Improper Fraction: " + getSign() + " " + wholeNumber + " " + getNumerator() + "/" + getDenominator();
    }

    @Override
    public Fraction add(Fraction other) {
        if (other instanceof ImproperFraction) {
            ImproperFraction otherImproperFraction = (ImproperFraction) other;
            ImproperFraction newImproperFraction = this.add(otherImproperFraction);
            return newImproperFraction.convertToFraction();
        }
        Fraction newFraction = this.convertToFraction();
        int numerator1 = newFraction.returnNumerator();
        int numerator2 = other.returnNumerator();
        if (newFraction.getDenominator() == other.getDenominator()) {
            return new Fraction(returnSign(numerator1 + numerator2), numerator1 + numerator2, newFraction.getDenominator()).simplify();
        }
        int i = getLCM(newFraction.getDenominator(), other.getDenominator());
        int newNumerator1 = numerator1 * i;
        int newNumerator2 = numerator2 * i;
        return new Fraction(returnSign(newNumerator1 + newNumerator2), newNumerator1 + newNumerator2, i).simplify();
    }

    @Override
    public Fraction subtract(Fraction other) {
        if (other instanceof ImproperFraction) {
            ImproperFraction otherImproperFraction = (ImproperFraction) other;
            ImproperFraction newImproperFraction = this.subtract(otherImproperFraction);
            return newImproperFraction.convertToFraction();
        }
        Fraction newFraction = this.convertToFraction();
        int numerator1 = newFraction.returnNumerator();
        int numerator2 = other.returnNumerator();
        if (newFraction.getDenominator() == other.getDenominator()) {
            return new Fraction(returnSign(numerator1 - numerator2), numerator1 - numerator2, newFraction.getDenominator()).simplify();
        }
        int i = getLCM(newFraction.getDenominator(), other.getDenominator());
        int newNumerator1 = numerator1 * i;
        int newNumerator2 = numerator2 * i;
        return new Fraction(returnSign(newNumerator1 - newNumerator2), newNumerator1 - newNumerator2, i).simplify();
    }

    @Override
    public Fraction multiply(Fraction other) {
        if (other instanceof ImproperFraction) {
            ImproperFraction otherImproperFraction = (ImproperFraction) other;
            ImproperFraction newImproperFraction = this.multiply(otherImproperFraction);
            return newImproperFraction.convertToFraction();
        }

        Fraction newFraction = this.convertToFraction();
        int numerator1 = newFraction.getNumerator() * other.getNumerator();
        int denominator1 = newFraction.getDenominator() * other.getDenominator();
        if (newFraction.getSign() == null && other.getSign() == null) {
            return new Fraction(null, numerator1, denominator1).simplify();
        }
        if (newFraction.getSign() == null || other.getSign() == null)  {
            return new Fraction("-", numerator1, denominator1);
        }
        return new Fraction(null, numerator1, denominator1);
    }

    @Override
    public Fraction divide(Fraction other) {
        if (other instanceof ImproperFraction) {
            ImproperFraction otherImproperFraction = (ImproperFraction) other;
            ImproperFraction newImproperFraction = this.divide(otherImproperFraction);
            return newImproperFraction.convertToFraction();
        }

        Fraction newFraction = this.convertToFraction();
        int numerator1 = newFraction.getNumerator() * other.getDenominator();
        int denominator1 = newFraction.getDenominator() * other.getNumerator();
        if (newFraction.getSign() == null && other.getSign() == null) {
            return new Fraction(null, numerator1, denominator1).simplify();
        }
        if (newFraction.getSign() == null || other.getSign() == null)  {
            return new Fraction("-", numerator1, denominator1);
        }
        return new Fraction(null, numerator1, denominator1);
    }

    public ImproperFraction add(ImproperFraction other) {
        Fraction fraction1 = this.convertToFraction();
        Fraction fraction2 = other.convertToFraction();
        Fraction fraction = fraction1.add(fraction2);
        return fraction.simplifyToImproper();
    }

    public ImproperFraction subtract(ImproperFraction other) {
        Fraction fraction1 = this.convertToFraction();
        Fraction fraction2 = other.convertToFraction();
        return fraction1.subtract(fraction2).simplifyToImproper();
    }

    public ImproperFraction multiply(ImproperFraction other) {
        Fraction fraction1 = this.convertToFraction();
        Fraction fraction2 = other.convertToFraction();
        System.out.println(fraction2);
        return fraction1.multiply(fraction2).simplifyToImproper();
    }

    public ImproperFraction divide(ImproperFraction other) {
        Fraction fraction1 = this.convertToFraction();
        Fraction fraction2 = other.convertToFraction();
        return fraction1.divide(fraction2).simplifyToImproper();
    }

    public ImproperFraction simplify() {
        for (int i = Math.abs(getNumerator()); i > 1; i --) {
            if (getNumerator() % i == 0 && getDenominator() % i == 0) {
                if (getNumerator() >= getDenominator()) {
                    if (getNumerator() % getDenominator() == 0) {
                        return new ImproperFraction(getSign(), wholeNumber + getNumerator() / getDenominator(), 0, getDenominator());
                    }
                    int newNumerator = getNumerator() / i;
                    int newDenominator = getDenominator() / i;
                    return new ImproperFraction(getSign(), wholeNumber + newNumerator / newDenominator, newNumerator - newDenominator, newDenominator);
                }
                return new ImproperFraction(getSign(), wholeNumber, getNumerator() / i, getDenominator() / i);
            }
        }
        return this;
    }

    public float convertToDecimal() {
        Fraction newFraction = this.convertToFraction();
        return (float) newFraction.getNumerator() / newFraction.getDenominator();
    }

    public Fraction convertToFraction() {
        return new Fraction(getSign(), wholeNumber * getDenominator() + getNumerator(), getDenominator());
    }
}
