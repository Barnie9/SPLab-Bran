package app.controller;

import app.command.*;
import app.model.*;
import app.service.BookService;
import app.service.impl.BookServiceImpl;
import app.services.BookStatistics;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class BooksController {

    BookService bookService = new BookServiceImpl();

    @GetMapping("/books")
    public List<Book> getBooks() {
        GetBooksCmd getBooksCmd = new GetBooksCmd();

        return getBooksCmd.execute(bookService);
    }

    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable int id) {
        GetBookByIdCmd getBookByIdCmd = new GetBookByIdCmd(id);

        return getBookByIdCmd.execute(bookService);
    }

    @PostMapping("/books")
    public Book createBook(@RequestBody Map<String, String> book) {
        CreateBookCmd createBookCmd = new CreateBookCmd(book.get("title"));

        return createBookCmd.execute(bookService);
    }

    @PutMapping("/books/{id}")
    public Book updateBook(@PathVariable int id, @RequestBody Map<String, String> book) {
        UpdateBookCmd updateBookCmd = new UpdateBookCmd(id, book.get("title"));

        return updateBookCmd.execute(bookService);
    }

    @DeleteMapping("/books/{id}")
    public Book deleteBook(@PathVariable int id) {
        DeleteBookCmd deleteBookCmd = new DeleteBookCmd(id);

        return deleteBookCmd.execute(bookService);
    }

    @GetMapping("/statistics")
    public ResponseEntity<?> printStatistics() {
        Section cap1 = new Section("Capitolul 1");

        try {
            Paragraph p1 = new Paragraph("Paragraph 1");
            cap1.add(p1);

            Paragraph p2 = new Paragraph("Paragraph 2");
            cap1.add(p2);

            Paragraph p3 = new Paragraph("Paragraph 3");
            cap1.add(p3);

            Paragraph p4 = new Paragraph("Paragraph 4");
            cap1.add(p4);

            cap1.add(new ImageProxy("ImageOne", 10, 10));
            cap1.add(new Image("ImageTwo"));
            cap1.add(new Paragraph("Some text"));
            cap1.add(new Table("Table 1"));

            BookStatistics stats = new BookStatistics();
            cap1.accept(stats);
            stats.printStatistics();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>("", HttpStatus.OK);
    }
}
