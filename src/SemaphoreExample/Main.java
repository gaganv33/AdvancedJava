package SemaphoreExample;

public class Main {
    public static void main(String[] args) {
        WorkerHandler workerHandler = new WorkerHandler(3);

        for (int i = 0; i < 10; i++) {
            Runnable task = getRunnableTask(i + 1);
            workerHandler.submitTask(task);
        }
    }

    private static Runnable getRunnableTask(int id) {
        return () -> {
            System.out.printf("Started running task : %d\n", id);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.printf("Exception in task : %d\n", id);
            }
            System.out.printf("Ending task : %d\n", id);
        };
    }
}
