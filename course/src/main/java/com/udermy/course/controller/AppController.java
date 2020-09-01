package com.udermy.course.controller;

import com.udermy.course.service.UserAdaptorImpl;
import com.udermy.course.util.User;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AppController {

    @Autowired
    UserAdaptorImpl userAdaptor;

    @FXML
    private TableView<User> tableview;

    @FXML
    TextField firstname;

    @FXML
    TextField lastname;

    @FXML
    TextField username;

    @FXML
    TextField pass;

    public void addUser(){
        userAdaptor.setUsers(
                firstname.getText(),
                lastname.getText(),
                username.getText(),
                pass.getText());

    firstname.setText("");
    lastname.setText("");
    username.setText("");
    pass.setText("");
    }


    public void fetchUser(ActionEvent actionEvent){
        Iterable<User> users = userAdaptor.getUsers();
        ObservableList<User> data = tableview.getItems();
        data.clear();
        users.forEach((user -> data.add(user)));
    }

}
