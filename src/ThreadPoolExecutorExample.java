import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ThreadPoolExecutorExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 3, 2,
                TimeUnit.MINUTES, new ArrayBlockingQueue<>(3), new CustomThreadFactory(), new CustomExceptionHandler());

        Future<?> task1 = threadPoolExecutor.submit(() -> {
            System.out.println("Starting task - 1");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println("Error in task - 1");
            }
        });
        Future<List<Integer>> task2 = threadPoolExecutor.submit(() -> {
            System.out.println("Starting task - 2");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println("Error in task - 2");
            }
            List<Integer> v = new ArrayList<>();
            v.add(10);
            return v;
        });

        try {
            System.out.println(task1.get(2, TimeUnit.SECONDS));
        } catch (TimeoutException e) {
            System.out.println("TimeoutException");
        }
        System.out.println(task2.get());
    }

    private static class CustomThreadFactory implements ThreadFactory {
        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);
            thread.setName("Thread Pool Executor");
            thread.setDaemon(false);
            return thread;
        }
    }

    private static class CustomExceptionHandler implements RejectedExecutionHandler {
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            System.out.printf("%s: Runnable is rejected, since the working queue is full and all the threads are busy\n", r.getClass().getName());
        }
    }
}
