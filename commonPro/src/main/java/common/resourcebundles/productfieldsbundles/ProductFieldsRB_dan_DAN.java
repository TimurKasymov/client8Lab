package common.resourcebundles.productfieldsbundles;


import java.util.ListResourceBundle;

public class ProductFieldsRB_dan_DAN extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        Object[][] resources = {
                {"product_id", "produkt id"},
                {"creation_date", "Oprettelsesdato"},
                {"price", "pris"},
                {"manufacture_cost", "fremstillingsomkostninger"},
                {"unit_of_measure", "måleenhed"},
                {"name", "navn"},
                {"coordinates_id", "koordinater id"},
                {"x_coordinate", "x koordinat"},
                {"y_coordinate", "y koordinat"},
                {"organization_id", "organisations-id"},
                {"organization_name", "Organisationens navn"},
                {"organization_annul_turnover", "organisationens årlige omsætning"},
                {"user_name", "brugernavn"},
                {"user_id", "bruger ID"},
                {"organization_type", "organisationstype"}
        };

        return resources;
    }
}
