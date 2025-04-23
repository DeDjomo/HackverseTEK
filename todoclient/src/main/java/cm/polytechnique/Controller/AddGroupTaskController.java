package cm.polytechnique.Controller;

import cm.polytechnique.App;
import cm.polytechnique.Zoom;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddGroupTaskController implements Initializable {

    @FXML
    private Button add;
    @FXML
    private ImageView add1;
    @FXML
    private AnchorPane anchor1;
    @FXML
    private Button cancel;
    @FXML
    private TextArea descrription;
    @FXML
    private ImageView fond;
    @FXML
    private ImageView logo;
    @FXML
    private TextField name;
    @FXML
    private Spinner<Integer> priority;
    @FXML
    private ImageView sort1;
    @FXML
    private VBox vboxTask;
    @FXML
    private Label labelAdd;
    @FXML
    private Label labelSort;


    // pour ajouter un projet
    @FXML
    void onActionAdd(ActionEvent event) throws IOException {
        App.setRout("MainView");
    }

    // pour annuler
    @FXML
    void onActionCancel(ActionEvent event) throws IOException {
        App.setRout("MainView");
    }

    // pour ajouter une tache a un projet
    @FXML
    void onClickedAdd(MouseEvent event) throws IOException {
        App.setRout("TaskProject");
    }

    // pour ordonner les taches d'un projet
    @FXML
    void onClickedSort1(MouseEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fond.setImage(new Image("nuit_violette.jpg"));
        logo.setImage(new Image("logo.png"));
        sort1.setImage(new Image("sort.png"));
        add1.setImage(new Image("add.png"));
        Zoom.applyZoomEffect(anchor1,1.02);
        Zoom.applyZoomEffect(labelAdd,1.2);
        Zoom.applyZoomEffect(labelSort,1.2);


        // Configuration de la plage de valeurs (1 à 3)
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 3, 1); // Min: 1, Max: 3, Initial: 1
        priority.setValueFactory(valueFactory);

    }
}
