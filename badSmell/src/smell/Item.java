package smell;

import java.io.PrintWriter;

class Item {
    protected final int _productId;
    private final int _imageID;
    private final int _qty;
    private final int _unitprice;

    public Item(int prodID, int imageID, int inQty, int unitprice) {
        _productId = prodID;
        _imageID = imageID;
        _qty = inQty;
        _unitprice = unitprice;
    }

    int getLineItemPrice() {
        return _unitprice * _qty;
    }

    public void printLineItemDescription(PrintWriter pw) {
        pw.println("Begin Line Item");
        pw.println("Product = " + _productId);
        pw.println("Image = " + _imageID);
        pw.println("Quantity = " + _qty);
        pw.println("Total = " + getLineItemPrice());
        pw.println("End Line Item");
    }

}
