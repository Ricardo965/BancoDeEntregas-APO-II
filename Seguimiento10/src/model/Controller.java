import java.io.IOException;

public class Controller {

    private CountryList listOfCountries = new CountryList();


    public boolean addCountry(String countryToAdd) {
        String[] arr = countryToAdd.split("::");
        return listOfCountries.addCountry(arr);
        
    }

    public String conventionalOrder() {
        return listOfCountries.conventionalOrder();
    }

    public String totalMedalsOrder() {
        return listOfCountries.totalMedalsOrder();
    }

    public String alfabeticalOrder() {
        return listOfCountries.alfabeticalOrder();
    }
    
    
    public void save() {
        try {
            listOfCountries.save();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load() {
        try {
            listOfCountries.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}