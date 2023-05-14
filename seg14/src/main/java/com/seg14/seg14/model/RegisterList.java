package com.seg14.seg14.model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;

import java.util.ArrayList;

public class RegisterList {
    private ObservableList<Registrable> listOfRegisters = FXCollections.observableArrayList();

    private RegisterList(){}

    private static RegisterList instance = null;

    public static RegisterList getInstance(){
        if(instance == null) {
            instance = new RegisterList();
        }
        return instance;
    }

    public ObservableList<Registrable> getListOfRegisters() {
        return listOfRegisters;
    }

    public void setListOfRegisters(ObservableList<Registrable> listOfContacts) {
        this.listOfRegisters = listOfContacts;
    }

    public ObservableList<Registrable> incomeFilter(){
        ObservableList<Registrable> out = FXCollections.observableArrayList();
        for (Registrable r : instance.getListOfRegisters()) {
            if (r instanceof Income){
                out.add(r);
            }
        }
        return out;
    }
    public ObservableList<Registrable> expenseFilter(){
        ObservableList<Registrable> out = FXCollections.observableArrayList();
        for (Registrable r : instance.getListOfRegisters()) {
            if (r instanceof Expense){
                out.add(r);
            }
        }
        return out;
    }
}
