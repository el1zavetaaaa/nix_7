package controller;

import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;
import entity.Author;
import entity.Book;
import util.BookService;
import util.impl.BookServiceImpl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class BookController {
    private static BookController instance = null;
    private final Scanner in = new Scanner(System.in);
    private final BookService bookService = new BookServiceImpl();

    private BookController() {
    }

    public static BookController getInstance() {
        if (instance == null) {
            instance = new BookController();
        }
        return instance;
    }

    public void createBook() {
        Book book = new Book();

        System.out.print("Enter name: ");
        book.setName(in.nextLine());
        System.out.print("Enter price: ");
        try {
            book.setPrice(Integer.parseInt(in.nextLine()));
        } catch (NumberFormatException e) {
            System.err.println("Pages amount must be number!");
            return;
        }
        bookService.create(book);

        System.out.println("Book id: " + book.getId());
        System.out.println("Book created!");
    }

    public void updateBook() {

        Integer id;
        System.out.print("Enter book id: ");
        try {
            id = Integer.parseInt(in.nextLine());
        } catch (NumberFormatException e) {
            System.err.println("Id must be number");
            return;
        }

        Book book = bookService.findBookById(id);
        if (book == null) {
            System.err.println("No book with current id!");
            return;
        }

        System.out.println(book);

        System.out.print("Enter new name: ");
        book.setName(in.nextLine());
        System.out.print("Enter price: ");
        try {
            book.setPrice(Integer.parseInt(in.nextLine()));
        } catch (NumberFormatException e) {
            System.err.println("Pages amount must be number!");
            return;
        }
        bookService.update(book);

        System.out.println("Book updated!");
    }

    public void deleteBook() {

        Integer id;
        System.out.print("Enter book id: ");
        try {
            id = Integer.parseInt(in.nextLine());
        } catch (NumberFormatException e) {
            System.err.println("Id must be number");
            return;
        }

        Book book = bookService.findBookById(id);
        if (book == null) {
            System.err.println("No book with current id!");
            return;
        }

        bookService.delete(book);
        System.out.println("Book deleted!");
    }

    public void findBookById() {
        Integer id;
        System.out.print("Enter book id: ");
        try {
            id = Integer.parseInt(in.nextLine());
        } catch (NumberFormatException e) {
            System.err.println("Id must be number");
            return;
        }

       Book book = bookService.findBookById(id);
        if (book == null) {
            System.err.println("No book with current id!");
            return;
        }
        System.out.println(book);
    }

    public void findAllBooks() {
        List<Book> books = new ArrayList<>(bookService.findAllBooks());
        books.sort(Comparator.comparing(Book::getId));

        AsciiTable bookTable = new AsciiTable();
        bookTable.addRule();
        bookTable.addRow(null,null, null, "BOOKS").setTextAlignment(TextAlignment.CENTER);
        bookTable.addRule();
        bookTable.addRow("ID", "NAME", "PRICE", "AUTHORS_ID");
        bookTable.addRule();
        for (Book book : books) {
            bookTable.addRow(book.getId(), book.getName(), book.getPrice(), book.getAuthors().toString());
            bookTable.addRule();
        }
        System.out.println(bookTable.render());
    }

    public void findBookAuthors() {

        Integer id;
        System.out.print("Enter book id: ");
        try {
            id = Integer.parseInt(in.nextLine());
        } catch (NumberFormatException e) {
            System.err.println("Id must be number");
            return;
        }

        Book book = bookService.findBookById(id);
        if (book == null) {
            System.err.println("No book with current id!");
            return;
        }
        List<Author> authors = new ArrayList<>(bookService.readAuthors(book));
        authors.sort(Comparator.comparing(Author::getId));

        AsciiTable authorTable = new AsciiTable();
        authorTable.addRule();
        authorTable.addRow(null,null, book.getName() + " authors").setTextAlignment(TextAlignment.CENTER);
        authorTable.addRule();
        authorTable.addRow("ID", "NAME", "SURNAME");
        authorTable.addRule();
        for (Author author : authors) {
            authorTable.addRow(author.getId(), author.getFirstname(), author.getLastname());
            authorTable.addRule();
        }
        System.out.println(authorTable.render());
    }


}
