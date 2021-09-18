package service.impl;

import dao.AuthorDao;
import dao.BookDao;
import dao.impl.AuthorDaoImpl;
import dao.impl.BookDaoImpl;
import entity.Author;
import entity.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.BookService;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

public class BookServiceImpl implements BookService {
    private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
    private static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");
    private static final Logger LOGGER_ERROR = LoggerFactory.getLogger("error");

    private final AuthorDao authorDAO = new AuthorDaoImpl();
    private final BookDao bookDao = new BookDaoImpl();

    @Override
    public void create(Book book) {
            bookDao.create(book);
        LOGGER_INFO.info("create new book: " + book.getId() + ": " + book.getName());
    }

    @Override
    public void update(Book book) {
        if (isBookDeleted(book)) {
            LOGGER_ERROR.error("Error: book with this id was deleted");
            return;
        }
        bookDao.update(book);
        LOGGER_INFO.info(("update book: " + book.getId()) + ": " + book.getName());
    }

    @Override
    public void delete(Book book) {
        if (isBookDeleted(book)) {
            LOGGER_ERROR.error("Error: book with this id was deleted");
            return;
        }
        bookDao.delete(book);
        LOGGER_WARN.warn("remove book: " + book.getId() + ": " + book.getName());
    }

    @Override
    public Set<Book> findAllBooks() {
        return bookDao.findAllBooks().stream().filter(book -> !isBookDeleted(book)).collect(Collectors.toSet());
    }

    @Override
    public Book findBookById(Number id) {
        try {
            Book book = bookDao.findBookById(id);
            if (isBookDeleted(book)) {
                LOGGER_ERROR.error("Error: book with this id was deleted");
                return null;
            }
            return book;
        } catch (NoSuchElementException e) {
            LOGGER_ERROR.error("Error: no book with current id");
            return null;
        }
    }

    @Override
    public void addAuthorToBook(Book book, Author author) {
        if (author == null) {
            System.err.println("No author with this id");
            return;
        }
        if (book == null) {
            System.err.println("No book with current id");
            return;
        }
        if (author.getBooks().contains(book.getId())) {
            LOGGER_WARN.warn("WARN: Author already have this book");
            return;
        }
        authorDAO.addBookToAuthor(author, book);
        LOGGER_INFO.info("Book was successfully added to author: " + author.getId() + ": " + author.getFirstname() + author.getLastname() + "\n " + book.getId() + ": " + book.getName());
    }


    @Override
    public Set<Author> readAuthors(Book book) {
        Set<Author> authors = new HashSet<>();
        book.getAuthors().forEach(authorId -> authors.add(authorDAO.findAuthorById(authorId)));
        return authors;
    }

    private boolean isBookDeleted(Book book) {
        return !book.getAvailable();
    }
}
