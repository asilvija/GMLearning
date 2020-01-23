package smell;

import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Vector;

class ItemList {
    private final Vector<Item> _iList;

    ItemList() {
        _iList = new Vector<>();
    }

    void addLineItem(Item lineItem) {
        _iList.addElement(lineItem);
    }

    private void printOrderTotal(PrintWriter pw) {

        Iterator iter = _iList.iterator();
        Item item;

        int result = 0;
        while (iter.hasNext()) {
            item = (Item) iter.next();
            result += item.getLineItemPrice();
        }
        pw.println("Order total = " + result);
    }

    void printOrder(PrintWriter pw) {
        printItemsDescription(pw);
        printOrderTotal(pw);
    }

    private void printItemsDescription(PrintWriter pw) {
        Iterator iter = _iList.iterator();
        while (iter.hasNext()) {
            ((Item) iter.next()).printLineItemDescription(pw);
        }
    }
}
