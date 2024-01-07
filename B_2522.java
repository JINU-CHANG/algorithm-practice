import java.util.Scanner;

public class B_2522 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = N;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                printStar(j, K);
            }
            System.out.println();
            K--;
        }

        K = K+2;

        for (int i = N+1; i <= 2*N -1; i++) {
            for (int j = 1; j <= N; j++) {
                printStar(j, K);
            }
            System.out.println();
            K++;
        }
    }

    public static void printStar(int j, int K) {
        if (j >= K) {
            System.out.print("*");
        } else {
            System.out.print(" ");
        }
    }
}
