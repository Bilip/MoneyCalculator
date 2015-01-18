package moneycalculator.model;

public class Number {

    private int numerator;
    private int denominator;

    public Number(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        reduce();
    }

    public Number(Number number) {
        this(number.getNumerator(), number.getDenominator());
    }

    public Number(int number) {
        this(number, 1);
    }

    public Number(long number) {
        this((int) number, 1);
    }

    public Number(double number) {
        this((int) number, 1);

        while (number != numerator) {
            number *= 10;
            denominator *= 10;
            numerator = (int) number;
        }
        reduce();
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public Number add(Number number) {
        if (this.denominator == number.denominator) {
            return new Number(numerator + number.numerator, number.denominator);
        } else {
            return new Number(
                    mcm(this, number).numerator + mcm(number, this).numerator,
                    mcm(number, this).denominator);
        }
    }

    public static Number multiply(Number numberA, Number numberB) {
        Number result = new Number(numberA.numerator * numberB.numerator, numberA.denominator * numberB.denominator);
        result.reduce();
        return result;
    }

    public Number divide(Number numberA, Number numberB) {
        return new Number(numberA.numerator * numberB.denominator, numberA.denominator * numberB.numerator);
    }

    public int[] getPrimeNumbers() {
        return new int[]{2, 3, 4, 5, 7, 11, 13, 17, 19, 23, 25};
    }

    public Number mcm(Number firstNumber, Number secondNumber) {
        return new Number(
                firstNumber.numerator * secondNumber.denominator,
                firstNumber.denominator * secondNumber.denominator);
    }

    public boolean isDivisible(int number) {
        return ((numerator % number == 0) & denominator % number == 0);
    }

    private void reduce() {
        int[] primeNumber = getPrimeNumbers();
        for (int Number : primeNumber) {
            while (isDivisible(Number)) {
                numerator = numerator / Number;
                denominator = denominator / Number;
            }
        }
    }

    @Override
    public String toString() {
        return numerator + " / " + denominator;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }

        final Number other = (Number) obj;

        if (this.numerator != other.numerator) {
            return false;
        }
        if (this.denominator != other.denominator) {
            return false;
        }

        return true;
    }
    
    public static Number parseNumber(String value){
        double parse = Double.parseDouble(value);
        Number num = new Number(parse);
        num.reduce();
        return num;
    }
}
