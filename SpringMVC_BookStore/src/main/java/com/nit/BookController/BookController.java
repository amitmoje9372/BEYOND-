package com.nit.BookController;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nit.Service.BookServiceImpl;
import com.nit.model.Book;

@Controller
public class BookController
{
	@Autowired(required=true)
	private BookServiceImpl bookserv;
	
	@RequestMapping("/bookinsert")
	public String insertBook(Model model)
	{
		Book book=new Book();
		model.addAttribute("book",book);
		return "insertBook";	
	}
	
	
	@RequestMapping(value="/insertbookreturn",method=RequestMethod.POST)
	public String getBook(@ModelAttribute("book") Book b,Model model)
	{
	boolean isSaved=bookserv.isSave(b);
		if (isSaved) {
			model.addAttribute("successmsg", "Book Saved successfully.");
		} else {
			model.addAttribute("errormsg", "Failed to save the Book.");
		}

		return "insertBook";
	}
	
	@RequestMapping("/search")
	public String searchAndView(HttpServletRequest req,Model model)
	{
		List<Book> al=null;
		al=bookserv.findAllBook();
		model.addAttribute("booklist",al);
		return "viewbook";
	}
	
	@RequestMapping("/booksearch")
	public String searchAndViewResult(HttpServletRequest req,Model model)
	{
		List<Book> al=null;
		String isbn=req.getParameter("isbn");
		
		if("".equals(isbn)|| null==isbn)
		{ 
			al=bookserv.findAllBook();
		 model.addAttribute("booklist",al);
		 return "viewbook";
		}
		
		else
		{
			al=bookserv.findThatBook(isbn);
			model.addAttribute("booklist",al);
			 return "viewbook";
		}
	}
	
	@RequestMapping("/advancesearch")
	public String advanceSearch(Model model)
	{
		Book b=new Book();
		model.addAttribute("b",b);		
		return "searchBook";
	}
	
	@RequestMapping(value="/booksAdvSearch",method=RequestMethod.POST)
	public String advanceSearchResult(@ModelAttribute("b") Book bo,Model model)
	{
		List<Book> booksList = null;

		booksList = bookserv.searchBooks(bo);
		model.addAttribute("books", booksList);
		return "searchBook";
	}

}
