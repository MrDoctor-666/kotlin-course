package lab3

import kotlin.math.PI
import kotlin.math.pow
import kotlin.math.sqrt

interface Shape {
    fun calcArea(): Double
    fun calcPerimeter(): Double
}

class Circle(private val radius: Double) : Shape {
    init {
        if (radius < 0) throw Error("Radius is negative")
    }

    override fun calcArea(): Double = PI * radius.pow(2)

    override fun calcPerimeter(): Double = 2 * PI * radius

}

class Square(private val a: Double) : Shape {
    init {
        if (a < 0) throw Error("Side is negative")
    }

    override fun calcArea(): Double = a.pow(2)

    override fun calcPerimeter(): Double = 4 * a

}

class Rectangle(private val a: Double, private val b: Double) : Shape {
    init {
        if (a < 0 || b < 0) throw Error("Side is negative")
    }

    override fun calcArea(): Double = a * b

    override fun calcPerimeter(): Double = 2 * (a + b)

}

class Triangle(
    private val a: Double,
    private val b: Double,
    private val c: Double
) : Shape {
    init {
        if (a < 0 || b < 0 || c < 0) throw Error("Side is negative")
        if (a + b <= c || a + c <= b || b + c <= a) throw  Error("Triangle doesn't exist")
    }

    override fun calcArea(): Double {
        val semiP = calcPerimeter() / 2
        return sqrt(semiP * (semiP - a) * (semiP - b) * (semiP - c))
    }

    override fun calcPerimeter(): Double = a + b + c

}