package alltests;


import entity.Book;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.jupiter.api.*;

import service.BookService;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BookServiceTest {
    private final static BookService bookService = new BookService();
    private final static int BOOKS_SIZE = 10;

    @BeforeAll
    public static void setUp() {
        for (int i = 0; i < BOOKS_SIZE; i++) {
            Book book = BookGenerationUtil.generateBook();
            bookService.create(book);
        }
        Assertions.assertEquals(BOOKS_SIZE, bookService.findAllBooks().length );
    }

    @Test
    @Order(2)
    public void create() {
        Book book = BookGenerationUtil.generateBook();
        bookService.create(book);
        Book[] books = bookService.findAllBooks();
        Assertions.assertEquals(BOOKS_SIZE + 1, books.length);

    }

    @Test
    @Order(3)
    public void update() {
        Book[] books = bookService.findAllBooks();
        Book book;
        book = ArrayUtils.get(books, 0);
        bookService.update(book);
    }

    @Test
    @Order(4)
    public void delete() {
        Book[] books = bookService.findAllBooks();
        Assertions.assertEquals(BOOKS_SIZE + 1, books.length);
        Book book;
        book = ArrayUtils.get(books, 0);
        bookService.delete(book.getId(), book);
        books = bookService.findAllBooks();
        Assertions.assertEquals(BOOKS_SIZE, books.length);
    }

    @Test
    @Order(5)
    public void findAll() {
        Book[] books = bookService.findAllBooks();
        Assertions.assertEquals(BOOKS_SIZE, books.length);
    }


}