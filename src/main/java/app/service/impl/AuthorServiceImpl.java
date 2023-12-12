package app.service.impl;

import app.entity.Author;
import app.repository.AuthorRepository;
import app.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author getAuthorById(int id) {
        return authorRepository.getReferenceById(id);
    }

    @Override
    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Author createAuthor(String name) {
        Author author = new Author();
        author.setName(name);
        return authorRepository.save(author);
    }

    @Override
    public Author updateAuthor(String name, int id) {
        Author authorToUpdate = authorRepository.getReferenceById(id);
        authorToUpdate.setName(name);
        return authorRepository.save(authorToUpdate);
    }

    @Override
    public Author deleteAuthor(int id) {
        Author authorToDelete = authorRepository.getReferenceById(id);
        authorRepository.delete(authorToDelete);
        return authorToDelete;
    }
}
