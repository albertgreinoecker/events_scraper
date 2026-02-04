module at.osbeyond.events_scraper {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.jsoup;
    requires org.controlsfx.controls;

    opens at.osbeyond.events_scraper to javafx.fxml;
    exports at.osbeyond.events_scraper;
}