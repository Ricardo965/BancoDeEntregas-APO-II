package com.seg14.seg14;

import com.seg14.seg14.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Date;
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
    void saveReg(ActionEvent event) throws ParseException {
        Registrable temp = null;

        /*int day = datePickerDP.getValue().getDayOfMonth();
        int month = datePickerDP.getValue().getMonthValue();
        int year = datePickerDP.getValue().getYear();

        String dt = day + "/" + month + "/" + year;
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dt);*/
        Date date =  Date.from(datePickerDP.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());

        if (typeCB.getValue() != null){
            if (Double.valueOf(amountTF.getText()) < 0) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("No ingrese numeros negativos");
                alert.showAndWait();
            } else {
                if (typeCB.getValue().equals("Ingreso")) {
                    temp = new Income(Double.valueOf(amountTF.getText()), descriptionTF.getText(), date);
                } else {
                    temp = new Expense(Double.valueOf(amountTF.getText()), descriptionTF.getText(), date);
                }
                RegisterList.getInstance().getListOfRegisters().add(temp);
                closeWindow(event);
                HelloApplication.openWindow("alfaTable.fxml");
            }

        } else  {
            //throw new RuntimeException("Seleccione un tipo de registro");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Seleccione un tipo de registro");
            alert.showAndWait();
        }


    }

    @FXML
    private void closeWindow(ActionEvent event) {

        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();


    }

}