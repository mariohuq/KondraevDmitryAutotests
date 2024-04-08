package edu.hsai.calculator;

import com.epam.tat.module4.Calculator;
import org.junit.jupiter.api.BeforeAll;

public abstract class CalculatorTest {
    protected static Calculator calculator;

    // double results compared with respect to DELTA
    public static final double DELTA = 1.e-3;

    @BeforeAll
    static void init() {
        calculator = new Calculator();
    }
}
