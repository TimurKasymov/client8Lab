package resourcebundles.productcreatingandupdatingformbundles;

import java.util.ListResourceBundle;

public class ProductCreatingAndUpdatingFormRB_en_CAN extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        Object[][] contents = {
                {"productNameField", "product name"},
                {"coordinateXField", "0 < X < 910"},
                {"coordinateYField", "0 < Y < 590"},
                {"priceField", "product price"},
                {"manufactureCostField", "production cost"},
                {"unitOfMeasureField", "select unit"},
                {"organizationNameField", "organization name"},
                {"organizationTypeField", "select organization type"},
                {"organizationAnnualTurnOverField", "annual turnover"},

                {"productNameLabel", "product name"},
                {"coordinateXLabel", "X coordinate"},
                {"coordinateYLabel", "Y coordinate"},
                {"priceLabel", "product price"},
                {"manufactureCostLabel", "manufacture cost"},
                {"unitOfMeasureLabel", "unit of measure"},
                {"organizationNameLabel", "organization name"},
                {"organizationTypeLabel", "organization type"},
                {"organizationAnnualTurnOverLabel", "annual turnover"},

                {"cancelButton", "Cancel"},
                {"okButton", "OK"}
        };
        return contents;
    }
}
