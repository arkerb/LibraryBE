package com.library.Library.bookDeadline;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface BookDeadlineDAO extends JpaRepository<BookDeadline, Long> {

    @Query("SELECT bd FROM BookDeadline bd where bd.type = ?1")
    Optional<BookDeadline> getDeadlineDaysByType(String type);

    @Modifying
    @Transactional
    @Query("UPDATE BookDeadline SET days = ?1 where type = ?2")
    void updateDeadlineTypeDays(Integer days, String type);
}
