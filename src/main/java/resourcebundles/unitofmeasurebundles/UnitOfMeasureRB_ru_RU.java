package resourcebundles.unitofmeasurebundles;


import java.util.ListResourceBundle;

public class UnitOfMeasureRB_ru_RU extends ListResourceBundle {
@Override
    protected Object[][] getContents() {
        Object[][] contents = {
                {"kilograms", "килограммы"},
                {"meters", "метры"},
                {"liters", "литры"},
                {"milligrams", "миллиграмы"},
        };
        return contents;
    }
}
