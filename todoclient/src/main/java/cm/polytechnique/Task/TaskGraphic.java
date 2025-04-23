package cm.polytechnique.Task;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class TaskGraphic {
    private Label date;
    private Label name;
    private StackPane pane;
    private ImageView fond;
    private ImageView priority;
    private String id;
    private String state;
    private String description;

    public TaskGraphic() {
        // on initialise les nodes
        this.date = new Label();
        this.name = new Label();
        this.pane = new StackPane();
        this.fond = new ImageView();
        this.priority = new ImageView();
    }

    // les setters
    public void setDate(Label date) {this.date = date;}
    public void setName(Label name) {this.name = name;}
    public void setPane(StackPane pane) {this.pane = pane;}
    public void setFond(ImageView fond) {this.fond = fond;}
    public void setPriority(ImageView priority) {this.priority = priority;}
    public void setId(String id){this.id=id;}
    public void setState(String state){this.state=state;}
    public void setDescription(String description){this.description=description;}

    // les getters
    public Label getDate() {return date;}
    public Label getName() {return name;}
    public StackPane getPane() {return pane;}
    public ImageView getFond() {
        return fond;
    }
    public ImageView getPriority() {
        return priority;
    }
    public String getId(){return id;}
    public String getState(){return state;}
    public String getDescription(){return description;}
}
