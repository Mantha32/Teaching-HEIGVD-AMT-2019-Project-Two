package io.useraccount.api.services;
import io.useraccount.api.exceptions.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUserDAOService<T, U> {
    public T create(T entity) throws NotFoundException;

    public T update(U id, T entity) throws NotFoundException;

    public void delete(U id) throws NotFoundException;

    public T get(U id) throws NotFoundException;

    public Page<T> get(Pageable pgble);
}
