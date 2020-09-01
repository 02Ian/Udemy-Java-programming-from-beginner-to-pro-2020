package com.udermy.course.util;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "udemydata")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid")
    private int userid;

    @Column(name="firstname")
    private String firstname;

    @Column(name="lastname")
    private String lastname;

    @Column(name = "username")
    private String username;

    @Column(name= "pass")
    private String pass;

    public User( String firstname, String lastname, String username, String pass) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.pass = pass;
    }
User(){}

}
