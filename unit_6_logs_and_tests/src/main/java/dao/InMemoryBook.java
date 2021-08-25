package dao;

import entity.Book;
import org.apache.commons.lang3.ArrayUtils;


import java.util.UUID;

public class InMemoryBook {

    private int BOOKS_SIZE = 0;
    private Book[] books = (Book[]) new Book[BOOKS_SIZE];
    private static final InMemoryBook instance = new InMemoryBook();
    private final InMemoryBook inMemoryBook = InMemoryBook.getInstance();

    public InMemoryBook() { }

    public static InMemoryBook getInstance() {
        return instance;
    }

    public void create(Book book) {
        book.setId(generateID());
        books = ArrayUtils.add(books, book);
    }

    public void update(Book book) {
        Book inDbBook = findBookById(book.getId());
        inDbBook.setName(book.getName());
    }

    public Book[] delete(String id, Book book) {
        if (book.getId().equals(id)) {
            books = ArrayUtils.removeElement(books, book);
        }
        return books;
    }

    public Book findBookById(String id) {
        for (int i = 0; i < books.length; i++) {
            if (ArrayUtils.get(books, i).getId().equals(id)) {
                return ArrayUtils.get(books, i);
            }
        }
        return null;
    }

    public Book[] findAllBooks() {
        return books;
    }

    public String generateID() {
        String id = UUID.randomUUID().toString();
        for (int i = 0; i < books.length; i++) {
            if (ArrayUtils.get(books, i).getId().equals(id)) {
                return generateID();
            }
        }
        return id;
    }
}
