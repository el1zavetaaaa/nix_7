package alltests;

import entity.Author;

public class AuthorGenerationUtil {
    public static final String FirstNAME = "Test";
    public static final String LastNAME = "Test";

    public static Author generateAuthor() {
        Author author = new Author();
        author.setFirstname(FirstNAME);
        author.setLastname(LastNAME);

        return author;
    }


}
