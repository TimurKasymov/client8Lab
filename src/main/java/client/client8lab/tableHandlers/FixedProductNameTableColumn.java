package client.client8lab.tableHandlers;

import javafx.scene.control.TableColumn;

public class FixedProductNameTableColumn<S, T>  extends TableColumn {
    private ProductColumnNames fixedName;

    public FixedProductNameTableColumn(ProductColumnNames columnFixedName){
        super(columnFixedName.toString());
        this.fixedName = columnFixedName;
    }

    public ProductColumnNames getFixedName(){
        return fixedName;
    }
}
