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
public class TestJPARepositoryEntityGraph {

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
	public void findOnlyBooksAndFetch() {
		log.info("... findOnlyBooksAndFetch ...");		
		Author author = authorRepository.findOnlyBooksAndFetch(1);
		displayAuthor(author);
	}
	
	@Test
	public void findOnlyBooksAndLoad() {
		log.info("... findOnlyBooksAndLoad ...");		
		Author author = authorRepository.findOnlyBooksAndLoad(1);
		displayAuthor(author);
	}
	
	@Test
	public void findBooksPublisherAndFetch() {
		log.info("... findBooksPublisherAndFetch ...");		
		Author author = authorRepository.findBooksPublisherAndFetch(1);
		displayAuthor(author);
	}
	
	@Test
	public void findBooksPublisherAndLoad() {
		log.info("... findBooksPublisherAndLoad ...");		
		Author author = authorRepository.findBooksPublisherAndLoad(1);
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
