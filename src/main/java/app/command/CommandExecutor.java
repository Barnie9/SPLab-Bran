package app.command;

import app.service.BookService;

public interface CommandExecutor {
    abstract Request executeCommand(Command command, BookService bookService);
}
