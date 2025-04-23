package cm.polytechnique.Controller;

import cm.polytechnique.App;
import cm.polytechnique.Task.Task;
import cm.polytechnique.Task.TaskGraphic;
import cm.polytechnique.Zoom;
import cm.polytechnique.model.data.SingleTask;
import cm.polytechnique.model.getdata.ReadTasks;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Maincontroller implements Initializable {

    @FXML
    private ImageView add;
    @FXML
    private ImageView addProject;
    @FXML
    private AnchorPane anchor1;
    @FXML
    private AnchorPane anchor2;
    @FXML
    private AnchorPane anchor3;
    @FXML
    private AnchorPane anchor4;
    @FXML
    private ImageView fond;
    @FXML
    private Label labelAdd;
    @FXML
    private Label labelAddProject;
    @FXML
    private Label labelSearch;
    @FXML
    private Label labelSetting;
    @FXML
    private Label labelSort1;
    @FXML
    private Label labelSort2;
    @FXML
    private Label labelSort3;
    @FXML
    private Label labelSort4;
    @FXML
    private Label labelTeam;
    @FXML
    private ImageView logo;
    @FXML
    private Rectangle rect;
    @FXML
    private ImageView search;
    @FXML
    private ImageView setting;
    @FXML
    private ImageView sort1;
    @FXML
    private ImageView sort2;
    @FXML
    private ImageView sort3;
    @FXML
    private ImageView sort4;
    @FXML
    private ImageView team;
    @FXML
    private VBox vboxFinish;
    @FXML
    private VBox vboxNotComplete;
    @FXML
    private VBox vboxRunning;
    @FXML
    private VBox vboxTask;



    @FXML
    void onClickedAdd(MouseEvent event) throws IOException {
        App.setRout("AddTask");
    }

    // fonction rechercher
    @FXML
    void onClickedSearch(MouseEvent event) throws IOException {
        App.setRout("Search");
    }

    // paramètre
    @FXML
    void onClickedSetting(MouseEvent event) {

    }

    // ajouter un projet
    @FXML
    void onClickedAddProject(MouseEvent event) throws IOException {
        App.setRout("AddGroupTask");
    }

    // ajouter une liste de partage
    @FXML
    void onClickedTeam(MouseEvent event) {

    }

    // pour trier les différentes pages
    @FXML
    void onClickedSort1(MouseEvent event) {

    }
    @FXML
    void onClickedSort2(MouseEvent event) {

    }
    @FXML
    void onClickedSort3(MouseEvent event) {

    }
    @FXML
    void onClickedSort4(MouseEvent event) {

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        search.setImage(new Image("search.png"));
        add.setImage(new Image("add.png"));
        setting.setImage(new Image("setting.png"));
        fond.setImage(new Image("nuit_violette.jpg"));
        addProject.setImage(new Image("addProject.png"));
        team.setImage(new Image("addTeam.png"));
        sort1.setImage(new Image("sort.png"));
        sort2.setImage(new Image("sort.png"));
        sort3.setImage(new Image("sort.png"));
        sort4.setImage(new Image("sort.png"));
        logo.setImage(new Image("logo.png"));

        Zoom.applyZoomEffect(anchor1,1.02);
        Zoom.applyZoomEffect(anchor2,1.02);
        Zoom.applyZoomEffect(anchor3,1.02);
        Zoom.applyZoomEffect(anchor4,1.02);
        Zoom.applyZoomEffect(labelSetting,1.2);
        Zoom.applyZoomEffect(labelAdd,1.2);
        Zoom.applyZoomEffect(labelAddProject,1.2);
        Zoom.applyZoomEffect(labelSearch,1.2);
        Zoom.applyZoomEffect(labelSort1,1.2);
        Zoom.applyZoomEffect(labelSort2,1.2);
        Zoom.applyZoomEffect(labelSort3,1.2);
        Zoom.applyZoomEffect(labelSort4,1.2);
        Zoom.applyZoomEffect(labelTeam,1.2);

        // récupérons toutes les taches de l'utilisateur dans la BD
        App.TaskList = ReadTasks.readSingleTasks();
        System.out.println(App.TaskList.size());
        // espacement entre les élément
        vboxTask.setSpacing(2);
        // ajout de quelques élément
        for(SingleTask i : App.TaskList){
            TaskGraphic t = new TaskGraphic();
            Task.initilizeTask(t,i);
            vboxTask.getChildren().add(t.getPane());
        }
    }
}
