package com.library.Library.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserDAO extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u where lower(u.username) LIKE CONCAT('%',?1,'%')")
    List<User> findByUsername(String name);

    @Query("SELECT u FROM User u where lower(concat(u.firstName, ' ', u.lastName)) LIKE CONCAT('%',?1,'%')")
    List<User> findByFullName(String name);
}
