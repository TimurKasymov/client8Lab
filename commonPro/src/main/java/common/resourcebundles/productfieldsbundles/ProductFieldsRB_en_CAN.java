package common.resourcebundles.productfieldsbundles;


import java.util.ListResourceBundle;

public class ProductFieldsRB_en_CAN extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        Object[][] resources = {
                {"product_id", "product id"},
                {"creation_date", "creation date"},
                {"price", "price"},
                {"manufacture_cost", "manufacture cost"},
                {"unit_of_measure", "unit of measure"},
                {"name", "name"},
                {"coordinates_id", "coordinates id"},
                {"x_coordinate", "x coordinate"},
                {"y_coordinate", "y coordinate"},
                {"organization_id", "organization id"},
                {"organization_name", "organization name"},
                {"organization_annul_turnover", "organization annul turnover"},
                {"user_name", "user name"},
                {"user_id", "user id"},
                {"organization_type", "organization type"}
        };

        return resources;
    }
}
