package com.github.fromi.calculator;

public class Calculator {
    private double currentValue;

    public Calculator() {
        currentValue = 0;
    }

    public Calculator(double initialValue) {
        currentValue = initialValue;
    }

    public double display() {
        return currentValue;
    }

    public void add(double value) {
        currentValue += value;
    }

    public void multiplyBy(double value) {
        currentValue *= value;
    }

    public void subtract(double value) {
        currentValue -= value;
    }

    public void divideBy(double value) {
        if (value == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        currentValue /= value;
    }
}
