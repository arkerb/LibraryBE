package com.library.Library.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

enum AccountType {
    USER,
    ADMIN
}

@Entity
@Table(name = "USER_ACCOUNT")
@Getter
@Setter
@RequiredArgsConstructor
public class User {
    @Id
    @SequenceGenerator(
            name="user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(generator = "user_sequence")
    private Long id;
    private String accountType;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;

    public User(AccountType accountType, String username, String password, String firstName, String lastName, String email) {
        this.accountType = accountType.name();
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
