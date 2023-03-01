package natashalearn.springframework.spring6webapp.services;

import natashalearn.springframework.spring6webapp.domain.Author;

public interface AuthorService {
    Iterable<Author> findAll();
}
