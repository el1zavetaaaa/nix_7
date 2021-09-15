package dao.impl;

import dao.BookDao;
import db.DB;
import entity.Author;
import entity.Book;

import java.util.Set;

public class BookDaoImpl implements BookDao {
    @Override
    public void create(Book book) {
        DB.getInstance().createBook(book);
    }

    @Override
    public void update(Book book) {
        DB.getInstance().updateBook(book);
    }

    @Override
    public void delete(Book book) {
        DB.getInstance().deleteBook(book);
    }

    @Override
    public Set<Book> findAllBooks() {
        return DB.getInstance().findAllBooks();
    }

    @Override
    public Book findBookById(Number id) {
        return DB.getInstance().findBookById((Integer) id);
    }

    @Override
    public void addAuthorToBook(Book book, Author author) {
        DB.getInstance().createAuthorBook(author, book);
    }
}
