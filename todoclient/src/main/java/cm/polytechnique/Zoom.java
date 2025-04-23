package cm.polytechnique;

import javafx.animation.ScaleTransition;
import javafx.scene.Node;
import javafx.util.Duration;

public class Zoom {

    // Méthode pour appliquer le zoom à un nœud
    public static void applyZoomEffect(Node node, double hoverScale) {
        node.setOnMouseEntered(event -> {
            ScaleTransition st = new ScaleTransition(Duration.millis(200), node);
            st.setToX(hoverScale);
            st.setToY(hoverScale);
            st.play();
        });

        node.setOnMouseExited(event -> {
            ScaleTransition st = new ScaleTransition(Duration.millis(200), node);
            st.setToX(1.0);
            st.setToY(1.0);
            st.play();
        });
    }
}
