package no_4000_4999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class P_4889 {

    static BufferedReader bufferedReader;
    static BufferedWriter bufferedWriter;
    static int index;
    static int openCount;
    static int closeCount;
    static String input;
    static char current;
    static List<Character> stack;

    public static void main(String[] args) throws IOException {
        initIO();
        index = 1;
        input = bufferedReader.readLine();
        while (!input.contains("-")) {
            print(String.format("%d. %d\n", index, getAnswer()));
            index++;
            input = bufferedReader.readLine();
        }
    }

    static int getAnswer() {
        int answer = 0;
        stack = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            current = input.charAt(i);
            if (!stack.isEmpty() && isPair(getLast(stack), current)) {
                removeLast(stack);
            } else {
                stack.add(current);
            }
        }
        openCount = 0;
        closeCount = 0;
        for (char c : stack) {
            if (c == '{') {
                openCount++;
            } else {
                closeCount++;
            }
        }

        return openCount / 2 + openCount % 2 + closeCount / 2 + closeCount % 2;
    }

    static boolean isPair(char c1, char c2) {
        return c1 == '{' && c2 == '}';
    }

    static <T> T getLast(List<T> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return list.get(list.size() - 1);
    }

    static <T> T removeLast(List<T> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return list.remove(list.size() - 1);
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
