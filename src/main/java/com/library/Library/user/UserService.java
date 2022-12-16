package com.library.Library.user;

import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User loadUserById(long userId);
}
