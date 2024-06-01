package controllers;

import javafx.fxml.FXML;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import org.studdybuddy.App;

import java.io.IOException;
import java.net.URL;

public class Home {

    @FXML
    private WebView webViewHome;

    public void initialize() {
        WebEngine webEngine = webViewHome.getEngine();
//        webEngine.load("https://kbrdrive.web.app");

        URL url = getClass().getResource("/org/studdybuddy/home.html");
        if (url != null) {
            webEngine.load(url.toExternalForm());
        } else {
            System.out.println("Couldn't find the HTML file.");
        }
    }

    @FXML
    void goToCgpaPage() throws IOException {
        App.loadPage("cgpaCalculator", "CGPA Calculator", true);
    }

    @FXML
    void goToSearchPage() throws IOException {
        App.loadPage("courseQuery", "CGPA Calculator", true);
    }




}