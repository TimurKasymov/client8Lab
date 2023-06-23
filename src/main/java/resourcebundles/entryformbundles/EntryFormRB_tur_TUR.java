package resourcebundles.entryformbundles;

import java.util.ListResourceBundle;

public class EntryFormRB_tur_TUR extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        Object[][] contents = {
                {"settingsMenu", "Filtre oluştur"},
                {"login_btn", "giriş yapmak"},
                {"signup_btn", "üye olmak"},
                {"title_lbl", "lütfen giriş yapın veya kayıt olun allah aşkına"},
                {"name_lbl", "isim"},
                {"password_lbl", "şifre"}
        };
        return contents;
    }
}
