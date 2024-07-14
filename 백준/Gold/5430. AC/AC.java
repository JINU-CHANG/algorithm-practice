import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String functions = br.readLine();
            int n = Integer.parseInt(br.readLine());

            Deque<Integer> deque = readNumbers();

            if (checkError(functions, deque.size())) {
                sb.append("error\n");
            } else {
                startFunction(functions, deque);
            }
        }

        System.out.print(sb);
    }

    public static Deque<Integer> readNumbers() throws IOException {
        Deque<Integer> deque = new LinkedList<>();

        String stringNumbers = br.readLine();
        String[] arrayNumbers = stringNumbers
                .substring(1, stringNumbers.length() - 1)
                .split(",");

        for (String arrayNumber : arrayNumbers) {
            if (arrayNumber.isBlank()) {
                return deque;
            }
            deque.add(Integer.parseInt(arrayNumber));
        }

        return deque;
    }

    public static boolean checkError(String functions, int numbersSize) {
        int sum = 0;
        for (int i = 0; i < functions.length(); i++) {
            if (functions.charAt(i) == 'D') {
                sum++;
            }
        }
        return sum > numbersSize;
    }

    public static void startFunction(String functions, Deque<Integer> deque) {
        boolean front = true;

        for (int i = 0; i < functions.length(); i++) {
            char function = functions.charAt(i);

            if (function == 'R') {
                front = !front;
            }

            if (function == 'D') {
                if (front) {
                    deque.removeFirst();
                } else {
                    deque.removeLast();
                }
            }
        }

        printNumbers(deque, front);
    }

    public static void printNumbers(Deque<Integer> deque, boolean front) {
        sb.append("[");

        while(!deque.isEmpty()) {
            if (front) {
                sb.append(deque.pop());
            } else {
                sb.append(deque.removeLast());
            }

            if (!deque.isEmpty()) {
                sb.append(",");
            }
        }

        sb.append("]\n");
    }
}

