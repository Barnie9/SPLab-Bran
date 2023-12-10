package app.command;

import app.model.Book;
import app.service.BookService;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class GetBooksCmd implements Command {
    @Override
    public List<Book> execute(BookService bookService) {
        return bookService.getBooks();
    }
}
