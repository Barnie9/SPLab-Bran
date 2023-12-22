package app.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@RequiredArgsConstructor
public class CrudRepositoryAdapter<T, ID> implements CrudRepository<T, ID> {

    private final JpaRepository<T, ID> jpaRepository;

    @Override
    public T save(T entity) {
        return jpaRepository.save(entity);
    }

    @Override
    public void delete(T entity) {
        jpaRepository.delete(entity);
    }

    @Override
    public T getReferenceById(ID id) {
        return jpaRepository.getReferenceById(id);
    }

    @Override
    public List<T> findAll() {
        return jpaRepository.findAll();
    }
}
