package com.library.Library.bookDeadline;

import javax.persistence.*;

@Entity
@Table
public class BookDeadline {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String type;
    private Integer days;

    public BookDeadline() {
    }

    ;

    public BookDeadline(Long id, String type, Integer days) {
        this.id = id;
        this.type = type;
        this.days = days;
    }

    public BookDeadline(String type, Integer days) {
        this.type = type;
        this.days = days;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }
}
