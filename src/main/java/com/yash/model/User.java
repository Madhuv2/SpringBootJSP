package com.yash.model;

import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotNull
    @Size(max = 65)
    @Column(name = "username")
    private String username;
    @NotNull
    @Size(max = 65)
    @Column(name = "password")
    private String password;

    @NotNull
    @Email
    @Size(max = 100)
    @Column(unique = true)
    private String email;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "user")
    private UserDetail userDetail;


    public User(){}

    public User(@NotNull String username, @NotNull String password, @NotNull String email, UserDetail userDetail) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.userDetail = userDetail;
    }

    public UserDetail getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(UserDetail userDetail) {
        this.userDetail = userDetail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
