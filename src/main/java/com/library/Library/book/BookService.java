package com.library.Library.book;

import com.library.Library.bookDeadline.BookDeadline;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {

    Book loadBookById(Long id);

    void addNewBook(Book book);

    List<Book> getAllBooks();

    BookDeadline getBookDeadlineDaysByType(String type);

    void updateDefaultBookDeadlineByType(Integer days, String type);

    List<Book> findBooksByTitle(String title);

    void loanBook(Long bookId, Long borrowerId);

    void returnBookFromLoan(Long bookId);
}
