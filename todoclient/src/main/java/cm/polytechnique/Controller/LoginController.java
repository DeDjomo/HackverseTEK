package cm.polytechnique.Controller;

import cm.polytechnique.App;
import cm.polytechnique.Mail.OTPService;
import cm.polytechnique.Mail.TestEmail;
import cm.polytechnique.Notification.Notification;
import cm.polytechnique.model.data.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private Button Login_button;
    @FXML
    private Label Login_label;
    @FXML
    private AnchorPane already_pane;
    @FXML
    private Button create_button;
    @FXML
    private AnchorPane create_pane;
    @FXML
    private TextField email1;
    @FXML
    private TextField mail2;
    @FXML
    private PasswordField password1;
    @FXML
    private PasswordField password2;
    @FXML
    private TextField username1;
    @FXML
    private ImageView fond;
    @FXML
    private ImageView logo1;
    @FXML
    private ImageView logo2;
    @FXML
    private Button sendCode;
    @FXML
    private PasswordField code;

    String x;




    @FXML
    void on_action_create(ActionEvent event) throws IOException {
        // on vérifie d'abord que tous les champs sont plein
        if(password1.getText().isEmpty()||email1.getText().isEmpty()||username1.getText().isEmpty()||code.getText().isEmpty()){
            Notification.showError("ERROR","","Please fill in all fields");
        }
        else{
            System.out.println("2");
            System.out.println(x);
            System.out.println("2");
            if(x.equals(code.getText())){
                System.out.println(x);
                System.out.println(code.getText());
                // si le code est valide
                //j'enregistre le user dans la bd
                User u = new User(username1.getText(),email1.getText(),password1.getText());
                int b = u.save();
                if(b==0){
                    App.setRout("MainView");
                }else{
                    Notification.showError("ERROR","","Error during database save operation");
                }

            }else{
                Notification.showError("ERROR","","Invalid Code");
            }
        }
    }

    @FXML
    void on_action_login(ActionEvent event) throws IOException {
        App.setRout("MainView");
    }

    @FXML
    void onActionSendCode(ActionEvent event) throws IOException {
        if(password1.getText().isEmpty()||email1.getText().isEmpty()||username1.getText().isEmpty()){
            Notification.showError("ERROR","","Please fill in all fields");
        }
        else{
            x= OTPService.genererCode(email1.getText());
            System.out.println("1");
            System.out.println(x);
            System.out.println("1");


            TestEmail.testEmail(email1.getText(),x);
            Notification.showWarning("Warning","","If you don't receive notifications,check if the email is in your Gmail spam folder.");
        }
    }

    @FXML
    void on_clicked_forgot_password(MouseEvent event) {

    }

    @FXML
    void on_clicked_login(MouseEvent event) {
        create_pane.setVisible(false);
        already_pane.setVisible(true);
    }

    @FXML
    void on_clicked_signUp(MouseEvent event) {
        create_pane.setVisible(true);
        already_pane.setVisible(false);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        create_pane.setVisible(false);
        already_pane.setVisible(true);
        fond.setImage(new Image("photos/fond3.jpg"));
        logo1.setImage(new Image("photos/logo.png"));
        logo2.setImage(new Image("photos/logo.png"));
    }
}
