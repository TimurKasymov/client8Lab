package client.client8lab.tableHandlers;

import client.client8lab.GUI.Controllers.MainFormController;
import javafx.beans.property.*;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import common.src.models.OrganizationType;
import common.src.models.Product;
import common.src.models.UnitOfMeasure;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public class ProductTableColumnsInitializer {
    private TableView tableView;

    public ProductTableColumnsInitializer(TableView tableView){
        this.tableView = tableView;
    }

    public void initializeColumns() {
        TableColumn<Product, Long> productIdColumn = new FixedProductNameTableColumn<>(ProductColumnNames.PRODUCT_ID);
        productIdColumn.setCellValueFactory(cellValue -> new SimpleObjectProperty<>(cellValue.getValue().getId()));

        TableColumn<Product, String> nameColumn = new FixedProductNameTableColumn<>(ProductColumnNames.NAME);
        nameColumn.setCellValueFactory(cellValue -> new SimpleObjectProperty<>(cellValue.getValue().getName()));

        TableColumn<Product, String> creationDateColumn = new FixedProductNameTableColumn<>(ProductColumnNames.CREATION_DATE);
        creationDateColumn.setCellValueFactory(cellValue -> new SimpleObjectProperty<>(cellValue.getValue().getCreationDate().withZoneSameInstant(MainFormController.getCurrentLocale().get().getZoneID()).format(MainFormController.getCurrentLocale().get().getDateTimeFormatter())));
        TableColumn<Product, Float> priceColumn = new FixedProductNameTableColumn<>(ProductColumnNames.PRICE);
        priceColumn.setCellValueFactory(cellValue -> new SimpleObjectProperty<>(cellValue.getValue().getPrice()));

        TableColumn<Product, Double> manufactureCostColumn = new FixedProductNameTableColumn<>(ProductColumnNames.MANUFACTURE_COST);
        manufactureCostColumn.setCellValueFactory(cellValue -> new SimpleObjectProperty<>(cellValue.getValue().getManufactureCost()));

        TableColumn<Product, UnitOfMeasure> unitofmeasureCostColumn = new FixedProductNameTableColumn<>(ProductColumnNames.UNIT_OF_MEASURE);
        unitofmeasureCostColumn.setCellValueFactory(cellValue -> new SimpleObjectProperty<>(cellValue.getValue().getUnitOfMeasure()));

        TableColumn<Product, Integer> coordinatesIdColumn = new FixedProductNameTableColumn<>(ProductColumnNames.COORDINATES_ID);
        coordinatesIdColumn.setCellValueFactory(cellValue -> new SimpleObjectProperty<>(cellValue.getValue().getCoordinates().getId()));

        TableColumn<Product, Double> coordinatesXColumn = new FixedProductNameTableColumn<>(ProductColumnNames.X_COORDINATE);
        coordinatesXColumn.setCellValueFactory(cellValue -> new SimpleObjectProperty<>(cellValue.getValue().getCoordinates().getX()));

        TableColumn<Product, Float> coordinatesYColumn = new FixedProductNameTableColumn<>(ProductColumnNames.Y_COORDINATE);
        coordinatesYColumn.setCellValueFactory(cellValue -> new SimpleObjectProperty<>(cellValue.getValue().getCoordinates().getY()));

        TableColumn<Product, Long> organizationIDColumn = new FixedProductNameTableColumn<>(ProductColumnNames.ORGANIZATION_ID);
        organizationIDColumn.setCellValueFactory(cellValue -> new SimpleObjectProperty<>(cellValue.getValue().getManufacturer().getId()));

        TableColumn<Product, String> organizationNameColumn = new FixedProductNameTableColumn<>(ProductColumnNames.ORGANIZATION_NAME);
        organizationNameColumn.setCellValueFactory(cellValue -> new SimpleObjectProperty<>(cellValue.getValue().getManufacturer().getName()));

        TableColumn<Product, Integer> organizationAnTurnOverColumn = new FixedProductNameTableColumn<>(ProductColumnNames.ORGANIZATION_ANNUAL_TURN_OVER);
        organizationAnTurnOverColumn.setCellValueFactory(cellValue -> new SimpleObjectProperty<>(cellValue.getValue().getManufacturer().getAnnualTurnover()));

        TableColumn<Product, OrganizationType> organizationTypeColumn = new FixedProductNameTableColumn<>(ProductColumnNames.ORGANIZATION_TYPE);
        organizationTypeColumn.setCellValueFactory(cellValue -> new SimpleObjectProperty<>(cellValue.getValue().getManufacturer().getOrganizationType()));

        TableColumn<Product, String> userNameOverColumn = new FixedProductNameTableColumn<>(ProductColumnNames.USER_NAME);
        userNameOverColumn.setCellValueFactory(cellValue -> new SimpleObjectProperty<>(cellValue.getValue().getUser().getName()));

        TableColumn<Product, Integer> userIdTypeColumn = new FixedProductNameTableColumn<>(ProductColumnNames.USER_ID);
        userIdTypeColumn.setCellValueFactory(cellValue -> new SimpleObjectProperty<>(cellValue.getValue().getUser().getId()));

        tableView.getColumns().setAll(productIdColumn, nameColumn, creationDateColumn, priceColumn, manufactureCostColumn, unitofmeasureCostColumn,
                coordinatesIdColumn, coordinatesXColumn, coordinatesYColumn, organizationIDColumn, organizationNameColumn, organizationAnTurnOverColumn, organizationTypeColumn);
    }

}
