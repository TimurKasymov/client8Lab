package client.client8lab;

import client.client8lab.backService.container.SettingsContainer;
import client.client8lab.backService.settings.SettingsModel;
import client.client8lab.formUtils.FormsManager;
import com.fasterxml.jackson.databind.ObjectMapper;
import common.src.models.User;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClientApplication extends Application {

    public static User user;

    @Override
    public void start(Stage stage) throws IOException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        var inputStream = classloader.getResourceAsStream("settings.json");
        if (inputStream == null){
            System.out.println("settings file not found");
            System.exit(-1);
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line).append("\n");
        }
        reader.close();
        var str = sb.toString();
        ObjectMapper mapper = new ObjectMapper();
        SettingsContainer.settingsModel = mapper.readValue(str, SettingsModel.class);

        var controller = FormsManager.manageEntry(true);
    }
    public static Scene entryScene;
    public static void main(String[] args) {
        launch();
    }
}