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

class Book(
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

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Book

        if (name != other.name) return false
        if (authors != other.authors) return false
        if (genre != other.genre) return false
        if (year != other.year) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + authors.hashCode()
        result = 31 * result + genre.hashCode()
        result = 31 * result + year.hashCode()
        return result
    }
}

sealed class BookStatus {
    object Available : BookStatus()
    class UsedBy(val user: User) : BookStatus()
    object ComingSoon : BookStatus()
    object OnMaintenance : BookStatus()

}