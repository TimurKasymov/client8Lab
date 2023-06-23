package common.resourcebundles.productfieldsbundles;


import java.util.ListResourceBundle;

public class ProductFieldsRB_tur_TUR extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        Object[][] resources = {
                {"product_id", "ürün kimliği"},
                {"creation_date", "oluşturulma tarihi"},
                {"price", "fiyat"},
                {"manufacture_cost", "üretim maliyeti"},
                {"unit_of_measure", "ölçü birimi"},
                {"name", "isim"},
                {"coordinates_id", "koordinat kimliği"},
                {"x_coordinate", "x koordinat"},
                {"y_coordinate", "y coordinate"},
                {"organization_id", "organizasyon kimliği"},
                {"organization_name", "Kuruluş Adı"},
                {"organization_annul_turnover", "organizasyon annul ciro"},
                {"user_name", "Kullanıcı adı"},
                {"user_id", "Kullanıcı kimliği"},
                {"organization_type", "Organizasyon tipi"}
        };

        return resources;
    }
}
