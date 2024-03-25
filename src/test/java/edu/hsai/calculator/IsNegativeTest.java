package edu.hsai.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class IsNegativeTest extends CalculatorTest {
    @ParameterizedTest
    @ValueSource(longs = {1, Long.MAX_VALUE, 20_000})
    void shouldRejectPositive(long val) {
        Assertions.assertFalse(calculator.isNegative(val));
    }

    @ParameterizedTest
    @ValueSource(longs = {-1, Long.MIN_VALUE, -20_000})
    void shouldAcceptNegative(long val) {
        Assertions.assertTrue(calculator.isNegative(val));
    }

    @Test
    void shouldRejectZero() {
        Assertions.assertFalse(calculator.isNegative(0));
    }
}
