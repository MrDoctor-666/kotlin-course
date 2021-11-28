package lab5

import java.time.Year

enum class Genre {
    FANTASY,
    SCI_FI,
    HORROR,
    NON_FICTION
}

@JvmInline
value class Author(val fullName: String) {
    override fun toString(): String {
        return fullName
    }
}

data class Book(
    val name: String,
    val authors: List<Author>,
    val genre: Genre,
    val year: Year
) {

    init {
        if (year.isAfter(Year.now())) throw IllegalArgumentException("Year is wrong")
    }

    override fun toString(): String {
        return "\"$name\" by $authors" + System.lineSeparator() +
                "Genre: $genre" + System.lineSeparator() +
                "Year: $year" + System.lineSeparator()
    }
}

sealed class BookStatus {
    object Available : BookStatus()
    class UsedBy(val user: User) : BookStatus()
    object ComingSoon : BookStatus()
    object OnMaintenance : BookStatus()

}