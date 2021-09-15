package service;

import entity.Author;
import entity.Book;

import java.util.Set;

public interface BookService {
    void create(Book book);
    void update (Book book);
    void delete(Book book);
    Set<Book> findAllBooks();
    Book findBookById(Number id);
    void addAuthorToBook(Book book, Author author );
    Set<Author> readAuthors(Book book);
}
