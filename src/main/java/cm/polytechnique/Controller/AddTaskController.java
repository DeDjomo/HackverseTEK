package cm.polytechnique.Controller;

import cm.polytechnique.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddTaskController implements Initializable {

    @FXML
    private Button add;
    @FXML
    private Button cancel;
    @FXML
    private TextArea descrription;
    @FXML
    private TextField name;
    @FXML
    private ImageView fond;
    @FXML
    private Spinner<Integer> priority;
    @FXML
    private ImageView logo;


    @FXML
    void onActionAdd(ActionEvent event) throws IOException {
        App.setRout("MainView");
    }

    @FXML
    void onActionCancel(ActionEvent event) throws IOException {
        App.setRout("MainView");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fond.setImage(new Image("nuit_violette.jpg"));
        logo.setImage(new Image("logo.png"));

        // Configuration de la plage de valeurs (1 à 3)
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 3, 1); // Min: 1, Max: 3, Initial: 1
        priority.setValueFactory(valueFactory);
    }
}
