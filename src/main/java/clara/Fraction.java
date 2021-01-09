package clara;

import java.util.Objects;

public class Fraction {
    private int numerator;
    private int denominator;

    @Override
    public String toString() {
        return "Numerator: " + this.numerator + ", Denominator" + this.denominator;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof Fraction) {
            Fraction otherFraction = (Fraction) other;
            return this.numerator == otherFraction.numerator &&
                    Objects.equals(this.denominator, otherFraction.denominator);
        }
        return false;
    }

    public Fraction() {
    }

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
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

    public Fraction add(Fraction other) {
        if (this.denominator == other.denominator) {
            return new Fraction(this.numerator + other.numerator, this.denominator);
        }

        int i = getLCM(this.denominator, other.denominator);
        int newNumerator1 = this.numerator * i;
        int newNumerator2 = other.numerator * i;
        return new Fraction(newNumerator1 + newNumerator2, i);
    }

    public Fraction subtract(Fraction other) {
        if (this.denominator == other.denominator) {
            return new Fraction(this.numerator - other.numerator, this.denominator);
        }

        int i = getLCM(this.denominator, other.denominator);
        int newNumerator1 = this.numerator * i;
        int newNumerator2 = other.numerator * i;
        return new Fraction(newNumerator1 - newNumerator2, i);
    }

    public Fraction multiply(Fraction other) {
        return new Fraction(this.numerator * other.numerator, this.denominator * other.denominator);
    }

    public Fraction divide(Fraction other) {
        return new Fraction(this.numerator * other.denominator, this.denominator * other.numerator);
    }

    public Fraction simplify() {
        for (int i = this.numerator; i > 1; i --) {
            if (this.numerator % i == 0 && this.denominator % i == 0) {
                return new Fraction(this.numerator / i, this.denominator / i);
            }
        }
        return this;
    }
}
