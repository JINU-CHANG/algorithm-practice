import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Matrix {
    long[][] arr;

    public Matrix(long[][] arr) {
        this.arr = arr;
    }
}

public class Main{

    static int n;
    static long b;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        b = Long.parseLong(st.nextToken());

        long[][] arr = new long[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Matrix matrix = new Matrix(arr);
        Matrix recursived = recursive(matrix, b);

        for (int i = 0; i < n; i++) {
            long[][] resultArr = recursived.arr;
            for (int j = 0; j < n; j++) {
                sb.append(resultArr[i][j] % 1000 + " ");
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static Matrix recursive(Matrix matrix, long b) {
        if (b == 1) return matrix;

        if (b % 2 == 0) {
            Matrix recursived = recursive(matrix, b / 2);
            return calculate(recursived.arr, recursived.arr);
        } else {
            Matrix recursived = recursive(matrix, (b - 1) / 2);
            return calculate(calculate(recursived.arr, recursived.arr).arr, matrix.arr);
        }
    }

    private static Matrix calculate(long[][] matrix1, long[][] matrix2) {
        long[][] nMatrix = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                long sum = 0;
                for (int k = 0; k < n; k++) {
                    //System.out.println(matrix1[i][k] + " * " + matrix2[k][j]);
                    sum += (matrix1[i][k] * matrix2[k][j]);
                    sum %= 1000;
                }

                nMatrix[i][j] = sum;
            }
        }

        return new Matrix(nMatrix);
    }
}
