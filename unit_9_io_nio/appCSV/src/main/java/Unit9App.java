import controller.AuthorController;
import controller.BookController;
import controller.ConnectionController;
import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;

import java.util.Scanner;

public class Unit9App {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        boolean continueEnter = true;
        String userChoice;

        AsciiTable table = new AsciiTable();
        table.addRule();
        table.addRow(null, "MENU").setTextAlignment(TextAlignment.CENTER);
        table.addRule();
        table.addRow(null, "0. EXIT").setTextAlignment(TextAlignment.CENTER);
        table.addRule();
        table.addRow("AUTHOR", "BOOK").setTextAlignment(TextAlignment.CENTER);
        table.addRule();
        table.addRow("1.1 Create author", "2.1 Create book").setTextAlignment(TextAlignment.CENTER);
        table.addRule();
        table.addRow("1.2 Update author", "2.2 Update book").setTextAlignment(TextAlignment.CENTER);
        table.addRule();
        table.addRow("1.3 Get author`s books", "2.3 Get book`s authors").setTextAlignment(TextAlignment.CENTER);
        table.addRule();
        table.addRow("1.4 Get all authors", "2.4 Get all books").setTextAlignment(TextAlignment.CENTER);
        table.addRule();
        table.addRow("1.5 Delete author", "2.5 Delete book").setTextAlignment(TextAlignment.CENTER);
        table.addRule();
        table.addRow(null, "ASSOCIATIONS").setTextAlignment(TextAlignment.CENTER);
        table.addRule();
        table.addRow(null, "3.6 Add books to author").setTextAlignment(TextAlignment.CENTER);
        table.addRule();
        table.addRow(null, "3.7 Add authors to book").setTextAlignment(TextAlignment.CENTER);
        table.addRule();

        while (continueEnter) {

            System.out.println(table.render());
            System.out.print("Enter number from table: ");
            userChoice = in.nextLine();

            switch (userChoice) {
                case "1.1":
                    AuthorController.getInstance().createAuthor();
                    break;
                case "1.2":
                    AuthorController.getInstance().findAllAuthors();
                    AuthorController.getInstance().updateAuthor();
                    break;
                case "1.3":
                    AuthorController.getInstance().findAllAuthors();
                    AuthorController.getInstance().findAuthorBooks();
                    break;
                case "1.4":
                    AuthorController.getInstance().findAllAuthors();
                    break;
                case "1.5":
                    AuthorController.getInstance().findAllAuthors();
                    AuthorController.getInstance().deleteAuthor();
                    break;

                case "2.1":
                    BookController.getInstance().createBook();
                    break;
                case "2.2":
                    BookController.getInstance().findAllBooks();
                    BookController.getInstance().updateBook();
                    break;
                case "2.3":
                    BookController.getInstance().findAllBooks();
                    BookController.getInstance().findBookAuthors();
                    break;
                case "2.4":
                    BookController.getInstance().findAllBooks();
                    break;
                case "2.5":
                    BookController.getInstance().findAllBooks();
                    BookController.getInstance().deleteBook();
                    break;

                case "3.6":
                    AuthorController.getInstance().findAllAuthors();
                    ConnectionController.addBook();
                    break;
                case "3.7":
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

