package sample;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Controller implements Initializable {

    @FXML
    private Button myButton;
    @FXML
    private Button SignButton;
    @FXML
    private TextField myTextField;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO (don't really need to do anything here).

    }

    // When user click on myButton
    // this method will be called.
    public void showDateTime(ActionEvent event) {

        Date now= new Date();

        DateFormat df = new SimpleDateFormat("yyyy-dd-MM HH:mm:ss");
        String dateTimeString = df.format(now);
        // Show in VIEW
        myTextField.setText(dateTimeString);
        System.out.println("fuck");

    }

    public void toSign(ActionEvent event){
        System.out.println(SignButton.getText());

        Platform.runLater(()->{
            Stage primaryStage = (Stage) SignButton.getScene().getWindow();
            primaryStage.hide();
            try{
                // Read file fxml and draw interface. new controller initialized from root;
                Parent root = FXMLLoader.load(getClass()
                        .getResource("login.fxml"));

                primaryStage.setTitle("My Login Application");
                primaryStage.setScene(new Scene(root));
                primaryStage.show();
            }catch (Exception e){
                e.printStackTrace();
            }
        });
    }

    public void Login(ActionEvent event){
        System.out.println(username.getText()+" "+password.getText());
    }

}


