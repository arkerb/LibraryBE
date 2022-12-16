package com.library.Library.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookDAO extends JpaRepository<Book, Long> {

    @Query("SELECT b FROM Book b where lower(b.title) LIKE CONCAT('%',?1,'%')")
    List<Book> findBooksByTitle(String title);

    @Modifying
    @Transactional
    @Query("UPDATE Book SET borrowed = true, borrowerId = :borrowerId, deadLine = :deadLine WHERE id = :id")
    void updateBookLoanDetails(@Param("id") Long id,
                               @Param("borrowerId") Long borrowerId,
                               @Param("deadLine") LocalDate deadLine);

    @Modifying
    @Transactional
    @Query("UPDATE Book SET borrowed = false, borrowerId = null, deadLine = null WHERE id = :id")
    void returnBookFromLoan(@Param("id") Long id);
}

