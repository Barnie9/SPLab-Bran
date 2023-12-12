package app.service;

import app.entity.Book;
import app.entity.BookAuthor;

import java.util.List;

public interface BookService {
    Book getBookById(int id);
    List<Book> getBooks();
    Book createBook(String title);
    Book updateBook(String title, int id);
    Book deleteBook(int id);
    BookAuthor addAuthor(int bookId, int authorId);
}
