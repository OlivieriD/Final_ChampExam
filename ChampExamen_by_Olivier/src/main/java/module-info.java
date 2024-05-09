module com.champqcsoft.champexamen_by_olivier {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.champqcsoft.champexamen_by_olivier to javafx.fxml;
    exports com.champqcsoft.champexamen_by_olivier;
}