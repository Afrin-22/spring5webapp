package com.rin.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.rin.spring5webapp.domain.Author;
import com.rin.spring5webapp.domain.Book;
import com.rin.spring5webapp.repositories.AuthorRepository;
import com.rin.spring5webapp.repositories.BookRepository;

@Component
public class BootStrapData implements CommandLineRunner {

	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	
	
	public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
	}


	@Override
	public void run(String... args) throws Exception {
		
		Author eric = new Author("Eric","Evans");
		Book ddd = new Book("Domain Driven Design", "432535");
		
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		authorRepository.save(eric);
		bookRepository.save(ddd);
		
		Author rod = new Author("Rod","Johnson");
		Book noEJB = new Book("NoEJB", "4658658");
		
		eric.getBooks().add(noEJB);
		ddd.getAuthors().add(rod);
		authorRepository.save(rod);
		bookRepository.save(noEJB);
		

		System.out.println("Starting bootstap...");
		System.out.println("No of books "+bookRepository.count());
	}

}
