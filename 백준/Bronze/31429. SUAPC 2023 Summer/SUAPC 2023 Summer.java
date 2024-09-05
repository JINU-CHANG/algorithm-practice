import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = {1600, 894, 1327, 1311, 1004, 1178, 1357, 837, 1055, 556, 773};
        int[] arr2 = {12, 11, 11, 10, 9, 9, 9, 8, 7, 6, 6};

        int num = arr[n - 1];
        int p = arr2[n - 1];
        System.out.print(p + " " + num );
    }
}

