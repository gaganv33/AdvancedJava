package Concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolExecutorPractise {
    public static void main(String[] args) {
        try (ExecutorService service = Executors.newFixedThreadPool(3)) {
            for(int i = 0; i < 10; i++)
                service.execute(new Task(i + 1));
        }
    }
}
