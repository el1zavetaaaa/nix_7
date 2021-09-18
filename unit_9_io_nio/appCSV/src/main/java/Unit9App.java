import controller.AuthorController;
import controller.BookController;
import controller.ConnectionController;

import java.util.Scanner;

public class Unit9App {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        boolean continueEnter = true;
        String userChoice;
        System.out.println("Author and Book CRUD Application");
        System.out.println("1 Create author.");
        System.out.println("2 Update author.");
        System.out.println("3 Get author`s books.");
        System.out.println("4 Get all authors.");
        System.out.println("5 Delete author.");
        System.out.println("6 Create book.");
        System.out.println("7 Update book.");
        System.out.println("8 Get book`s authors.");
        System.out.println("9 Get all books.");
        System.out.println("10 Delete book.");
        System.out.println("11 Add books to author.");
        System.out.println("12 Add authors to book.");
        System.out.println("0 Exit.");

        while (continueEnter) {

            System.out.print("Enter number: ");
            userChoice = in.nextLine();

            switch (userChoice) {
                case "1":
                    AuthorController.getInstance().createAuthor();
                    break;
                case "2":
                    AuthorController.getInstance().findAllAuthors();
                    AuthorController.getInstance().updateAuthor();
                    break;
                case "3":
                    AuthorController.getInstance().findAllAuthors();
                    AuthorController.getInstance().findAuthorBooks();
                    break;
                case "4":
                    AuthorController.getInstance().findAllAuthors();
                    break;
                case "5":
                    AuthorController.getInstance().findAllAuthors();
                    AuthorController.getInstance().deleteAuthor();
                    break;

                case "6":
                    BookController.getInstance().createBook();
                    break;
                case "7":
                    BookController.getInstance().findAllBooks();
                    BookController.getInstance().updateBook();
                    break;
                case "8":
                    BookController.getInstance().findAllBooks();
                    BookController.getInstance().findBookAuthors();
                    break;
                case "9":
                    BookController.getInstance().findAllBooks();
                    break;
                case "10":
                    BookController.getInstance().findAllBooks();
                    BookController.getInstance().deleteBook();
                    break;

                case "11":
                    AuthorController.getInstance().findAllAuthors();
                    ConnectionController.addBook();
                    break;
                case "12":
                    BookController.getInstance().findAllBooks();
                    ConnectionController.addAuthor();
                    break;
                case "0":
                    continueEnter = false;
                    break;
                default:
                    System.out.println("Incorrect input! Please, try again.");
            }
        }
    }
}

