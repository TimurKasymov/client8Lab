package resourcebundles.availablelocalesbundles;

import java.util.ListResourceBundle;

public class AvailableLocalesRB_ru_RU extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        Object[][] contents = {
                {"russian", "русский"},
                {"english", "английский"},
                {"turkish", "турецкий"},
                {"danish", "датцкий"},
        };
        return contents;
    }
}
