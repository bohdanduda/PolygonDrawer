package GUI;

import Manager.PolygonManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

public class HomePageController {

    @FXML
    private Button btn_Clear;

    @FXML
    private Button btn_Draw;

    @FXML
    private Button btn_Export;

    @FXML
    private Pane pane_Polygon;

    @FXML
    private TextField txtField_URL;

    @FXML
    private Label lbl_Perimeter;

    private PolygonManager manager = new PolygonManager();
    private Scanner scanner = new Scanner(System.in);
    private URL url;

    @FXML
    void btn_Draw_Clicked(ActionEvent event) {
        if (!this.validateURL(this.txtField_URL.getText())) {
            this.txtField_URL.clear();
            return;
        }

        try {
            this.manager.getLines(getURLContent(getURL()));
            this.manager.transformPolygon();
            this.drawPolygon();
            setPerimeterValue();
        } catch (IOException | IllegalArgumentException e) {
            showErrorAlert("Error while loading polygon from url. Error message:" + e.getMessage());
            this.txtField_URL.clear();
        }
    }

    @FXML
    void btn_Clear_Pressed(ActionEvent event) {
        this.txtField_URL.clear();
        this.pane_Polygon.getChildren().clear();
        this.lbl_Perimeter.setText("NaN");
    }

    @FXML
    void btn_Export_Clicked(ActionEvent event) {
        this.manager.drawPolygonPicture();
        showInformationAlert("Polygon picture has been successfully drawn, you can find it in output project directory.");
    }

    private boolean validateURL(String textURL) {
        try {
            this.url = new URL(textURL);
            if (this.url.openStream() != null) {
                return true;
            }
        } catch (MalformedURLException e) {
            showErrorAlert("Specified url is invalid. Error message: " + e.getMessage());
        } catch (IOException e) {
            showErrorAlert("Cannot open specified URL. Error message: " + e.getMessage());
        }
        return false;
    }

    private URL getURL() {
        String urlText = this.txtField_URL.getText();
        try {
            return new URL(urlText);
        } catch (MalformedURLException e) {
            showErrorAlert("Specified url is invalid. " + e.getMessage());
            return null;
        }
    }

    private Scanner getURLContent(URL url) throws IOException {
        return new Scanner(this.url.openStream());
    }

    private List<Double> parsePolygonPoints() {
        Model.Polygon polygon = this.manager.getPolygon();

        List<Double> parsedPoints = new ArrayList<>();
        if (polygon != null) {
            for (int i = 0; i < polygon.getPoints().size(); i++) {
                parsedPoints.add((double) polygon.getPoints().get(i).getX());
                parsedPoints.add((double) polygon.getPoints().get(i).getY());
            }
        }

        return parsedPoints;
    }

    private void drawPolygon() {
        List<Double> parsedPoints = parsePolygonPoints();
        Polygon polygon = new Polygon();
        polygon.getPoints().addAll(parsedPoints);

        polygon.setFill(Color.WHITE);
        polygon.setStroke(Color.BLACK);

        this.pane_Polygon.getChildren().add(polygon);
    }

    private void setPerimeterValue() {
        this.lbl_Perimeter.setText(String.valueOf(this.manager.getPerimeter()));
    }

    private void showErrorAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Error occurred");
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void showInformationAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText("Information");
        alert.setContentText(message);
        alert.showAndWait();
    }
}