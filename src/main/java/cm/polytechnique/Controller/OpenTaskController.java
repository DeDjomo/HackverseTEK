package cm.polytechnique.Controller;

import cm.polytechnique.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static cm.polytechnique.App.taskToOpen;

public class OpenTaskController implements Initializable {

    @FXML
    private Button cancel;
    @FXML
    private Button confirm;
    @FXML
    private TextArea description;
    @FXML
    private ImageView fond;
    @FXML
    private ImageView logo;
    @FXML
    private TextField name;
    @FXML
    private Spinner<Integer> priority;
    @FXML
    private Button remove;
    @FXML
    private Button revised;
    @FXML
    private Label taskTitleName;
    @FXML
    private ChoiceBox<String> state;

    // pour retourner au menue principal
    @FXML
    void onActionCancel(ActionEvent event) throws IOException {
        App.setRout("MainView");
    }

    // ici on modifie la tache et on va au menue principal
    @FXML
    void onActionConfirm(ActionEvent event) throws IOException {
        // on enregistre les donnée dans la bd et on modifie les caractéristique de tache dans notre liste de tache(ça va dépendre)

        App.setRout("MainView");
    }

    // ici on supprime la tache puis on va au menue principal
    @FXML
    void onActionRemove(ActionEvent event) throws IOException {
        App.setRout("MainView");
    }

    // on clique ici pour permettre la modification des champs
    @FXML
    void onActionRevised(ActionEvent event) {
        revised.setVisible(false);
        confirm.setVisible(true);

        // on réactive les composants
        priority.setEditable(true);
        name.setEditable(true);
        description.setEditable(true);
        // Configuration priorité (1 à 3)
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 3, 1); // Min: 1, Max: 3, Initial: 1
        priority.setValueFactory(valueFactory);
        // donnons le choix
        state.getItems().addAll("Running", "Finish", "Not Complete");

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        confirm.setVisible(false);
        revised.setVisible(true);


        // on récupère les données de notre variable globale taskToOpen
        state.setValue(taskToOpen.getState());
        name.setText(taskToOpen.getName().getText());
        description.setText(taskToOpen.getDescription());
        // Configuration de la plage de valeurs a 2 par exemple
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(2, 2, 1); // Min: 1, Max: 3, Initial: 1
        priority.setValueFactory(valueFactory);


        // par défaut on déactive tous les composants
        priority.setEditable(false);
        name.setEditable(false);
        description.setEditable(false);
    }
}
