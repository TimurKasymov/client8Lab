package resourcebundles.enums;

import client.client8lab.GUI.Controllers.MainFormController;

import java.util.ResourceBundle;

public enum ProductCreatingAndUpdatingFormElements {
    PRODUCT_NAME_TF("productNameField"),
    COORDINATE_X_TF("coordinateXField"),
    COORDINATE_Y_TF("coordinateYField"),
    PRICE_TF("priceField"),
    MANUFACTURE_COST_TF("manufactureCostField"),
    UNIT_OF_MEASURE_CB("unitOfMeasureField"),
    ORGANIZATION_NAME_TF("organizationNameField"),
    ORGANIZATION_TYPE_CB("organizationTypeField"),
    ORGANIZATION_ANNUAL_TURNOVER_TF("organizationAnnualTurnOverField"),

    PRODUCT_NAME_LABEL("productNameLabel"),
    COORDINATE_X_LABEL("coordinateXLabel"),
    COORDINATE_Y_LABEL("coordinateYLabel"),
    PRICE_LABEL("priceLabel"),
    MANUFACTURE_COST_LABEL("manufactureCostLabel"),
    UNIT_OF_MEASURE_LABEL("unitOfMeasureLabel"),
    ORGANIZATION_NAME_LABEL("organizationNameLabel"),
    ORGANIZATION_TYPE_LABEL("organizationTypeLabel"),
    ORGANIZATION_ANNUAL_TURNOVER_LABEL("organizationAnnualTurnOverLabel"),

    OK_Button("okButton"),
    CANCEL_BUTTON("cancelButton");

    private final String bundleObjectName;

    ProductCreatingAndUpdatingFormElements(String bundleObjectName){
        this.bundleObjectName = bundleObjectName;
    }

    @Override
    public String toString() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("resourcebundles.productcreatingandupdatingformbundles.ProductCreatingAndUpdatingFormRB", MainFormController.getCurrentLocale().get().getLocale());
        return resourceBundle.getString(bundleObjectName);
    }
}
