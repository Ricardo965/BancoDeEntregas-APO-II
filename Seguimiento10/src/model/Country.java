public class Country implements Comparable<Country>{
    private String name;
    private int goldMedals;
    private int silverMedals;
    private int bronzeMedals;

    public Country() {
        this.name = "";
        this.goldMedals = 0;
        this.silverMedals = 0;
        this.bronzeMedals = 0;
    }

    
    public Country(String name, int goldMedals, int silverMedals, int bronzeMedals) {
        this.name = name;
        this.goldMedals = goldMedals;
        this.silverMedals = silverMedals;
        this.bronzeMedals = bronzeMedals;
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getGoldMedals() {
        return goldMedals;
    }
    public void setGoldMedals(int goldMedals) {
        this.goldMedals = goldMedals;
    }
    public int getSilverMedals() {
        return silverMedals;
    }
    public void setSilverMedals(int silverMedals) {
        this.silverMedals = silverMedals;
    }
    public int getBronzeMedals() {
        return bronzeMedals;
    }
    public void setBronzeMedals(int bronzeMedals) {
        this.bronzeMedals = bronzeMedals;
    }
    public void addGoldMedals(int goldMedals) {
        this.goldMedals += goldMedals;
    }
    public void addSilverMedals(int silverMedals) {
        this.silverMedals += silverMedals;
    }
    public void addBronzeMedals(int bronzeMedals) {
        this.bronzeMedals += bronzeMedals;
    }


    @Override
    public int compareTo(Country o) {
        int criteria1 = (this.goldMedals)-(o.goldMedals);
        if(criteria1 == 0){
            int criteria2 = (this.silverMedals)-(o.silverMedals);
            if (criteria2 == 0) {
                int criteria3 = (this.bronzeMedals)-(o.bronzeMedals);
                if (criteria3 == 0) {
                    return (this.name).compareTo(o.name);
                } else {
                    return criteria3*-1;
                }
            } else {
                return criteria2*-1;
            }
        }else{
            return criteria1*-1;
        }
    }
}
