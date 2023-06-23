package client.client8lab.formUtils;

import client.client8lab.ClientApplication;
import client.client8lab.GUI.Controllers.DisplayController;
import client.client8lab.GUI.Controllers.EntryController;
import client.client8lab.GUI.Controllers.MainFormController;
import client.client8lab.GUI.Controllers.UsersFormController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FormsManager {

    public static MainFormController mainFormController;
    private static Parent mainFormNode;
    private static Scene mainScene;


    public static DisplayController displayController;
    private static Parent displayFormNode;
    private static Scene displayScene;

    public static UsersFormController userController;
    private static Parent userFormNode;
    private static Scene  userScene;

    public static EntryController entryController;
    private static Parent entryFormNode;
    private static Scene entryScene;

    private static Stage displayStage;
    private static Stage entryOrMainStage;
    private static Stage userStage;

    private static final String userFormFileName = "UsersForm.fxml";
    private static final String dataFormFileName = "DataGridForm.fxml";
    private static final String entryFormFileName = "Entry-view.fxml";
    private static final String displayFormFileName = "DisplayForm.fxml";

    private static MainFormController getMainForm() throws IOException {
        if (mainFormController != null) return mainFormController;

        var location = ClientApplication.class.getResource(dataFormFileName);
        FXMLLoader fxmlLoader = new FXMLLoader(location);
        mainFormNode = fxmlLoader.load();
        mainFormController = fxmlLoader.getController();

        return mainFormController;
    }

    private static UsersFormController getUsersForm() throws IOException {
        if (userController != null) return userController;

        var location = ClientApplication.class.getResource(userFormFileName);
        FXMLLoader fxmlLoader = new FXMLLoader(location);
        userFormNode = fxmlLoader.load();
        userController = fxmlLoader.getController();
        return userController;
    }

    private static EntryController getEntryController() throws IOException {
        if (entryController != null) return entryController;

        var location = ClientApplication.class.getResource(entryFormFileName);
        FXMLLoader fxmlLoader = new FXMLLoader(location);
        entryFormNode = fxmlLoader.load();
        entryController = fxmlLoader.getController();
        return entryController;
    }

    private static DisplayController getDisplayController() throws IOException {
        if (displayController != null) return displayController;

        var location = ClientApplication.class.getResource(displayFormFileName);
        FXMLLoader fxmlLoader = new FXMLLoader(location);
        displayFormNode = fxmlLoader.load();
        displayController = fxmlLoader.getController();
        return displayController;
    }

    public static DisplayController manageDisplay(boolean showDisplay) throws IOException {
        getDisplayController();
        if(displayScene != null){
            displayStage.show();
            return displayController;
        }
        displayScene = new Scene(displayFormNode);
        if (displayStage == null) displayStage = new Stage();

        if (showDisplay) {
            displayStage.setScene(displayScene);
            displayStage.setResizable(false);
            displayStage.show();
        }
        return displayController;
    }

    public static UsersFormController manageUsers(boolean show) throws IOException {
        getUsersForm();
        if(userScene != null){
            userStage.show();
            return userController;
        }
        userScene = new Scene(userFormNode);
        if (userStage == null) userStage = new Stage();

        if (show) {
            userStage.setScene(userScene);
            userStage.setResizable(false);
            userStage.show();
        }
        return userController;
    }

    public static MainFormController manageMain(boolean showMain) throws IOException {
        getMainForm();
        if (mainScene == null) mainScene = new Scene(mainFormNode);
        if (entryOrMainStage == null) entryOrMainStage = new Stage();

        if (showMain) {
            entryOrMainStage.setResizable(false);
            entryOrMainStage.setScene(mainScene);
            entryOrMainStage.show();
        }
        return mainFormController;
    }

    public static void hideDisplay(){
        displayStage.hide();
    }

    public static void hideUsers(){
        userStage.hide();
    }

    public static EntryController manageEntry(boolean showEntry) throws IOException {
        getEntryController();
        if (entryScene == null) entryScene = new Scene(entryFormNode, 320, 240);
        if (entryOrMainStage == null) entryOrMainStage = new Stage();

        if (showEntry) {
            entryOrMainStage.setMinWidth(540);
            entryOrMainStage.setMinHeight(500);
            entryOrMainStage.centerOnScreen();
            entryOrMainStage.setResizable(false);
            entryOrMainStage.setScene(entryScene);
            entryOrMainStage.show();
        }
        return entryController;
    }

}