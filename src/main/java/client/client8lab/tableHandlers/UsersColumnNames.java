package client.client8lab.tableHandlers;

import client.client8lab.GUI.Controllers.MainFormController;

import java.util.ResourceBundle;

public enum UsersColumnNames {
    USER_ID("user_id"),
    USER_NAME("user_name"),
    USER_ROLE("user_role");
    private final String bundleObjectName;

    UsersColumnNames(String bundleObjectName){
        this.bundleObjectName = bundleObjectName;
    }

    @Override
    public String toString() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("resourcebundles.userfieldsbundles.UserFieldsRB", MainFormController.getCurrentLocale().get().getLocale());
        return resourceBundle.getString(bundleObjectName);
    }
}
