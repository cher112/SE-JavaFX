package Application;
import tools.csvstreamTool;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import vo.Student;
import vo.Trainer;

public class LiveController implements Initializable {

    @FXML
    private TextField trainer;
    @FXML
    private TextField nextTime;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String[] lives = csvstreamTool.readCur("CurLive");
        String date = lives[2];
        String Tid = lives[1];
        System.out.println(date);
        nextTime.setText(date);
        Trainer[] tra = csvstreamTool.searchTrainer(Tid,0);
        assert tra != null;
        String name = tra[0].getName();
        trainer.setText(name);
        // TODO (don't really need to do anything here).

    }

    // When user click on myButton
    // this method will be called.
    public void showDateTime(ActionEvent event) {

        Date now= new Date();

        DateFormat df = new SimpleDateFormat("yyyy-dd-MM HH:mm:ss");
        String dateTimeString = df.format(now);
        // Show in VIEW
        nextTime.setText(dateTimeString);
        System.out.println("fuck");

    }


}


