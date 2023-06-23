package client.client8lab.GUI.Controllers;

import client.client8lab.formUtils.FormsManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import common.src.AvailableLocales;

import java.util.Arrays;

public class LanguageChangingFormController {
    @FXML
    private ComboBox<AvailableLocales> languageComboBox;

    private Stage currentStage;

    @FXML
    public void initialize(){
        initLanguages();
    }

    private void initLanguages(){
        Arrays.stream(AvailableLocales.values()).forEach(languageComboBox.getItems()::add);
        languageComboBox.setValue(MainFormController.getCurrentLocale().get());
    }

    @FXML
    protected void onCancelButtonPressed(ActionEvent actionEvent){
        currentStage.close();
    }

    @FXML
    protected void onOkButtonPressed(ActionEvent actionEvent){
        MainFormController.setCurrentLocale(languageComboBox.getValue());
        FormsManager.entryController.updateLocale();
        currentStage.close();
    }

    @FXML
    protected void onButtonMouseEntered(MouseEvent event) {
        Button button = (Button) event.getTarget();
        button.setStyle("""
                -fx-background-color: null;
                -fx-border-width: 2;
                -fx-border-radius: 50;
                -fx-border-color: black
                """);
    }

    @FXML
    protected void onButtonMouseExited(MouseEvent event) {
        Button button = (Button) event.getTarget();
        button.setStyle("""
                -fx-background-color: null;
                -fx-border-width: 1;
                -fx-border-radius: 50;
                -fx-border-color: black
                """);
    }

    public void setCurrentStage(Stage stage){
        this.currentStage = stage;
    }
}
