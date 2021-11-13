import lab4.Matrix
import lab3.*


fun main() {
    //lab3
    val spFc = ShapeFactorImpl(1000000.0)
    val listSp = mutableListOf<Shape>()
    listSp.add(spFc.createCircle(10.0))
    listSp.add(spFc.createSquare(10.0))
    listSp.add(spFc.createRectangle(10.0, 11.0))
    listSp.add(spFc.createTriangle(10.0, 11.0, 12.0))

    ShapesCount(listSp).printInfo()

    //lab4
    val arr: Array<Array<Double>> = arrayOf(
        arrayOf(1.0, 2.0),
        arrayOf(3.0, 4.0)
    )
    val arr2: Array<Array<Double>> = arrayOf(
        arrayOf(4.0, 3.0, 2.0),
        arrayOf(2.0, 1.0, 1.0)
    )
    val arr3: Array<Array<Double>> = arrayOf(
        arrayOf(4.0, 3.0),
        arrayOf(2.0, 1.0)
    )
    val matrixA = Matrix(arr)
    val matrixB = Matrix(arr2)
    val matrixC = Matrix(arr3)

    println(System.lineSeparator() + "Matrix A: " + System.lineSeparator() + matrixA.toString())
    println("Matrix B: " + System.lineSeparator() + matrixB.toString())
    println("Matrix B: " + System.lineSeparator() + matrixC.toString())
    println("Matrix A + matrix C: " + System.lineSeparator() + (matrixA + matrixC).toString())
    println("Matrix A - matrix C: " + System.lineSeparator() + (matrixA - matrixC).toString())
    println("Matrix A * matrix B: " + System.lineSeparator() + (matrixA * matrixB).toString())
    println("Matrix B * 3.0: " + System.lineSeparator() + (matrixB * 3.0).toString())
    println("Matrix B / 3.0: " + System.lineSeparator() + (matrixB / 3.0).toString())
    println("+Matrix B: " + System.lineSeparator() + (+matrixB).toString())
    println("-Matrix B: " + System.lineSeparator() + (-matrixB).toString())

    matrixA *= 3.0
    matrixA /= 3.0
    println("Matrix A *3 /3: " + System.lineSeparator() + matrixA.toString())

    println(matrixB == matrixA)
    println(matrixB == Matrix(arr2))
}