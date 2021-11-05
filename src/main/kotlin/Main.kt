import lab3.*

fun main() {
    val spFc = ShapeFactorImpl(1000000.0)
    val listSp = mutableListOf<Shape>()
    listSp.add(spFc.createCircle(10.0))
    listSp.add(spFc.createSquare(10.0))
    listSp.add(spFc.createRectangle(10.0, 11.0))
    listSp.add(spFc.createTriangle(10.0, 11.0, 12.0))

    ShapesCount(listSp).printInfo()
}