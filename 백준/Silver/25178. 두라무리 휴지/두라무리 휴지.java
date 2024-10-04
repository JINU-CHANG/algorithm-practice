import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String first = br.readLine();
        String second = br.readLine();
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));


        if (isConsistOfSameWord(first, second)
                && isFirstAndLastWordSame(first, second)
                && isSameWordWithoutVowels(first, second, vowels)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static boolean isConsistOfSameWord(String first, String second) {
        char[] firstCharArray = first.toCharArray();
        char[] secondCharArray = second.toCharArray();
        Arrays.sort(firstCharArray);
        Arrays.sort(secondCharArray);

        return Arrays.equals(firstCharArray, secondCharArray);
    }

    private static boolean isFirstAndLastWordSame(String first, String second) {
        boolean firstWordSame = first.charAt(0) == second.charAt(0);
        boolean lastWordSame = first.charAt(first.length() - 1) == second.charAt(second.length() - 1);

        return firstWordSame && lastWordSame;
    }

    private static boolean isSameWordWithoutVowels(String first, String second, Set<Character> vowels) {
        StringBuilder firstString = new StringBuilder();
        StringBuilder secondString = new StringBuilder();

        for (int i = 0; i < first.length(); i++) {
            if (!vowels.contains(first.charAt(i))) {
                firstString.append(first.charAt(i));
            }

            if (!vowels.contains(second.charAt(i))) {
                secondString.append(second.charAt(i));
            }
        }

        return firstString.toString().equals(secondString.toString());
    }
}
