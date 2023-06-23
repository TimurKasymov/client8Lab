package common.resourcebundles.rolesbundles;


import java.util.ListResourceBundle;

public class RoleRB_dan_DAN extends ListResourceBundle {
@Override
    protected Object[][] getContents() {
        Object[][] contents = {
                {"admin", "admin"},
                {"min_user", "min bruger"},
                {"middle_user", "mellembruger"}
        };
        return contents;
    }
}
