package entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Connection {

    private Integer id;
    private Integer authorId;
    private Integer bookId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Connection authorBook = (Connection) o;

        if (getAuthorId() != null ? !getAuthorId().equals( authorBook.getAuthorId()) :  authorBook.getAuthorId() != null)
            return false;
        return getBookId() != null ? getBookId().equals(authorBook.getBookId()) : authorBook.getBookId() == null;
    }

    @Override
    public int hashCode() {
        int result = getAuthorId() != null ? getAuthorId().hashCode() : 0;
        result = 31 * result + (getBookId() != null ? getBookId().hashCode() : 0);
        return result;
    }

    public Integer getBookId() {
        return bookId;
    }

}
