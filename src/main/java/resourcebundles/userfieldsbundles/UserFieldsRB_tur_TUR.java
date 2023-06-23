package resourcebundles.userfieldsbundles;


import java.util.ListResourceBundle;

public class UserFieldsRB_tur_TUR extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        Object[][] resources = {
                {"user_id", "İD"},
                {"user_name", "isim"},
                {"user_role", "rol"},
        };

        return resources;
    }
}
