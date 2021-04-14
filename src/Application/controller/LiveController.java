package Application.controller;
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

}


