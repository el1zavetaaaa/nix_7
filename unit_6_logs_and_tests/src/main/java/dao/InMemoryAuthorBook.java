package dao;

import java.util.Arrays;

import entity.AuthorBook;


public class InMemoryAuthorBook {


    private AuthorBook[] authorsbooks = new AuthorBook[1];
    private int count = 1;
    private static final InMemoryAuthorBook instance = new InMemoryAuthorBook();

    private InMemoryAuthorBook() {
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public static InMemoryAuthorBook getInstance() {
        return instance;
    }

    public void create(String bookId, String[] authorsId) {

        for (AuthorBook authorandbook : authorsbooks) {
            if (!(authorandbook == null)) {
                if (authorandbook.getIdBook().equals(bookId)) {
                    return;
                }
            }
        }
        String[] idAuthors = new String[authorsId.length];
        for (int i = 0; i < idAuthors.length; i++) {
            AuthorBook authorbook = new AuthorBook();
            authorbook.setIdBook(bookId);
            authorbook.setIdAuthor(authorsId[i]);
            authorsbooks = Arrays.copyOf(authorsbooks, count);
            authorsbooks[count - 1] = authorbook;
            count++;

        }

    }


    public void delete(String idBook) {

        int countDelId = 0;

        AuthorBook[] resultArray;
        for (int i = 0; i < authorsbooks.length; i++) {
            if (authorsbooks[i].getIdBook().equals(idBook)) {
                authorsbooks[i] = null;
                setCount(getCount() - 1);
                countDelId++;
            }
        }

        resultArray = new AuthorBook[authorsbooks.length - countDelId];
        int countresultArray = 0;
        for (AuthorBook authorandbook : authorsbooks) {
            if (!(authorandbook == null)) {
                resultArray[countresultArray] = authorandbook;
                countresultArray++;
            }
        }
        authorsbooks = resultArray;


    }


    public AuthorBook[] findAllAuthorsBooks() {
        return authorsbooks;
    }

}
