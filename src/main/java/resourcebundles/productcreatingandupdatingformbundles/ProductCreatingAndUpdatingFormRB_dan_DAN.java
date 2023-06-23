package resourcebundles.productcreatingandupdatingformbundles;

import java.util.ListResourceBundle;

public class ProductCreatingAndUpdatingFormRB_dan_DAN extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        Object[][] contents = {
                {"productNameField", "product name"},
                {"coordinateXField", "0 < X < 910"},
                {"coordinateYField", "0 < Y < 590"},
                {"priceField", "product price"},
                {"manufactureCostField", "produktionsomkostninger"},
                {"unitOfMeasureField", "select unit"},
                {"organizationNameField", "organisationsnavn"},
                {"organizationTypeField", "vælg organisationstype"},
                {"organizationAnnualTurnOverField", "årlig omsætning"},

                {"productNameLabel", "product name"},
                {"coordinateXLabel", "X coordinate"},
                {"coordinateYLabel", "Y coordinate"},
                {"priceLabel", "product price"},
                {"manufactureCostLabel", "unit"},
                {"unitOfMeasureLabel", "Gangnavn"},
                {"organizationNameLabel", "organisationsnavn"},
                {"organizationTypeLabel", "organisationstype"},
                {"organizationAnnualTurnOverLabel", "årlig omsætning"},

                {"cancelButton", "Cancel"},
                {"okButton", "OK"}
        };
        return contents;
    }
}
