package client.client8lab.tableHandlers;

import client.client8lab.GUI.Controllers.MainFormController;

import java.util.ResourceBundle;

public enum ProductColumnNames {

    PRODUCT_ID("product_id"),
    CREATION_DATE("creation_date"),
    PRICE("price"),
    MANUFACTURE_COST("manufacture_cost"),
    UNIT_OF_MEASURE("unit_of_measure"),
    NAME("name"),
    COORDINATES_ID("coordinates_id"),
    X_COORDINATE("x_coordinate"),
    Y_COORDINATE("y_coordinate"),
    ORGANIZATION_ID("organization_id"),
    ORGANIZATION_NAME("organization_name"),
    ORGANIZATION_ANNUAL_TURN_OVER("organization_annul_turnover"),
    USER_NAME("user_name"),
    USER_ID("user_id"),
    ORGANIZATION_TYPE("organization_type");

    private final String bundleObjectName;

    ProductColumnNames(String bundleObjectName){
        this.bundleObjectName = bundleObjectName;
    }

    @Override
    public String toString() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("resourcebundles.productfieldsbundles.ProductFieldsRB", MainFormController.getCurrentLocale().get().getLocale());
        return resourceBundle.getString(bundleObjectName);
    }
}
