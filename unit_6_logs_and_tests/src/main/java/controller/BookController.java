package controller;


import entity.Book;
import org.apache.commons.lang3.ArrayUtils;
import service.BookService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BookController {
    private final BookService bookService= new BookService();

    public void start() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("select your option");
        String position;
        try {
            runNavigation();
            while ((position = reader.readLine()) != null) {
                crud(position, reader);
                position = reader.readLine();
                if (position.equals("0")) {
                    break;
                }
                crud(position, reader);
            }
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void runNavigation() {
        System.out.println();
        System.out.println("if you want create book, please enter 1");
        System.out.println("if you update book, please enter 2");
        System.out.println("if you want delete book, please enter 3");
        System.out.println("if you want findById book, please enter 4");
        System.out.println("if you want findAll books, please enter 5");
        System.out.println("if you want exit, please enter 0");
        System.out.println();
    }

    private void crud(String position, BufferedReader reader) {
        switch (position) {
            case "1":
                create(reader);
                break;
            case "2":
                update(reader);
                break;
            case "3":
                delete(reader);
                break;
            case "4":
                findById(reader);
                break;
            case "5":
                findAll(reader);
                break;
            case "0":
                System.out.println("Enter 0 one more time!");;
                break;

        }
        runNavigation();
    }

    private void create(BufferedReader reader) {
        System.out.println("Book.create");
        try {
            System.out.println("Please, enter book's name");
            String name = reader.readLine();
            Book book = new Book();
            book.setName(name);
            bookService.create(book);
            System.out.println("book's name = "  + book.getName() + " ,book's id = " + book.getId());
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void update(BufferedReader reader) {
        System.out.println("Book.update");
        try {
            System.out.println("Please, enter id");
            String id = reader.readLine();
            System.out.println("Please, enter book's name");
            String name = reader.readLine();
            Book book = new Book();
            book.setId(id);
            book.setName(name);
            bookService.update(book);
            System.out.println("book's name = " + book.getName());
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void delete(BufferedReader reader) {
        System.out.println("Book.delete");
        try {
            System.out.println("Please, enter id");
            String id = reader.readLine();
            Book book = bookService.findBookById(id);
            bookService.delete(id, book);
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void findById(BufferedReader reader) {
        System.out.println("Book.findById");
        try {
            System.out.println("Please, enter id");
            String id = reader.readLine();
            Book book = bookService.findBookById(id);
            System.out.println("book = " + book.getName());

        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void findAll(BufferedReader reader) {
        System.out.println("Book.findAll");
        Book[] books = bookService.findAllBooks();
        for (int i = 0; i < books.length; i++) {
            System.out.println(ArrayUtils.get(books, i));
            System.out.println("books = " + books);
        }
    }

}
