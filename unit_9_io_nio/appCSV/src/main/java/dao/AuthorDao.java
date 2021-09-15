package dao;

import entity.Author;
import entity.Book;

import java.util.Set;

public interface AuthorDao {
    void create(Author author);
    void update (Author author);
    void delete(Author author);
    Set<Author> findAllAuthors();
    Author findAuthorById(Number id);
    void addBookToAuthor(Author author, Book book);
}
