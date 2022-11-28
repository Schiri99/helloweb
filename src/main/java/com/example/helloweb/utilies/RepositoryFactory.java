package com.example.helloweb.utilies;

import com.example.helloweb.data.BookRepository;
import com.example.helloweb.data.DBBookRepository;
import com.example.helloweb.data.InMemoryBookRepository;

public class RepositoryFactory {
	public static final String DB_TYPE="DB";
	public static final String IM_TYPE="IM";
	private static String type = DB_TYPE;
	public static BookRepository createBookRepository() {
		if(type.equals(DB_TYPE)) {
			return new DBBookRepository();			
		}else {
			return new InMemoryBookRepository();
		}
	}
	public static void setType(String newType) {
		type = newType;
	}
}
