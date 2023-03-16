package com.spring.app.springapp1.service;

import com.spring.app.springapp1.model.Book;

public interface BookService {

    Iterable<Book> findAll();
}
