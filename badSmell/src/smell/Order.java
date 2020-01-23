package smell;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Order {

    private final ItemList _itemList;

    public Order(ItemList lineItemList) {
        _itemList = lineItemList;
    }

    @Override
    public boolean equals(Object sOrder) {
        return (this == sOrder || (sOrder instanceof Order && (_itemList.equals(((Order) sOrder)._itemList))));
    }

    public void printOrder(PrintWriter pw) {
        _itemList.printOrder(pw);
    }

    /** This method saves the order to the database */
    public void saveOrder() throws SQLException {
        String sql = new StringBuffer().append("INSERT INTO T_ORDER ")
            .append("(AUTHORIZATION_CODE, ")
            .append("SHIPMETHOD_ID, USER_ID, ADDRESS_ID) ")
            .append("VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)").toString();
        PreparedStatement orderStatement = getConnection().prepareStatement(sql);
        orderStatement.executeUpdate();
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:sqlite:test.db");
    }
}
