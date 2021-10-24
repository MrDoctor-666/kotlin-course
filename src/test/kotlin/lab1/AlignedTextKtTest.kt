package lab1

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class AlignedTextKtTest {
    private val strTest = """- It's too long. By the time I've called look out, what's your name?
        |- Romanadvoratnelundar.
        |- By the time I've called that out, you could be dead. I'll call you Romana.
    """.trimMargin()

    @Test
    fun emptyStringTest() {
       assertEquals("", alignText("", 4, Alignment.LEFT))
    }

    @Test
    fun simpleLeftTest() {
        val expected = "- It's too long. By the  " + System.lineSeparator() +
                "time I've called look    " + System.lineSeparator() +
                "out, what's your name?   " +System.lineSeparator() +
                "- Romanadvoratnelundar.  " +System.lineSeparator() +
                "- By the time I've called" +System.lineSeparator() +
                "that out, you could be   " +System.lineSeparator() +
                "dead. I'll call you      " +System.lineSeparator() +
                "Romana.                  "
        assertEquals(expected, alignText(strTest, 25, Alignment.LEFT))
    }

    @Test
    fun simpleRightTest() {
        val expected = "  - It's too long. By the" +System.lineSeparator() +
                "    time I've called look" +System.lineSeparator() +
                "   out, what's your name?" +System.lineSeparator() +
                "  - Romanadvoratnelundar." +System.lineSeparator() +
                "- By the time I've called" +System.lineSeparator() +
                "   that out, you could be" +System.lineSeparator() +
                "      dead. I'll call you" +System.lineSeparator() +
                "                  Romana."
        assertEquals(expected, alignText(strTest, 25, Alignment.RIGHT))
    }

    @Test
    fun simpleCenterTest() {
        val expected = " - It's too long. By the " + System.lineSeparator() +
                "  time I've called look  " + System.lineSeparator() +
                "  out, what's your name? " + System.lineSeparator() +
                " - Romanadvoratnelundar. " + System.lineSeparator() +
                "- By the time I've called" + System.lineSeparator() +
                "  that out, you could be " + System.lineSeparator() +
                "   dead. I'll call you   " + System.lineSeparator() +
                "         Romana.         "
        assertEquals(expected, alignText(strTest, 25, Alignment.CENTER))
    }

    @Test
    fun wordTooBig() {
        val strToTest = "Romanadvoratnelundar."
        val expected = "Romanadvoratnelund" + System.lineSeparator() + "ar.".padStart(18, ' ')
        assertEquals(expected, alignText(strToTest, 18, Alignment.RIGHT))
    }

    @Test
    fun wordTooBigCenter() {
        val strToTest = "Romanadvoratnelundar."
        val expected = "Romanadvoratnelund" + System.lineSeparator() + "        ar.       "
        assertEquals(expected, alignText(strToTest, 18, Alignment.CENTER))
    }
}