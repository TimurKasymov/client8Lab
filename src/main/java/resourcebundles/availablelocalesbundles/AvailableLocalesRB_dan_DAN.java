package resourcebundles.availablelocalesbundles;

import java.util.ListResourceBundle;

public class AvailableLocalesRB_dan_DAN extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        Object[][] contents = {
                {"russian", "russisk"},
                {"english", "engelsk"},
                {"turkish", "tyrkisk"},
                {"danish", "dansk"},
        };
        return contents;
    }
}
