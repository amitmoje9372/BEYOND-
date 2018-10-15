package com.nit.Service;

import java.util.List;

import com.nit.model.Book;

public interface BookService
{
	public boolean isSave(Book b);
	public List<Book> findAllBook();
	public List<Book> findThatBook(String isbn);
}
