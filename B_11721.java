import java.util.Scanner;

public class B_11721 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();

        for(int i = 0; i < word.length(); i += 10) {
            if (i + 10 > word.length() - 1) {
                System.out.println(word.substring(i, word.length()));
                break;
            }
            System.out.println(word.substring(i, i + 10));
        }
    }
}
