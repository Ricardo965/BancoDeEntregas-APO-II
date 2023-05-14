package com.seg14.seg14;

import com.seg14.seg14.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class AlfaTableController implements Initializable {

    @FXML
    private TableColumn<Register, Double> amountColumn;

    @FXML
    private TableColumn<Register, Date> dateColumn;

    @FXML
    private TableColumn<Register, String> descriptionColumn;

    @FXML
    private RadioButton expendRB;

    @FXML
    private RadioButton generalBalanceRB;

    @FXML
    private RadioButton incomeRB;

    @FXML
    private TableView<Registrable> registryTableTB;

    @FXML
    private Label totalLabel;

    @FXML
    private Label balanceLabel;

    @FXML
    void filterExpends(ActionEvent event) {
        RegisterList.getInstance().getListOfRegisters().sort(((o1, o2) -> ((Register)o2).getRegDate().compareTo(((Register)o1).getRegDate())));

        amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("regDate"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));

        registryTableTB.setItems(RegisterList.getInstance().expenseFilter());

        totalLabel.setText("Total gastos: " + calculateTotalExpense());
        totalLabel.autosize();
        updateColor();
    }

    @FXML
    void filterGeneralBalance(ActionEvent event) {
        RegisterList.getInstance().getListOfRegisters().sort(((o1, o2) -> ((Register)o2).getRegDate().compareTo(((Register)o1).getRegDate())));

        amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("regDate"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        generalBalanceRB.fire();
        registryTableTB.setItems(RegisterList.getInstance().getListOfRegisters());
        totalLabel.setText("");
        updateColor();
    }

    @FXML
    void filterIncome(ActionEvent event) {

        RegisterList.getInstance().getListOfRegisters().sort(((o1, o2) -> ((Register)o2).getRegDate().compareTo(((Register)o1).getRegDate())));

        amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("regDate"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));

        registryTableTB.setItems(RegisterList.getInstance().incomeFilter());

        totalLabel.setText("Total ingresos: " + calculateTotalIncome());
        totalLabel.autosize();
        updateColor();

    }

    @FXML
    void regAmount(ActionEvent event) {
        closeWindow(event);
        HelloApplication.openWindow("hello-view.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ToggleGroup tgl = new ToggleGroup();
        incomeRB.setToggleGroup(tgl);
        generalBalanceRB.setToggleGroup(tgl);
        generalBalanceRB.fire();
        expendRB.setToggleGroup(tgl);


        RegisterList.getInstance().getListOfRegisters().sort(((o1, o2) -> ((Register)o2).getRegDate().compareTo(((Register)o1).getRegDate())));

        amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("regDate"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));

        registryTableTB.setItems(RegisterList.getInstance().getListOfRegisters());

        updateColor();

        balanceLabel.setText("Balance: " + String.valueOf(calculateTotalIncome() - calculateTotalExpense()));
        balanceLabel.autosize();
        totalLabel.setText("");

    }

    private void updateColor(){
        registryTableTB.setRowFactory(tv -> new javafx.scene.control.TableRow<Registrable>() {
            protected void updateItem(Registrable item, boolean empty) {
                super.updateItem(item, empty);
                if (item == null) {
                    setStyle("");
                } else if (item instanceof Income) {
                    setStyle("-fx-background-color: #9AAB64FF;");
                } else {
                    setStyle("-fx-background-color: #F3B98CFF;");
                }
            }
        });
    }

    public double calculateTotalIncome(){
        double total = 0;
        for (int i = 0; i < RegisterList.getInstance().incomeFilter().size(); i++) {
            total += ((Income)RegisterList.getInstance().incomeFilter().get(i)).getAmount();
        }
        return total;
    }

    public double calculateTotalExpense(){
        double total = 0;
        for (int i = 0; i < RegisterList.getInstance().expenseFilter().size(); i++) {
            total += ((Expense)RegisterList.getInstance().expenseFilter().get(i)).getAmount();
        }
        return total;
    }

    @FXML
    private void closeWindow(ActionEvent event) {

        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();


    }
}
