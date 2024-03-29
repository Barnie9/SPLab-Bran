package app.command;

import app.entity.Book;
import app.service.BookService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GetBookByIdCmd implements Command {
    private Long id;

    @Override
    public Book execute(BookService bookService) {
        return bookService.getBookById(id);
    }
}
