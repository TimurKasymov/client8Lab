package common.resourcebundles.productfieldsbundles;


import java.util.ListResourceBundle;

public class ProductFieldsRB_ru_RU extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        Object[][] resources = {
                {"product_id", "айди продукта"},
                {"creation_date", "дата создания"},
                {"price", "цена"},
                {"manufacture_cost", "цена производства"},
                {"unit_of_measure", "единица измерения"},
                {"name", "имя"},
                {"coordinates_id", "айди координиты"},
                {"x_coordinate", "x координита"},
                {"y_coordinate", "y координита"},
                {"organization_id", "айди организации"},
                {"organization_name", "название организации"},
                {"organization_annul_turnover", "годовой доход организации"},
                {"user_name", "имя юсера"},
                {"user_id", "айди юсера"},
                {"organization_type", "тип организации"}
        };

        return resources;
    }
}
