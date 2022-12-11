package com.library.Library.book;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDAO bookDAO;

    public Book loadBookById(long bookId) {
        return bookDAO.findById(bookId).
                orElseThrow( () -> new IllegalStateException("Book Id " + bookId + " does not exist"));
    }

}
