package com.library.Library.book;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Book {
    @Id
    @SequenceGenerator(
            name = "book_sequence",
            sequenceName = "book_sequence",
            allocationSize = 1
    )
    @GeneratedValue(generator = "book_sequence")
    private Long id;
    private String title;
    private LocalDate publishDate;
    private boolean borrowed;
    private Long borrowerId;
    private LocalDate deadLine;
    private String location;
    private Integer floor;

    public Book() {
    }

    ;

    public Book(Long id, String title, LocalDate publishDate, boolean borrowed, Long borrowerId, LocalDate deadLine, String location, Integer floor) {
        this.id = id;
        this.title = title;
        this.publishDate = publishDate;
        this.borrowed = borrowed;
        this.borrowerId = borrowerId;
        this.deadLine = deadLine;
        this.location = location;
        this.floor = floor;
    }

    public Book(String title, LocalDate publishDate, String location, Integer floor) {
        this.title = title;
        this.publishDate = publishDate;
        this.borrowed = false;
        this.borrowerId = null;
        this.deadLine = null;
        this.location = location;
        this.floor = floor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }

    public Long getBorrowerId() {
        return borrowerId;
    }

    public void setBorrowerId(Long borrowerId) {
        this.borrowerId = borrowerId;
    }

    public LocalDate getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(LocalDate deadLine) {
        this.deadLine = deadLine;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }
}

