package com.ekaterinadubinina.java.structure;

public class Person {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private CategoryPerson categoryPerson;

    public Person(int id, String firstName, String lastName, String email, String category) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.categoryPerson = categoryPerson;
    }

    public Person(String firstName, String lastName, String email, String category) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.categoryPerson = categoryPerson;
    }

    public Person() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public CategoryPerson getCategoryPerson() {
        return categoryPerson;
    }

    public void setCategoryPerson(CategoryPerson categoryPerson) {
        this.categoryPerson = categoryPerson;
    }
}
