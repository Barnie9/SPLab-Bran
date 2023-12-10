package app.service;

import app.model.Book;
import app.model.Author;

import java.util.List;

public interface BookService {
    Book getBookById(int id);
    List<Book> getBooks();
    Book createBook(Book book);
    Book updateBook(Book book, int id);
    Book deleteBook(int id);
}
