package common.resourcebundles.rolesbundles;

import java.util.ListResourceBundle;

public class RoleRB_ru_RU extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        Object[][] contents = {
                {"admin", "админ"},
                {"min_user", "минимальные права"},
                {"middle_user", "средние права"}

        };
        return contents;
    }
}
