package dao;

import entity.Author;

import org.apache.commons.lang3.ArrayUtils;


import java.util.UUID;

public class InMemoryAuthor {

    private int AUTHORS_SIZE = 0;

    private Author[] authors = (Author[]) new Author[AUTHORS_SIZE];
    private static final InMemoryAuthor instance = new InMemoryAuthor();
    private final InMemoryAuthor inMemoryAuthor = InMemoryAuthor.getInstance();

    public InMemoryAuthor() { }

    public static InMemoryAuthor getInstance() {
        return instance;
    }

    public void create(Author author) {
        author.setId(generateID());
        authors = ArrayUtils.add(authors, author);
    }

    public void update(Author author) {
        Author inDbAuthor = findAuthorById(author.getId());
        inDbAuthor.setFirstname(author.getFirstname());
        inDbAuthor.setLastname(author.getLastname());
    }

    public Author[] delete(String id, Author author) {
        if (author.getId().equals(id)) {
            authors = ArrayUtils.removeElement(authors, author);
        }
        return authors;
    }

    public Author findAuthorById(String id) {
        for (int i = 0; i < authors.length; i++) {
            if (ArrayUtils.get(authors, i).getId().equals(id)) {
                return ArrayUtils.get(authors, i);
            }
        }
        return null;
    }

    public Author[] findAllAuthors() {
        return authors;
    }

    public String generateID() {
        String id = UUID.randomUUID().toString();
        for (int i = 0; i < authors.length; i++) {
            if (ArrayUtils.get(authors, i).getId().equals(id)) {
                return generateID();
            }
        }
        return id;
    }
}
