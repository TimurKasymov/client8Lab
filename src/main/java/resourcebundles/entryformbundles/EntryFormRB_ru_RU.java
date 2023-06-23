package resourcebundles.entryformbundles;

import java.util.ListResourceBundle;

public class EntryFormRB_ru_RU extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        Object[][] contents = {
                {"settingsMenu", "Настройки"},
                {"login_btn", "Залогиниться"},
                {"signup_btn", "Засайнапиться"},
                {"title_lbl", "пожалуйста, войдите или зарегистрируйтесь"},
                {"name_lbl", "имя"},
                {"password_lbl", "пароль"}
        };
        return contents;
    }
}
