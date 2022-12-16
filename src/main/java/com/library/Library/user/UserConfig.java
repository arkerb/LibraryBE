package com.library.Library.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner createUsers(UserDAO userDAO) {
        return args -> {
            User user1 = new User(
                    AccountType.ADMIN, "user", "user", "user", "name", "test@test.ee"
            );
            User user2 = new User(
                    AccountType.DEFAULT, "maOlenLahe54", "lahePass", "Miks", "Fullnimi", "test@test.ee"
            );
            User user3 = new User(
                    AccountType.DEFAULT, "TaistaZZZFSA", "lahedamPass", "Juku", "Jukunson", "test@test.ee"
            );
            userDAO.saveAll(List.of(user1, user2, user3));
        };

    }

}
