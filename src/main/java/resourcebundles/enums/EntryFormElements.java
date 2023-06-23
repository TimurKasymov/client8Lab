package resourcebundles.enums;

import client.client8lab.GUI.Controllers.MainFormController;

import java.util.ResourceBundle;

public enum EntryFormElements {
    SETTINGS_MENU("settingsMenu"),
    LOGIN_BTN("login_btn"),
    TITLE_LABEL("title_lbl"),
    NAME_LABEL("name_lbl"),
    PASSWORD_LABEL("password_lbl"),
    SIGNUP_BTN("signup_btn");

    private final String bundleObjectName;

    EntryFormElements(String bundleObjectName){
        this.bundleObjectName = bundleObjectName;
    }

    @Override
    public String toString() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("resourcebundles.entryformbundles.EntryFormRB", MainFormController.getCurrentLocale().get().getLocale());
        return resourceBundle.getString(bundleObjectName);
    }
}
