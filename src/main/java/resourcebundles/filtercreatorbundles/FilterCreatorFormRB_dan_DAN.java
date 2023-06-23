package resourcebundles.filtercreatorbundles;

import java.util.ListResourceBundle;

public class FilterCreatorFormRB_dan_DAN extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        Object[][] content = {
                {"filterColumnLabel", "Column to filter:"},
                {"signLabel", "Filter sign:"},
                {"valueForFilteringLabel", "Filter value:"},
                {"columnsForFilteringComboBox", "columns"},
                {"signsCombobox", "signs"},
                {"filteringValueTextField", "value here"},
                {"createButton", "Create"},
                {"cancelButton", "Cancel"}
        };
        return content;
    }
}
