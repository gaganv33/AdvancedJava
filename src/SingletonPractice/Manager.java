package SingletonPractice;

/*
    Double locking singleton pattern
 */
public class Manager {
    private static volatile Manager manager;

    private Manager() {}

    public static Manager getInstance() {
        if (manager == null) {
            synchronized (Manager.class) {
                if (manager == null) {
                    manager = new Manager();
                }
            }
        }
        return manager;
    }
}
