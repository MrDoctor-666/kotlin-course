package lab3

import kotlin.math.PI
import kotlin.math.pow
import kotlin.math.sqrt

interface Shape {
    fun calcArea(): Double
    fun calcPerimeter(): Double
}

class Circle(val radius: Double) : Shape {
    init {
        if (radius < 0) throw IllegalArgumentException("Radius is negative")
    }

    override fun calcArea(): Double = PI * radius.pow(2)

    override fun calcPerimeter(): Double = 2 * PI * radius

}

class Square(val a: Double) : Shape {
    init {
        if (a < 0) throw IllegalArgumentException("Side is negative")
    }

    override fun calcArea(): Double = a.pow(2)

    override fun calcPerimeter(): Double = 4 * a

}

class Rectangle(val a: Double, val b: Double) : Shape {
    init {
        if (a < 0 || b < 0) throw IllegalArgumentException("Side is negative")
    }

    override fun calcArea(): Double = a * b

    override fun calcPerimeter(): Double = 2 * (a + b)

}

class Triangle(
    val a: Double,
    val b: Double,
    val c: Double
) : Shape {
    init {
        if (a < 0 || b < 0 || c < 0) throw IllegalArgumentException("Side is negative")
        if (a + b <= c || a + c <= b || b + c <= a) throw  IllegalArgumentException("Triangle doesn't exist")
    }

    override fun calcArea(): Double {
        val semiP = calcPerimeter() / 2
        return sqrt(semiP * (semiP - a) * (semiP - b) * (semiP - c))
    }

    override fun calcPerimeter(): Double = a + b + c

}