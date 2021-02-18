package clara;

public class Fraction {
    private int numerator;
    private int denominator;
    private String sign;

    @Override
    public String toString() {
        return "Fraction: " + numerator + "/" + denominator;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof Fraction) {
            Fraction otherFraction = (Fraction) other;
            Fraction simplifiedFraction = this.simplify();
            Fraction simplifiedFraction1 = otherFraction.simplify();
            return simplifiedFraction.numerator == simplifiedFraction1.numerator &&
                    simplifiedFraction.denominator == simplifiedFraction1.denominator;
        }
        return false;
    }

    public Fraction(String sign, int numerator, int denominator) {
        this.numerator = numerator;
        if (denominator == 0) {
            throw new IllegalArgumentException("Unexpected argument: " + denominator);
        }
        this.denominator = denominator;

        if (sign == null || sign.equals("-")) {
            this.sign = sign;
        } else {
            throw new IllegalArgumentException("Unexpected argument: " + sign);
        }
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public String getSign() {
        return sign;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public void setDenominator(int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Unexpected argument: " + denominator + "\n Denominator cannot have value of 0");
        }
        this.denominator = denominator;
    }

    public void setSign(String sign) {
        if (sign == null || sign.equals("-")) {
            this.sign = sign;
        } else {
            throw new IllegalArgumentException("Unexpected argument: " + sign + "\n Sign must be either - or null");
        }
    }

    public int getLCM(int n1, int n2) {
        if (n1 <= n2) {
            for (int i = n1; i <= n1 * n2; i++) {
                if (i % n1 == 0 && i % n2 == 0) {
                    return i;
                }
            }
        }

        for (int i = n2; i <= n1 * n2; i++) {
            if (i % n1 == 0 && i % n2 == 0) {
                return i;
            }
        }
        return n1 * n2;
    }

    public int returnNumerator() {
        if (sign == null) {
            return numerator;
        }
        return -numerator;
    }

    public String returnSign(int num) {
        if (num >= 0) {
            return null;
        }
        return "-";
    }

    public Fraction add(Fraction other) {
        int numerator1 = returnNumerator();
        int numerator2 = other.returnNumerator();

        if (denominator == other.denominator) {
            return new Fraction(returnSign(numerator1 + numerator2), Math.abs(numerator1 + numerator2), denominator).simplify();
        }
        int i = getLCM(denominator, other.denominator);
        int newNumerator1 = numerator1 * i;
        int newNumerator2 = numerator2 * i;
        return new Fraction(returnSign(newNumerator1 + newNumerator2), Math.abs(newNumerator1 + newNumerator2), i).simplify();
    }

    public Fraction subtract(Fraction other) {
        int numerator1 = returnNumerator();
        int numerator2 = other.returnNumerator();

        if (denominator == other.denominator) {

            return new Fraction(returnSign(numerator1 - numerator2), Math.abs(numerator1 - numerator2), denominator).simplify();
        }
        int i = getLCM(denominator, other.denominator);
        int newNumerator1 = numerator1 * i;
        int newNumerator2 = numerator2 * i;
        return new Fraction(returnSign(newNumerator1 - newNumerator2), Math.abs(newNumerator1 - newNumerator2), i).simplify();
    }

    public Fraction multiply(Fraction other) {
        int numerator1 = numerator * other.numerator;
        int denominator1 = denominator * other.denominator;
        if (sign == null && other.sign == null) {
            return new Fraction(null, numerator1, denominator1).simplify();
        }
        if (sign == null || other.sign == null)  {
            return new Fraction("-", numerator1, denominator1);
        }
        return new Fraction(null, numerator1, denominator1);
    }

    public Fraction divide(Fraction other) {
        int numerator1 = numerator * other.denominator;
        int denominator1 = denominator * other.numerator;
        if (sign == null && other.sign == null) {
            return new Fraction(null, numerator1, denominator1).simplify();
        }
        if (sign == null || other.sign == null)  {
            return new Fraction("-", numerator1, denominator1);
        }
        return new Fraction(null, numerator1, denominator1);
    }

    public Fraction simplify() {
        for (int i = numerator; i > 1; i --) {
            if (numerator % i == 0 && denominator % i == 0) {
                return new Fraction(sign, numerator / i, denominator / i);
            }
        }
        return this;
    }

    public ImproperFraction simplifyToImproper() {
        Fraction newFraction = this.simplify();
        if (newFraction.getNumerator() > newFraction.getDenominator()) {
            int wholeNumber = newFraction.numerator / newFraction.denominator;
            int newNumerator = newFraction.numerator - (newFraction.denominator * wholeNumber);
            return new ImproperFraction(sign, wholeNumber, newNumerator, newFraction.denominator);
        }
        if (newFraction.numerator == newFraction.denominator) {
            return new ImproperFraction(sign, 1, 0, newFraction.denominator);
        }
        return new ImproperFraction(sign, 0, numerator, denominator);
    }

    public float convertToDecimal() {
        return (float) numerator / denominator;
    }
}
