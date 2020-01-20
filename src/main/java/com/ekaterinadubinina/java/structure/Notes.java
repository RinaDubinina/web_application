package com.ekaterinadubinina.java.structure;

import java.time.LocalDateTime;

public class Notes {
    private int id;
    private int personId;
    private String headline;
    private String body;
    private String phoneNumber;
    private LocalDateTime createdDate;
    private CategoryNotes categoryNotes;

    public Notes(int id, int personId, String headline, String body, String phoneNumber, LocalDateTime createdDate, CategoryNotes category) {
        this.id = id;
        this.personId = personId;
        this.headline = headline;
        this.body = body;
        this.phoneNumber = phoneNumber;
        this.createdDate = createdDate;
        this.categoryNotes = categoryNotes;
    }

    public Notes() {
    }

/*    public Notes(int personId, String headline, String body, String phoneNumber, LocalDateTime createdDate, CategoryNotes categoryNotes) {
        this.personId = personId;
        this.headline = headline;
        this.body = body;
        this.phoneNumber = phoneNumber;
        this.createdDate = createdDate;
        this.categoryNotes = categoryNotes;
    }*/

    public Notes(int personId, String headline, String body, String phoneNumber, CategoryNotes categoryNotes) {
        this.personId = personId;
        this.headline = headline;
        this.body = body;
        this.phoneNumber = phoneNumber;
        this.categoryNotes = categoryNotes;
        this.createdDate = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public CategoryNotes getCategoryNotes() {
        return categoryNotes;
    }

    public void setCategoryNotes(CategoryNotes categoryNotes) {
        this.categoryNotes = categoryNotes;
    }
}
