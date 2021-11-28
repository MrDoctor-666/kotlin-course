package lab5

import java.lang.IllegalStateException
import java.time.Year

class Library : LibraryService {
    private val userList = mutableListOf<User>()
    private val bookStatuses = mutableMapOf<Book, BookStatus>()
    private val maxToGive = 3

    override fun findBooks(substring: String): List<Book> = bookStatuses.keys.filter { it.name.contains(substring) }

    override fun findBooks(author: Author): List<Book> = bookStatuses.keys.filter { it.authors.contains(author) }

    override fun findBooks(year: Year): List<Book> = bookStatuses.keys.filter { it.year == year }

    override fun findBooks(genre: Genre): List<Book> = bookStatuses.keys.filter { it.genre == genre }

    //addition
    override fun findBooks(
        substrName: String,
        author: Author?,
        year: Year?,
        genre: Genre?,
        status: BookStatus?
    ): List<Book> {
        return bookStatuses.filter {
            it.key.name.contains(substrName) &&
                    (author == null || it.key.authors.contains(author)) &&
                    (year == null || it.key.year == year) &&
                    (genre == null || it.key.genre == genre) &&
                    (status == null || it.value == status)
        }.keys.toList()
    }

    override fun getAllBooks(): List<Book> = bookStatuses.keys.toList()

    override fun getAllAvailableBooks(): List<Book> =
        bookStatuses.filter { it.value == BookStatus.Available }.keys.toList()

    override fun getBookStatus(book: Book): BookStatus {
        if (!bookStatuses.contains(book)) throw Exception("")
        return bookStatuses[book]!!
    }

    override fun getAllBookStatuses(): Map<Book, BookStatus> = bookStatuses.toMap()

    override fun setBookStatus(book: Book, status: BookStatus) {
        if (!bookStatuses.contains(book)) throw IllegalStateException("This book is not in the library")
        bookStatuses.replace(book, status)
    }

    override fun addBook(book: Book, status: BookStatus) {
        if (bookStatuses.keys.contains(book)) throw IllegalStateException("This book exists in the library")
        bookStatuses[book] = status
        //bookList.add(book)
    }

    override fun registerUser(user: User) {
        if (userList.contains(user)) throw IllegalStateException("This user exists")
        userList.add(user)
    }

    override fun unregisterUser(user: User) {
        if (!userList.contains(user)) throw IllegalStateException("This user doesn't exist")
        userList.remove(user)
    }

    override fun takeBook(user: User, book: Book) {
        if (!userList.contains(user)) throw IllegalStateException("This user is unregister")
        if (!bookStatuses.contains(book) || bookStatuses[book] !is BookStatus.Available) throw IllegalStateException(
            "Book can't be given"
        )

        //if user owns maximum books then we can't give him this book
        if (bookStatuses.filter {
                (it.value is BookStatus.UsedBy && (it.value as BookStatus.UsedBy).user == user)
            }.size == maxToGive)
            throw Exception("User owns too much books")

        bookStatuses.replace(book, BookStatus.UsedBy(user))
    }

    override fun returnBook(book: Book) {
        if (!bookStatuses.contains(book)) throw IllegalStateException("This book doesn't exist in the library")
        if (bookStatuses[book] !is BookStatus.UsedBy) throw IllegalStateException("This book is not taken")

        bookStatuses.replace(book, BookStatus.Available)
    }
}
