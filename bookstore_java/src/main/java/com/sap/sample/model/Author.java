package com.sap.sample.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author I059508
 */
@Entity(name = "Author")
@Table(name = "\"bookstore.db::store.Author\"")
public class Author {

	@Id
	@Column(name = "authorId")
	private String authorId;

	@Column(name = "authorName'")
	private String authorName;
	@Column(name = "'numberOfBOoks'")
	private String numberOfBooks;
	
	@OneToMany
	private List<Book> books = new ArrayList<Book>();

	public Author() {
		System.out.println();
	}
	
	public Author(String authorId, String authorName, String numberOfBooks) {
		super();
		this.authorId = authorId;
		this.authorName = authorName;
		this.numberOfBooks = numberOfBooks;
	}

	public String getAuthorId() {
		return authorId;
	}

	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getNumberOfBooks() {
		return numberOfBooks;
	}

	public void setNumberOfBooks(String numberOfBooks) {
		this.numberOfBooks = numberOfBooks;
	}

	
}
