import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField x;

    @FXML
    private TextField y;

    @FXML
    private ScatterChart<?, ?> diagramm;
    
    @FXML
    private NumberAxis xAxis;
    
    @FXML
    private NumberAxis yAxis;
    
    XYChart.Series datenreihe;

    @FXML
    void hinzufuegen(ActionEvent event) {
        // Liest einen x und einen y-Wert aus
        int xWert = Integer.parseInt(x.getText());
        int yWert = Integer.parseInt(y.getText());
        // diagramm.getData().get(0) liefert die erste Datenreihe
        // mit getData() erhält man die Daten dieser Datenreihe
        // mit add() kann man dann den neuen Datenpunkt einfügen
        diagramm.getData().get(0).getData().add(new XYChart.Data(xWert,yWert));
        System.out.println("Eingefuegt");

    }
    
    void diagrammEinrichten()
    {
        // Erstellt eine neue Datenreihe
       datenreihe = new XYChart.Series();
       // Fügt einzelne Werte dieser Datenreihe hinzu
       datenreihe.getData().add(new XYChart.Data(1,2));
       datenreihe.getData().add(new XYChart.Data(2,3));
       datenreihe.getData().add(new XYChart.Data(3,1));
       // Fügt die Datenreihe in das Diagramm ein
       diagramm.getData().add(datenreihe);
    }

    @FXML
    void initialize() {
        assert x != null : "fx:id=\"x\" was not injected: check your FXML file 'view.fxml'.";
        assert y != null : "fx:id=\"y\" was not injected: check your FXML file 'view.fxml'.";
        assert diagramm != null : "fx:id=\"diagramm\" was not injected: check your FXML file 'view.fxml'.";
        diagrammEinrichten();
        
    }
}
