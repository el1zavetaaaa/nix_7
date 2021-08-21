package alltests;


import entity.Book;

public class BookGenerationUtil {
    public static final String NAME = "test";

    public static Book generateBook() {
        Book book = new Book();
        book.setName(NAME);

        return book;
    }

    public static Book generateBook1(String name) {
        Book book = new Book();
        book.setName(name);

        return book;
    }


}
