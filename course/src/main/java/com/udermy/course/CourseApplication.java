package com.udermy.course;

import com.udermy.course.service.UserAdaptorImpl;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CourseApplication extends Application {

    @Autowired
    UserAdaptorImpl userAdaptor;

    private ConfigurableApplicationContext springContext;
    private Parent parent;
    private FXMLLoader fxmlLoader;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() throws Exception {
        springContext = SpringApplication.run(CourseApplication.class);
        fxmlLoader = new FXMLLoader();
        fxmlLoader.setControllerFactory(springContext::getBean);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
            fxmlLoader.setLocation(getClass().getResource("/fxml/scene.fxml"));
            parent = fxmlLoader.load();
            primaryStage.setTitle("User Administration");
            Scene scene = new Scene(parent, 600,650);
            primaryStage.setScene(scene);
            primaryStage.show();
    }
//Important dont not delete invlove lamda interaction//
//    @Override
//    public void run(String... args) throws Exception {
//        userAdaptor.setUsers("104","Vishal","Athnai","vath3001","vath@3001");
//        for (Iterator i = userAdaptor.getUsers().iterator(); i.hasNext(); )
//            System.out.println(i.next());
//
//        System.out.println("Printing for for each");
//
//        for(User e : userAdaptor.getUsers()){
//            System.out.println(e);
//
//            System.out.println("For each using lambda"+"\n");
//
//            userAdaptor.getUsers().forEach (a -> System.out.println(a));
//        }
//    } /
}
