package app.command;

import app.entity.Book;
import app.service.BookService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DeleteBookCmd implements Command {
    private Long id;

    @Override
    public Book execute(BookService bookService) {
        return bookService.deleteBook(id);
    }
}
