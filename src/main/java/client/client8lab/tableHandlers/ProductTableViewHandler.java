package client.client8lab.tableHandlers;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.TableView;
import common.src.models.Product;

import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class ProductTableViewHandler {
    public TableView tableView;

    public static ObservableList<Product> modelsCollection;

    private static FilteredList<Product> filteredList;

    private static SortedList<Product> sortedList;

    private static ObservableList<Predicate<Product>> predicates;

    public ProductTableViewHandler(TableView tableView, ObservableList modelsCollection) {
        this.tableView = tableView;
        this.modelsCollection = modelsCollection;
        predicates = FXCollections.observableArrayList();
        predicates.addListener(this::listChanged);
        filteredList = new FilteredList(modelsCollection);
        filteredList.setPredicate(this::checkPredicates);
        sortedList = new SortedList(filteredList);
        sortedList.comparatorProperty().bind(tableView.comparatorProperty());
        tableView.setItems(sortedList);
    }

    public void initializeColumns() {
        ProductTableColumnsInitializer tableColumnsInitializer = new ProductTableColumnsInitializer(tableView);
        tableColumnsInitializer.initializeColumns();
        listChanged(null);
    }

    public void listChanged(ListChangeListener.Change change) {
        filteredList.setPredicate(this::checkPredicates);
    }

    public boolean checkPredicates(Object o) {
        for (Predicate predicate : predicates) {
            if (!predicate.test(o)) {
                return false;
            }
        }
        return true;
    }

    public void addElement(Product product){
        Platform.runLater(()-> modelsCollection.add(product));
    }

    public void updateElement(Product product){
        if (modelsCollection.removeIf(product1 -> Objects.equals(product1.getId(), product.getId()))){
            modelsCollection.add(product);
        }
    }

    public void removeElement(Product product){
        Platform.runLater(()-> modelsCollection.removeIf(product1-> Objects.equals(product1.getId(), product.getId())));
    }

    public static List<Predicate<Product>> getPredicates() {
        return predicates;
    }

    public  SortedList<Product> getSortedList(){
        return sortedList;
    }

}
