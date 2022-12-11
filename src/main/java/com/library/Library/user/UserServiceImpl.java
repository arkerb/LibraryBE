package com.library.Library.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    public User loadUserById(long userId) {
        return userDAO.findById(userId).
                orElseThrow( () -> new IllegalStateException("User Id " + userId + " does not exist"));
    }

}
