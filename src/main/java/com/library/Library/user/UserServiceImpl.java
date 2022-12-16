package com.library.Library.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    public User loadUserById(long userId) {
        return userDAO.findById(userId).
                orElseThrow(() -> new IllegalStateException("User Id " + userId + " does not exist"));
    }

    @Override
    public void deleteUserById(long userId) {
        userDAO.deleteById(userId);
    }

    @Override
    public void createNewUser(User user) {
        userDAO.save(user);
    }

    @Override
    public List<User> findUsersByUsername(String name) {
        return userDAO.findByUsername(name.toLowerCase());
    }

    @Override
    public List<User> findUsersByFullName(String name) {
        return userDAO.findByFullName(name.toLowerCase());
    }

}
