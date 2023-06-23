package resourcebundles.availablelocalesbundles;

import java.util.ListResourceBundle;

public class AvailableLocalesRB_tur_TUR  extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        Object[][] contents = {
                {"russian", "Rusça"},
                {"english", "İngilizce"},
                {"turkish", "Türkçe"},
                {"danish", "Danimarkalı"},
        };
        return contents;
    }
}
