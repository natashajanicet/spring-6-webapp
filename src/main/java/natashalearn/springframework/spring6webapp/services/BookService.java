package natashalearn.springframework.spring6webapp.services;

import natashalearn.springframework.spring6webapp.domain.Book;

public interface BookService {
    Iterable<Book> findAll();
}
