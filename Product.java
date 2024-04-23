package MagazijnRobot;

public class Product {
    public int id;
    public String naam;
    public int quantity;
    public int x;
    public  int y;
    public Product() {};
    public Product(int id, String naam, int quantity, int x, int y) {
        this.id = id;
        this.naam = naam;
        this.quantity = quantity;
        this.x = x;
        this.y = y;
    }
}
