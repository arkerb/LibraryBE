package com.library.Library.user;

import javax.persistence.*;

enum AccountType {
    DEFAULT,
    ADMIN
}

@Entity
@Table(name = "USER_ACCOUNT")
public class User {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
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

    public User(Long id, AccountType accountType, String username, String password, String firstName, String lastName, String email) {
        this.id = id;
        this.accountType = accountType.name();
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public User(AccountType accountType, String username, String password, String firstName, String lastName, String email) {
        this.accountType = accountType.name();
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public User(String accountType, String username, String password, String firstName, String lastName, String email) {
        this.accountType = accountType;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
