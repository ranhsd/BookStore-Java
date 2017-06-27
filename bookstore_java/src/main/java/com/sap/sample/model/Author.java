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
	@Column(name = "'authorId'")
	private String authorId;

	@Column(name = "'authorName'", length = 100)
	private String authorName;
	
	@Column(name = "'numberOfBooks'")
	private Integer numberOfBooks;
	
	@OneToMany
	private List<Book> authorBooks = new ArrayList<Book>();

	public Author() {
		System.out.println();
	}
	
	public Author(String authorId, String authorName, Integer numberOfBooks) {
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

	public Integer getNumberOfBooks() {
		return numberOfBooks;
	}

	public void setNumberOfBooks(Integer numberOfBooks) {
		this.numberOfBooks = numberOfBooks;
	}

	
}
