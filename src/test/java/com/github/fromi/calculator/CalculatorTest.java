package com.github.fromi.calculator;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void init_with_zero() {
        assertThat(calculator.display(), equalTo(0d));
    }

    @Test
    public void add() {
        calculator.add(10);
        assertThat(calculator.display(), equalTo(10d));
    }

    @Test
    public void subtract() {
        calculator.subtract(5);
        assertThat(calculator.display(), equalTo(-5d));
    }

    @Test
    public void multiply() {
        calculator = new Calculator(6);
        calculator.multiplyBy(7);
        assertThat(calculator.display(), equalTo(42d));
    }

    @Test
    public void divide() {
        calculator = new Calculator(50);
        calculator.divideBy(10);
        assertThat(calculator.display(), equalTo(5d));
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannot_divide_by_zero() {
        calculator.divideBy(0);
    }
}
