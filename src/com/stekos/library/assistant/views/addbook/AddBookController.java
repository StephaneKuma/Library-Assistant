/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stekos.library.assistant.views.addbook;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.stekos.library.assistant.controllers.dao.BookDao;
import com.stekos.library.assistant.models.Book;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * FXML Controller class
 *
 * @author Stekos
 */
public class AddBookController implements Initializable {

    @FXML
    private JFXTextField titleTxt;
    @FXML
    private JFXTextField codeTxt;
    @FXML
    private JFXTextField authorTxt;
    @FXML
    private JFXButton saveBtn;
    @FXML
    private JFXButton cancelBtn;
    @FXML
    private JFXTextField editionTxt;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void save(ActionEvent event) {
        if ("".equals(titleTxt.getText()) || "".equals(codeTxt.getText()) || "".equals(authorTxt.getText()) || "".equals(editionTxt.getText())) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Avertissemnt");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez remplir tous les champs !!!");
            alert.showAndWait();
        } else {
            try {
                Book book = new Book(codeTxt.getText(), titleTxt.getText(), authorTxt.getText(), editionTxt.getText());
                BookDao dao = new BookDao();
                dao.add(book);
            } catch (Exception ex) {
                Logger.getLogger(AddBookController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void cancel(ActionEvent event) {
        titleTxt.setText("");
        codeTxt.setText("");
        authorTxt.setText("");
        editionTxt.setText("");
   }
    
}
