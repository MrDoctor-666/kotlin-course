package lab4

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class MatrixTest {
    private val arr: Array<Array<Double>> = arrayOf(
        arrayOf(1.0, 2.0),
        arrayOf(3.0, 4.0)
    )
    private val matrixA = Matrix(arr)
    private val arr2: Array<Array<Double>> = arrayOf(
        arrayOf(4.0, 3.0, 2.0),
        arrayOf(2.0, 1.0, 1.0)
    )
    private val matrixB = Matrix(arr2)

    @Test
    fun initError() {
        try {
            Matrix(arrayOf(arrayOf(1.0), arrayOf(2.0, 3.0)))
        } catch (ex: IllegalArgumentException) {
            assertEquals("Matrix is wrong-sized", ex.message)
        }
    }

    @Test
    fun initRight() {
        arr[0][0] = 0.0
        assertEquals(1.0, matrixA[0, 0])
    }

    @Test
    fun set() {
        matrixA[1, 0] = 0.0
        assertEquals(0.0, matrixA[1, 0])
    }

    @Test
    fun getDimensions() {
        val dimB = matrixB.getDimensions()
        assertEquals(2, dimB.first)
        assertEquals(3, dimB.second)
    }

    @Test
    fun testEquals() {
        val testMatrix = Matrix(arr)
        assertTrue(matrixA == testMatrix)
    }

    @Test
    fun testEqualsNot() {
        assertFalse(matrixA == matrixB)
    }

    @Test
    fun plus() {
        matrixA += matrixA
        val arrToCompare: Array<Array<Double>> = arrayOf(
            arrayOf(2.0, 4.0),
            arrayOf(6.0, 8.0)
        )
        val matrixToCompare = Matrix(arrToCompare)
        assertEquals(matrixToCompare, matrixA)
    }

    @Test
    fun plusError() {
        try {
            matrixA + matrixB
        } catch (ex: IllegalArgumentException) {
            assertEquals("Dimensions are different", ex.message)
        }
    }

    @Test
    fun minus() {
        matrixA -= matrixA
        val arrToCompare: Array<Array<Double>> = arrayOf(
            arrayOf(0.0, 0.0),
            arrayOf(0.0, 0.0)
        )
        val matrixToCompare = Matrix(arrToCompare)
        assertEquals(matrixToCompare, matrixA)
    }

    @Test
    fun timesMatrix() {
        matrixA *= matrixB
        val arrToCompare: Array<Array<Double>> = arrayOf(
            arrayOf(8.0, 5.0, 4.0),
            arrayOf(20.0, 13.0, 10.0)
        )
        val matrixToCompare = Matrix(arrToCompare)
        assertEquals(matrixToCompare, matrixA)
    }

    @Test
    fun timesScalar() {
        matrixA *= 3.0
        val arrToCompare: Array<Array<Double>> = arrayOf(
            arrayOf(3.0, 6.0),
            arrayOf(9.0, 12.0)
        )
        val matrixToCompare = Matrix(arrToCompare)
        assertEquals(matrixToCompare, matrixA)
    }

    @Test
    fun div() {
        matrixA /= 3.0
        val arrToCompare: Array<Array<Double>> = arrayOf(
            arrayOf(1.0 / 3, 2.0 / 3),
            arrayOf(3.0 / 3, 4.0 / 3)
        )
        val matrixToCompare = Matrix(arrToCompare)
        assertEquals(matrixToCompare, matrixA)
    }
}