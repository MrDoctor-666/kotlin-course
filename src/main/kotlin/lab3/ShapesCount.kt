package lab3

class ShapesCount(private val lShapes: List<Shape>) {
    init {
        if (lShapes.isEmpty()) throw Error("List is empty")
    }

    fun sumArea(): Double {
        var sumArea = 0.0
        lShapes.forEach { sumArea += it.calcArea() }
        return sumArea
    }

    fun sumPerimeter(): Double = lShapes.sumOf { it.calcPerimeter() }

    fun maxArea(): Shape {
        var maxA = lShapes[0]
        lShapes.forEach {
            if (it.calcArea() > maxA.calcArea()) maxA = it
        }
        return maxA
    }

    fun minArea(): Shape = lShapes.minByOrNull { it.calcArea() } as Shape

    fun maxPerimeter(): Shape = lShapes.maxByOrNull { it.calcPerimeter() } as Shape

    fun minPerimeter(): Shape = lShapes.minByOrNull { it.calcPerimeter() } as Shape

    fun printInfo() {
        println("Max S = " + maxArea().calcArea().toString() + " in " + maxArea().javaClass)
        println("Min S = " + minArea().calcArea().toString() + " in " + minArea().javaClass)
        println("Max P = " + maxPerimeter().calcPerimeter().toString() + " in " + maxPerimeter().javaClass)
        println("Min P = " + minPerimeter().calcPerimeter().toString() + " in " + minPerimeter().javaClass)
        println("Total S = ${sumArea()}")
        println("Total P = ${sumPerimeter()}")
    }
}