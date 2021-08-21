package alltests;

import entity.Author;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.jupiter.api.*;
import service.AuthorService;



import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AuthorServiceTest {
    private final static AuthorService authorService = new AuthorService();
    private final static int AUTHORS_SIZE = 10;

    @BeforeAll
    public static void setUp() {
        for (int i = 0; i < AUTHORS_SIZE; i++) {
            Author author = AuthorGenerationUtil.generateAuthor();
            authorService.create(author);
        }
        Assertions.assertEquals(AUTHORS_SIZE, authorService.findAllAuthors().length);
    }

    @Test
    @Order(2)
    public void create() {
        Author author =AuthorGenerationUtil.generateAuthor();
        authorService.create(author);
        Author[] authors = authorService.findAllAuthors();
        Assertions.assertEquals(AUTHORS_SIZE + 1, authors.length);

    }


    @Test
    @Order(4)
    public void update() {
        Author[] authors = authorService.findAllAuthors();
        Author author;
        author = ArrayUtils.get(authors, 0);
        authorService.update(author);
    }

    @Test
    @Order(5)
    public void delete() {
        Author[] authors = authorService.findAllAuthors();
        Assertions.assertEquals(AUTHORS_SIZE + 1, authors.length);
        Author author;
        author = ArrayUtils.get(authors, 0);
        authorService.delete(author.getId(), author);
        authors = authorService.findAllAuthors();
        Assertions.assertEquals(AUTHORS_SIZE, authors.length);
    }

    @Test
    @Order(6)
    public void findAll() {
        Author[] authors = authorService.findAllAuthors();
        Assertions.assertEquals(AUTHORS_SIZE, authors.length);
    }


}