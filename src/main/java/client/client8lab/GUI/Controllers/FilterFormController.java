package client.client8lab.GUI.Controllers;

import client.client8lab.formUtils.FormsManager;
import client.client8lab.tableHandlers.ProductColumnNames;
import client.client8lab.tableHandlers.ProductTableViewHandler;
import client.client8lab.tableHandlers.predicatefactory.FilterSigns;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.util.function.Predicate;

public class FilterFormController {
    @FXML
    private GridPane filterFormMainPane;
    @FXML
    private Label columnForFilteringLabel;
    @FXML
    private Label filterSignLabel;
    @FXML
    private Label filteringValueLabel;

    private ProductColumnNames columnForFiltering;

    private Predicate predicate;

    private EventHandler removeButtonPressedEventHandler;

    @FXML
    public void initialize() {
        removeButtonPressedEventHandler = this::removeListeners;
        MainFormController.getMainFormController().getRemoveFiltersButton().addEventHandler(MouseEvent.MOUSE_CLICKED, removeButtonPressedEventHandler);
        MainFormController.getCurrentLocale().addListener(change->updateLocale());
    }

    private void updateLocale(){
        columnForFilteringLabel.setText(columnForFiltering.toString());
    }

    @FXML
    private void onCloseButtonPressed(ActionEvent actionEvent) {
        MainFormController mainFormController = MainFormController.getMainFormController();
        mainFormController.getFiltersHBox().getChildren().remove(filterFormMainPane);
        removeListeners(null);
    }

    private void removeListeners(Event event) {
        MainFormController.getMainFormController().getRemoveFiltersButton().removeEventHandler(MouseEvent.MOUSE_CLICKED, removeButtonPressedEventHandler);
        ProductTableViewHandler.getPredicates().remove(predicate);
        var filtered = FormsManager.mainFormController.getModelsCollection().stream().filter(p-> FormsManager.mainFormController.getTableViewHandler().checkPredicates(p)).toList();
        FormsManager.mainFormController.getModelsCollection().setAll(FormsManager.mainFormController.getTableViewHandler().getSortedList());

    }

    public void setColumnForFilteringLabel(ProductColumnNames value) {
        columnForFiltering = value;
        columnForFilteringLabel.setText(value.toString());
    }

    public void setFilterSignLabel(FilterSigns value) {
        filterSignLabel.setText(value.toString());
    }

    public void setFilteringValueLabel(String value) {
        filteringValueLabel.setText(value);
    }

    public void setPredicate(Predicate predicate) {
        this.predicate = predicate;
    }

}
