package alltests;

import entity.Author;
import entity.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import service.AuthorService;
import service.BookService;

public class CreateAuthorOrBookIfNameNotRight {
    private final static AuthorService authorService = new AuthorService();
    private final static int AUTHORS_SIZE = 10;
    private final static BookService bookService = new BookService();
    private final static int BOOKS_SIZE = 10;


    @Test
    @Order(1)
    public static void setUpAuthor() {
        for (int i = 0; i < AUTHORS_SIZE; i++) {
            Author author = AuthorGenerationUtil.generateAuthor();
            authorService.create(author);
        }
        Assertions.assertEquals(AUTHORS_SIZE, authorService.findAllAuthors().length);
    }

    @Test
    @Order(2)
    public void createIfNameOfAuthorNotRight() {
        Author author = AuthorGenerationUtil.generateAuthor1("1", "2");
        authorService.create(author);
        Author[] authors = authorService.findAllAuthors();
        Assertions.assertNotEquals(AUTHORS_SIZE + 1, authors.length);

    }

    @Test
    @Order(3)
    public static void setUpBook() {
        for (int i = 0; i < BOOKS_SIZE; i++) {
            Book book = BookGenerationUtil.generateBook();
            bookService.create(book);
        }
        Assertions.assertEquals(BOOKS_SIZE, bookService.findAllBooks().length);
    }

    @Test
    @Order(4)
    public void createIfNameOfBookNotRight() {
        Book book = BookGenerationUtil.generateBook1("1");
        bookService.create(book);
        Book[] books = bookService.findAllBooks();
        Assertions.assertNotEquals(BOOKS_SIZE + 1, books.length);

    }


}
