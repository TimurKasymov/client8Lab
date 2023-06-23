package resourcebundles.enums;



import client.client8lab.GUI.Controllers.MainFormController;

import java.util.ResourceBundle;

public enum MainFormElements {
    SETTINGS_MENU("settingsMenu"),
    LOG_OUT_MENU_ITEM("logOutMenuItem"),
    LANGUAGE_MENU_ITEM("languageMenuItem"),
    INFO_MENU("infoMenu"),
    CREATE_FILTER_BUTTON("createFilterButton"),
    REMOVE_FILTERS_BUTTON("removeFiltersButton"),
    ADD_BUTTON("addButton"),
    ADD_IF_MIN_BUTTON("addIfMinButton"),
    UPDATE_BUTTON("updateButton"),
    ClEAR_BUTTON("clearButton"),
    SHOW_USERS_BUTTON("showUsersButton"),
    REMOVE_BUTTON("removeButton"),
    REMOVE_BY_ID_BUTTON("removeByIdButton"),
    CLEAR_BUTTON("clearButton"),
    HELP("help"),
    CONTROLLERS_LABEL("controllersLabel"),
    EXECUTE_SCRIPT_BUTTON("executeScriptButton"),
    VISUALIZE_BUTTON("visualizeButton");


    private final String bundleObjectName;

    MainFormElements(String bundleObjectName){
        this.bundleObjectName = bundleObjectName;
    }

    @Override
    public String toString() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("resourcebundles.mainformbundles.MainFormRB", MainFormController.getCurrentLocale().get().getLocale());
        return resourceBundle.getString(bundleObjectName);
    }
}
