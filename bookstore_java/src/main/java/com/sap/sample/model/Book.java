package com.sap.sample.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author I059508
 */
@Entity(name = "Book")
@Table(name = "\"bookstore.db::store.Book\"")
public class Book {

	@Id
	@Column(name = "'bookId'")
	private String bookId;
	
	@Column(name = "'authorId'")
	private String authorId;


	public Book() {

	}

	public Book(String bookId, String authoerId, String isbn, String bookName, Integer price, String priceCurrency,
			String authorName) {
		super();
		this.bookId = bookId;
		this.authorId = authoerId;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getAuthorId() {
		return authorId;
	}

	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}

}
