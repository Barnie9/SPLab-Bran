package app.service.impl;

import app.entity.Book;
import app.repository.BookRepository;
import app.service.BookService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book getBookById(int id) {
        return bookRepository.getReferenceById(id);
    }

    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book createBook(String title) {
        Book book = new Book();
        book.setTitle(title);
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(String title, int id) {
        Book bookToUpdate = bookRepository.getReferenceById(id);
        bookToUpdate.setTitle(title);
        return bookRepository.save(bookToUpdate);
    }

    @Override
    public Book deleteBook(int id) {
        Book bookToDelete = bookRepository.getReferenceById(id);
        bookRepository.delete(bookToDelete);
        return bookToDelete;
    }
}
