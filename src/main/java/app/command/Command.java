package app.command;

import app.service.BookService;

public interface Command {
    <T> T execute(BookService bookService);
}
