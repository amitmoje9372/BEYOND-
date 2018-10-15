package com.nit.Dao;

import java.util.List;

import com.nit.model.Book;

public interface BookDao 
{
	public boolean saveBook(Book b);
	public List<Book> findAllBook();
	public List<Book> findThatBook(String isbn);

}
