import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[] count = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    static String[] cards;
    static int ans = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        cards = new String[5];
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char color = st.nextToken().charAt(0);
            char num = st.nextToken().charAt(0);
            int numInt = num - '0';

            count[numInt]  = count[numInt] + 1;
            cards[i] = "" + color + num;
        }

        ans = Math.max(ans, solve1());
        ans = Math.max(ans, solve2());
        ans = Math.max(ans, solve3());
        ans = Math.max(ans, solve4());
        ans = Math.max(ans, solve5());
        ans = Math.max(ans, solve6());
        ans = Math.max(ans, solve7());
        ans = Math.max(ans, solve8());
        ans = Math.max(ans, solve9());

        System.out.println(ans);
    }

    public static int solve1() {
        Arrays.sort(cards, (o1, o2) -> o1.charAt(1) - o2.charAt(1));
        char color = cards[0].charAt(0);
        int number = cards[0].charAt(1) - '0' - 1;

        for (String card : cards) {
            if (card.charAt(0) != color || card.charAt(1) - '0' != number + 1) return -1;
            number++;
        }

        return 900 + number;
    }

    public static int solve2() {
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 4) return 800 + i;
        }

        return -1;
    }

    public static int solve3() {
        int threeSameNum = 0;
        boolean threeSame = false;
        int twoSameNum = 0;
        boolean twoSame = false;

        for (int i = 0; i < count.length; i++) {
            if (count[i] == 3) {
                threeSameNum = i;
                threeSame = true;
            }
            if (count[i] == 2) {
                twoSameNum = i;
                twoSame = true;
            }
        }

        if (threeSame && twoSame) return (threeSameNum * 10) + (twoSameNum) + 700;
        return -1;
    }

    public static int solve4() {
        char color = cards[0].charAt(0);
        for (String card : cards) {
            if (card.charAt(0) != color) return -1;
        }

        return cards[cards.length - 1].charAt(1) - '0' + 600;
    }

    public static int solve5() {
        Arrays.sort(cards, (o1, o2) -> o1.charAt(1) - o2.charAt(1));

        int number = cards[0].charAt(1) - '0' - 1;
        for (String card : cards) {
            if (card.charAt(1) - '0' != number + 1) return -1;
            number++;
        }

        return 500 + cards[cards.length - 1].charAt(1) - '0';
    }

    public static int solve6() {
        int threeSameNum = 0;
        boolean threeSame = false;

        for (int i = 0; i < count.length; i++) {
            if (count[i] == 3) {
                threeSameNum = i;
                threeSame = true;
            }
        }

        if (threeSame) return 400 + threeSameNum;
        return -1;
    }

    public static int solve7() {
        List<Integer> twoSameNum = new ArrayList<>();

        for (int i = 0; i < count.length; i++) {
            if (count[i] == 2) {
                twoSameNum.add(i);
            }
        }

        if (twoSameNum.size() == 2) return (twoSameNum.get(1) * 10) + (twoSameNum.get(0)) + 300;
        return -1;
    }

    public static int solve8() {
        int twoSameNum = 0;
        boolean twoSame = false;

        for (int i = 0; i < count.length; i++) {
            if (count[i] == 2) {
                twoSameNum = i;
                twoSame = true;
            }
        }

        if (twoSame) return twoSameNum + 200;
        return -1;
    }

    public static int solve9() {
        Arrays.sort(cards, (o1, o2) -> o1.charAt(1) - o2.charAt(1));
        return cards[cards.length - 1].charAt(1) - '0' + 100;
    }
}
