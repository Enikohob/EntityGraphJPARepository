package com.tech.mkblogs.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tech.mkblogs.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

	 /**
	  *  No Entity Graph
	  * @param id
	  * @return
	  */
	
	 @Query("SELECT author FROM Author author WHERE author.id = :id ")
	 Author findAuthor(@Param("id")  Integer id);
	
	 /**
	 * attributePaths examples
	 */
	 
	 @EntityGraph(attributePaths = {"books"},type = EntityGraphType.FETCH)
	 @Query("SELECT author FROM Author author WHERE author.id = :id ")
	 Author findOnlyBooksAndFetch(@Param("id")  Integer id);
	 
	 @EntityGraph(attributePaths = {"books"},type = EntityGraphType.LOAD)
	 @Query("SELECT author FROM Author author WHERE author.id = :id ")
	 Author findOnlyBooksAndLoad(@Param("id")  Integer id);
	 
	 @EntityGraph(attributePaths = {"books","books.publisher"},type = EntityGraphType.LOAD)
	 @Query("SELECT author FROM Author author WHERE author.id = :id ")
	 Author findBooksPublisherAndLoad(@Param("id") Integer id);
	 
	 @EntityGraph(attributePaths = {"books","books.publisher"},type = EntityGraphType.FETCH)
	 @Query("SELECT author FROM Author author WHERE author.id = :id ")
	 Author findBooksPublisherAndFetch(@Param("id") Integer id);
	 
	 /**
	  * Using Named Entity Graph Value
	  */
	 
	 @EntityGraph(value ="graph.author.books" , type = EntityGraphType.FETCH)
	 @Query("SELECT author FROM Author author WHERE author.id = :id ")
	 Author findNamedEntityGraphBooksAndFetch(@Param("id")  Integer id);
	 
	 @EntityGraph(value ="graph.author.books" , type = EntityGraphType.LOAD)
	 @Query("SELECT author FROM Author author WHERE author.id = :id ")
	 Author findNamedEntityGraphBooksAndLoad(@Param("id")  Integer id);
	 
	 @EntityGraph(value ="graph.author.books.publisher",type = EntityGraphType.FETCH)
	 @Query("SELECT author FROM Author author WHERE author.id = :id ")
	 Author findNamedEntityGraphBooksPublisherAndFetch(@Param("id") Integer id);
	 
	 @EntityGraph(value ="graph.author.books.publisher",type = EntityGraphType.LOAD)
	 @Query("SELECT author FROM Author author WHERE author.id = :id ")
	 Author findNamedEntityGraphBooksPublisherAndLoad(@Param("id") Integer id);
	 
}
