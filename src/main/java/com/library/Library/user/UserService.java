package com.library.Library.user;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    User loadUserById(long userId);

    void deleteUserById(long userId);

    void createNewUser(User user);

    List<User> findUsersByUsername(String name);

    List<User> findUsersByFullName(String name);
}
