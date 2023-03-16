package com.spring.app.springapp1.repository;

import com.spring.app.springapp1.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Integer> {
}
