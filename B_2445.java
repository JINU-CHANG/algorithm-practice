import java.util.Scanner;

public class B_2445 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= (2*N); j++) {
                if (j <= i || j >= (2*N) - i+1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        for (int i = N+1; i <= (2*N); i++) {
            for (int j = 1; j <= (2*N); j++){
                if ((j <= (2*N-i) || j >= i+1)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
