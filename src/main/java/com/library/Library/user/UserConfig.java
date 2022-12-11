package com.library.Library.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner2(UserDAO userDAO) {
        return args -> {
          User user1 = new User(
                  AccountType.ADMIN, "user", "user", "user", "name", "test@test.ee"
          );
            userDAO.saveAll(List.of(user1));
        };

    }

}
