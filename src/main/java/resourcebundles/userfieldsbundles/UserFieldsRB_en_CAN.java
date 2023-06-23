package resourcebundles.userfieldsbundles;


import java.util.ListResourceBundle;

public class UserFieldsRB_en_CAN extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        Object[][] resources = {
                {"user_id", "user ID"},
                {"user_name", "name"},
                {"user_role", "role"},
        };

        return resources;
    }
}
