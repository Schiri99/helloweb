package com.example.helloweb.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.apache.catalina.tribes.group.Response;

import com.example.helloweb.data.BookRepository;
import com.example.helloweb.data.DBBookRepository;
import com.example.helloweb.data.InMemoryBookRepository;
import com.example.helloweb.model.Book;
import com.example.helloweb.utilies.RepositoryFactory;


public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public static final String BOOK_LIST = "booklist";
    public static final String BOOK_SAVED ="booksaved";
    
    static {
    	RepositoryFactory.setType(RepositoryFactory.IM_TYPE);
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String path = request.getRequestURI();
		int first= path.lastIndexOf("/");
		int last =path.lastIndexOf(".");
		String action=path.substring(first +1,last);
		
		System.out.println(action);
		
		String view= null;
		
		switch(action) {
			case"listbooks":
			//ottieni la lista dei libri
				listBooks(request,response);
				view="ShowBooks.jsp";
				break;
			case"addbook":
			//mostra la form di inserimento di un libro
				view = "AddBookForm.jsp";
				break;
			case"savebook":
			//inserisci il libro della base dati
				saveBook(request,response);
				view="SavedBook.jsp";
				break;
			default:
				//mostra pagina di errori
				view ="DoNotExist.jsp";	
		}
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

	
	private void listBooks(HttpServletRequest request, HttpServletResponse response) {
		BookRepository br = RepositoryFactory.createBookRepository();
		Iterable<Book> books= br.listBooks();
		request.setAttribute(BOOK_LIST, books);
	}
	private void saveBook(HttpServletRequest request, HttpServletResponse response) {
		String title=request.getParameter("title");
		int numPages=Integer.parseInt(request.getParameter("numPages")) ;
		double cost=Double.parseDouble(request.getParameter("cost"));
		String author=request.getParameter("author");
		Book book=new Book(0,title,numPages,cost,author);
		BookRepository repository = RepositoryFactory.createBookRepository();
		Book saved =repository.addBook(book);
		request.setAttribute(BOOK_SAVED, saved);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
