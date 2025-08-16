import java.io.BufferedReader;
import java.io.InputStreamReader;

class Node {
    int num;
    Node left;
    Node right;

    public Node(int num, Node left, Node right) {
        this.num = num;
        this.left = left;
        this.right = right;
    }

    public void addNode(Node node) {
        if (this.num > node.num) {
            if (this.left == null) this.left = node;
            else this.left.addNode(node);
        } else {
            if (this.right == null) this.right = node;
            else this.right.addNode(node);
        }
    }
}

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        Node root = new Node(Integer.parseInt(br.readLine()), null, null);

        while ((str = br.readLine()) != null) {
            int x = Integer.parseInt(str);
            root.addNode(new Node(x, null, null));
        }

        postOrder(root);
    }

    public static void postOrder(Node node) {
        if (node.left != null) postOrder(node.left);
        if (node.right != null) postOrder(node.right);
        System.out.println(node.num);
    }
}
