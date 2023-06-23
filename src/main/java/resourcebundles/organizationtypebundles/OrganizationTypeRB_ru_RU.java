package resourcebundles.organizationtypebundles;


import java.util.ListResourceBundle;

public class OrganizationTypeRB_ru_RU extends ListResourceBundle {
@Override
    protected Object[][] getContents() {
        Object[][] contents = {
                {"commercial", "коммерческая"},
                {"government", "государсвтенная"},
                {"trust", "трастовая"},
                {"privateLimitCompany", "закрытое акционерное общество"},
                {"openJointStockCompany", "Открытое акционерное общество"}
        };
        return contents;
    }
}
