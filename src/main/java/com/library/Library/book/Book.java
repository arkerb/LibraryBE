package com.library.Library.book;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "BOOK")
@Getter
@Setter
@RequiredArgsConstructor
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
    private Boolean borrowed;
    private Long borrowerId;
    private LocalDate deadLine;
    private String location;
    private Integer floor;

    public Book(String title, LocalDate publishDate, boolean borrowed, Long borrowerId, LocalDate deadLine, String location, Integer floor) {
        this.title = title;
        this.publishDate = publishDate;
        this.borrowed = borrowed;
        this.borrowerId = borrowerId;
        this.deadLine = deadLine;
        this.location = location;
        this.floor = floor;
    }
}

