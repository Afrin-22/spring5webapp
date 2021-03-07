package com.rin.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.rin.spring5webapp.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

}
