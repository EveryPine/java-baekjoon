package no_10000_10999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class P_10799 {

    static BufferedReader bufferedReader;
    static BufferedWriter bufferedWriter;

    static String input;
    static List<String> stack;

    public static void main(String[] args) throws IOException {
        initIO();
        input = bufferedReader.readLine();

        print(getAnswer());

    }

    static int getAnswer() {
        int answer = 0;
        String[] splitted = input.split("");
        stack = new ArrayList<>();

        for (int i = 0; i < splitted.length; i++) {
            // 새로운 막대기 추가
            if (Objects.equals(splitted[i], "(")) {
                stack.add(splitted[i]);
            } else {
                // '()'인 경우 (레이저인 경우) -> 누적 막대기 개수만큼 조각 개수 추가
                if (Objects.equals(splitted[i - 1], "(")) {
                    answer += stack.size() - 1;
                } else { // 한 막대기 끝 도달 -> 조각 개수 1 추가
                    answer++;
                }
                stack.remove(stack.size() - 1);
            }
        }

        return answer;
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
