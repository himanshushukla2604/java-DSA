import java.util.LinkedList;
import java.util.Queue;

class BinaryTreeRevsion {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static int idx = -1;

    public static Node buildTree(int[] nodes) {
        idx++;
        if (nodes[idx] == -1) {
            return null;
        }

        Node newNode = new Node(nodes[idx]);
        newNode.left = buildTree(nodes);
        newNode.right = buildTree(nodes);
        return newNode;
    }

    public static void PreOrderTraversal(Node root) {

        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        PreOrderTraversal(root.left);
        PreOrderTraversal(root.right);

    }

    public static void PostOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        PostOrderTraversal(root.left);
        PostOrderTraversal(root.right);
        System.out.print(root.data + " ");
    }

    public static void InOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        InOrderTraversal(root.left);
        System.out.print(root.data + " ");
        InOrderTraversal(root.right);
    }

    public static void LevelOrderTraversal(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        queue.add(null);

        while (!queue.isEmpty()) {
            Node currNode = queue.remove();
            if (currNode == null) {
                System.out.println();
                if (queue.isEmpty())
                    break;
                else
                    queue.add(null);
            } else {
                System.out.print(currNode.data);
                if (currNode.left != null)
                    queue.add(currNode.left);
                if (currNode.right != null)
                    queue.add(currNode.right);
            }
        }
    }

    // total number of nodes in the tree

    static int totalNodeCount(Node root) {
        if (root == null)
            return 0;

        return 1 + totalNodeCount(root.left) + totalNodeCount(root.right);
    }

    
    public static void main(String[] args) {
        int[] arr = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        Node root = buildTree(arr);

        PreOrderTraversal(root);
        System.out.println("Post Order Traversal :");
        PostOrderTraversal(root);
        System.out.println("InOrder Traversal :");
        InOrderTraversal(root);

        System.out.println("LevelOrder Traversal : ");
        LevelOrderTraversal(root);

        System.out.println("Total Number of Nodes : " + totalNodeCount(root));

    }
}