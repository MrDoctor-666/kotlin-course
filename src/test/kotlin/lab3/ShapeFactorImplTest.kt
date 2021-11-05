package lab3

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import kotlin.math.PI

internal class ShapeFactorImplTest {
    val shapeFact = ShapeFactorImpl()

    @Test
    fun createCircle() {
        val circle = shapeFact.createCircle(10.0)
        assertEquals(2 * PI * 10.0, circle.calcPerimeter())
        assertEquals(PI * 100.0, circle.calcArea())
    }

    @Test
    fun createSquare() {
        val square = shapeFact.createSquare(10.0)
        assertEquals(40.0, square.calcPerimeter())
        assertEquals(100.0, square.calcArea())
    }

    @Test
    fun createRectangle() {
        val rectangle = shapeFact.createRectangle(10.0, 12.0)
        assertEquals(20.0 + 24.0, rectangle.calcPerimeter())
        assertEquals(120.0, rectangle.calcArea())
    }

    @Test
    fun createTriangle() {
        val triangle = shapeFact.createTriangle(6.0, 8.0, 10.0)
        assertEquals(24.0, triangle.calcPerimeter())
        assertEquals(24.0, triangle.calcArea())
    }

    @Test
    fun createRandomCircle() {
        try {
            shapeFact.createRandomCircle()
        } catch (e: Exception) {
            fail()
        }
    }

    @Test
    fun createRandomSquare() {
        try {
            shapeFact.createRandomSquare()
        } catch (e: Exception) {
            fail()
        }
    }

    @Test
    fun createRandomRectangle() {
        try {
            shapeFact.createRandomRectangle()
        } catch (e: Exception) {
            fail()
        }
    }

    @Test
    fun createRandomTriangle() {
        try {
            shapeFact.createRandomTriangle()
        } catch (e: Exception) {
            fail()
        }
    }

    @Test
    fun createRandomShape() {
        try {
            shapeFact.createRandomShape()
        } catch (e: Exception) {
            fail()
        }
    }

    @Test
    fun wrongCircleCreation() {
        try {
            shapeFact.createCircle(-1.0)
        } catch (e: Error) {
            assertEquals("Radius is negative", e.message)
        }
    }

    @Test
    fun wrongTriangleCreation() {
        try {
            shapeFact.createTriangle(4.0, 6.0, 10.0)
        } catch (e: Error) {
            assertEquals("Triangle doesn't exist", e.message)
        }
    }

}