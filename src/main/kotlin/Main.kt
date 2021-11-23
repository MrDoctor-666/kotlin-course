//import lab4.Matrix
//import lab3.*
import lab5.*
import java.time.Year


fun main() {
    libWorks()
    //lab3
    /*val spFc = ShapeFactorImpl(1000000.0)
    val listSp = mutableListOf<Shape>()
    listSp.add(spFc.createCircle(10.0))
    listSp.add(spFc.createSquare(10.0))
    listSp.add(spFc.createRectangle(10.0, 11.0))
    listSp.add(spFc.createTriangle(10.0, 11.0, 12.0))

    ShapesCount(listSp).printInfo()*/

    //lab4
    /*val arr: Array<Array<Double>> = arrayOf(
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
    println(matrixB == Matrix(arr2))*/
}

fun libWorks() {
    //lab5
    val bookList = listOf(
        Book("Hello world", autList(), Genre.HORROR, Year.of(2009)),
        Book("In the woods", autList(), Genre.FANTASY, Year.of(2017)),
        Book("Hitchhiker's guide to the galaxy", listOf(Author("Douglas Adams")), Genre.SCI_FI, Year.of(1978)),
        Book("1", listOf(), Genre.NON_FICTION, Year.of(-100))
    )
    val lib: LibraryService = Library()

    //add to library
    bookList.forEach { lib.addBook(it) }

    println("All books: " + lib.getAllBooks().toString())
    lib.setBookStatus(bookList[0], BookStatus.OnMaintenance)
    lib.setBookStatus(bookList[3], BookStatus.ComingSoon)
    println("\nAll statuses: ")
    lib.getAllBookStatuses().forEach { println("${it.key.name} is ${it.value}") }

    //find
    println("\n" + lib.findBooks("woods", genre = Genre.FANTASY))

    //work with users
    lib.registerUser(User("Dave", "Mill"))
    lib.takeBook(User("Dave", "Mill"), bookList[1])
    println("\nAll statuses: ")
    lib.getAllBookStatuses().forEach { println("${it.key.name} is ${it.value}") }
    println("\nAvailable now:\n" + lib.getAllAvailableBooks())
    lib.returnBook(bookList[1])
    println("\nAvailable now:\n" + lib.getAllAvailableBooks())
}

fun autList(): List<Author> {
    return listOf(
        Author("James Hey"),
        Author("John Here")
    )
}
