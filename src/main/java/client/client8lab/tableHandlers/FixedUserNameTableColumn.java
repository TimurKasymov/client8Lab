package client.client8lab.tableHandlers;

import javafx.scene.control.TableColumn;

public class FixedUserNameTableColumn<S, T>  extends TableColumn {
    private UsersColumnNames fixedName;

    public FixedUserNameTableColumn(UsersColumnNames columnFixedName){
        super(columnFixedName.toString());
        this.fixedName = columnFixedName;
    }

    public UsersColumnNames getFixedName(){
        return fixedName;
    }
}
