package com.tech.mkblogs.repository;

import java.util.Set;

import javax.transaction.Transactional;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tech.mkblogs.model.Author;
import com.tech.mkblogs.model.Book;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
@Transactional
public class TestJPARepositoryNamedEntityGraph {

	@Autowired
	AuthorRepository authorRepository; 
	
	@Before
	public void beforeMethod() {
		log.info("=============================================================");		
	}

	@After
	public void afterMethod() {		
		log.info("=============================================================");
	}

	@Test
	public void selectWithOutEntityGraph() {
		log.info("... selectWithOutEntityGraph ...");		
		Author author = authorRepository.findAuthor(1);
		displayAuthor(author);
	}
	
	@Test
	public void findNamedEntityGraphBooksAndFetch() {
		log.info("... findNamedEntityGraphBooksAndFetch ...");		
		Author author = authorRepository.findNamedEntityGraphBooksAndFetch(1);
		displayAuthor(author);
	}
	
	@Test
	public void findNamedEntityGraphBooksAndLoad() {
		log.info("... findNamedEntityGraphBooksAndLoad ...");		
		Author author = authorRepository.findNamedEntityGraphBooksAndLoad(1);
		displayAuthor(author);
	}
	
	@Test
	public void findNamedEntityGraphBooksPublisherAndFetch() {
		log.info("... findNamedEntityGraphBooksPublisherAndFetch ...");		
		Author author = authorRepository.findNamedEntityGraphBooksPublisherAndFetch(1);
		displayAuthor(author);
	}
	
	@Test
	public void findNamedEntityGraphBooksPublisherAndLoad() {
		log.info("... findNamedEntityGraphBooksPublisherAndLoad ...");		
		Author author = authorRepository.findNamedEntityGraphBooksPublisherAndLoad(1);
		displayAuthor(author);
	}
	
	protected void displayAuthor(Author author) {
		log.info(author.getFirstName()+" "+author.getLastName()+" wrote "+author.getBooks().size()+" books.");
		Set<Book> books = author.getBooks(); 
		 for(Book book: books) {
			log.info(book.getPublisher()); 
		 }
	}
	
}
