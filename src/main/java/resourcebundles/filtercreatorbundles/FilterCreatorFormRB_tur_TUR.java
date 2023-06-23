package resourcebundles.filtercreatorbundles;

import java.util.ListResourceBundle;

public class FilterCreatorFormRB_tur_TUR extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        Object[][] content = {
                {"filterColumnLabel", "Filtrelenecek sütun:"},
                {"signLabel", "Filtre işareti:"},
                {"valueForFilteringLabel", "Filtre değeri:"},
                {"columnsForFilteringComboBox", "columns"},
                {"signsCombobox", "işaretler"},
                {"filteringValueTextField", "değer burada"},
                {"createButton", "Oluştur"},
                {"cancelButton", "Cancel"}
        };
        return content;
    }
}
