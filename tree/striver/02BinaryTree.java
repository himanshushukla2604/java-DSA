import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.Stack;
import java.util.Iterator;

class BinaryTree {

    static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }

    public static List<List<Integer>> zigZakTreversal(Node root) {
        List<List<Integer>> result = new ArrayList<>();

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        boolean lefttoright = true;

        while (!queue.isEmpty()) {
            int size = queue.size();

            List<Integer> subarr = new ArrayList<>(size);
            // Collections.fill(subarr, 0);
            for (int i = 0; i < size; i++) {

                // add data in queue
                if (queue.peek().left != null)
                    queue.add(queue.peek().left);
                if (queue.peek().right != null)
                    queue.add(queue.peek().right);

                if (lefttoright)
                    subarr.add(queue.poll().val);// if we have to store from left to right. we will insert at the end

                else
                    subarr.add(0, queue.poll().val);// if we have to store from right to left.
                // we will insert at the beginning
            }
            result.add(subarr);
            lefttoright = !lefttoright;
        }
        return result;
    }

    // Find maximum path sum ---------------------------------------------------
    public static int maxPathSum(Node root) {
        int[] maxValue = new int[1];
        maxValue[0] = Integer.MIN_VALUE;
        maxPathDown(root, maxValue);
        return maxValue[0];
    }

    public static int maxPathDown(Node root, int[] maxValue) {
        if (root == null) {
            return 0;
        }
        int leftSum = Math.max(0, maxPathDown(root.left, maxValue));
        int rightSum = Math.max(0, maxPathDown(root.right, maxValue));

        maxValue[0] = Math.max(maxValue[0], (leftSum + rightSum + root.val));

        return Math.max(leftSum, rightSum) + root.val;
    }

    // ------------------------------------------------------------------------

    // Check Two trees are identical ------------------------
    public static boolean identicalTree(Node p, Node q) {
        if (p == null || q == null) {
            return (p == q);
        }

        return p.val == q.val && identicalTree(p.left, q.left) && identicalTree(q.right, q.right);
    }

    // -------------------------------------------------------
    // ------------------ Boundary traversal -----------------
    public static void boundaryTraversal(Node root) {
        List<Integer> ds = new ArrayList<>();
        ds.add(root.val);
        if (root.left != null)
            leftTreversal(root.left, ds);
        inOrder(root, ds);
        if (root.right != null) {
            rightRevTraverse(root.right, ds);
        }

        Iterator<Integer> itr = ds.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }

    public static void rightRevTraverse(Node root, List<Integer> ds) {
        Stack<Integer> stack = new Stack<>();

        while (root.left != null || root.right != null) {
            stack.push(root.val);
            if (root.right != null)
                root = root.right;
            else
                root = root.left;
        }

        while (!stack.isEmpty()) {
            ds.add(stack.pop());
        }
    }

    public static void inOrder(Node root, List<Integer> ds) {
        if (root.left == null && root.right == null) {
            ds.add(root.val);
            return;
        }
        inOrder(root.left, ds);
        inOrder(root.right, ds);
        return;
    }

    public static void leftTreversal(Node root, List<Integer> ds) {
        if (root.left == null && root.right == null)
            return;
        ds.add(root.val);
        if (root.left != null)
            leftTreversal(root.left, ds);
        else
            leftTreversal(root.right, ds);

        return;
    }

    public static void main(String[] args) {
        Node root = new Node(30);
        root.left = new Node(20);
        root.right = new Node(50);
        root.left.left = new Node(10);
        root.left.right = new Node(15);
        root.right.left = new Node(40);
        root.right.right = new Node(60);

        List<List<Integer>> zigzak = zigZakTreversal(root);
        Iterator<List<Integer>> ite = zigzak.iterator();
        while (ite.hasNext()) {
            List<Integer> arr = ite.next();
            Iterator<Integer> itr = arr.iterator();
            while (itr.hasNext()) {
                System.out.print(itr.next() + " ");
            }
            System.out.println();
        }

        System.out.println(maxPathSum(root));

        System.out.println(identicalTree(root.left, root.right));

        boundaryTraversal(root);
    }
}
