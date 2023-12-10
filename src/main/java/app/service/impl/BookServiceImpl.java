package app.service.impl;

import app.model.Book;
import app.service.BookService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    List<Book> books = new ArrayList<>();

    @Override
    public Book getBookById(int id) {
        return books.get(id);
    }

    @Override
    public List<Book> getBooks() {
        return books;
    }

    @Override
    public Book createBook(Book book) {
        books.add(book);
        return books.get(books.size() - 1);
    }

    @Override
    public Book updateBook(Book book, int id) {
        books.set(id, book);
        return books.get(id);
    }

    @Override
    public Book deleteBook(int id) {
        return books.remove(id);
    }
}
