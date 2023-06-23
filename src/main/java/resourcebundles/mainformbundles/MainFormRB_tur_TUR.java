package resourcebundles.mainformbundles;

import java.util.ListResourceBundle;

public class MainFormRB_tur_TUR extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        Object[][] contents = {
                {"createFilterButton", "Filtre oluştur"},
                {"removeFiltersButton", "Filtreleri kaldır"},
                {"addButton", "Eklemek"},
                {"updateButton", "Güncelleme"},
                {"removeButton", "Kaldırmak"},
                {"removeByIdButton", "kimliğe göre kaldır"},
                {"clearButton", "temizlemek"},
                {"controllersLabel", "Kontrolörler"},
                {"infoMenu", "Bilgi"},
                {"settingsMenu", "Ayarlar"},
                {"help", "fgjfiremj"},
                {"helpMenu", "Yardım"},
                {"languageMenuItem", "Dil"},
                {"logOutMenuItem", "Komut dosyasını yürüt"},
                {"executeScriptButton", "Execute script"},
                {"visualizeButton", "Görselleştir"},
                {"showUsersButton", "Kullanıcıları göster"}
        };
        return contents;
    }
}
