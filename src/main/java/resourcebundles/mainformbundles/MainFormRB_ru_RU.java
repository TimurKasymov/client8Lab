package resourcebundles.mainformbundles;

import java.util.ListResourceBundle;

public class MainFormRB_ru_RU extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        Object[][] contents = {
                {"createFilterButton", "Создать фильтр"},
                {"removeFiltersButton", "Удалить фильтры"},
                {"addButton", "Добавить"},
                {"updateButton", "Обновить"},
                {"removeButton", "Удалить"},
                {"removeByIdButton", "Удалить по id"},
                {"clearButton", "Очистить"},
                {"controllersLabel", "Контроллеры"},
                {"infoMenu", "Инфо"},
                {"settingsMenu", "Настройки"},
                {"clear", "Удалить все"},
                {"helpMenu", "Помощь"},
                {"help", "помощь"},
                {"languageMenuItem", "Язык"},
                {"logOutMenuItem", "Выйти"},
                {"executeScriptButton", "Запустить скрипт"},
                {"visualizeButton", "Визуализация"},
                {"showUsersButton", "показать пользователей"}

        };
        return contents;
    }
}
