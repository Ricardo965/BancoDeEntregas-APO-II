module com.seg14.seg14 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.seg14.seg14 to javafx.fxml;
    exports com.seg14.seg14;
}