package com.example.helloweb.data;

import com.example.helloweb.model.Book;

public interface BookRepository {
	Book addBook(Book b);
	Iterable<Book> listBooks() ;
}
