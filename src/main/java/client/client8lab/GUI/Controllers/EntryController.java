package client.client8lab.GUI.Controllers;

import client.client8lab.ClientApplication;
import client.client8lab.formUtils.FormsManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import resourcebundles.enums.EntryFormElements;
import resourcebundles.enums.MainFormElements;

import java.io.IOException;

public class EntryController {
    @FXML
    public Label loginLabel;
    @FXML
    private TextField nameTF;
    @FXML
    private Label nameLabel;
    @FXML
    private Label passwordLabel;
    @FXML
    private Menu settingsButton;
    @FXML
    private Label titleLabel;
    @FXML
    private TextField passwordTF;
    @FXML
    private Button loginBtn;
    @FXML
    private Button signUpBtn;
    @FXML
    private VBox box;
    private MainFormController mainController;
    private final int LANGUAGE_CHANGING_FORM_WIDTH = 300;

    private final int LANGUAGE_CHANGING_FORM_HEIGHT = 200;

    @FXML
    public void initialize() {
        loginLabel.setText("");
    }

    void updateLocale() {
        titleLabel.setText(EntryFormElements.TITLE_LABEL.toString());
        passwordLabel.setText(EntryFormElements.PASSWORD_LABEL.toString());
        nameLabel.setText(EntryFormElements.NAME_LABEL.toString());
        loginBtn.setText(EntryFormElements.LOGIN_BTN.toString());
        signUpBtn.setText(EntryFormElements.SIGNUP_BTN.toString());
        settingsButton.setText(EntryFormElements.SETTINGS_MENU.toString());
    }

    @FXML
    protected void onLoginButtonPressed(ActionEvent actionEvent) throws IOException {
        mainController = FormsManager.manageMain(false);
        MainFormController.backendManager.login(nameTF.getText(), passwordTF.getText());
        setName();
    }

    @FXML
    protected void onSignUpButtonPressed(ActionEvent actionEvent) throws IOException {
        mainController = FormsManager.manageMain(false);
        MainFormController.backendManager.signup(nameTF.getText(), passwordTF.getText());
        setName();
    }

    private void setName(){
        MainFormController.userName = nameTF.getText();
        MainFormController.userPassword = passwordTF.getText();
        mainController.getUserMenu().setText(nameTF.getText());
    }

    @FXML
    protected void onLanguageMenuItemPressed(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(ClientApplication.class.getResource("LanguageChangingForm.fxml"));
            Parent parent = fxmlLoader.load();
            LanguageChangingFormController languageChangingFormController = fxmlLoader.getController();
            Scene scene = new Scene(parent, LANGUAGE_CHANGING_FORM_WIDTH, LANGUAGE_CHANGING_FORM_HEIGHT);
            Stage stage = new Stage();
            languageChangingFormController.setCurrentStage(stage);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ioException) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.show();
        }
    }
}