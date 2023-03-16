package com.spring.app.springapp1.repository;

import com.spring.app.springapp1.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer> {
}
