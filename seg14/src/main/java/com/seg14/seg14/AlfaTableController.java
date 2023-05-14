package com.seg14.seg14;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class AlfaTableController implements Initializable {

    @FXML
    private TableColumn<?, ?> amountColumn;

    @FXML
    private TableColumn<?, ?> dateColumn;

    @FXML
    private TableColumn<?, ?> descriptionColumn;

    @FXML
    private RadioButton expendRB;

    @FXML
    private RadioButton generalBalanceRB;

    @FXML
    private RadioButton incomeRB;

    @FXML
    private TableView<?> registryTableTB;

    @FXML
    private Label totalLabel;

    @FXML
    void filterExpends(ActionEvent event) {

    }

    @FXML
    void filterGeneralBalance(ActionEvent event) {

    }

    @FXML
    void filterIncome(ActionEvent event) {

    }

    @FXML
    void regAmount(ActionEvent event) {
        com.seg14.seg14.HelloApplication.openWindow("hello-view.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ToggleGroup tgl = new ToggleGroup();
        incomeRB.setToggleGroup(tgl);
        generalBalanceRB.setToggleGroup(tgl);
        expendRB.setToggleGroup(tgl);
    }
}
