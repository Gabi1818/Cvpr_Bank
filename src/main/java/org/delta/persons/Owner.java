package org.delta.persons;

public class Owner {
    private String name;
    private String surname;
    private String id;

    public Owner(String name, String surname, String id) {
        this.name = name;
        this.surname = surname;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
