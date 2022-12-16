package com.library.Library.book;

import com.library.Library.bookDeadline.BookDeadline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(method = RequestMethod.GET, value = "/{bookId}")
    public Book getBookById(@PathVariable("bookId") Long bookId) {
        return bookService.loadBookById(bookId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "")
    public ResponseEntity addNewBook(@RequestBody Book book) {
        bookService.addNewBook(book);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Book> getBookListForUsers() {
        return bookService.getAllBooks();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/deadline/{type}")
    public BookDeadline getBookDeadlineByType(@PathVariable("type") String type) {
        return bookService.getBookDeadlineDaysByType(type);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/deadline/{type}/{days}")
    public ResponseEntity updateDefaultBookDeadlineByType(@PathVariable("type") String type,
                                                          @PathVariable("days") Integer days) {
        bookService.updateDefaultBookDeadlineByType(days, type);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/title/{title}")
    public List<Book> findBooksByTitle(@PathVariable("title") String title) {
        return bookService.findBooksByTitle(title);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{bookId}/loan/{borrowerId}")
    public ResponseEntity loanBook(@PathVariable("bookId") Long bookId,
                                   @PathVariable("borrowerId") Long borrowerId) {
        bookService.loanBook(bookId, borrowerId);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{bookId}/return")
    public ResponseEntity returnBook(@PathVariable("bookId") Long bookId) {
        bookService.returnBookFromLoan(bookId);
        return ResponseEntity.ok(HttpStatus.OK);
    }


}
