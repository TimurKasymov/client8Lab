package resourcebundles.productcreatingandupdatingformbundles;

import java.util.ListResourceBundle;

public class ProductCreatingAndUpdatingFormRB_ru_RU extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        Object[][] contents = {
                {"productNameField", " название продукта"},
                {"coordinateXField", "0 < X < 910"},
                {"coordinateYField", "0 < Y < 590"},
                {"priceField", " цена продукта"},
                {"manufactureCostField", " стоимость производства"},
                {"unitOfMeasureField", "выберите ед измерения"},
                {"organizationNameField", " название организации"},
                {"organizationTypeField", "выберите тип организации"},
                {"organizationAnnualTurnOverField", " годовой оборот"},

                {"productNameLabel", "название продукта"},
                {"coordinateXLabel", "координату X"},
                {"coordinateYLabel", "координату Y"},
                {"priceLabel", "цена продукта"},
                {"manufactureCostLabel", "  ед измерения"},
                {"unitOfMeasureLabel", "Имя банды"},
                {"organizationNameLabel", " название организации"},
                {"organizationTypeLabel", " тип организации"},
                {"organizationAnnualTurnOverLabel", "годовой оборот"},

                {"cancelButton", "Отмена"},
                {"okButton", "Ок"}
        };
        return contents;
    }
}
