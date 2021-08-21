package service;


import entity.Author;
import dao.InMemoryAuthor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class AuthorService {
    private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
    private static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");
    private final InMemoryAuthor authorDao = new InMemoryAuthor();


    public void create(Author author) {
        LOGGER_INFO.info("create new author: " + author.getFirstname() + author.getLastname());
        if (author.getFirstname().matches("[A-Za-zА-яа-я]+$")) {
            if (author.getLastname().matches("[A-Za-zА-яа-я]+$")) {
                authorDao.create(author);
            }
        }

    }


    public void update(Author author) {

        authorDao.update(author);

    }

    public void delete(String id, Author author) {
        LOGGER_WARN.warn("remove user by id: " + id);
        authorDao.delete(id, author);
    }

    public Author findAuthorById(String id) {
        return authorDao.findAuthorById(id);
    }

    public Author[] findAllAuthors() {
        return authorDao.findAllAuthors();
    }

}
