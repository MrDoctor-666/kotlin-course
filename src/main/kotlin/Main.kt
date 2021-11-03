fun main() {

    val str = """- It's too long. By the time I've called look out, what's your name?
        |- Romanadvoratnelundar.
        |- By the time I've called that out, you could be dead. I'll call you Romana.
    """.trimMargin()
    println(str + System.lineSeparator())
    println(lab1.alignText(str, 25, lab1.Alignment.CENTER) + System.lineSeparator())

    val exp = lab2.Calculator("-2 + 2^5*(-(2 -3))/4")
    println(exp.calc())

}