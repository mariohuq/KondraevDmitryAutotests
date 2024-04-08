package edu.hsai.calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class PowTest extends CalculatorTest {
    @ParameterizedTest
    @CsvSource({"3, 1, 3", "7, 2, 49", "-3, 1, -3", "-7, 2, 49"})
    void shouldAcceptIntegerPower(double base, double exponent, double expected) {
        assertEquals(expected, calculator.pow(base, exponent), DELTA);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-10., 7.5, 30.})
    void shouldBeOneForZeroExponent(double base) {
        assertEquals(1., calculator.pow(base, 0.), DELTA);
    }

    @ParameterizedTest
    @CsvSource({"3, -1, 0.3334", "7, -2, 0.0204", "-3, -1, -0.3334", "-7, -2, 0.0204"})
    void shouldAcceptNegativePower(double base, double exponent, double expected) {
        assertEquals(expected, calculator.pow(base, exponent), DELTA);
    }

    @ParameterizedTest
    @CsvSource({"3.14, 1, 3.14", "7.2, 2, 51.84", "-3.14, 1, -3.14", "-7.2, 2, 51.84"})
    void shouldAcceptFractionalBase(double base, double exponent, double expected) {
        assertEquals(expected, calculator.pow(base, exponent), DELTA);
    }

    @ParameterizedTest
    @CsvSource({"3, 0.15, 1.1791", "7, 2.5, 129.6418", "-3, 0.15, -1.1791", "-7, 2.5, -129.6418"})
    void shouldAcceptFractionalExponent(double base, double exponent, double expected) {
        assertEquals(expected, calculator.pow(base, exponent), DELTA);
    }

    @ParameterizedTest
    @CsvSource({"3, -0.15, 0.8481", "7, -2.5, 0.0077"})
    void shouldAcceptNegativeFractionalExponent(double base, double exponent, double expected) {
        assertEquals(expected, calculator.pow(base, exponent), DELTA);
    }

    @ParameterizedTest
    @CsvSource({"-3, -0.15", "-7, -2.5", "0, 0"})
    void shouldProduceNaN(double base, double exponent) {
        assertEquals(Double.NaN, calculator.pow(base, exponent));
    }

    @ParameterizedTest
    @MethodSource("positiveInfinity")
    void shouldProducePositiveInfinity(double base, double exponent) {
        assertEquals(Double.POSITIVE_INFINITY, calculator.pow(base, exponent));
    }

    static Stream<Arguments> positiveInfinity() {
        return Stream.of(
                arguments(1.4, Double.POSITIVE_INFINITY),
                arguments(0.4, Double.NEGATIVE_INFINITY),
                arguments(+0., -2.5),
                arguments(Double.POSITIVE_INFINITY, 4.5),
                arguments(-0., -6),
                arguments(Double.NEGATIVE_INFINITY, 5.3)
                );
    }

}
