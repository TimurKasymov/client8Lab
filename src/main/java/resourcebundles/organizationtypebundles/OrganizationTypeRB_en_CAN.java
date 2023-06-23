package resourcebundles.organizationtypebundles;


import java.util.ListResourceBundle;

public class OrganizationTypeRB_en_CAN extends ListResourceBundle {
@Override
    protected Object[][] getContents() {
        Object[][] contents = {
                {"commercial", "commercial"},
                {"government", "government"},
                {"trust", "trust"},
                {"privateLimitCompany", "closed joint stock company"},
                {"openJointStockCompany", "Open Joint Stock Company"}
        };
        return contents;
    }
}
