package com.erdalgunay.library.service;

import com.erdalgunay.library.domain.Book;
import com.erdalgunay.library.repository.BookRepository;
import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.MongoURI;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.UnknownHostException;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository ;


    public Book save(Book book){

        book.setId(UUID.randomUUID().toString());

        bookRepository.save(book);

        return book;
    }

    public Book find(String id){
        return bookRepository.findBy(id);
    }

    public List<Book> listAll() {
        return bookRepository.findAll();
    }

    public boolean update(Book book){

        if (!isBookExist(book))
            return false;

        bookRepository.save(book);
        return true;
    }

    public Boolean delete(Book book){

        if (!isBookExist(book)) {
            return false;
        }

        bookRepository.delete(book);
        return true;
    }

    public boolean isBookExist(Book book){
        return bookRepository.findBy(book.getId()) != null;
    }

}
