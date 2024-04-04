import java.util.Scanner;

public class Main {

    public static void main(final String[] args) {
        final Scanner sc = new Scanner(System.in);
        final String tmp = "1 2 ";
        final StringBuilder st = new StringBuilder();

        final int num = sc.nextInt();

        for (int i = 0; i < (num/2); i++) {
            st.append(tmp);
        }

        if (num%2!=0) {
            st.append("3");
        }

        System.out.println(st.toString());
    }
}
