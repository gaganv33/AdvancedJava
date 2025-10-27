package Concurrency;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolExecutorPractise {
    public static void main(String[] args) {
        try (ScheduledExecutorService service = Executors.newScheduledThreadPool(3)) {
            service.schedule(new Task(1), 1000, TimeUnit.MILLISECONDS);
            service.scheduleAtFixedRate(new Task(2), 2000, 3000, TimeUnit.MILLISECONDS);
            service.scheduleWithFixedDelay(new Task(3), 1000, 2000, TimeUnit.MILLISECONDS);

            try {
                if(!service.awaitTermination(20000, TimeUnit.MILLISECONDS)) {
                    service.shutdownNow();
                }
            } catch (InterruptedException e) {
                service.shutdownNow();
            }
        }
    }
}
