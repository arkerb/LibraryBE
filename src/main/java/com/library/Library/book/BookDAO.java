package com.library.Library.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookDAO extends JpaRepository<Book, Long> {
}
