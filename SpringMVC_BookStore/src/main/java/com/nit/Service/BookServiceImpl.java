package com.nit.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.nit.Dao.BookDaoImpl;
import com.nit.model.Book;

@Service("bookserv")
public class BookServiceImpl implements BookService 
{
	@Autowired(required=true)
	private BookDaoImpl bookdao;
	
	public boolean isSave(Book b) 
	{
		return bookdao.saveBook(b);
	}

	public List<Book> findAllBook() {
		
		return bookdao.findAllBook();
	}

	public List<Book> findThatBook(String isbn)
	{
		
		return bookdao.findThatBook(isbn);
	}

	public List<Book> searchBooks(Book bo) {
		
		return bookdao.searchBooks(bo);
	}

}
