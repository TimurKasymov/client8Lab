package client.client8lab.GUI.Controllers;

import client.client8lab.validators.ProductValidator;
import com.dlsc.formsfx.model.structure.DataField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;
import resourcebundles.enums.ProductCreatingAndUpdatingFormElements;
import common.src.models.*;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class ProductCreatingAndUpdatingFormController {
    @FXML
    private TextField productNameTextField;
    private boolean productNameTextFieldValidated;
    @FXML
    private TextField coordinateXTextField;
    private boolean coordinateXTextFieldValidated;
    @FXML
    private TextField coordinateYTextField;
    private boolean coordinateYTextFieldValidated;
    @FXML
    private TextField priceTextField;
    private boolean priceTextFieldValidated;
    @FXML
    private TextField organizationAnnulTurnoverTextField;
    private boolean organizationAnnulTurnoverTextFieldValidated;

    @FXML
    private TextField manufactureCostTextField;
    private boolean manufactureCostTextFieldValidated;

    @FXML
    private ComboBox<UnitOfMeasure> unitOfMeasureComboBox;
    private boolean unitOfMeasureComboBoxValidated;

    @FXML
    private ComboBox<OrganizationType> organizationTypeComboBox;
    private boolean organizationTypeComboBoxValidated;

    @FXML
    private TextField organizationNameTextField;
    private boolean organizationNameTextFieldValidated;

    @FXML
    private Label productNameLabel;
    @FXML
    private Label coordinateXLabel;
    @FXML
    private Label coordinateYLabel;
    @FXML
    private Label priceLabel;
    @FXML
    private Label organizationNameLabel;
    @FXML
    private Label organizationAnnualTurnOverLabel;
    @FXML
    private Label manufactureCostLabel;
    @FXML
    private Label unitOfMeasureLabel;
    @FXML
    private Label organizationTypeLabel;
    @FXML
    private Button cancelButton;
    @FXML
    private Button okButton;

    private Stage currentStage;

    public Product product = null;

    @FXML
    public void initialize(){
        initListeners();
        initManufactureTypeComboBox();
        initUnitOfMeasureComboBox();
        updateLocale();
        MainFormController.getCurrentLocale().addListener(change->updateLocale());
    }

    public void loadProduct(Product product){
        if(product == null) return;
        this.product = product;
        productNameTextField.setText(product.getName());
        coordinateXTextField.setText(product.getCoordinates().getX().toString());
        coordinateYTextField.setText(product.getCoordinates().getY().toString());
        priceTextField.setText(product.getPrice().toString());
        manufactureCostTextField.setText(product.getManufactureCost().toString());
        unitOfMeasureComboBox.setValue(product.getUnitOfMeasure());

        if(product.getManufacturer() == null) return;
        organizationNameTextField.setText(product.getManufacturer().getName());
        organizationAnnulTurnoverTextField.setText(product.getManufacturer().getAnnualTurnover().toString());
        organizationTypeComboBox.setValue(product.getManufacturer().getOrganizationType());
    }
    private void updateLocale(){
        productNameTextField.setPromptText(ProductCreatingAndUpdatingFormElements.PRODUCT_NAME_TF.toString());
        coordinateXTextField.setPromptText(ProductCreatingAndUpdatingFormElements.COORDINATE_X_TF.toString());
        coordinateYTextField.setPromptText(ProductCreatingAndUpdatingFormElements.COORDINATE_Y_TF.toString());
        priceTextField.setPromptText(ProductCreatingAndUpdatingFormElements.PRICE_TF.toString());
        manufactureCostTextField.setPromptText(ProductCreatingAndUpdatingFormElements.MANUFACTURE_COST_TF.toString());
        unitOfMeasureComboBox.setPromptText(ProductCreatingAndUpdatingFormElements.UNIT_OF_MEASURE_CB.toString());
        organizationNameTextField.setPromptText(ProductCreatingAndUpdatingFormElements.ORGANIZATION_NAME_TF.toString());
        organizationTypeComboBox.setPromptText(ProductCreatingAndUpdatingFormElements.ORGANIZATION_TYPE_CB.toString());
        organizationAnnulTurnoverTextField.setPromptText(ProductCreatingAndUpdatingFormElements.ORGANIZATION_ANNUAL_TURNOVER_TF.toString());

        productNameLabel.setText(ProductCreatingAndUpdatingFormElements.PRODUCT_NAME_LABEL.toString());
        coordinateXLabel.setText(ProductCreatingAndUpdatingFormElements.COORDINATE_X_LABEL.toString());
        coordinateYLabel.setText(ProductCreatingAndUpdatingFormElements.COORDINATE_Y_LABEL.toString());
        priceLabel.setText(ProductCreatingAndUpdatingFormElements.PRICE_TF.toString());
        manufactureCostLabel.setText(ProductCreatingAndUpdatingFormElements.MANUFACTURE_COST_LABEL.toString());
        unitOfMeasureLabel.setText(ProductCreatingAndUpdatingFormElements.UNIT_OF_MEASURE_LABEL.toString());
        organizationNameLabel.setText(ProductCreatingAndUpdatingFormElements.ORGANIZATION_NAME_LABEL.toString());
        organizationTypeLabel.setText(ProductCreatingAndUpdatingFormElements.ORGANIZATION_TYPE_LABEL.toString());
        organizationAnnualTurnOverLabel.setText(ProductCreatingAndUpdatingFormElements.ORGANIZATION_ANNUAL_TURNOVER_LABEL.toString());

        okButton.setText(ProductCreatingAndUpdatingFormElements.OK_Button.toString());
        cancelButton.setText(ProductCreatingAndUpdatingFormElements.CANCEL_BUTTON.toString());
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

    private boolean validateToBeTriggeredHelper(TextField toBeValidated, Function<String, Boolean> validator){
        var validated = validator.apply(toBeValidated.getText());
        if(validated)
            toBeValidated.setStyle(validatedStyle);
        else
            toBeValidated.setStyle(unvalidatedStyle);
        return validated;
    }

    private void initListeners(){
        productNameTextField.textProperty()
                .addListener(change-> productNameTextFieldValidated = validateToBeTriggeredHelper(productNameTextField, ProductValidator::validateName) );
        coordinateXTextField.textProperty()
                .addListener(change-> coordinateXTextFieldValidated = validateToBeTriggeredHelper(coordinateXTextField, ProductValidator::validateXCoordinate) );
        coordinateYTextField.textProperty()
                .addListener(change-> coordinateYTextFieldValidated = validateToBeTriggeredHelper(coordinateYTextField, ProductValidator::validateYCoordinate) );
        priceTextField.textProperty()
                .addListener(change-> priceTextFieldValidated = validateToBeTriggeredHelper(priceTextField, ProductValidator::validatePrice) );
        manufactureCostTextField.textProperty()
                .addListener(change-> manufactureCostTextFieldValidated = validateToBeTriggeredHelper(manufactureCostTextField, ProductValidator::validateManufactureCost) );
        organizationNameTextField.textProperty()
                .addListener(change-> organizationNameTextFieldValidated = validateToBeTriggeredHelper(organizationNameTextField, ProductValidator::validateOrganizationName) );
        organizationAnnulTurnoverTextField.textProperty()
                .addListener(change-> organizationAnnulTurnoverTextFieldValidated = validateToBeTriggeredHelper(organizationAnnulTurnoverTextField, ProductValidator::validateOrganizationAnnualTurnOver) );
    }

    public void validateNow(){
        productNameTextFieldValidated = validateToBeTriggeredHelper(productNameTextField, ProductValidator::validateName);
        coordinateXTextFieldValidated = validateToBeTriggeredHelper(coordinateXTextField, ProductValidator::validateXCoordinate);
        coordinateYTextFieldValidated = validateToBeTriggeredHelper(coordinateYTextField, ProductValidator::validateYCoordinate);
        priceTextFieldValidated = validateToBeTriggeredHelper(priceTextField, ProductValidator::validatePrice);
        manufactureCostTextFieldValidated = validateToBeTriggeredHelper(manufactureCostTextField, ProductValidator::validateManufactureCost);
        organizationNameTextFieldValidated = validateToBeTriggeredHelper(organizationNameTextField, ProductValidator::validateOrganizationName);
        organizationAnnulTurnoverTextFieldValidated = validateToBeTriggeredHelper(organizationAnnulTurnoverTextField, ProductValidator::validateOrganizationAnnualTurnOver);

        organizationTypeComboBoxValidated = organizationTypeComboBox.getValue() != null;
        unitOfMeasureComboBoxValidated = unitOfMeasureComboBox.getValue() != null;
    }

    private void initUnitOfMeasureComboBox(){
        for (UnitOfMeasure genre : UnitOfMeasure.values()){
            unitOfMeasureComboBox.getItems().add(genre);
        }
    }

    private void initManufactureTypeComboBox(){
        for (OrganizationType country : OrganizationType.values()){
            organizationTypeComboBox.getItems().add(country);
        }
    }


    @FXML
    protected void mouseEntered(MouseEvent event){
        Button button = (Button) event.getTarget();
        if(validateAllFields())
            button.setStyle("""
                -fx-background-color: null;
                -fx-border-width: 1;
                -fx-border-radius: 50;
                -fx-border-color: #00bb00
                """);
        else
            button.setStyle("""
                -fx-background-color: null;
                -fx-border-width: 1;
                -fx-border-radius: 50;
                -fx-border-color: #bb0000
                """);
    }

    @FXML
    protected void mouseExited(MouseEvent event){
        Button button = (Button) event.getTarget();
        button.setStyle("""
                -fx-background-color: null;
                -fx-border-width: 1;
                -fx-border-radius: 50;
                -fx-border-color: black
                """);
    }


    @FXML
    protected void onOkButtonPressed(ActionEvent actionEvent){
        if (validateAllFields()){
            product = collectData();
            currentStage.close();
        }
    }

    @FXML
    protected void onCloseButtonPressed(ActionEvent actionEvent){
        currentStage.close();
    }

    private Product collectData(){
        var prodName = productNameTextField.getText();
        var prodPrice = Float.parseFloat(priceTextField.getText());
        var orgType = organizationTypeComboBox.getValue();
        var orgName = organizationNameTextField.getText();
        var turnOver = Integer.parseInt(organizationAnnulTurnoverTextField.getText());
        var x = Double.parseDouble(coordinateXTextField.getText());
        var y = Float.parseFloat(coordinateYTextField.getText());
        var manufactureCost = Double.parseDouble(manufactureCostTextField.getText());
        var unitOfMeasure = unitOfMeasureComboBox.getValue();


        return new Product(product == null ? 0L : product.getId(), prodName, new Coordinates(product == null ? 0 : product.getCoordinates().getId(), x, y),
                prodPrice, manufactureCost, unitOfMeasure, new Organization(product != null && product.getManufacturer() != null ?
                product.getManufacturer().getId() : 0L, orgName, turnOver, orgType));
    }

    private boolean validateAllFields(){
        validateNow();
        return productNameTextFieldValidated && coordinateXTextFieldValidated && coordinateYTextFieldValidated
                && priceTextFieldValidated && manufactureCostTextFieldValidated && organizationNameTextFieldValidated
                && organizationAnnulTurnoverTextFieldValidated && organizationTypeComboBoxValidated && unitOfMeasureComboBoxValidated;
    }

    public boolean isCoordinateXValidity(){
        if(productNameTextField.getText().isEmpty()){
            productNameTextField.setStyle("""
                -fx-border-radius: 100;
                -fx-background-radius: 100;
                -fx-border-color: red
                """);
            return false;
        }
        productNameTextField.setStyle("""
                -fx-border-radius: 100;
                -fx-background-radius: 100;
                -fx-border-color: null
                """);
        return true;
    }

    public void setCurrentStage(Stage stage){
        this.currentStage = stage;
    }
}
