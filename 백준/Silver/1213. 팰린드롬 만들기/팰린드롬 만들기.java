import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static char[] palindrome;
    static int ansFlag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String name = br.readLine();
        palindrome = new char[name.length()];

        char[] nameArray = name.toCharArray();
        Arrays.sort(nameArray);

        if (nameArray.length % 2 == 0) {
            ansFlag = makeEvenPalindrome(nameArray);
        } else {
            ansFlag = makeOddPalindrome(nameArray);
        }

        if (ansFlag == 1) {
            System.out.println(String.valueOf(palindrome));
        } else {
            System.out.println("I'm Sorry Hansoo");
        }
    }

    private static int makeEvenPalindrome(char[] nameArray) {
        int count = 0;
        for (int i = 0; i <= nameArray.length - 2; i += 2) {
            if (nameArray[i] != nameArray[i + 1]) return -1;
            palindrome[count] = nameArray[i];
            palindrome[nameArray.length - 1 - count] = nameArray[i + 1];
            count++;
        }

        return 1;
    }

    private static int makeOddPalindrome(char[] nameArray) {
        int count = 0;
        for (int i = 0; i < nameArray.length; i++) {
            if (i == nameArray.length - 1 || (nameArray[i] != nameArray[i + 1])) {
                if (palindrome[nameArray.length / 2] != 0) return -1;
                palindrome[nameArray.length / 2] = nameArray[i];
                continue;
            }
            palindrome[count] = nameArray[i];
            palindrome[nameArray.length - 1 - count] = nameArray[i + 1];
            i++; count++;
        }

        return 1;
    }
}
