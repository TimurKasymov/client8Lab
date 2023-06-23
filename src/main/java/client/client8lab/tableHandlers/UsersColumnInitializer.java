package client.client8lab.tableHandlers;

import common.src.models.Product;
import common.src.models.Role;
import common.src.models.User;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.time.LocalDateTime;

public class UsersColumnInitializer {

    private TableView tableView;

    public UsersColumnInitializer(TableView tableView){
        this.tableView = tableView;
    }

    public void initializeColumns() {
        TableColumn<User, Integer> productIdColumn = new FixedUserNameTableColumn<>(UsersColumnNames.USER_ID);
        productIdColumn.setCellValueFactory(cellValue -> new SimpleObjectProperty<>(cellValue.getValue().getId()));

        TableColumn<User, String> nameColumn = new FixedUserNameTableColumn<>(UsersColumnNames.USER_NAME);
        nameColumn.setCellValueFactory(cellValue -> new SimpleObjectProperty<>(cellValue.getValue().getName()));

        TableColumn<User, Role> creationDateColumn = new FixedUserNameTableColumn<>(UsersColumnNames.USER_ROLE);
        creationDateColumn.setCellValueFactory(cellValue -> new SimpleObjectProperty<>(cellValue.getValue().role));

        tableView.getColumns().setAll(productIdColumn, nameColumn, creationDateColumn);
    }
}
