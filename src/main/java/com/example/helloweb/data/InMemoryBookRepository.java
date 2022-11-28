package com.example.helloweb.data;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.Map;

import com.example.helloweb.model.Book;

public class InMemoryBookRepository implements BookRepository {
	private static Map<Long,Book> db=new HashMap<>();
	public static long id;

	//blocco statico ,costruttore per le variabili statiche.
	static {
		Book dummyBook1= new Book(1,"java for dummies",500,18.50,"franco");
		Book dummyBook2= new Book(2,"java for dummies2",400,16.50,"franco2");
		db.put(dummyBook1.getId(), dummyBook1);
		db.put(dummyBook2.getId(), dummyBook2);
	}

	@Override
	public Book addBook(Book b) {
		b.setId(++id);
		db.put( b.getId(),b);
		/*
		List<Integer> nums = new ArrayList<>();
		for(int i =0;i<1_000_000;i++) {
			nums.add(i);
		}
			*/
		return b;
	}

	@Override
	public Iterable<Book> listBooks() {
		
		return db.values();
	}

}
