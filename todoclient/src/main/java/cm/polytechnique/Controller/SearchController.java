package cm.polytechnique.Controller;

import cm.polytechnique.App;
import cm.polytechnique.Zoom;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SearchController implements Initializable {

    @FXML
    private ImageView back;
    @FXML
    private ImageView fond;
    @FXML
    private ImageView logo;
    @FXML
    private VBox resultVBox;
    @FXML
    private ImageView search;
    @FXML
    private TextField searchTextField;
    @FXML
    private Label labelBack;
    @FXML
    private Label labelSearch;


    // pour rechercher une tache
    @FXML
    void onActionSearch(ActionEvent event) {

    }

    // pour retourner a la vue principale
    @FXML
    void onClickedBack(MouseEvent event) throws IOException {
        App.setRout("MainView");
    }

    // pour rechercher une tache ou un projet
    @FXML
    void onClickedSearch(MouseEvent event) {

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fond.setImage(new Image("nuit_violette.jpg"));
        back.setImage(new Image("arrowLeft.png"));
        search.setImage(new Image("blackSearch.png"));
        logo.setImage(new Image("logo.png"));
        Zoom.applyZoomEffect(labelBack,1.15);
        Zoom.applyZoomEffect(labelSearch,1.15);
    }
}
