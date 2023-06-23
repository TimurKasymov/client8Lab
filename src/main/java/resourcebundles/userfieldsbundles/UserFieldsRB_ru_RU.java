package resourcebundles.userfieldsbundles;


import java.util.ListResourceBundle;

public class UserFieldsRB_ru_RU extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        Object[][] resources = {
                {"user_id", "айди"},
                {"user_name", "имя"},
                {"user_role", "роль"},
        };

        return resources;
    }
}
