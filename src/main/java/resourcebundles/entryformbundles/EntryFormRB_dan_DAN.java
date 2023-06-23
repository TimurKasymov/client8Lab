package resourcebundles.entryformbundles;

import java.util.ListResourceBundle;

public class EntryFormRB_dan_DAN extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        Object[][] contents = {
                {"settingsMenu", "Opret filter"},
                {"login_btn", "Fjern filtre"},
                {"signup_btn", "Tilføje"},
                {"title_lbl", "log venligst ind"},
                {"name_lbl", "navn"},
                {"password_lbl", "adgangskode"}
        };
        return contents;
    }
}
