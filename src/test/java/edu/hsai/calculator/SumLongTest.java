package edu.hsai.calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SumLongTest extends CalculatorTest {
    @ParameterizedTest
    @CsvSource({"-1, 2, 1", "1, -2, -1", "-10, 10, 0"})
    void shouldAcceptDifferentSigns(long a, long b, long expected) {
        assertEquals(expected, calculator.sum(a, b));
    }

    @ParameterizedTest
    @CsvSource({"9223372036854775807, 1, -9223372036854775808", "-9223372036854775808, -1, 9223372036854775807"})
    void shouldOverflowAndUnderflow(long a, long b, long expected) {
        assertEquals(expected, calculator.sum(a, b));

    }

    @ParameterizedTest
    @CsvSource({"23, 0, 23", "0, 4, 4", "0, -15, -15", "-10, 0, -10"})
    void shouldRespectZero(long a, long b, long expected) {
        assertEquals(expected, calculator.sum(a, b));
    }

    @ParameterizedTest
    @CsvSource({"23, 11, 34", "99, 4, 103"})
    void shouldAcceptPositiveArguments(long a, long b, long expected) {
        assertEquals(expected, calculator.sum(a, b));
    }
}
