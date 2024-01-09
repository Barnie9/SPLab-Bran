package app.repository;

import app.entity.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BookCrudRepositoryAdapter implements CrudRepository<Book, Long> {

    private final JpaRepository<Book, Long> jpaRepository;

    @Override
    public Book save(Book entity) {
        return jpaRepository.save(entity);
    }

    @Override
    public void delete(Book entity) {
        jpaRepository.delete(entity);
    }

    @Override
    public Book getReferenceById(Long id) {
        return jpaRepository.getReferenceById(id);
    }

    @Override
    public List<Book> findAll() {
        return jpaRepository.findAll();
    }
}
