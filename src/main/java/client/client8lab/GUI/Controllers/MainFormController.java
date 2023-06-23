package client.client8lab.GUI.Controllers;

import client.client8lab.ClientApplication;
import client.client8lab.backService.BackendManager;
import client.client8lab.backService.utils.ScriptFilePacker;
import client.client8lab.formUtils.FormsManager;
import client.client8lab.tableHandlers.ProductTableViewHandler;
import common.src.network.MessageType;
import javafx.application.Platform;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import common.src.AvailableLocales;
import resourcebundles.enums.MainFormElements;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import common.src.CurrentLocaleContainer;
import common.src.models.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class MainFormController {
    @FXML
    private Menu infoMenu;

    @FXML
    private Menu settingsMenu;

    private Scene primaryScene;

    @FXML
    private MenuItem languageMenuItem;

    @FXML
    private MenuItem infoMenuItem;
    @FXML
    private TextField fileInputField;

    @FXML
    private MenuItem logOutMenuItem;

    @FXML
    private HBox filtersHBox;

    @FXML
    private TableView tableView;
    @FXML
    private Button showUsersBtn;

    private volatile static ObservableList<Product> modelsCollection = FXCollections.observableArrayList();
    public static BackendManager backendManager;
    public static User currentUser;

    @FXML
    private Button removeFiltersButton;

    @FXML
    private Button executeScriptButton;

    @FXML
    protected Button createFilterButton;

    @FXML
    protected Button addButton;

    @FXML
    protected Button addIfMinButton;

    @FXML
    protected Button updateButton;

    @FXML
    protected Button removeButton;

    @FXML
    protected Button clearButton;
    @FXML
    protected Button helpButton;
    @FXML
    protected Button printUniqueUnitOfMeasureButton;

    @FXML
    protected Label controllersLabel;
    @FXML
    private Menu userMenu;

    @FXML
    private Button visualizeButton;
    @FXML
    private Label outputLabel;

    public static String userName;
    public static String userPassword;

    private final int VISUALIZATION_FORM_WIDTH = 800;

    private final int VISUALIZATION_FORM_HEIGHT = 600;

    private final int FILTER_CREATING_FROM_WIDTH = 400;

    private final int FILTER_CREATING_FORM_HEIGHT = 300;

    private final int ADDITIONAL_FORM_WIDTH = 300;

    private final int ADDITIONAL_FORM_HEIGHT = 200;

    private final int MUSIC_BAND_CREATING_AND_UPDATING_FORM_HEIGHT = 600;

    private final int MUSIC_BAND_CREATING_AND_UPDATING_FORM_WIDTH = 400;

    private final int LANGUAGE_CHANGING_FORM_WIDTH = 300;

    private final int LANGUAGE_CHANGING_FORM_HEIGHT = 200;


    private volatile ProductTableViewHandler tableViewHandler;
    public EntryController entryController;


    private static MainFormController mainFormController;

    @FXML
    public void initialize() {
        backendManager = new BackendManager();
        tableViewHandler = new ProductTableViewHandler(tableView, modelsCollection);

        tableViewHandler.initializeColumns();
        mainFormController = this;

        CurrentLocaleContainer.getCurrentLocale().addListener(change -> updateLocale());
        updateLocale();

        backendManager =  new BackendManager();
        addListenerToIncomingResponses();
        addListeners();

    }


    @FXML
    protected void onFileNameChanged(KeyEvent actionEvent){
        var fileName = fileInputField.getText();
        if(fileName.contains(".txt")){
            fileInputField.setStyle(validatedStyle);
            executeScriptButton.setDisable(false);
        }
        else{
            fileInputField.setStyle(unvalidatedStyle);
            executeScriptButton.setDisable(true);
        }
    }

    public void addListeners(){
        modelsCollection.addListener(new ListChangeListener<Product>() {
            @Override
            public void onChanged(Change<? extends Product> c) {
                if(FormsManager.displayController == null) return;
                Platform.runLater(()-> FormsManager.displayController.updateProductLocation(modelsCollection));
            }
        });
    }

    public void addListenerToIncomingResponses(){
        backendManager.initiateListener((response) -> {

            Platform.runLater(()-> {
                modelsCollection.setAll(response.products == null ? new LinkedList<>() : response.products);
                if (FormsManager.userController != null){
                    UsersFormController.usersModelsCollection.setAll(response.users == null ? new LinkedList<>() : response.users);
                    FormsManager.userController.tableView.setItems(UsersFormController.usersModelsCollection);
                }
                tableView.setItems(modelsCollection);
            });

            if(response.messageType == MessageType.LOGGED){
                Platform.runLater(()-> {
                    try {
                        FormsManager.manageMain(true);
                        if(response.currentUser != null){
                            currentUser = response.currentUser;
                            FormsManager.mainFormController.userMenu.setText(response.currentUser.getName() + " " + response.currentUser.role.toString());
                            handeRoleChange(currentUser.role);
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
                backendManager.requestData(userName, userPassword);
                return;
            }
            if(response.messageType == MessageType.ASSIGN_ROLE){
                currentUser = response.currentUser;
                handeRoleChange(currentUser.role);
            }
            if(response.messageType == MessageType.LOGGING_FAILED) {
                Platform.runLater(()-> FormsManager.entryController.loginLabel.setText("login failed"));
            }

        });
    }

    private void updateLocale() {
        tableViewHandler.initializeColumns();
        removeFiltersButton.setText(MainFormElements.REMOVE_FILTERS_BUTTON.toString());
        createFilterButton.setText(MainFormElements.CREATE_FILTER_BUTTON.toString());
        addButton.setText(MainFormElements.ADD_BUTTON.toString());
        updateButton.setText(MainFormElements.UPDATE_BUTTON.toString());
        removeButton.setText(MainFormElements.REMOVE_BUTTON.toString());
        controllersLabel.setText(MainFormElements.CONTROLLERS_LABEL.toString());
        infoMenu.setText(MainFormElements.INFO_MENU.toString());
        settingsMenu.setText(MainFormElements.SETTINGS_MENU.toString());
        logOutMenuItem.setText(MainFormElements.LOG_OUT_MENU_ITEM.toString());
        languageMenuItem.setText(MainFormElements.LANGUAGE_MENU_ITEM.toString());
        clearButton.setText(MainFormElements.CLEAR_BUTTON.toString());
        showUsersBtn.setText(MainFormElements.SHOW_USERS_BUTTON.toString());
        executeScriptButton.setText(MainFormElements.EXECUTE_SCRIPT_BUTTON.toString());
        visualizeButton.setText(MainFormElements.VISUALIZE_BUTTON.toString());
        infoMenuItem.setText(MainFormElements.INFO_MENU.toString());
        helpButton.setText(MainFormElements.HELP.toString());

        if(FormsManager.userController == null) return;
        FormsManager.userController.updateLocale();
    }

    @FXML
    protected void onShowUsersButtonPressed(ActionEvent actionEvent){
        Button button = (Button) actionEvent.getSource();
        try {
            button.setDisable(true);
            backendManager.requestData(userName, userPassword);
            FormsManager.manageUsers(true);
        } catch (IOException exception) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.show();
        } finally {
            button.setDisable(false);
        }
    }

    @FXML
    protected void onAddButtonPressed(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getSource();
        try {
            button.setDisable(true);
            ProductCreatingAndUpdatingFormController productCreatingAndUpdatingFormController = initCreatingForm(null);
            Product product = productCreatingAndUpdatingFormController.product;
            if (product == null) return;
            backendManager.addProduct(product, userName, userPassword);

        } catch (IOException exception) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.show();
        } finally {
            button.setDisable(false);
        }
    }

    @FXML
    protected void onClearButtonPressed(ActionEvent actionEvent) {
        backendManager.clearAll(userName, userPassword);
    }

    @FXML
    protected void onFilterCreatingButtonPressed(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(ClientApplication.class.getResource("FilterCreatorForm.fxml"));
            Parent node = fxmlLoader.load();
            FilterCreatorFormController filterCreatorFormController = fxmlLoader.getController();
            Scene scene = new Scene(node, FILTER_CREATING_FROM_WIDTH, FILTER_CREATING_FORM_HEIGHT);
            Stage stage = new Stage();
            stage.setResizable(false);
            filterCreatorFormController.setCurrentStage(stage);
            stage.setScene(scene);
            stage.show();
        } catch (IOException exception) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.show();
        }
    }

    @FXML
    protected void onFilterRemovingButtonPressed(ActionEvent actionEvent) {
        filtersHBox.getChildren().clear();
    }

    @FXML
    protected void onRemoveButtonPressed(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getSource();
        try {
            Product product = (Product) tableView.getSelectionModel().getSelectedItem();
            if (product != null) {
                backendManager.delete(product, userName, userPassword);
            }
        }
        catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.show();
        }
    }

    @FXML
    protected void onExecuteScriptButtonPressed(ActionEvent actionEvent) {
        var fileName = fileInputField.getText();
        var filePacker = new ScriptFilePacker();
        filePacker.pack(fileName);
        backendManager.executeScript(filePacker.getPackedScripts(), userName, userPassword);
    }

    @FXML
    protected void onVisualizationButtonPressed(ActionEvent actionEvent) throws IOException {
        Button button = (Button) actionEvent.getSource();
        FormsManager.manageDisplay(true);
    }

    @FXML
    protected void onLogOutPressed(ActionEvent actionEvent) throws IOException {
        FormsManager.manageEntry(true);
        FormsManager.hideDisplay();
        FormsManager.hideUsers();
    }

    @FXML
    protected void onUpdateButtonPressed(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getSource();
        try {
            Product product = (Product) tableView.getSelectionModel().getSelectedItem();
            if (product != null) {
                try {
                    ProductCreatingAndUpdatingFormController productCreatingAndUpdatingFormController = initCreatingForm(product);
                    var updatedProduct = productCreatingAndUpdatingFormController.product;
                    if (updatedProduct == null) return;
                    var found = modelsCollection.stream().filter(p-> p.getId().equals(product.getId())).findFirst();
                    if(found.isEmpty())
                        return;
                    backendManager.update(updatedProduct, userName, userPassword);

                } catch (IOException exception) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.show();
                }
            } else {

            }
        } finally {
            button.setDisable(false);
        }
    }

    @FXML
    protected void onLanguageMenuItemPressed(ActionEvent actionEvent) {
        try {
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

    @FXML
    protected void onInfoMenuItemPressed(ActionEvent actionEvent) {

    }

    @FXML
    protected void onPrintUniquePressed(ActionEvent actionEvent) {
        List<UnitOfMeasure> uniqueUnits = modelsCollection.stream().map(Product::getUnitOfMeasure).distinct().toList();
        var strB = new StringBuilder();
        for (var unit: uniqueUnits
             ) {
            strB.append(unit).append(" ");
        }
        outputLabel.setText(strB.toString());
    }

    private ProductCreatingAndUpdatingFormController initCreatingForm(Product toBeLoadedToForm) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ClientApplication.class.getResource("ProductCreatingForm.fxml"));
        Parent node = fxmlLoader.load();
        Scene scene = new Scene(node, MUSIC_BAND_CREATING_AND_UPDATING_FORM_WIDTH, MUSIC_BAND_CREATING_AND_UPDATING_FORM_HEIGHT);
        Stage stage = new Stage();
        ProductCreatingAndUpdatingFormController productCreatingAndUpdatingFormController = fxmlLoader.getController();
        productCreatingAndUpdatingFormController.loadProduct(toBeLoadedToForm);
        productCreatingAndUpdatingFormController.setCurrentStage(stage);
        stage.setScene(scene);
        stage.showAndWait();
        return productCreatingAndUpdatingFormController;
    }


    public static MainFormController getMainFormController() {
        return mainFormController;
    }

    public static void updateCollectionList(ArrayList<Product> newList) {
        modelsCollection.clear();
        modelsCollection.addAll(newList);

    }

    public HBox getFiltersHBox() {
        return filtersHBox;
    }

    public TableView getTableView() {
        return tableView;
    }

    public Button getRemoveFiltersButton() {
        return removeFiltersButton;
    }

    public ProductTableViewHandler getTableViewHandler() {
        return tableViewHandler;
    }

    public Menu getUserMenu() {
        return userMenu;
    }



    public static void setCurrentLocale(AvailableLocales availableLocales) {
        getCurrentLocale().set(availableLocales);
    }

    public ObservableList<Product> getModelsCollection() {
        return modelsCollection;
    }

    public void setPrimaryScene(Scene scene){
        this.primaryScene = scene;
    }

    public Scene getPrimaryScene(){
        return primaryScene;
    }

    public static SimpleObjectProperty<AvailableLocales> getCurrentLocale() {
        return CurrentLocaleContainer.getCurrentLocale();
    }


    private void handeRoleChange(Role role){
        switch (role) {
            case ADMIN -> {
                addButton.setVisible(true);
                updateButton.setVisible(true);
                showUsersBtn.setVisible(true);
                helpButton.setVisible(true);
                removeButton.setVisible(true);
                clearButton.setVisible(true);
                executeScriptButton.setVisible(true);
                fileInputField.setVisible(true);
            }
            case MIDDLE_USER -> {
                addButton.setVisible(true);
                updateButton.setVisible(true);
                showUsersBtn.setVisible(false);
                helpButton.setVisible(true);
                removeButton.setVisible(false);
                clearButton.setVisible(false);
                executeScriptButton.setVisible(false);
                fileInputField.setVisible(false);
            }
            case MIN_USER -> {
                addButton.setVisible(false);
                updateButton.setVisible(false);
                showUsersBtn.setVisible(false);
                helpButton.setVisible(true);
                removeButton.setVisible(false);
                clearButton.setVisible(false);
                executeScriptButton.setVisible(false);
                fileInputField.setVisible(false);
            }
        }

    }
    final String validatedStyle = """
                -fx-border-radius: 100;
                -fx-background-radius: 100;
                -fx-border-color: null
                """;
    final String unvalidatedStyle = """
                -fx-border-radius: 100;
                -fx-background-radius: 100;
                -fx-border-color: red
                """;

}