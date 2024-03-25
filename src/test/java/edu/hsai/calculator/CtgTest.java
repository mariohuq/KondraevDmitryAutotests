package edu.hsai.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class CtgTest extends CalculatorTest {
    // arguments varied with EPSILON
    private static final double EPSILON = 1.e-5;

    @ParameterizedTest
    @MethodSource("ctgValues")
    void shouldAcceptTableValues(double val, double expected) {
        Assertions.assertEquals(expected, calculator.ctg(val), DELTA, "for values from (0; π)");
        Assertions.assertEquals(expected, calculator.ctg(val + Math.PI), DELTA,"for values from (π; 2π)" );
        Assertions.assertEquals(expected, calculator.ctg(val - Math.PI), DELTA, "for values from (-π; 0)");
    }

    @ParameterizedTest
    @ValueSource(doubles = {0, Math.PI, -Math.PI})
    void shouldProduceInfinity(double val) {
        Assertions.assertEquals(Double.POSITIVE_INFINITY, calculator.ctg(val + EPSILON), DELTA, "Positive infinity");
        Assertions.assertEquals(Double.NEGATIVE_INFINITY, calculator.ctg(val - EPSILON), DELTA, "Negative infinity");
    }

    static Stream<Arguments> ctgValues() {
        return Stream.of(
                arguments(Math.PI / 6, Math.sqrt(3.)),
                arguments(Math.PI / 4, 1.),
                arguments(Math.PI / 3, Math.sqrt(3.) / 3.),
                arguments(Math.PI / 2, 0.),
                arguments(2. * Math.PI / 3, -Math.sqrt(3.) / 3.),
                arguments(3. * Math.PI / 4, -1.),
                arguments(5. * Math.PI / 6, -Math.sqrt(3.))
        );
    }
}
