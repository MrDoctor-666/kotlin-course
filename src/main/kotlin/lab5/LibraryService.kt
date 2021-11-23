package lab5

import java.time.Year

interface LibraryService {
    fun findBooks(substring: String): List<Book>
    fun findBooks(author: Author): List<Book>
    fun findBooks(year: Year): List<Book>
    fun findBooks(genre: Genre): List<Book>
    fun findBooks(
        substrName: String = "",
        author: Author? = null,
        year: Year? = null,
        genre: Genre? = null,
        status: BookStatus? = null
    ): List<Book>

    fun getAllBooks(): List<Book>
    fun getAllAvailableBooks(): List<Book>

    fun getBookStatus(book: Book): BookStatus
    fun getAllBookStatuses(): Map<Book, BookStatus>

    fun setBookStatus(book: Book, status: BookStatus)

    fun addBook(book: Book, status: BookStatus = BookStatus.Available)

    fun registerUser(user: User)
    fun unregisterUser(user: User)

    fun takeBook(user: User, book: Book)
    fun returnBook(book: Book)
}
