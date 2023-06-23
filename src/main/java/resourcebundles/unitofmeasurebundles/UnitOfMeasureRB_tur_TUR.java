package resourcebundles.unitofmeasurebundles;


import java.util.ListResourceBundle;

public class UnitOfMeasureRB_tur_TUR extends ListResourceBundle {
@Override
    protected Object[][] getContents() {
        Object[][] contents = {
                {"kilograms", "kilogram"},
                {"meters", "metre"},
                {"liters", "litre"},
                {"milligrams", "miligram"},
        };
        return contents;
    }
}
