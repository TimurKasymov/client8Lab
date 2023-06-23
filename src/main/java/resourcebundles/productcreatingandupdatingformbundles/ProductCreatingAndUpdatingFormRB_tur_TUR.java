package resourcebundles.productcreatingandupdatingformbundles;

import java.util.ListResourceBundle;

public class ProductCreatingAndUpdatingFormRB_tur_TUR extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        Object[][] contents = {
                {"productNameField", "ürün adı"},
                {"coordinateXField", "0 < X < 910"},
                {"coordinateYField", "0 < Y < 590"},
                {"priceField", "ürün fiyatı"},
                {"manufactureCostField", "üretim maliyeti"},
                {"unitOfMeasureField", "birim seç"},
                {"organizationNameField", "kuruluş adı"},
                {"organizationTypeField", "kuruluş türünü seçin"},
                {"organizationAnnualTurnOverField", "yıllık ciro"},

                {"productNameLabel", "ürün adı"},
                {"coordinateXLabel", "X koordinatı"},
                {"coordinateYLabel", "Y koordinatı"},
                {"priceLabel", "ürün fiyatı"},
                {"manufactureCostLabel", "unit"},
                {"unitOfMeasureLabel", "Çete adı"},
                {"organizationNameLabel", "kuruluş adı"},
                {"organizationTypeLabel", "kuruluş türü"},
                {"organizationAnnualTurnOverLabel", "yıllık ciro"},

                {"cancelButton", "Cancel"},
                {"okButton", "Tamam"}
        };
        return contents;
    }
}
