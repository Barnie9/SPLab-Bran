package app.command;

import app.service.BookService;

public class SynchronousExecutor implements CommandExecutor {
    @Override
    public Request executeCommand(Command command, BookService bookService) {
        return new Request<>(0, command, true, command.execute(bookService));
    }
}
