package resourcebundles.userfieldsbundles;


import java.util.ListResourceBundle;

public class UserFieldsRB_dan_DAN extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        Object[][] resources = {
                {"user_id", "bruger ID"},
                {"user_name", "brugernavn"},
                {"user_role", "brugerrolle"},
        };

        return resources;
    }
}
