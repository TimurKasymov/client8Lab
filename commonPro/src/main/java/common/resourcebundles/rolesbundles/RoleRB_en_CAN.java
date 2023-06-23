package common.resourcebundles.rolesbundles;


import java.util.ListResourceBundle;

public class RoleRB_en_CAN extends ListResourceBundle {
@Override
    protected Object[][] getContents() {
        Object[][] contents = {
                {"admin", "admin"},
                {"min_user", "min user"},
                {"middle_user", "middle user"}
        };
        return contents;
    }
}
