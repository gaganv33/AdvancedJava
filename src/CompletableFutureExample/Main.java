package CompletableFutureExample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<List<Integer>> allValues = CompletableFuture.supplyAsync(() -> {
            List<Integer> arrayList = new ArrayList<>();
            for (int i = 0; i < 20; i++) {
                arrayList.add(i);
            }
            return arrayList;
        });

        CompletableFuture<List<Integer>> evenValues = allValues.thenComposeAsync((arrayList) -> CompletableFuture.supplyAsync(() -> {
            List<Integer> v = new ArrayList<>();
            for (var x : arrayList) {
                if (x % 2 == 0) v.add(x);
            }
            return v;
        }));

        CompletableFuture<List<Integer>> oddValues = allValues.thenComposeAsync((arrayList) -> CompletableFuture.supplyAsync(() -> {
            List<Integer> v = new ArrayList<>();
            for (var x : arrayList) {
                if (x % 2 == 1) v.add(x);
            }
            return v;
        }));

        CompletableFuture<List<Integer>> combinedValues = evenValues.thenCombineAsync(oddValues, (evenArrayList, oddArrayList) -> {
            int n = evenArrayList.size();
            int m = oddArrayList.size();
            int i = 0;
            int j = 0;
            List<Integer> v = new ArrayList<>();
            boolean isEvenTurn = false;
            while (i < n && j < m) {
                if (isEvenTurn) v.add(evenArrayList.get(i++));
                else v.add(oddArrayList.get(j++));
                isEvenTurn = !isEvenTurn;
            }
            while (i < n) v.add(evenArrayList.get(i++));
            while (j < m) v.add(oddArrayList.get(j++));
            return v;
        });

        CompletableFuture<Void> result = combinedValues.thenApplyAsync((arrayList) -> {
            List<Integer> v = new ArrayList<>(arrayList);
            Collections.reverse(v);
            System.out.print("Calling thenApplyAsync: ");
            System.out.println(v);
            return v;
        }).thenAccept((arrayList) -> {
            System.out.print("Calling thenAccept method: ");
            System.out.println(arrayList);
        });

        System.out.println(evenValues.get());
        System.out.println(oddValues.get());
        System.out.println(combinedValues.get());
    }
}
