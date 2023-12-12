package app.service;

import app.entity.Author;

import java.util.List;

public interface AuthorService {
    Author getAuthorById(int id);
    List<Author> getAuthors();
    Author createAuthor(String name);
    Author updateAuthor(String name, int id);
    Author deleteAuthor(int id);
}
