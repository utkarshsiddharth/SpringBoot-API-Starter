package com.skdev;

import jakarta.persistence.*;

@Entity
public class Book {
    @Id
    @SequenceGenerator(
            name = "book_id_sequence",
            sequenceName = "book_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "book_id_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private int id;
    private String title;
    private String description;

    public Book(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Book(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
