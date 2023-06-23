package client.client8lab.GUI.Controllers;

import client.client8lab.formUtils.FormsManager;
import client.client8lab.tableHandlers.UsersColumnInitializer;
import common.src.AvailableLocales;
import common.src.models.Product;
import common.src.models.Role;
import common.src.models.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import resourcebundles.enums.MainFormElements;

import java.util.Arrays;

public class UsersFormController {
    public volatile static ObservableList<User> usersModelsCollection = FXCollections.observableArrayList();
    @FXML
    public TableView<User> tableView;
    @FXML
    public ComboBox<Role> userRoleComboBox;


    @FXML
    public void initialize() {
        UsersColumnInitializer tableColumnsInitializer = new UsersColumnInitializer(tableView);
        tableColumnsInitializer.initializeColumns();
        tableView.setItems(usersModelsCollection);

        tableView.onMouseClickedProperty().set(new EventHandler<MouseEvent>() {
                                                   @Override
                                                   public void handle(MouseEvent event) {
                                                       var userSelected = tableView.getSelectionModel().getSelectedItem();
                                                       userRoleComboBox.setValue(userSelected.role);
                                                   }
                                               }
        );
        userRoleComboBox.onActionProperty().set(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                var userSelected = tableView.getSelectionModel().getSelectedItem();
                var roleSelected = userRoleComboBox.getValue();
                if(userSelected != null && roleSelected != null)
                    MainFormController.backendManager.changeUserRole(MainFormController.userName, MainFormController.userPassword, userSelected.getId(), roleSelected);
            }
        });
        Arrays.stream(Role.values()).forEach(userRoleComboBox.getItems()::add);
    }

    public void updateLocale() {
        UsersColumnInitializer tableColumnsInitializer = new UsersColumnInitializer(tableView);
        tableColumnsInitializer.initializeColumns();
        tableView.setItems(usersModelsCollection);

        Arrays.stream(Role.values()).forEach(userRoleComboBox.getItems()::add);
    }
}
