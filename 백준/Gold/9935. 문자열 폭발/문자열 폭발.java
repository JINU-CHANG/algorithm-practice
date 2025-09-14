import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    static String word;
    static String bombWord;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        word = br.readLine();
        bombWord = br.readLine();

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < word.length(); i++) {
            stack.push(word.charAt(i));

            while (stack.size() >= bombWord.length() && stack.peek() == bombWord.charAt(bombWord.length() - 1)) {
                boolean check = true;
                int lastIndex = stack.size() - 1;
                for (int j = 0; j < bombWord.length(); j++) {
                    if (lastIndex - (bombWord.length() - j) + 1 < 0 || (stack.get(lastIndex - (bombWord.length() - j) + 1) != bombWord.charAt(j))) {
                        check = false;
                        break;
                    }
                }

                if (check) {
                    for (int j = 0; j < bombWord.length(); j++) stack.pop();
                } else{
                    break;
                }
            }
        }

        for (int i = 0; i < stack.size(); i++) {
            sb.append(stack.get(i));
        }

        if (stack.isEmpty()) {
            System.out.println("FRULA");
        } else {
            System.out.println(sb);
        }
    }
}
