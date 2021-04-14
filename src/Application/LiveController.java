package Application;
import tools.csvTool;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import vo.Trainer;

public class LiveController implements Initializable {

    @FXML
    private TextField trainer;
    @FXML
    private TextField nextTime;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String[] lives = csvTool.readCur("CurLive");
        String date = lives[2];
        String Tid = lives[1];
        System.out.println(date);
        nextTime.setText(date);
        Trainer[] tra = csvTool.searchTrainer(Tid,0);
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


