package controller;

import entity.Author;
import entity.AuthorBook;
import entity.Book;
import org.apache.commons.lang3.ArrayUtils;
import service.AuthorBookService;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AuthorBookController {

    private final AuthorBookService authorBookService = new AuthorBookService();

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
        System.out.println("if you want create author and book, please enter 1");
        System.out.println("if you want delete author and book, please enter 2");
        System.out.println("if you want findAll authors and books, please enter 3");
        System.out.println("if you want exit, please enter 0");
        System.out.println();
    }

    private void crud(String position, BufferedReader reader) {
        switch (position) {
            case "1":
                create(reader);
                break;
            case "2":
                delete(reader);
                break;
            case "3":
                findAll(reader);
                break;
            case "0":
                System.out.println("Enter 0 one more time!");
                break;
        }
        runNavigation();
    }

    private void create(BufferedReader reader) {
        System.out.println("Author and Book.create");
        try {
            System.out.println("Please, enter author's first name");
            String firstname = reader.readLine();
            System.out.println("Please, enter author's last name");
            String lastname = reader.readLine();

            Author author = new Author();
            author.setFirstname(firstname);
            author.setLastname(lastname);
            Author[] authors = {author};
            System.out.println("Please, enter book's name");
            String name = reader.readLine();
            Book book = new Book();
            book.setName(name);
            authorBookService.createBookAuthors(book, authors);
            System.out.println("author's first name = " + author.getFirstname() + " ,author's last name = " + author.getLastname() + " ,author's id = " + author.getId() + " ,book's name = " + book.getName() + " ,book's id = " + book.getId());
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void delete(BufferedReader reader) {
        System.out.println("Author and Book.delete");
        try {
            System.out.println("Please, enter id");
            String id = reader.readLine();
            authorBookService.delete(id);
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void findAll(BufferedReader reader) {
        System.out.println("Author and Book.findAll");
        AuthorBook[] authorBooks = authorBookService.findAllAuthorsBooks();
        for (int i = 0; i < authorBooks.length; i++) {
            System.out.println(ArrayUtils.get(authorBooks, i));
            System.out.println("books = " + authorBooks);
        }
    }
}
