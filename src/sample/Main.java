package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;


public class Main extends Application {

    Button button;
    ListView<String> listView;
    String wybranyKraj, wybranySezon;
    Label label;

    @Override
    public void start(Stage primaryStage) throws IOException{
        primaryStage.setTitle("Tabele ligowe");

        listView = new ListView<>();
        listView.getItems().addAll("Anglia", "Francja", "Niemcy", "Hiszpania", "Polska", "Włochy");
        listView.setMaxWidth(100);

        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        choiceBox.getItems().addAll("2017-2018", "2016-2017", "2015-2016", "2014-2015");
        choiceBox.setValue("2017-2018");

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Informacja");
        alert.setHeaderText(null);
        alert.setContentText("Wybierz kraj");

        label = new Label();
        Button wybierz = new Button("Wybierz");
        wybierz.setOnAction(e -> {
            wybranyKraj = listView.getSelectionModel().getSelectedItem();
            wybranySezon = choiceBox.getValue();
            try {
                //generuj(wybranyKraj);
                Generuj generuj = new Generuj();
                while (wybranyKraj == null) {
                    alert.showAndWait();
                    break;
                }
                String url = generuj.wybranyKraj(wybranyKraj, wybranySezon);
                String tabela = generuj.generuj(url);
                label.setText(tabela);

            }
            catch (IOException er){
                System.out.println(false);
            }
        });

        BorderPane borderPane = new BorderPane();
        borderPane.setLeft(listView);
        borderPane.setCenter(label);

        HBox bottom = new HBox();
        bottom.getChildren().addAll(wybierz, choiceBox);
        borderPane.setBottom(bottom);


        StackPane layout = new StackPane();
        layout.getChildren().addAll(borderPane);

        Scene scene = new Scene(layout, 700, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args)  {
        launch(args);
    }

}
