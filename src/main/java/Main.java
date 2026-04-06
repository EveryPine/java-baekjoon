import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        String pattern = bufferedReader.readLine();
        String prefix = pattern.split("\\*")[0];
        String suffix = pattern.split("\\*")[1];

        for (int i = 0; i < n; i++) {
            String filename = bufferedReader.readLine();
            if (isMatched(filename, prefix, suffix)) {
                System.out.println("DA");
            } else {
                System.out.println("NE");
            }
        }
    }

    static boolean isMatched(String filename, String prefix, String suffix) {
        if (filename.length() < prefix.length() + suffix.length()) {
            return false;
        }
        return filename.startsWith(prefix) && filename.endsWith(suffix);
    }
}
