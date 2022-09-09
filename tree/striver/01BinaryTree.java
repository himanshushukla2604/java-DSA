import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;
import java.math.*;;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

}

class BinaryTree {

    public static void preOrder(Node root) {
        if (root == null)
            return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);

    }

    public static void inOrder(Node root) {
        if (root == null)
            return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void postOrder(Node root) {
        if (root == null)
            return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");

    }

    // if we need to return then we can make arrayList of arraylist and than can
    // return it
    public static void levelOrderTreversal(Node root) {
        if (root == null)
            return;
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int qsize = queue.size();
            for (int i = 0; i < qsize; i++) {
                System.out.print(queue.peek().data + " ");
                if (queue.peek().left != null)
                    queue.offer(queue.peek().left);
                if (queue.peek().right != null)
                    queue.offer(queue.peek().right);
                queue.poll();
            }
            System.out.println();
        }
    }
    
    // itrativePreOrder of tree -----------------------
    public static void itrativePreOrder(Node root) {
        Stack<Node> stack = new Stack<Node>();

        if (root == null)
            return;
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            // int stackSize = stack.size();
            System.out.print(root.data + " ");
            if (root.right != null)
                stack.push(root.right);
            if (root.left != null)
                stack.push(root.left);

            // System.out.println();
        }
        System.out.println();
    }

    // Itrative inOrder of the tree -------------------------------------------
    public static void itrativeInOrder(Node root) {
        if (root == null)
            return;
        Node node = root;
        Stack<Node> stack = new Stack<Node>();
        while (true) {
            // System.out.println("Here we go");
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                if (stack.isEmpty())
                    break;
                // System.out.println(stack.pop());
                node = stack.pop();
                System.out.print(node.data + " ");
                node = node.right;
            }
        }
        System.out.println();
    }

    // Itrative Post Order Using 2 stacks ---------------------------------
    public static void itrativePostOrder2Stacks(Node root) {
        if (root == null)
            return;
        // Node node = root;
        Stack<Node> st1 = new Stack<Node>();
        Stack<Node> st2 = new Stack<Node>();
        // System.out.println(root.data);
        st1.push(root);
        while (!st1.isEmpty()) {
            root = st1.pop();
            st2.push(root);
            if (root.left != null)
                st1.push(root.left);
            if (root.right != null)
                st1.push(root.right);

        }

        while (!st2.isEmpty()) {
            System.out.print(st2.pop().data + " ");
        }

    }

    // Itrative Post Order Using one stack
    public static void itrativePostOrder1Stack(Node root) {
        if (root == null)
            return;

        Stack<Node> stack = new Stack<Node>();
        Node curr = root;
        Node temp = root;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {// if root left is not null
                stack.push(curr);
                curr = curr.left;

            } else {
                temp = stack.peek().right;
                if (temp == null) {
                    temp = stack.peek();// pop out the element// stack top assinged to temp
                    stack.pop();
                    System.out.print(temp.data + " ");// print the data
                    while (!stack.isEmpty() && temp == stack.peek().right) {// this is loop for handling the node whose
                                                                            // // left and right are visited but not
                                                                            // null
                        temp = stack.pop();
                        System.out.print(temp.data + " ");
                    }
                } else {
                    curr = temp;
                }
            }
        }
        System.out.println();
    }

    // Height of the tree -------------------------------------
    public static int hightOfTree(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(hightOfTree(root.left), hightOfTree(root.right));
    }

    // Check Tree is balenced or not ---------------------------------------------
    public static int balenceCheck(Node root) {
        if (root == null) {
            return 0;
        }
        int lefthight = balenceCheck(root.left);
        if (lefthight == -1)
            return -1;
        int righthight = balenceCheck(root.right);
        if (righthight == -1)
            return -1;

        if (Math.abs(lefthight - righthight) > 1) {
            return -1;
        }

        return Math.max(lefthight, righthight);
    }

    // Diameter Of The Tree ------------------------------------------
    public static int diameterOfTree(Node root, int[] diameter) {
        if (root == null)
            return 0;
        int leftHeight = diameterOfTree(root.left, diameter);
        int rightHeight = diameterOfTree(root.right, diameter);

        diameter[0] = Math.max(diameter[0], leftHeight + rightHeight);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(12);
        root.right = new Node(9);
        root.left.left = new Node(23);
        root.left.right = new Node(45);
        root.right.left = new Node(56);
        root.right.right = new Node(67);
        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);
        System.out.println();
        levelOrderTreversal(root);
        itrativePreOrder(root);
        itrativeInOrder(root);
        itrativePostOrder2Stacks(root);
        System.out.println();
        itrativePostOrder1Stack(root);

        System.out.println(hightOfTree(root));

        if (balenceCheck(root) != -1) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }

        int[] diameter = new int[1];
        System.out.println(diameterOfTree(root, diameter));
    }
}