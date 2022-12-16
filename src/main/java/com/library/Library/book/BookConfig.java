package com.library.Library.book;

import com.library.Library.bookDeadline.BookDeadline;
import com.library.Library.bookDeadline.BookDeadlineDAO;
import com.library.Library.bookDeadline.DeadlineType;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class BookConfig {

    @Bean
    CommandLineRunner initBookDeadlineTypes(BookDeadlineDAO bookDeadlineDAO) {
        return args -> {
            BookDeadline bookDLDefault = new BookDeadline(DeadlineType.DEFAULT.toString(), 28);
            BookDeadline bookDLNew = new BookDeadline(DeadlineType.NEW_BOOK.toString(), 7);
            BookDeadline bookDLLow = new BookDeadline(DeadlineType.LOW_COPIES.toString(), 7);
            bookDeadlineDAO.saveAll(
                    List.of(bookDLDefault, bookDLNew, bookDLLow));
        };
    }

    @Bean
    CommandLineRunner createBasicBooks(BookDAO bookDAO) {
        return args -> {
            Book book1 = new Book("Mets", LocalDate.now(), "Metsas", 3);
            Book book2 = new Book("Mets", LocalDate.now(), "Metsas", 2);
            Book book3 = new Book("Mets 2", LocalDate.now(), "Metsas", 2);
            bookDAO.saveAll(
                    List.of(book1, book2, book3));
        };
    }

}
