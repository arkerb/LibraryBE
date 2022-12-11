package com.library.Library.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping(path="{bookId}")
    public Book getBookById(@PathVariable("bookId") Long bookId) {
        return bookService.loadBookById(bookId);
    }



}
