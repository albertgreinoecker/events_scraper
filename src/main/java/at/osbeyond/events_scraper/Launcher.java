package at.osbeyond.events_scraper;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class Launcher extends Application {

    @Override
    public void start(Stage stage) {


        TextArea textArea = new TextArea();
        textArea.setPromptText("Mehrzeiliger Text hier...");
        textArea.setWrapText(true);              // Zeilenumbruch innerhalb des Feldes
        textArea.setPrefRowCount(10);            // Start-Höhe (optional)

        Button button = new Button("Hole Daten");
        button.setMaxWidth(Double.MAX_VALUE);    // Button über die ganze Breite (optional)
        button.setOnAction(e -> {
            System.out.println("Inhalt:");
            System.out.println(textArea.getText());
            try {
                List<Event> events = new TreibhausScraper().get();
                textArea.setText("");
                for (Event ev : events)
                {
                    textArea.appendText(ev.toString() + "\n");
                }

            } catch (IOException ex) {
                ex.printStackTrace();
            }

        });

        VBox root = new VBox(10, textArea, button);
        root.setPadding(new Insets(12));

        // TextArea soll wachsen, Button bleibt unten
        VBox.setVgrow(textArea, Priority.ALWAYS);

        Scene scene = new Scene(root, 600, 400);
        stage.setTitle("TextArea + Button");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }


}