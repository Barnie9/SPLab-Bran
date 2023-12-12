package app.service.impl;

import app.entity.Author;
import app.entity.Book;
import app.entity.BookAuthor;
import app.repository.AuthorRepository;
import app.repository.BookAuthorRepository;
import app.repository.BookRepository;
import app.service.BookService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final BookAuthorRepository bookAuthorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository, BookAuthorRepository bookAuthorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.bookAuthorRepository = bookAuthorRepository;
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

    @Override
    public BookAuthor addAuthor(int bookId, int authorId) {
        Book book = bookRepository.getReferenceById(bookId);
        Author author = authorRepository.getReferenceById(authorId);

        BookAuthor bookAuthor = new BookAuthor();

        bookAuthor.setBook(book);
        bookAuthor.setAuthor(author);

        return bookAuthorRepository.save(bookAuthor);
    }
}
