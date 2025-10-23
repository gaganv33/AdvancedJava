package Concurrency;

public class DaemonThreadImplementation {
    public static void main(String[] args) {
        Thread daemon_thread = new Thread(() -> {
            for(int i = 0; i < 1000; i++) {
                try {
                    Thread.sleep(5);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("Daemon Thread");
            }
        });

        Thread user_thread = new Thread(() -> {
           for(int i = 0; i < 10; i++) {
               try {
                   Thread.sleep(4);
               } catch (Exception e) {
                   System.out.println(e.getMessage());
               }
               System.out.println("User Thread");
           }
        });

        daemon_thread.setDaemon(true);
        daemon_thread.setPriority(5);
        user_thread.setPriority(4);
        daemon_thread.start();
        user_thread.start();
    }
}
