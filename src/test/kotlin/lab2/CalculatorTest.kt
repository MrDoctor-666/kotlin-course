package lab2

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.lang.Math.pow

internal class CalculatorTest {
    @Test
    fun unaryMinusAfterPowTest() {
        assertEquals(253.0, Calculator("-3+4^+4").calc())
    }

    @Test
    fun unaryMinusAfterBracketsTest() {
        assertEquals(-2.0, Calculator("((-4+3))*8/4").calc())
    }

    @Test
    fun simpleExpressionTest() {
        assertEquals(-15.75, Calculator("(4+3)*9/ -4").calc())
    }

    @Test
    fun complexExpressionTest() {
        assertEquals(-2 + pow(2.0, 5.0) * (-(2 - 3)) / 4, Calculator("-2 + 2^5*(-(2 -3))/4").calc())
        assertEquals(6.0, Calculator("-2 + 2^5*(-(2 -3))/4").calc())
    }


    @Test
    fun constantPiTest() {
        assertEquals(kotlin.math.PI + 1, Calculator("pi + 1").calc())
    }

    @Test
    fun constantETest() {
        assertEquals(kotlin.math.E - 2, Calculator("-2 + E").calc())
    }

    @Test
    fun wrongLettersErrorTest() {
        try {
            Calculator("3+alksdjfklsdjfkldj+asdfd+3").calc()
        } catch (e: Error) {
            assertEquals("Unrecognizable letters", e.message)
        }
    }

    @Test
    fun wrongBracketsErrorTest() {
        try {
            Calculator("(3+4)*2)").calc()
        } catch (e: Error) {
            assertEquals("Wrong brackets", e.message)
        }
    }

    @Test
    fun wrongOperatorsErrorTest() {
        try {
            Calculator("*3").calc()
        } catch (e: Error) {
            assertEquals("Not enough arguments", e.message)
        }
    }

}