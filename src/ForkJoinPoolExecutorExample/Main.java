package ForkJoinPoolExecutorExample;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        Future<Integer> result = forkJoinPool.submit(new ComputeSum(0, 5));
        System.out.println(result.get());
    }
}
