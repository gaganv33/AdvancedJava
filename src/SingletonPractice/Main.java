package SingletonPractice;

public class Main {
    public static void main(String[] args) {
        Manager manager = Manager.getInstance();
        System.out.println(manager.getClass().getName());

        DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
        System.out.println(databaseConnection.getClass().getName());
    }
}
