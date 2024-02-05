package com.driver;
import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
    HashMap<Integer,Book> bookDb ;
    private int id;
    public BookRepository(){
        this.bookDb= new HashMap<>();
        this.id = 1;
    }

    public Book save(Book book){
        book.setId(id);
        bookDb.put(id,book);
        id++;
        return book;
    }

    public Book findBookById(int id){
        Book book = null;
        if(id>0) {
            for (Book book1 : bookDb.values()) {
                if (book1.getId() == id) {
                    book = book1;
                    break;
                }
            }
        }
        return book;
    }

    public List<Book> findAll(){
        List<Book> books = new ArrayList<>();
        for(Book book : bookDb.values()){
            books.add(book);
        }
        return books;
    }

    public void deleteBookById(int id){
        if(id<=0) return;
        for(int i=0;i< bookDb.size();i++){
            if(bookDb.get(i).getId()==id){
                bookDb.remove(i);
                break;
            }
        }
    }

    public void deleteAll(){
        bookDb.clear();
    }

    public List<Book> findBooksByAuthor(String author){
        List<Book> book = new ArrayList<>();
        for (Book book1 : bookDb.values()){
            if(book1.getAuthor().equals(author)){
                book.add(book1);
            }
        }
        return book;
    }

    public List<Book> findBooksByGenre(String genre){
        List<Book> book = new ArrayList<>();
        for (Book book1 : bookDb.values()){
            if(book1.getGenre().equals(genre)){
                book.add(book1);
            }
        }
        return book;
    }
}
