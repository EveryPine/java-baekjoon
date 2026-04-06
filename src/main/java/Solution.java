import java.util.*;
import java.util.function.Function;

class Solution {

    static int MINIMUM_ID_LENGTH = 3;
    static int MAXIMUM_ID_LENGTH = 15;

    public String solution(String new_id) {
        String answer = "";
        answer = new_id;

        // step 6을 진행한 이후, 마침표 제거가 필요하므로 step 4 다시 실행
        List<Function<String, String>> steps = List.of(
            this::step1, this::step2, this::step3, this::step4,
            this::step5, this::step6, this::step4, this::step7);

        for (Function<String, String> step: steps) {
            answer = step.apply(answer);
        }

        return answer;
    }

    // step 1: 대문자 -> 소문자
    String step1(String string) {
        return string.toLowerCase();
    }

    // step 2: 알파벳 소문자, 숫자, 일부 특수문자(-, _, .)를 제외한 모든 문자 제거
    String step2(String string) {
        String filterRegex = "[^a-z0-9-_.]";
        return string.replaceAll(filterRegex, "");
    }

    // step 3: 여러 마침표(.)를 하나의 마침표로 축약
    String step3(String string) {
        String filterRegex = "\\.+";
        return string.replaceAll(filterRegex, ".");
    }

    // step 4: 처음이나 끝에 위치한 마침표 제거
    String step4(String string) {
        StringBuilder sb = new StringBuilder(string);
        if (sb.length() > 0 && sb.charAt(0) == '.') {
            sb.deleteCharAt(0);
        }
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '.') {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    // step 5: 빈 문자열인 경우, "a"로 변경
    String step5(String string) {
        if (string.isEmpty()) {
            return "a";
        }
        return string;
    }

    // step 6: 문자열 길이를 15자 이내로 제한
    String step6(String string) {
        if (string.length() > MAXIMUM_ID_LENGTH) {
            return string.substring(0, MAXIMUM_ID_LENGTH);
        }
        return string;
    }

    // step 7: 문자열 길이가 3자 미만인 경우, 마지막 문자를 반복하여 3자로 조정
    String step7(String string) {
        StringBuilder sb = new StringBuilder(string);
        String lastChar = string.substring(string.length() - 1);
        while (sb.length() < MINIMUM_ID_LENGTH) {
            sb.append(lastChar);
        }

        return sb.toString();
    }
}