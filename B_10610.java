import java.util.Arrays;
import java.util.Scanner;

/**
 * 1. 3의 배수는 각 자릿수의 합이 3의 배수여야 한다.
 * 2. 자릿수가 10^5인것과 100000까지의 수를 입력할 수 있는 것은 서로 다른 개념이다.
 */
public class B_10610 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num = sc.next();

        if (!checkMultiplesOfThirty(num)) {
            System.out.println(-1);
        } else {
            System.out.println(convertToMaxNum(num));
        }
    }

    private static boolean checkMultiplesOfThirty(String num) {
        if (num.contains("0") && calculateSum(num) % 3 == 0) {
            return true;
        }
        return false;
    }

    private static int calculateSum(String num) {
        int total = 0;
        for(int i=0; i<num.length(); i++) {
            total += num.charAt(i) - '0';
        }
        return total;
    }

    private static String convertToMaxNum(String num) {
        char[] charArray = num.toCharArray();
        Arrays.sort(charArray);

        StringBuilder sb = new StringBuilder();

        for(int i=charArray.length-1; i>=0; i--) {
            sb.append(charArray[i]);
        }
        return sb.toString();
    }
}
