import java.util.Scanner;

public class B_11022 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        for (int i=0; i<number; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            int C = A + B;

            System.out.printf("Case #%d: %d + %d = %d", i+1, A, B, C);
            System.out.println();
        }
    }
}
