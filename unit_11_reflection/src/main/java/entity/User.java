package entity;

import annotation.AnnotationsToAppProperties;

public class User {
    @AnnotationsToAppProperties("name")
    private String name;
    @AnnotationsToAppProperties("surname")
    private String surname;
    @AnnotationsToAppProperties("dateOfBirth")
    private String dateOfBirth;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }


}
