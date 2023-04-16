import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class CountryList {
    private ArrayList<Country> listOfCountries;
    static String folder = "data";
    static String path = "data/data.txt";


    public CountryList() {
        this.listOfCountries = new ArrayList<Country>();
    }

    public ArrayList<Country> getListOfCountries() {
        return listOfCountries;
    }

    public void setListOfCountries(ArrayList<Country> listOfCountries) {
        this.listOfCountries = listOfCountries;
    }

    public boolean addCountry(String[] arr) {

        int flag = -1;
        
        for (int i = 0; i < listOfCountries.size(); i++) {
            if (arr[0].equalsIgnoreCase(listOfCountries.get(i).getName())) {
                flag = i;
                break;
            }
            
        }

        if (flag != -1) {
            switch (arr[1].toLowerCase()) {
                case "oro":
                    listOfCountries.get(flag).addGoldMedals(Integer.valueOf(arr[2]));
                    break;
                case "plata":
                    listOfCountries.get(flag).addSilverMedals(Integer.valueOf(arr[2]));
                    break;
                case "bronce":
                    listOfCountries.get(flag).addBronzeMedals(Integer.valueOf(arr[2]));
                    break;
                default:
                    return  false;
            }

        } else {
            Country temp = new Country();
            temp.setName(arr[0]);
            switch (arr[1].toLowerCase()) {
                case "oro":
                    temp.setGoldMedals(Integer.valueOf(arr[2]));
                    break;
                case "plata":
                    temp.setSilverMedals(Integer.valueOf(arr[2]));
                    break;
                case "bronce":
                    temp.setBronzeMedals(Integer.valueOf(arr[2]));
                    break;
                default:
                    return  false;
            }
            listOfCountries.add(temp);

        }

        return true;
    }

    public String conventionalOrder() {
        Collections.sort(listOfCountries);
        String txt = "";
        txt += String.format("| %-20s | %-20s | %-20s | %-20s | %-20s |%n", "Pais", "Medallas de Oro", "Medallas de Plata", "Medallas de Bronce", "Total medallas");
        for (Country c : listOfCountries) {
            txt += String.format("| %-20s | %-20d | %-20d | %-20d | %-20d |%n", c.getName(), c.getGoldMedals(), c.getSilverMedals(), c.getBronzeMedals(), (c.getGoldMedals() + c.getSilverMedals() + c.getBronzeMedals()));
        }
        return txt;
    }

    public String totalMedalsOrder() {
        Collections.sort(listOfCountries, (a, b) -> {
            int aTotal = a.getGoldMedals() + a.getSilverMedals() + a.getBronzeMedals();
            int bTotal = b.getGoldMedals() + b.getSilverMedals() + b.getBronzeMedals();
            int criteria1 = aTotal - bTotal;
            if(criteria1 == 0){

                return a.getName().compareTo(b.getName());

            } else return criteria1*-1;

        });
        String txt = "";
        txt += String.format("| %-20s | %-20s | %-20s | %-20s | %-20s |%n", "Pais", "Total medallas", "Medallas de Oro", "Medallas de Plata", "Medallas de Bronce");
        for (Country c : listOfCountries) {
            txt += String.format("| %-20s | %-20d | %-20d | %-20d | %-20d |%n", c.getName(), (c.getGoldMedals() + c.getSilverMedals() + c.getBronzeMedals()), c.getGoldMedals(), c.getSilverMedals(), c.getBronzeMedals());
        }
        return txt;
    }

    public String alfabeticalOrder() {
        insertionSort();
        String txt = "";
        txt += String.format("| %-20s | %-20s | %-20s | %-20s | %-20s |%n", "Pais", "Medallas de Oro", "Medallas de Plata", "Medallas de Bronce", "Total medallas");
        for (Country c : listOfCountries) {
            txt += String.format("| %-20s | %-20d | %-20d | %-20d | %-20d |%n", c.getName(), c.getGoldMedals(), c.getSilverMedals(), c.getBronzeMedals(), (c.getGoldMedals() + c.getSilverMedals() + c.getBronzeMedals()));
        }
        return txt;
    }
    
    public void insertionSort() { 
        
        for (int rojo = 1; rojo < listOfCountries.size(); rojo++){
            for (int verde = 0; verde < rojo; verde++) {
                if (listOfCountries.get(rojo).getName().compareToIgnoreCase(listOfCountries.get(verde).getName()) < 0) {
                    listOfCountries.add(verde, listOfCountries.remove(rojo));
                    break;
                }
            }
        }
    }

    public void save() throws IOException {
        File file = new File(path);
        FileOutputStream fos = new FileOutputStream(file);
        String data = "";
        for (int i = 0; i < listOfCountries.size(); i++) {
            data += listOfCountries.get(i).getName() + "::" + listOfCountries.get(i).getGoldMedals() + "::" + listOfCountries.get(i).getSilverMedals() + "::" + listOfCountries.get(i).getBronzeMedals() + "\n";
        }
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));
        writer.write(data);
        writer.flush();
        fos.close();
    }


    public void load() throws IOException {
        File file = new File(path);
        if (file.exists()) {
            FileInputStream fis = new FileInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
            String line = "";
            while ((line = reader.readLine()) != null) {
                String[] arr = line.split("::");
                listOfCountries.add(new Country(arr[0], Integer.parseInt(arr[1]), Integer.parseInt(arr[2]), Integer.parseInt(arr[3])));
            }
            reader.close();
        }else{
            File f = new File(folder);
            if(!f.exists()){
                f.mkdirs();
            }
            file.createNewFile();
        }
        
    }
}
