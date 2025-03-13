import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Set<Character> set = Set.of('a', 'e', 'i', 'o', 'u');

        while (true) {
            String s = br.readLine();

            if (s.equals("end")) break;

            boolean checkVowel = false;
            boolean threeVowel = false;
            boolean threeConstant = false;
            boolean twoWord = false;

            for (int i = 0; i < s.length(); i++) {

                int countVowels = 0;
                int countConstant = 0;
                char before = ' ';

                for (int j = i; j < i + 3 && j < s.length(); j++) {
                    char current = s.charAt(j);

                    if (set.contains(current)) {
                        checkVowel = true;
                        countVowels++;
                    } else {
                        countConstant++;
                    }

                    if (before == current && !((before == 'e' && current == 'e')
                            || (before == 'o' && current == 'o'))) {
                        twoWord = true;
                    }

                    if (countConstant == 3) threeConstant = true;
                    if (countVowels == 3) threeVowel = true;

                    before = current;
                }

            }

            if (!checkVowel || threeVowel || threeConstant || twoWord) sb.append("<").append(s).append(">").append(" is not acceptable.").append("\n");
            else sb.append("<").append(s).append(">").append(" is acceptable.").append("\n");
        }

        System.out.println(sb);
    }

}
