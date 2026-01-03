package SingletonPractice;

/*
    Bill Pugh Solution
 */
public class DatabaseConnection {
    private DatabaseConnection() {}

    private static class SingletonClassCreator {
        private static final DatabaseConnection INSTANCE = new DatabaseConnection();
    }

    public static DatabaseConnection getInstance() {
        return SingletonClassCreator.INSTANCE;
    }
}
