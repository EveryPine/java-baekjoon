package no_17000_17999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

class Assignment {

    private int score;
    private int time;
    private boolean received = false;

    private Assignment(int score, int time) {
        this.score = score;
        this.time = time;
    }

    public static Assignment of(String rawAssignment) {
        String[] splitted = rawAssignment.split(" ");

        return new Assignment(
            Integer.parseInt(splitted[1]),
            Integer.parseInt(splitted[2]));
    }

    public static Assignment from(int score, int time) {
        return new Assignment(score, time);
    }

    public int getScore() {
        if (received) {
            return 0;
        }
        received = true;
        return score;
    }

    public void carryOut() {
        if (time > 0) {
            time--;
        }
    }

    public boolean isCarriedOut() {
        return time == 0;
    }
}

public class P_17952 {

    static BufferedReader bufferedReader;
    static BufferedWriter bufferedWriter;

    static int n;
    static int answer = 0;
    static Assignment currentAssignment = Assignment.from(0, 0);
    static List<Assignment> stack = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        initIO();
        n = Integer.parseInt(bufferedReader.readLine());
        handleAssignment();
        print(answer);

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

    static void handleAssignment() throws IOException {
        for (int i = 0; i < n; i++) {
            String rawAssignment = bufferedReader.readLine();
            if (rawAssignment.charAt(0) == '1') {
                acceptNewAssignment(rawAssignment);
            } else {
                acceptOldAssignment();
            }
            currentAssignment.carryOut();
            if (currentAssignment.isCarriedOut()) {
                answer += currentAssignment.getScore();
            }

        }
    }

    static void acceptNewAssignment(String rawAssignment) {
        if (!currentAssignment.isCarriedOut()) {
            stack.add(currentAssignment);
        }
        currentAssignment = Assignment.of(rawAssignment);
    }

    static void acceptOldAssignment() {
        if (currentAssignment.isCarriedOut() && !stack.isEmpty()) {
            currentAssignment = stack.remove(stack.size() - 1);
        }
    }


}
