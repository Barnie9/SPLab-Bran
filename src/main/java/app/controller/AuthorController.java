package app.controller;

import app.entity.Author;
import app.service.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/authors")
    public ResponseEntity<List<Author>> getAuthors() {
        return new ResponseEntity<>(authorService.getAuthors(), HttpStatus.OK);
    }

    @GetMapping("/authors/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable int id) {
        return new ResponseEntity<>(authorService.getAuthorById(id), HttpStatus.OK);
    }

    @PostMapping("/authors")
    public ResponseEntity<Author> createAuthor(@RequestBody Map<String, String> body) {
        return new ResponseEntity<>(authorService.createAuthor(body.get("name")), HttpStatus.CREATED);
    }

    @PutMapping("/authors/{id}")
    public ResponseEntity<Author> updateAuthor(@PathVariable int id, @RequestBody Map<String, String> body) {
        return new ResponseEntity<>(authorService.updateAuthor(body.get("name"), id), HttpStatus.OK);
    }

    @DeleteMapping("/authors/{id}")
    public ResponseEntity<Author> deleteAuthor(@PathVariable int id) {
        return new ResponseEntity<>(authorService.deleteAuthor(id), HttpStatus.OK);
    }
}
