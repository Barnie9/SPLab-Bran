package app.command;

import app.model.Book;
import app.service.BookService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GetBookByIdCmd implements Command {
    private int id;

    @Override
    public Book execute(BookService bookService) {
        return bookService.getBookById(id);
    }
}
