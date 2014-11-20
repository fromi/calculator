package com.github.fromi.calculator;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class CalculatorInstructionParserTest {

    private CalculatorInstructionsParser calculatorInstructionsParser;

    @Before
    public void setUp() {
        calculatorInstructionsParser = new CalculatorInstructionsParser();
    }

    @Test
    public void display_initial_value() {
        String[] instructions = {"DISPLAY"};
        List<String> output = calculatorInstructionsParser.parse(Arrays.asList(instructions));
        assertThat(output.size(), equalTo(1));
        assertThat(output.get(0), equalTo("0.0"));
    }

    @Test
    public void add_then_multiply() {
        String[] instructions = {"ADD 6", "DISPLAY", "MULTIPLY BY 7", "DISPLAY"};
        List<String> output = calculatorInstructionsParser.parse(Arrays.asList(instructions));
        assertThat(output.size(), equalTo(2));
        assertThat(output.get(0), equalTo("6.0"));
        assertThat(output.get(1), equalTo("42.0"));
    }

    @Test
    public void subtract_then_divide() {
        String[] instructions = {"SUBTRACT 10", "DISPLAY", "DIVIDE BY 3", "DISPLAY"};
        List<String> output = calculatorInstructionsParser.parse(Arrays.asList(instructions));
        assertThat(output.size(), equalTo(2));
        assertThat(output.get(0), equalTo("-10.0"));
        assertThat(output.get(1), equalTo("-3.3333333333333335"));
    }

    @Test
    public void display_twice_gives_same_output() {
        String[] instructions = {"ADD 2", "DISPLAY", "DISPLAY"};
        List<String> output = calculatorInstructionsParser.parse(Arrays.asList(instructions));
        assertThat(output.size(), equalTo(2));
        assertThat(output.get(0), equalTo(output.get(1)));
    }
}
