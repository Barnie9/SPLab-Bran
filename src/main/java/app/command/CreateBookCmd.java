package app.command;

import app.entity.Book;
import app.service.BookService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateBookCmd implements Command {
    private String title;

    @Override
    public Book execute(BookService bookService) {
        return bookService.createBook(title);
    }
}
