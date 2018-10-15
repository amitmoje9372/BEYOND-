package com.nit.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bookstore.mapper.BookRowMapper;
import com.nit.model.Book;

@Repository("bookdao")
public class BookDaoImpl implements BookDao 
{
	private static final String INSERT_SQL ="INSERT INTO BOOK_TBL (Book_ID,BOOK_NAME,BOOK_PRICE,BOOK_ISBN,AUTHOR_NAME,ACTIVE_SW) VALUES (?,?,?,?,?,?)";
	private static final String FIND_ALL = "SELECT * FROM BOOK_TBL WHERE ACTIVE_SW='y'";
	private static final String FIND_THAT = "SELECT * FROM BOOK_TBL WHERE ACTIVE_SW='y' AND BOOK_ISBN=?";

	
	@Autowired(required = true)
	private JdbcTemplate jdbcTemplate;


	public boolean saveBook(Book b) 
	{
		b.setActiveSw("y");
		int c=jdbcTemplate.update(INSERT_SQL,b.getBookId(),b.getBookName(),b.getBookPrice(),b.getBookIsbn(),b.getAuthorName(),b.getActiveSw());
		
		return (c>0?true:false);
	}


	public List<Book> findAllBook() 
	{
		List<Book> al=jdbcTemplate.query(FIND_ALL, new BookRowMapper());
		return al;
	}

	public List<Book> findThatBook(String isbn) {
		List<Book> al=jdbcTemplate.query(FIND_THAT, new Object[] { isbn } ,new BookRowMapper());
		return al;
	}


	public List<Book> searchBooks(Book bo) 
	{
		StringBuffer query=new StringBuffer("SELECT * FROM BOOK_TBL WHERE 1=1");
		
		if(bo.getBookName()!= null &&  ! "".equals(bo.getBookName()))
		{
			query.append("AND BOOK_NAME LIKE '%"+bo.getBookName()+"%'");
		}
		
		if ( bo.getAuthorName()!= null && !"".equals(bo.getAuthorName()))
		{
			query.append("AND AUTHOR_NAME LIKE '%"+ bo.getAuthorName() + "%'");
		}


		if (bo.getBookPrice()!= null && !"".equals(bo.getBookPrice()))
		{
			query.append("AND BOOK_PRICE =" + bo.getBookPrice());
		}
		System.out.println(query);
		return jdbcTemplate.query(query.toString(), new BookRowMapper());

	}

}
