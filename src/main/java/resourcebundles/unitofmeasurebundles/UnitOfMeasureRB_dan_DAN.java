package resourcebundles.unitofmeasurebundles;


import java.util.ListResourceBundle;

public class UnitOfMeasureRB_dan_DAN extends ListResourceBundle {
@Override
    protected Object[][] getContents() {
        Object[][] contents = {
                {"kilograms", "kilograms"},
                {"meters", "meters"},
                {"liters", "liters"},
                {"milligrams", "milligrams"}
        };
        return contents;
    }
}
