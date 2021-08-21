package service;


import dao.InMemoryBook;
import entity.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class BookService {
    private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
    private static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");
    private final InMemoryBook bookDao = new InMemoryBook();


    public void create(Book book) {
        LOGGER_INFO.info("create new book: " + book.getName());

           bookDao.create(book);


    }

    public void update(Book book) {

        bookDao.update(book);

    }

    public void delete(String id, Book book) {
        LOGGER_WARN.warn("remove book by id: " + id);
        bookDao.delete(id, book);
    }


    public Book findBookById(String id) {
        return bookDao.findBookById(id);
    }

    public Book[] findAllBooks() {
        return bookDao.findAllBooks();
    }



}
