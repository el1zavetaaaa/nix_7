package dao.impl;

import dao.AuthorDao;
import db.DB;
import entity.Author;
import entity.Book;

import java.util.Set;

public class AuthorDaoImpl implements AuthorDao {
    @Override
    public void create(Author author) {
        DB.getInstance().createAuthor(author);
    }

    @Override
    public void update(Author author) {
        DB.getInstance().updateAuthor(author);
    }

    @Override
    public void delete(Author author) {
        DB.getInstance().deleteAuthor(author);
    }

    @Override
    public Set<Author> findAllAuthors() {
        return DB.getInstance().findAllAuthors();
    }

    @Override
    public Author findAuthorById(Number id) {
        return DB.getInstance().findAuthorById((Integer) id);
    }

    @Override
    public void addBookToAuthor(Author author, Book book) {
        DB.getInstance().createAuthorBook(author, book);
    }
}
