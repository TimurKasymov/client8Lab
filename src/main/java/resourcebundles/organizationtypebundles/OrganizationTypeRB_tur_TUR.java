package resourcebundles.organizationtypebundles;


import java.util.ListResourceBundle;

public class OrganizationTypeRB_tur_TUR extends ListResourceBundle {
@Override
    protected Object[][] getContents() {
        Object[][] contents = {
                {"commercial", "ticari"},
                {"government", "hükümet"},
                {"trust", "güven"},
                {"privateLimitCompany", "kapalı anonim şirket"},
                {"openJointStockCompany", "Açık Anonim Şirket"}
        };
        return contents;
    }
}
