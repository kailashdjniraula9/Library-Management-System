package com.library.services;

import java.util.List;

import com.library.entities.Book;

public interface BookService {
	
		//add Book
		public boolean addBook(Book book);
		
		// list the books
		public List<Book> getAllBooks();

		// list an individual book by id
		public Book getBookById(Book book);

		// update book
		public boolean updateBook(Book book);

		// delete book
		public boolean deleteBook(Book book);
		
		//book availability
		public boolean isBookAvailable(Book book);

}
