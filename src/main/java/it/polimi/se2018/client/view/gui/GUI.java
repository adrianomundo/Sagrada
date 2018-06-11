package it.polimi.se2018.client.view.gui;


import it.polimi.se2018.client.view.View;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.control.*;
import javafx.stage.Stage;



import static javafx.application.Application.launch;


public class GUI extends Application{

    private GuiView view;


    public void setView(GuiView view) {
        this.view = view;
    }

    public static void main(String []args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Login.start(primaryStage, this);
    }


    public void getMode(String mode){

        Platform.runLater(new Runnable() {

            @Override

            public void run() {


                if (mode.equalsIgnoreCase("multi")) {
                    view.sendMode(false);
                }
                if (mode.equalsIgnoreCase("single")) {
                    view.sendMode(true);
                }
            }
        });
    }

    public void getName(String name){

        Platform.runLater(new Runnable(){

            @Override

            public void run() {
                view.setName(name);
            }

        });
    }
}

