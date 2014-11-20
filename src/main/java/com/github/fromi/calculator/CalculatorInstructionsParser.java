package com.github.fromi.calculator;

import static java.lang.Double.parseDouble;
import static java.util.Optional.empty;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CalculatorInstructionsParser {

    private static final String DISPLAY = "DISPLAY";

    private static final String ADD = "ADD";
    private static final int ADD_VALUE_INDEX = ADD.length();

    private static final String SUBTRACT = "SUBTRACT";
    private static final int SUBTRACT_VALUE_INDEX = SUBTRACT.length();

    private static final String MULTIPLY = "MULTIPLY BY";
    private static final int MULTIPLY_VALUE_INDEX = MULTIPLY.length();

    private static final String DIVIDE = "DIVIDE BY";
    private static final int DIVIDE_VALUE_INDEX = DIVIDE.length();

    private final Calculator calculator = new Calculator();

    public List<String> parse(List<String> instructions) {
        List<String> outputs = new ArrayList<>();
        for (String instruction : instructions) {
            Optional<String> output = process(instruction);
            if (output.isPresent()) {
                outputs.add(output.get());
            }
        }
        return outputs;
    }

    private Optional<String> process(String instruction) {
        if (instruction == null) {
            throw new IllegalArgumentException();
        }
        if (instruction.equals(DISPLAY)) {
            return Optional.of(Double.toString(calculator.display()));
        } else {
            processOperation(instruction);
            return empty();
        }
    }

    private void processOperation(String operation) {
        if (operation.startsWith(ADD)) {
            calculator.add(extractDoubleAt(operation, ADD_VALUE_INDEX));
        } else if (operation.startsWith(SUBTRACT)) {
            calculator.subtract(extractDoubleAt(operation, SUBTRACT_VALUE_INDEX));
        } else if (operation.startsWith(MULTIPLY)) {
            calculator.multiplyBy(extractDoubleAt(operation, MULTIPLY_VALUE_INDEX));
        } else if (operation.startsWith(DIVIDE)) {
            calculator.divideBy(extractDoubleAt(operation, DIVIDE_VALUE_INDEX));
        } else {
            throw new IllegalArgumentException("Unknown operation: " + operation);
        }
    }

    private double extractDoubleAt(String operation, int index) {
        return parseDouble(operation.substring(index));
    }
}
