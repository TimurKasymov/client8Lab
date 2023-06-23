package client.client8lab.Graphics;

import client.client8lab.GUI.Controllers.MainFormController;
import javafx.animation.TranslateTransition;
import javafx.collections.ObservableList;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import common.src.models.Product;

import java.util.List;
import java.util.Random;

public class GraphicsManager {

    private static final String productIdKey = "prodid";

    private static final String prodDrawing = """
            M 5.85 -10.46 c 1.37 0.71 3.32 1.72 4.32 2.24 l 1.82 0.95 l -1.5 1.41 l -1.5 1.41 l 0.29 0.31 c 0.16 0.17 0.84 0.91 1.51 1.65 l 1.21 1.34 l -3.98 2.3 c -2.18 1.26 -4.04 2.32 -4.13 2.34 c -0.1 0.03 -0.69 -0.55 -1.73 -1.7 c -0.87 -0.97 -1.58 -1.78 -1.58 -1.83 c 0 -0.04 1.62 -0.92 3.59 -1.96 c 1.97 -1.05 3.61 -1.93 3.65 -1.96 c 0.03 -0.04 -1.71 -1.05 -3.88 -2.24 l -3.94 -2.17 l -3.94 2.17 c -2.17 1.19 -3.91 2.2 -3.88 2.23 c 0.04 0.04 1.7 0.94 3.69 2 l 3.62 1.93 l -0.57 0.61 c -0.32 0.33 -1.07 1.13 -1.67 1.77 l -1.1 1.16 l -4.03 -2.22 c -2.21 -1.23 -4.04 -2.25 -4.06 -2.27 c -0.02 -0.02 0.63 -0.81 1.45 -1.74 l 1.48 -1.7 l -1.07 -1 c -0.59 -0.55 -1.26 -1.18 -1.5 -1.4 l -0.42 -0.4 l 4.32 -2.25 c 2.38 -1.24 4.38 -2.25 4.43 -2.24 c 0.06 0.01 0.62 0.38 1.25 0.84 c 0.63 0.46 1.36 0.98 1.61 1.16 l 0.45 0.33 l 1.6 -1.19 c 0.87 -0.66 1.61 -1.19 1.64 -1.19 c 0.03 0 1.17 0.59 2.55 1.31 z M -0.5 5.83 l 0 4.41 l -0.53 -0.29 c -0.28 -0.17 -2.2 -1.19 -4.25 -2.28 l -3.72 -1.98 l 0 -1.94 l 0 -1.94 l 0.22 0.12 c 0.13 0.06 1.27 0.7 2.55 1.4 c 1.28 0.71 2.38 1.32 2.46 1.34 c 0.08 0.04 0.73 -0.57 1.7 -1.59 l 1.57 -1.66 l 0 4.41 z M 1.8 2.87 c 0.69 0.75 1.37 1.51 1.51 1.68 l 0.26 0.31 l 0.89 -0.51 c 0.49 -0.28 1.71 -0.98 2.72 -1.56 l 1.82 -1.06 l 0 1.98 l 0 1.98 l -4.23 2.25 l -4.22 2.25 l -0.03 -2.19 c -0.01 -1.21 -0.01 -3.16 0 -4.35 l 0.03 -2.15 l 1.25 1.37 z
            """;

    public static void doAnimation(Canvas productCanvas, Product product) {
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(4));
        transition.setToX(product.getCoordinates().getX());
        transition.setToY(product.getCoordinates().getY());
        transition.setNode(productCanvas);
        transition.play();
    }

    public static void update(List<Product> productsToUpdate, Pane pane) {
        var productCanvases = pane.getChildren().stream().map(canvas -> canvas.getProperties().get(productIdKey)).toList();
        for (var prodIdInCanvas : productCanvases) {
            var prod = productsToUpdate.stream().filter(p -> p.getId().equals(prodIdInCanvas)).findFirst();
            var canvas = pane.getChildren().stream().filter(c -> c.getProperties().get(productIdKey) == prodIdInCanvas).toArray()[0];
            if (prod.isPresent()) doAnimation((Canvas) canvas, prod.get());
            else
                pane.getChildren().remove((Canvas) canvas);
        }
        for (var prod : productsToUpdate) {
            var found = pane.getChildren().stream().anyMatch(canvas -> prod.getId().equals(canvas.getProperties().get(productIdKey)));
            if(!found){
                render(pane, prod);
            }
        }
    }

    public static void render(Pane pane, Product product) {
        var canvas = new Canvas(80, 80);
        canvas.onMouseEnteredProperty().set(e -> {
            var selectedCanvas = (Canvas) e.getTarget();
            var selectedProd = MainFormController.getMainFormController().getModelsCollection().stream().filter(p -> p.getId().equals(selectedCanvas.getProperties().get(productIdKey))).findFirst();
            if (selectedProd.isEmpty()) return;
            MainFormController
                    .getMainFormController()
                    .getTableView()
                    .getSelectionModel()
                    .select(selectedProd.get());
        });

        canvas.getProperties().put(productIdKey, product.getId());
        var gc = canvas.getGraphicsContext2D();

        Random random = new Random(product.getUser().getId());
        float red = random.nextFloat(0, 1);
        float green = random.nextFloat(0, 1);
        float blue = random.nextFloat(0, 1);
        var color = Color.color(red, green, blue);
        gc.setFill(color);
        gc.setStroke(color);
        gc.beginPath();
        gc.translate(canvas.getWidth() / 2, canvas.getHeight() / 2);
        gc.appendSVGPath(prodDrawing);

        pane.getChildren().add(canvas);
        gc.closePath();
        gc.fill();
        gc.stroke();

        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(1));
        transition.setToX(product.getCoordinates().getX());
        transition.setToY(product.getCoordinates().getY());
        transition.setNode(canvas);
        transition.play();
    }

    public static void renderAll(Pane pane, ObservableList<Product> products) {
        products.forEach(p -> render(pane, p));
    }

}
