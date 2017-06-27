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
	@Column(name = "'bookId'", nullable = false)
	private String bookId;
	
	
	@Column(name = "'authorId'", nullable = false)
	private String authorId;
	
	@Column(name = "'isbn'",length = 20, nullable = false)
	private String isbn;
	
	@Column(name = "'bookName'",length = 100, nullable = false)
	private String bookName;
	
	@Column(name = "'price'", nullable = false)
	private Integer price;
	
	@Column(name = "'priceCurrency'",length = 10,nullable = true)
	private String priceCurrency;
	
	@Column(name = "'authorName'",length = 100, nullable = true)
	private String authorName;
	
	


	public Book() {

	}

	public Book(String bookId, String authoerId, String isbn, String bookName, Integer price, String priceCurrency,
			String authorName) {
		super();
		this.bookId = bookId;
		this.authorId = authoerId;
		this.isbn = isbn;
		this.bookName = bookName;
		this.price = price;
		this.priceCurrency = priceCurrency;
		this.authorName = authorName;
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
	
	public String getIsbn() {
		return isbn;
	}
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public String getBookName() {
		return bookName;
	}
	
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
	public Integer getPrice() {
		return price;
	}
	
	public void setPrice(Integer price) {
		this.price = price;
	}
	
	public String getPriceCurrency() {
		return priceCurrency;
	}
	
	public void setPriceCurrency(String priceCurrency) {
		this.priceCurrency = priceCurrency;
	}
	
	public String getAuthorName() {
		return authorName;
	}
	
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

}
