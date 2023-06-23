package client.client8lab.GUI.Controllers;

import client.client8lab.ClientApplication;
import client.client8lab.Graphics.GraphicsManager;
import javafx.animation.TranslateTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import common.src.models.Product;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class DisplayController {

    @FXML
    public Pane paneToDrawOn;

    @FXML
    public void initialize(){
        GraphicsManager.renderAll(paneToDrawOn, MainFormController.getMainFormController().getModelsCollection());
    }

    public void updateProductLocation(List<Product> products){
        GraphicsManager.update(products, paneToDrawOn);
    }
}
