package cm.polytechnique.Task;

import cm.polytechnique.App;
import cm.polytechnique.model.data.SingleTask;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.util.Random;

import static cm.polytechnique.App.taskToOpen;

public class Task {

    public static void initilizeTask(TaskGraphic task, SingleTask st){
         Label name= new Label();
         Label date= new Label();
         StackPane stack = new StackPane();
         ImageView fond = new ImageView();
         ImageView priority= new ImageView();
         AnchorPane pane1 = new AnchorPane();
         AnchorPane pane2 = new AnchorPane();

         // ajout des composant au conteneur principal
         stack.getChildren().setAll(fond,pane1);
         pane1.getChildren().setAll(pane2);
         pane2.getChildren().setAll(name,date,priority);

         // modification de la taille des composants
        stack.setPrefSize(336,75);
        fond.setFitWidth(336);
        fond.setFitHeight(75);
        pane1.setPrefSize(336,75);
        pane2.setPrefSize(336,75);
        name.setPrefSize(200,75);
        date.setPrefSize(80,75);
        priority.setFitWidth(56);
        priority.setFitHeight(56);

        //modification de la position des composants
        date.setLayoutX(200);
        priority.setLayoutX(280);
        priority.setLayoutY(9);

        // effet de survol
        // Ajouter un effet de survol
        ColorAdjust colorAdjust = new ColorAdjust();
        colorAdjust.setBrightness(-0.3); // Assombrir légèrement
        stack.setOnMouseEntered(event -> {
            stack.setEffect(colorAdjust); // Appliquer l'effet au survol
        });
        stack.setOnMouseExited(event -> {
            stack.setEffect(null); // Supprimer l'effet lorsque le curseur quitte le Pane
        });




        // modification des paramètres

        // paramètre nom et date
        name.setText(st.getSingleTaskTitle());
        date.setText(st.getSingleTaskStart().toString());
        name.setAlignment(Pos.CENTER);
        date.setAlignment(Pos.CENTER);
        name.setStyle("-fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 15px;");
        date.setStyle("-fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 15px;");

        /*



         */




        // paramètre priorité
        String s = ".png";
        String p = "3";
        s = p+s;
        priority.setImage(new Image(s));

        // paramètre image de fond
        String[] strings = {"f1", "f2", "f3", "f4", "f5", "f6", "f7", "f8", "f9", "f10"};
        // Création d'un générateur aléatoire
        Random random = new Random();
        // Sélection d'un index aléatoire entre 0 et 9
        int randomIndex = random.nextInt(strings.length);
        String picture= strings[randomIndex]+".jpeg";
        //ajout de la photos a fond
        fond.setOpacity(0.8);
        fond.setPreserveRatio(false);
        fond.setImage(new Image(picture));


        //modification du style
        /*
        name.setStyle();
        num.setStyle();
        start.setStyle();
        end.setStyle();

         */



        // mise a jour de l'objet taskGraphic
        task.setDate(date);
        task.setName(name);
        task.setPane(stack);
        task.setFond(fond);
        task.setPriority(priority);
        task.setId(String.valueOf(st.getSingleTaskId()));
        task.setState("not define");
        task.setDescription(st.getSingleTaskDescription());



        // pour ouvrir une tache
        stack.setOnMouseClicked(mouseEvent->{
            // il doit y avoir une variable globale qui change chaque fois ici
            taskToOpen.setDate(date);
            taskToOpen.setName(name);
            taskToOpen.setPane(stack);
            taskToOpen.setFond(fond);
            taskToOpen.setPriority(priority);
            taskToOpen.setId("none");
            taskToOpen.setState("not define");
            taskToOpen.setDescription(st.getSingleTaskDescription());
            try {
                App.setRout("OpenTask");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });




    }
}
