package app.repository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CrudRepository<T, ID> {
    public T save(T entity);

    public void delete(T entity);

    public T getReferenceById(ID id);

    public List<T> findAll();
}
