package ForkJoinPoolExecutorExample;

import java.util.concurrent.RecursiveTask;

public class ComputeSum extends RecursiveTask<Integer> {
    private final int start;
    private final int end;

    public ComputeSum(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if ((end - start) <= 3) {
            int totalSum = 0;
            for (int i = start; i <= end; i++) totalSum += i;
            return totalSum;
        }
        int mid = (start + (end - start) / 2);

        ComputeSum left = new ComputeSum(start, mid);
        ComputeSum right = new ComputeSum(mid + 1, end);

        // Forking the subtasks for parallel execution
        left.fork();
        right.fork();

        // Combining the results of the subtasks
        int leftSum = left.join();
        int rightSum = right.join();

        return leftSum + rightSum;
    }
}
