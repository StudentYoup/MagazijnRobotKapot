package MagazijnRobot;

public class Orderline {
    private int orderlineID;
    private int orderID;
    private int stockItemID;
    private String description;
    private int quantity;
    private int pickedQuantity;
    private boolean complete;
    private Product product;

    // Constructor
    public Orderline(int orderlineID, int orderID, int stockItemID, String description, int quantity, int pickedQuantity, boolean complete) {
        this.orderlineID = orderlineID;
        this.orderID = orderID;
        this.stockItemID = stockItemID;
        this.description = description;
        this.quantity = quantity;
        this.pickedQuantity = pickedQuantity;
        this.complete = complete;
        this.product = Main.db.getProduct(stockItemID);
    }
}
