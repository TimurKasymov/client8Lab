package resourcebundles.entryformbundles;

import java.util.ListResourceBundle;

public class EntryFormRB_en_CAN extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        Object[][] contents = {
                {"settingsMenu", "settings"},
                {"login_btn", "login"},
                {"signup_btn", "sign up"},
                {"title_lbl", "please login or sign up for god sake"},
                {"name_lbl", "NAME"},
                {"password_lbl", "PASSWORD"}
        };
        return contents;
    }
}
