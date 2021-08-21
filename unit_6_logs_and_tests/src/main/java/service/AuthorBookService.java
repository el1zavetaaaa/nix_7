package service;

import dao.InMemoryAuthor;
import dao.InMemoryAuthorBook;
import dao.InMemoryBook;
import entity.Author;
import entity.AuthorBook;
import entity.Book;

import java.util.Arrays;
import java.util.regex.Pattern;

public class AuthorBookService {
    private final InMemoryAuthor authorDao = InMemoryAuthor.getInstance();
    private final InMemoryBook bookDao = InMemoryBook.getInstance();
    private final InMemoryAuthorBook authorBookDao = InMemoryAuthorBook.getInstance();


    public void createBookAuthors(Book book, Author[] authors) {


        if (book.getName() == "") {
            return;
        }
        if (authors[0].getFirstname() == "") {
            return;
        }

        int count = 0;
        bookDao.create(book);

        String[] authorsId = new String[count];
        for (Author author : authors) {
            authorsId = Arrays.copyOf(authorsId, count + 1);
            count++;
            authorDao.create(author);
            authorsId[count - 1] = InMemoryAuthor.getInstance().findAuthorById(author.getId())
                    .getId();
        }
        authorBookDao.create(InMemoryBook.getInstance().findBookById(book.getId()).getId()
                , authorsId);

    }
    public void update(AuthorBook authorBook) {
        authorBookDao.update(authorBook);
    }


    public void delete(String idBook) {

        authorBookDao.delete(idBook);

    }
    public AuthorBook findBookAuthorByIdBook(String idBook) {
        return authorBookDao.findAuthorByIdBook(idBook);
    }


    public AuthorBook[] findAllAuthorsBooks() {
        return authorBookDao.findAllAuthorsBooks();
    }

}
