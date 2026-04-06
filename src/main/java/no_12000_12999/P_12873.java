package no_12000_12999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P_12873 {

    static BufferedReader bufferedReader;
    static BufferedWriter bufferedWriter;
    static int n;
    static Deque<Integer> queue;

    public static void main(String[] args) throws IOException {
        initIO();
        n = Integer.parseInt(bufferedReader.readLine());
        queue = IntStream.rangeClosed(1, n).boxed()
            .collect(Collectors.toCollection(LinkedList::new));

        for (int t = 1; t <= n - 1; t++) {
            step(t);
        }

        print(queue.getFirst());
    }

    static void step(int t) {
        long k = (long) (Math.pow(t, 3) - 1) % queue.size();

        for (int i = 0; i < k; i++) {
            int temp = queue.removeFirst();
            queue.addLast(temp);
        }
        queue.removeFirst();
    }

    static void initIO() {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    static <T> void print(T data) throws IOException {
        bufferedWriter.write(data.toString());
        bufferedWriter.flush();
    }

}
