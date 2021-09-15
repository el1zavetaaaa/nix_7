package entity;

import lombok.ToString;

import java.util.HashSet;
import java.util.Set;


@ToString
public class Author {

    private String firstname;
    private String lastname;
    private Set<Integer> books;
    private Integer id;
    private Boolean available;

    public Author() {
        super();
        this.books = new HashSet<>();
        this.available = true;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Set<Integer> getBooks() {
        return books;
    }

    public void setBooks(Set<Integer> books) {
        this.books = books;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}