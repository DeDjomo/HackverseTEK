package cm.polytechnique;

import cm.polytechnique.Task.Task;
import cm.polytechnique.Task.TaskGraphic;
import cm.polytechnique.model.data.SingleTask;
import cm.polytechnique.model.getdata.ReadTasks;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static javafx.scene.Cursor.*;



public class App extends Application {
    static Scene scene;
    public static TaskGraphic taskToOpen;
    public static List<SingleTask> TaskList;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("Login"),1920,1080);
        scene.getStylesheets().add(getClass().getResource("Styles.css").toExternalForm());
        stage.setScene(scene);
        // pour afficher le stage (1920x1080)
        stage.show();
    }

    // deux fonctions statique pour pouvoir switcher entre les différentes vues
    public static void setRout(String fxml) throws IOException {
        App.scene.setRoot(loadFXML(fxml));
    }
    public static Parent loadFXML(String fxml) throws  IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Vues" + "/" + fxml + ".fxml"));
        return fxmlLoader.load();
    }


    public static void main(String[] args) {

        App.TaskList = ReadTasks.readSingleTasks();
        for (SingleTask task : App.TaskList){
            task.delete();
        }
        System.out.println(App.TaskList.size());
        launch();
    }
}















/*
public class App extends Application {

    private Stage stage;
    private double xOffset = 0;
    private double yOffset = 0;
    private boolean isMaximized = false;
    private double[] prevSize = new double[2];
    private double[] prevPos = new double[2];

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setFullScreen(true);

        // Création des boutons de contrôle
        Button closeBtn = createControlButton("", "red");
        Button minBtn = createControlButton("", "lightgreen");
        Button maxBtn = createControlButton("", "yellow");

        // Gestion des clics
        closeBtn.setOnAction(e -> stage.close());
        minBtn.setOnAction(e -> stage.setIconified(true));
        maxBtn.setOnAction(e -> toggleMaximize());

        // Barre de titre
        HBox titleBar = new HBox();
        titleBar.setStyle("-fx-background-color: black; -fx-padding: 5; -fx-spacing : 6");

        titleBar.getChildren().addAll(minBtn, maxBtn, closeBtn);

        // Layout principal
        BorderPane root = new BorderPane();
        root.setTop(titleBar);
        root.setStyle("-fx-background-color: black");

        // Chargement du FXML initial
        loadFXMLContent(root, "Vues/MainView.fxml"); // Remplacez par votre chemin FXML

        // Gestion du déplacement
        titleBar.setOnMousePressed(this::handleMousePressed);
        titleBar.setOnMouseDragged(this::handleMouseDragged);

        Scene scene = new Scene(root, 1980, 1000);
        setupResizeListeners(scene);

        stage.setScene(scene);
        stage.show();
    }

    private void loadFXMLContent(BorderPane root, String fxmlPath) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent content = loader.load();
            root.setCenter(content);
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
            // Contenu de secours si le chargement échoue
            Label errorLabel = new Label("Erreur de chargement: " + fxmlPath);
            errorLabel.setStyle("-fx-text-fill: red; -fx-font-size: 16;");
            root.setCenter(errorLabel);
        }
    }

    private Button createControlButton(String text, String color) {
        Button btn = new Button(text);
        btn.setStyle(String.format("""
            -fx-background-radius: 50;
            -fx-min-width: 30;
            -fx-focus-color: transparent;
            -fx-faint-focus-color: transparent;
            -fx-background-color: %s;
            -fx-text-fill: white;
        """, color));
        btn.setPrefSize(20,20);
        btn.setCursor(HAND);
        Zoom.applyZoomEffect(btn,1.1);
        return btn;
    }

    private void toggleMaximize() {
        if (isMaximized) {
            stage.setMaximized(false);
            stage.setWidth(prevSize[0]);
            stage.setHeight(prevSize[1]);
            stage.setX(prevPos[0]);
            stage.setY(prevPos[1]);
        } else {
            prevSize[0] = stage.getWidth();
            prevSize[1] = stage.getHeight();
            prevPos[0] = stage.getX();
            prevPos[1] = stage.getY();
            stage.setMaximized(true);
        }
        isMaximized = !isMaximized;
    }

    private void handleMousePressed(MouseEvent event) {
        if (!isMaximized) {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        }
    }

    private void handleMouseDragged(MouseEvent event) {
        if (!isMaximized) {
            stage.setX(event.getScreenX() - xOffset);
            stage.setY(event.getScreenY() - yOffset);
        }
    }

    private void setupResizeListeners(Scene scene) {
        ResizeListener resizeListener = new ResizeListener(stage);
        scene.addEventHandler(MouseEvent.MOUSE_MOVED, resizeListener::handle);
        scene.addEventHandler(MouseEvent.MOUSE_PRESSED, resizeListener::handle);
        scene.addEventHandler(MouseEvent.MOUSE_DRAGGED, resizeListener::handle);
    }

    public static void main(String[] args) {
        launch(args);
    }

    private static class ResizeListener {
        private final Stage stage;
        private Cursor cursor = Cursor.DEFAULT;
        private double startX, startY;

        public ResizeListener(Stage stage) {
            this.stage = stage;
        }

        public void handle(MouseEvent event) {
            if (event.getEventType() == MouseEvent.MOUSE_MOVED) {
                updateCursor(event);
            } else if (event.getEventType() == MouseEvent.MOUSE_PRESSED) {
                startX = event.getScreenX();
                startY = event.getScreenY();
            } else if (event.getEventType() == MouseEvent.MOUSE_DRAGGED) {
                handleResize(event);
            }
        }

        private void updateCursor(MouseEvent event) {
            if (stage.isMaximized()) {
                stage.getScene().setCursor(Cursor.DEFAULT);
                return;
            }

            double x = event.getX();
            double y = event.getY();
            double width = stage.getWidth();
            double height = stage.getHeight();
            final int MARGIN = 5;

            Cursor newCursor = Cursor.DEFAULT;
            if (x < MARGIN) {
                if (y < MARGIN) newCursor = Cursor.NW_RESIZE;
                else if (y > height - MARGIN) newCursor = Cursor.SW_RESIZE;
                else newCursor = W_RESIZE;
            } else if (x > width - MARGIN) {
                if (y < MARGIN) newCursor = Cursor.NE_RESIZE;
                else if (y > height - MARGIN) newCursor = Cursor.SE_RESIZE;
                else newCursor = Cursor.E_RESIZE;
            } else if (y < MARGIN) {
                newCursor = N_RESIZE;
            } else if (y > height - MARGIN) {
                newCursor = S_RESIZE;
            }

            stage.getScene().setCursor(newCursor);
            cursor = newCursor;
        }

        private void handleResize(MouseEvent event) {
            if (cursor == Cursor.DEFAULT || stage.isMaximized()) return;

            double newX = event.getScreenX();
            double newY = event.getScreenY();
            double deltaX = newX - startX;
            double deltaY = newY - startY;

            if (cursor.equals(NW_RESIZE)) {
                stage.setWidth(Math.max(stage.getWidth() - deltaX, stage.getMinWidth()));
                stage.setHeight(Math.max(stage.getHeight() - deltaY, stage.getMinHeight()));
                stage.setX(stage.getX() + deltaX);
                stage.setY(stage.getY() + deltaY);
            } else if (cursor.equals(NE_RESIZE)) {
                stage.setWidth(Math.max(stage.getWidth() + deltaX, stage.getMinWidth()));
                stage.setHeight(Math.max(stage.getHeight() - deltaY, stage.getMinHeight()));
                stage.setY(stage.getY() + deltaY);
            } else if (cursor.equals(SW_RESIZE)) {
                stage.setWidth(Math.max(stage.getWidth() - deltaX, stage.getMinWidth()));
                stage.setHeight(Math.max(stage.getHeight() + deltaY, stage.getMinHeight()));
                stage.setX(stage.getX() + deltaX);
            } else if (cursor.equals(SE_RESIZE)) {
                stage.setWidth(Math.max(stage.getWidth() + deltaX, stage.getMinWidth()));
                stage.setHeight(Math.max(stage.getHeight() + deltaY, stage.getMinHeight()));
            } else if (cursor.equals(W_RESIZE)) {
                stage.setWidth(Math.max(stage.getWidth() - deltaX, stage.getMinWidth()));
                stage.setX(stage.getX() + deltaX);
            } else if (cursor.equals(E_RESIZE)) {
                stage.setWidth(Math.max(stage.getWidth() + deltaX, stage.getMinWidth()));
            } else if (cursor.equals(N_RESIZE)) {
                stage.setHeight(Math.max(stage.getHeight() - deltaY, stage.getMinHeight()));
                stage.setY(stage.getY() + deltaY);
            } else if (cursor.equals(S_RESIZE)) {
                stage.setHeight(Math.max(stage.getHeight() + deltaY, stage.getMinHeight()));
            }

            startX = newX;
            startY = newY;
        }
    }
}

 */