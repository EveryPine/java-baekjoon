package no_1000_1999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P_1012 {

    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer stringTokenizer;

    static int t, m, n, k, x, y;
    static boolean[][] farm;

    public static void main(String[] args) throws IOException {
        t = Integer.parseInt(bufferedReader.readLine());

        while (t-- != 0) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            n = Integer.parseInt(stringTokenizer.nextToken());
            m = Integer.parseInt(stringTokenizer.nextToken());
            k = Integer.parseInt(stringTokenizer.nextToken());
            initFarm();
        }
    }

    static void initFarm() {
        farm = new boolean[m][n];
        while (k-- != 0) {
            stringTokenizer.
        }
    }

    static <T> void print(T data) throws IOException {
        bufferedWriter.write(data.toString());
        bufferedWriter.flush();
    }

}
