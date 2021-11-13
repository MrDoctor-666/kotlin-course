package lab3

import kotlin.random.Random
import kotlin.random.nextInt

interface ShapeFactory {
    fun createCircle(_radius: Double): Circle
    fun createSquare(_side: Double): Square
    fun createRectangle(_width: Double, _length: Double): Rectangle
    fun createTriangle(_sideA: Double, _sideB: Double, _sideC: Double): Triangle

    fun createRandomCircle(): Circle
    fun createRandomSquare(): Square
    fun createRandomRectangle(): Rectangle
    fun createRandomTriangle(): Triangle

    fun createRandomShape(): Shape
}

class ShapeFactorImpl(private val maxRandomValue: Double = Double.MAX_VALUE) : ShapeFactory {
    override fun createCircle(_radius: Double): Circle = Circle(_radius)

    override fun createSquare(_side: Double): Square = Square(_side)

    override fun createRectangle(_width: Double, _length: Double): Rectangle = Rectangle(_width, _length)

    override fun createTriangle(_sideA: Double, _sideB: Double, _sideC: Double): Triangle {
        return Triangle(_sideA, _sideB, _sideC)
    }

    override fun createRandomCircle(): Circle =
        Circle(Random.nextDouble(until = maxRandomValue))

    override fun createRandomSquare(): Square =
        Square(Random.nextDouble(until = maxRandomValue))

    override fun createRandomRectangle(): Rectangle =
        Rectangle(Random.nextDouble(until = maxRandomValue), Random.nextDouble(until = maxRandomValue))

    override fun createRandomTriangle(): Triangle {
        val a = Random.nextDouble(until = maxRandomValue)
        val b = Random.nextDouble(until = maxRandomValue)
        val c = Random.nextDouble(kotlin.math.max(a, b) - kotlin.math.min(a, b), a + b)
        return Triangle(a, b, c)
    }

    override fun createRandomShape(): Shape {
        return when (Random.nextInt(1..4)) {
            1 -> createRandomCircle()
            2 -> createRandomSquare()
            3 -> createRandomRectangle()
            4 -> createRandomTriangle()
            else -> throw Error("Invalid argument in when")
        }
    }

}