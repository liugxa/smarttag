package com.platform.gui.demo.book.action;

import java.util.ArrayList;
import java.util.List;

import com.platform.gui.demo.book.model.Author;
import com.platform.gui.demo.book.model.Book;
import com.platform.gui.framework.smart.action.ListTableAction;
import com.platform.gui.framework.smart.inter.IDataRecordList;
import com.platform.gui.framework.smart.inter.impl.DefaultDataRecordList;


public class BookListAction extends ListTableAction<Book>{

	private static final long serialVersionUID = 1L;

	private static List<Book> books = new ArrayList<Book>();
	
	private static List<Author> authors = new ArrayList<Author>();
	
	static{
		for(int i=0;i<100;i++){
			Book book = new Book();
			book.setId(i);
			book.setName("name" + i);
			book.setAuthor("author" + i);
			book.setPrice(i + 100);
			book.setPublisher("platform" + i);
			books.add(book);
			
			Author author = new Author();
			author.setName("author" + i);
			author.setAge("30" + i);
			author.setCompany("platform co..ltd");
			author.setSex("male");
			authors.add(author);
		}	
	}
	
	
	public String toList() throws Exception{
		return SUCCESS;
	}
	
	@Override
	public IDataRecordList<Book> registRecordDataList() throws Exception {
		return new DefaultDataRecordList<Book>(books);
	}
	
	@Override
	public String registRecordDataName() throws Exception {
		return "books";
	}
	
	private String author;
	private Author authorBean;
	public String toAuthor() throws Exception{
		for(Author a:authors){
			if(a.getName().equals(author)){
				authorBean = a;
			}
		}
		return SUCCESS;
	}
	public static List<Book> getBooks() {
		return books;
	}
	public static void setBooks(List<Book> books) {
		BookListAction.books = books;
	}
	public static List<Author> getAuthors() {
		return authors;
	}
	public static void setAuthors(List<Author> authors) {
		BookListAction.authors = authors;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Author getAuthorBean() {
		return authorBean;
	}
	public void setAuthorBean(Author authorBean) {
		this.authorBean = authorBean;
	}
}
