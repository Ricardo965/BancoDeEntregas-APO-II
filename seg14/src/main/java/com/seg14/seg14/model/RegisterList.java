import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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

    public ArrayList<Income> incomeFilter(){
        ArrayList<Income> out = new ArrayList<>();
        for (Registrable r : instance.getListOfRegisters()) {
            if (r instanceof Income){
                out.add((Income) r);
            }
        }
        return out;
    }
    public ArrayList<Expense> expenseFilter(){
        ArrayList<Expense> out = new ArrayList<>();
        for (Registrable r : instance.getListOfRegisters()) {
            if (r instanceof Expense){
                out.add((Expense) r);
            }
        }
        return out;
    }
}
