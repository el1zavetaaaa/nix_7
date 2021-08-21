package alltests;

import entity.Author;
import entity.AuthorBook;
import entity.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import service.AuthorBookService;

import static org.junit.jupiter.api.Assertions.*;

class AuthorBookServiceTest {
    private final static AuthorBookService authorBookService = new AuthorBookService();
    private final static int USERS_SIZE = 10;

    @BeforeAll
    static void setUp() {
        for (int i = 0; i < USERS_SIZE; i++) {
            Author author = new Author();
            author = AuthorGenerationUtil.generateAuthor();
            Author[] authors = {author};
            Book book = BookGenerationUtil.generateBook();
            authorBookService.createBookAuthors(book, authors);
        }
        Assertions.assertEquals(USERS_SIZE, authorBookService.findAllAuthorsBooks().length);
    }


    @Test
    @Order(1)
    void createBookAuthors() {
        Author author = new Author();
        author = AuthorGenerationUtil.generateAuthor();
        Author author1 = new Author();
        author1 = AuthorGenerationUtil.generateAuthor();
        Author[] authors = {author, author1};
        Book book = new Book();
        book.setName("test book createBookAuthors");
        authorBookService.createBookAuthors(book, authors);
        AuthorBook[] authorBooks = authorBookService.findAllAuthorsBooks();
        Assertions.assertEquals(USERS_SIZE + 1, authorBooks.length);
    }
    @Test
    @Order(3)
    void update() {
        AuthorBook[] allAuthorsBooks = authorBookService.findAllAuthorsBooks();
        String idBook = allAuthorsBooks[0].getIdBook();
        String idAuthor = allAuthorsBooks[0].getIdAuthor();
        AuthorBook authorBook = new AuthorBook();
        authorBook.setIdBook(idBook);
        authorBook.setIdAuthor(idAuthor);
        authorBookService.update(authorBook);
        allAuthorsBooks = authorBookService.findAllAuthorsBooks();
        Assertions.assertEquals(idAuthor, allAuthorsBooks[0].getIdAuthor());
    }

    @Test
    @Order(4)
    void findAllAuthorsBooks() {
        AuthorBook[] allAuthorsBooks = authorBookService.findAllAuthorsBooks();
        int expected = 11;
        Assertions.assertEquals(expected, allAuthorsBooks.length);
    }


    @Test
    @Order(5)
    void delete() {
        AuthorBook[] allAuthorsBooks = authorBookService.findAllAuthorsBooks();
        int before = allAuthorsBooks.length;
        String idBook = allAuthorsBooks[0].getIdBook();
        authorBookService.delete(idBook);
        allAuthorsBooks = authorBookService.findAllAuthorsBooks();
        int after = allAuthorsBooks.length;
        Assertions.assertEquals(before - 1, after);
    }


}

