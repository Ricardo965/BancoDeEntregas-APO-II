package com.seg14.seg14;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private TextField amountTF;

    @FXML
    private DatePicker datePickerDP;

    @FXML
    private TextField descriptionTF;

    @FXML
    private ComboBox<String> typeCB;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> cbView = FXCollections.observableArrayList();
        cbView.add("Ingreso"); cbView.add("Gasto");
        typeCB.setItems(cbView);
    }

    @FXML
    void saveReg(ActionEvent event) {

    }

    @FXML
    private void closeWindow(ActionEvent event) {

        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();


    }

}