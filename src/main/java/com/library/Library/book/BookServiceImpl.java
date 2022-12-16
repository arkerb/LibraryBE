package com.library.Library.book;

import com.library.Library.bookDeadline.BookDeadline;
import com.library.Library.bookDeadline.BookDeadlineDAO;
import com.library.Library.bookDeadline.DeadlineType;
import com.library.Library.user.User;
import com.library.Library.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDAO bookDAO;

    @Autowired
    private BookDeadlineDAO bookDeadlineDAO;

    @Autowired
    private UserService userService;

    @Override
    public Book loadBookById(Long id) {
        return bookDAO.findById(id).
                orElseThrow(() -> new IllegalStateException("Book Id " + id + " does not exist"));
    }

    @Override
    public void addNewBook(Book book) {
        bookDAO.save(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookDAO.findAll();
    }


    @Override
    public BookDeadline getBookDeadlineDaysByType(String type) {
        return bookDeadlineDAO.getDeadlineDaysByType(type).
                orElseThrow(() -> new IllegalStateException("Deadline type " + type + " does not exist"));
    }

    @Override
    public void updateDefaultBookDeadlineByType(Integer days, String type) {
        bookDeadlineDAO.updateDeadlineTypeDays(days, type);
    }

    @Override
    public List<Book> findBooksByTitle(String title) {
        return bookDAO.findBooksByTitle(title.toLowerCase());
    }

    @Override
    public void loanBook(Long bookId, Long borrowerId) {
        Book book = loadBookById(bookId);
        User user = userService.loadUserById(borrowerId);
        if (book == null || user == null) {
            throw new IllegalStateException("Faulty Ids");
        } else if (book.isBorrowed()) {
            throw new IllegalStateException("Book is borrowed");
        } else {
            calculateLoanDate(book, borrowerId);
        }
    }

    @Override
    public void returnBookFromLoan(Long bookId) {
        Book book = loadBookById(bookId);
        if (!book.isBorrowed()) {
            throw new IllegalStateException("Book is not borrowed");
        } else {
            bookDAO.returnBookFromLoan(bookId);
        }
    }

    private void calculateLoanDate(Book book, Long borrowerId) {
        bookDAO.updateBookLoanDetails(book.getId(), borrowerId, getNewDeadline(book));
    }

    private LocalDate getNewDeadline(Book book) {
        String type = book.getPublishDate().isAfter(LocalDate.now().minusMonths(3)) ? DeadlineType.NEW_BOOK.name() :
                ((findBooksByTitle(book.getTitle()).size() <= 5) ? DeadlineType.LOW_COPIES.name() :
                        DeadlineType.DEFAULT.name());
        return LocalDate.now().plusDays(getBookDeadlineDaysByType(type).getDays());
    }

}
