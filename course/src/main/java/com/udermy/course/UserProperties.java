package com.udermy.course;

import com.udermy.course.util.User;

public interface UserProperties {

    Iterable<User> getUsers();

    void setUsers(String firstname, String lastname, String username, String pass );
}
