package alltests;


import entity.Book;

public class BookGenerationUtil {
    public static final String NAME = "test";

    public static Book generateBook() {
        Book book = new Book();
        book.setName(NAME);

        return book;
    }


}
