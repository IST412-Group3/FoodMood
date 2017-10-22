/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.EntryList;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author David
 */
public class LoginFXMLController extends Controller implements Initializable {

    private String curView;
    @FXML
    private TextField Username;
    @FXML
    private PasswordField Password;

    public LoginFXMLController() {
        curView = "Login";
    }

    /**
     * @return the curView
     */
    public String getCurView() {
        return curView;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (entryList == null) {
            entryList = new EntryList();

        }
    }

    private void showMenu() {
        // Close Login Stage
        Stage temp = (Stage) Username.getScene().getWindow();
        temp.close();
        try {
            // Loads Menu Stage
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/MenuFXML.fxml"));
            Parent root = loader.load();
            Stage base = new Stage();
            base.setTitle("FoodMood - Menu");
            Scene main = new Scene(root);
            base.setScene(main);
            base.show();
        } catch (IOException except) {
            System.out.println("Error occured: " + except.toString());
        }
    }


    /**
     * Null check of username and password field
     *
     * @return True = username and/or password field are empty, False = username
     * and password not empty
     */
    private boolean isNull() {
        return Username.getText().isEmpty() || Password.getText().isEmpty();
    }



}
