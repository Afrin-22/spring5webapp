package com.rin.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.rin.spring5webapp.domain.Author;
import com.rin.spring5webapp.domain.Book;
import com.rin.spring5webapp.domain.Publisher;
import com.rin.spring5webapp.repositories.AuthorRepository;
import com.rin.spring5webapp.repositories.BookRepository;
import com.rin.spring5webapp.repositories.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner {

	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;
	
	public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,
			PublisherRepository publisherRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}


	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("Started in bootstap...");

		Publisher publisher = new Publisher("Rin", "afasf36", "Chennai", "TN", "604202");
		
		
		publisherRepository.save(publisher);
		
		System.out.println("Publisher count "+publisherRepository.count());
		
		Author eric = new Author("Eric","Evans");
		Book ddd = new Book("Domain Driven Design", "432535");
		
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		ddd.setPublisher(publisher);
		publisher.getBooks().add(ddd);
		
		authorRepository.save(eric);
		bookRepository.save(ddd);
		publisherRepository.save(publisher);
		
		Author rod = new Author("Rod","Johnson");
		Book noEJB = new Book("NoEJB", "4658658");
		
		
		eric.getBooks().add(noEJB);
		noEJB.getAuthors().add(rod);
		noEJB.setPublisher(publisher);
		publisher.getBooks().add(noEJB);

		authorRepository.save(rod);
		bookRepository.save(noEJB);
		publisherRepository.save(publisher);
		
		System.out.println("No of books "+bookRepository.count());
		System.out.println("Publisher no of books "+publisher.getBooks().size());
	}

}
