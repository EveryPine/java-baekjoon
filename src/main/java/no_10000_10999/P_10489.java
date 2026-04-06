package no_10000_10999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class P_10489 {

    static BufferedReader bufferedReader;
    static BufferedWriter bufferedWriter;
    static int n;
    static List<Integer> numbers;
    static List<Integer> stack;

    public static void main(String[] args) throws IOException {
        initIO();
        n = Integer.parseInt(bufferedReader.readLine());
        numbers = Arrays.stream(bufferedReader.readLine().split(" "))
            .map(Integer::parseInt)
            .collect(Collectors.toUnmodifiableList());
        stack = new ArrayList<>();
        process();
        print(stack.size());

        bufferedWriter.close();
    }

    static void initIO() {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    static <T> void print(T data) throws IOException {
        bufferedWriter.write(data.toString());
        bufferedWriter.flush();
    }

    static void process() {
        int topNumber;
        for (int number: numbers) {
            if (stack.isEmpty()) {
                stack.add(number);
                continue;
            }
            topNumber = stack.get(stack.size() - 1);
            if ((number + topNumber) % 2 == 0) {
                stack.remove(stack.size() - 1);
                continue;
            }
            stack.add(number);
        }
    }
}
