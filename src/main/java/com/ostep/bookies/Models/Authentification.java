package com.ostep.bookies.Models;

import org.springframework.security.core.userdetails.User;

import javax.persistence.*;
import java.util.Set;

@Entity

@Table(name = "t_role")
public class Authentification {

    public Authentification(){}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Transient
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    private String email,password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Authentification(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
