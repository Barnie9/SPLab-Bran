package app.command;

import app.model.Book;
import app.service.BookService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UpdateBookCmd implements Command {

    private int id;
    private String title;

    @Override
    public Book execute(BookService bookService) {
        return bookService.updateBook(new Book(title), id);
    }
}
