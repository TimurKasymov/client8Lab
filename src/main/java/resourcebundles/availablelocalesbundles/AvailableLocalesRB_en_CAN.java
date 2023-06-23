package resourcebundles.availablelocalesbundles;

import java.util.ListResourceBundle;

public class AvailableLocalesRB_en_CAN extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        Object[][] contents = {
                {"russian", "russian"},
                {"english", "english"},
                {"turkish", "turkish"},
                {"danish", "danish"},
        };
        return contents;
    }
}
