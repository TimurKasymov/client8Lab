package resourcebundles.rolesbundles;

import java.util.ListResourceBundle;

public class RoleRB_tur_TUR extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        Object[][] contents = {
                {"admin", "yönetici"},
                {"min_user", "minimum kullanıcı"},
                {"middle_user", "orta kullanıcı"}
        };
        return contents;
    }
}
