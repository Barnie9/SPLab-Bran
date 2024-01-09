package app.command;

import app.entity.Book;
import app.service.BookService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UpdateBookCmd implements Command {

    private Long id;
    private String title;

    @Override
    public Book execute(BookService bookService) {
        return bookService.updateBook(title, id);
    }
}
