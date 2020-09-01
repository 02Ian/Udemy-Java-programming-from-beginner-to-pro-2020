package com.udermy.course.service;

import com.udermy.course.UserProperties;
import com.udermy.course.util.GetUsers;
import com.udermy.course.util.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class UserAdaptorImpl implements UserProperties {

    @Bean
    UserAdaptorImpl userAdaptor(){return new UserAdaptorImpl();}

    @Autowired
    private GetUsers getUsers;

    @Autowired
    private GetUsers setUsers;

    @Override
    public Iterable<User> getUsers() {
        return getUsers.findAll();
    }

    @Override
    public void setUsers(String firstname, String lastname, String username, String pass) {
        User user =  new User(firstname, lastname, username, pass);
        setUsers.save(user);
    }


}
