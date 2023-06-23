package resourcebundles.organizationtypebundles;


import java.util.ListResourceBundle;

public class OrganizationTypeRB_dan_DAN extends ListResourceBundle {
@Override
    protected Object[][] getContents() {
        Object[][] contents = {
                {"commercial", "kommerciel"},
                {"government", "government"},
                {"trust", "tillid"},
                {"privateLimitCompany", "lukket aktieselskab"},
                {"openJointStockCompany", "Open Joint Stock Company"}
        };
        return contents;
    }
}
