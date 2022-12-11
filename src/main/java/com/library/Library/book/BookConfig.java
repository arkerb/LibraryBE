package com.library.Library.book;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class BookConfig {

    @Bean
    CommandLineRunner commandLineRunner(BookDAO bookDAO) {
        return args -> {
          Book book1 = new Book(
                  "Mets",
                  LocalDate.now(),
                  false, null,
                  LocalDate.now(),
                  "Metsas",
                  3);
            Book book2 = new Book(
                    "Mets",
                    LocalDate.now(),
                    false, null,
                    LocalDate.now(),
                    "Metsas",
                    2);
            Book book3 = new Book(
                    "Mets 2",
                    LocalDate.now(),
                    false, null,
                    LocalDate.now(),
                    "Metsas",
                    2);
            bookDAO.saveAll(
                    List.of(book1, book2, book3));
        };

    }

}
