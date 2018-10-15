package com.bookstore.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.nit.model.Book;



public class BookRowMapper implements RowMapper<Book> {

	public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
		Book b = new Book();
		b.setBookId(rs.getInt("BOOK_ID"));
		b.setBookIsbn(rs.getString("BOOK_ISBN"));
		b.setBookName(rs.getString("BOOK_NAME"));
		b.setBookPrice(rs.getDouble("BOOK_PRICE"));
		b.setAuthorName(rs.getString("AUTHOR_NAME"));
		b.setActiveSw(rs.getString("ACTIVE_SW"));
		return b;
	}

	/*public Book mapRow(ResultSet rs, int index) throws SQLException {
		Book b = new Book();
		b.setBookIsbn(rs.getString("BOOK_ISBN"));
		b.setBookName(rs.getString("BOOK_NAME"));
		b.setBookPrice(rs.getDouble("BOOK_PRICE"));
		b.setAuthorName(rs.getString("AUTHOR_NAME"));
		b.setActiveSw(rs.getString("ACTIVE_SW"));
		return b;
	}*/

}
