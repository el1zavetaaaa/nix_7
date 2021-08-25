package controller;

import entity.Author;
import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.AuthorService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AuthorController {

    private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
    private static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");
    private final AuthorService authorService = new AuthorService();

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
        System.out.println("if you want create author, please enter 1");
        System.out.println("if you update author, please enter 2");
        System.out.println("if you want delete author, please enter 3");
        System.out.println("if you want findById author, please enter 4");
        System.out.println("if you want findAll authors, please enter 5");
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
                System.out.println("Enter 0 one more time!");
                break;
        }
        runNavigation();
    }

    private void create(BufferedReader reader) {
        System.out.println("Author.create");
        try {
            System.out.println("Please, enter author's first name");
            String firstname = reader.readLine();
            System.out.println("Please, enter author's last name");
            String lastname = reader.readLine();

            Author author = new Author();
            author.setFirstname(firstname);
            author.setLastname(lastname);
            authorService.create(author);
            System.out.println("author's first name = " + author.getFirstname() + " ,author's last name = " + author.getLastname() + " ,author's id = " + author.getId());
            LOGGER_INFO.info("create new author: " + author.getFirstname() + author.getLastname());
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void update(BufferedReader reader) {
        System.out.println("Author.update");
        try {
            System.out.println("Please, enter id");
            String id = reader.readLine();
            System.out.println("Please, enter author's first name");
            String firstName = reader.readLine();
            System.out.println("Please, enter author's last name");
            String lastName = reader.readLine();
            Author author = new Author();
            author.setId(id);
            author.setFirstname(firstName);
            author.setLastname(lastName);
            authorService.update(author);
            System.out.println("author's first name = " + author.getFirstname() + " " + author.getLastname());
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void delete(BufferedReader reader) {
        System.out.println("Author.delete");
        try {
            System.out.println("Please, enter id");
            String id = reader.readLine();
            Author author = authorService.findAuthorById(id);
            authorService.delete(id, author);
            LOGGER_WARN.warn("remove user by id: " + id);
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void findById(BufferedReader reader) {
        System.out.println("Author.findById");
        try {
            System.out.println("Please, enter id");
            String id = reader.readLine();
            Author author = authorService.findAuthorById(id);
            System.out.println("author = " + author.getFirstname() + " " + author.getLastname());

        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void findAll(BufferedReader reader) {
        System.out.println("Author.findAll");
        Author[] authors = authorService.findAllAuthors();
        for (int i = 0; i < authors.length; i++) {
            System.out.println(ArrayUtils.get(authors, i));
            System.out.println("authors = " + authors);
        }
    }
}
