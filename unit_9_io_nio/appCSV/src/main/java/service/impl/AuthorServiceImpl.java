package service.impl;

import dao.AuthorDao;
import dao.BookDao;
import dao.impl.AuthorDaoImpl;
import dao.impl.BookDaoImpl;
import entity.Author;
import entity.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.AuthorService;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

public class AuthorServiceImpl implements AuthorService {
    private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
    private static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");
    private static final Logger LOGGER_ERROR = LoggerFactory.getLogger("error");

    private final AuthorDao authorDAO = new AuthorDaoImpl();
    private final BookDao bookDao = new BookDaoImpl();

    @Override
    public void create(Author author) {
                authorDAO.create(author);
        LOGGER_INFO.info("create new author: " + author.getId() + ": " + author.getFirstname() + author.getFirstname());
    }

    @Override
    public void update(Author author) {

        if (isAuthorDeleted(author)) {
            LOGGER_ERROR.error("Error: book with this id was deleted");
            return;
        }
        authorDAO.update(author);
        LOGGER_INFO.info(("update author: " + author.getId() + ": " + author.getFirstname() + author.getLastname()));
    }

    @Override
    public void delete(Author author) {
        if (isAuthorDeleted(author)) {
            LOGGER_ERROR.error("Error: author with this id was deleted");
            return;
        }
        authorDAO.delete(author);
        LOGGER_WARN.warn("remove user by id: " + author.getId() + ": " + author.getFirstname() + author.getLastname());
    }

    @Override
    public Set<Author> findAllAuthors() {
        return authorDAO.findAllAuthors().stream().filter(author -> !isAuthorDeleted(author)).collect(Collectors.toSet());

    }

    @Override
    public Author findAuthorById(Number id) {
        try {
            Author author = authorDAO.findAuthorById(id);
            if (isAuthorDeleted(author)) {
                LOGGER_ERROR.error("Error: author with this id was deleted");
                return null;
            }
            return author;
        } catch (NoSuchElementException e) {
            LOGGER_ERROR.error("Error: no author with current id");
            return null;
        }
    }

    @Override
    public void addBookToAuthor(Author author, Book book) {
        if (author == null) {
            System.err.println("No author with this id");
            return;
        }
        if (book == null) {
            System.err.println("No book with this id");
            return;
        }
        if (author.getBooks().contains(book.getId())) {
            LOGGER_WARN.warn("Author adding book warning: author already have this book");
            return;
        }
        authorDAO.addBookToAuthor(author, book);
        LOGGER_INFO.info("Book was added to author:" + author.getId() + ": " + author.getFirstname() + author.getLastname() + book.getId() + ": " + book.getName());
    }


    @Override
    public Set<Book> readBooks(Author author) {
        if (author == null) {
            System.err.println("No author with this id");
            return null;
        }
        Set<Book> books = new HashSet<>();
        author.getBooks().forEach(bookId -> books.add(bookDao.findBookById(bookId)));
        return books;
    }

    private boolean isAuthorDeleted(Author author) {
        return !author.getAvailable();
    }
}
