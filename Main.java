package MagazijnRobot;

public class Main {
    public static DBConnection db;
    public static void main(String[] args) {
        System.out.println("Main - Zorgboerderij!");

        db = new DBConnection();

        HMI_GUI HMI = new HMI_GUI();
    }
}
