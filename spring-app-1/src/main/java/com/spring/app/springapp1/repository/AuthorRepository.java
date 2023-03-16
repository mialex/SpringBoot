package com.spring.app.springapp1.repository;

import com.spring.app.springapp1.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Integer> {
}
