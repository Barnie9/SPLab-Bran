package app.controller;

import app.command.*;
import app.entity.BookAuthor;
import app.model.*;
import app.service.BookService;
import app.services.BookStatistics;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@RestController
public class BookController {

    private final BookService bookService;
    List<Request<?>> requests;
    CommandExecutor syncCommandExecutor;
    CommandExecutor asyncCommandExecutor;
    ExecutorService executorService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
        this.requests = new ArrayList<>();

        this.syncCommandExecutor = new SynchronousExecutor();
        this.asyncCommandExecutor = new AsynchronousExecutor();

        this.executorService = Executors.newFixedThreadPool(2);

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        // Schedule the function to run every 10 seconds
        scheduler.scheduleAtFixedRate(this::processRequests, 0, 10, TimeUnit.SECONDS);
    }

    @GetMapping("/requests/{id}")
    public ResponseEntity<?> getRequest(@PathVariable int id) {
        if (id >= requests.size()) {
            return new ResponseEntity<>("Request not found", HttpStatus.NOT_FOUND);
        }

        Request request = requests.get(id);

        if (request.isCompleted()) {
            return new ResponseEntity<>(request.getResult(), HttpStatus.OK);
        }

        return new ResponseEntity<>("Request not completed", HttpStatus.OK);
    }

    @GetMapping("/books")
    public ResponseEntity<Integer> getBooks() {
        Request request = syncCommandExecutor.executeCommand(new GetBooksCmd(), bookService);
        request.setId(requests.size());

        requests.add(request);

        return new ResponseEntity<>(requests.size() - 1, HttpStatus.OK);
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Integer> getBookById(@PathVariable int id) {
        Request request = syncCommandExecutor.executeCommand(new GetBookByIdCmd(id), bookService);
        request.setId(requests.size());

        requests.add(request);

        return new ResponseEntity<>(requests.size() - 1, HttpStatus.OK);
    }

    @PostMapping("/books")
    public ResponseEntity<Integer> createBook(@RequestBody Map<String, String> book) {
        Request request = syncCommandExecutor.executeCommand(new CreateBookCmd(book.get("title")), bookService);
        request.setId(requests.size());

        requests.add(request);

        return new ResponseEntity<>(requests.size() - 1, HttpStatus.OK);
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<Integer> updateBook(@PathVariable int id, @RequestBody Map<String, String> book) {
        Request request = syncCommandExecutor.executeCommand(new UpdateBookCmd(id, book.get("title")), bookService);
        request.setId(requests.size());

        requests.add(request);

        return new ResponseEntity<>(requests.size() - 1, HttpStatus.OK);
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<Integer> deleteBook(@PathVariable int id) {
        Request request = syncCommandExecutor.executeCommand(new DeleteBookCmd(id), bookService);
        request.setId(requests.size());

        requests.add(request);

        return new ResponseEntity<>(requests.size() - 1, HttpStatus.OK);
    }

    @PostMapping("/books/{bookId}/authors/{authorId}")
    public ResponseEntity<BookAuthor> addAuthor(@PathVariable int bookId, @PathVariable int authorId) {
        return new ResponseEntity<>(bookService.addAuthor(bookId, authorId), HttpStatus.OK);
    }

    public void processRequests() {
        System.out.println("Processing requests");

        for (Request request : requests) {
            if (!request.isCompleted()) {
                executorService.submit(() -> {
                    System.out.println("Executing request " + request.getId());

                    request.setResult(request.getCommand().execute(bookService));
                    request.setCompleted(true);

                    System.out.println("Request " + request.getId() + " completed");
                });
            }
        }
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
