class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Creation03 {
    public static Node head;

    public static void newNode(int val) {
        if (head == null) {
            head = new Node(val);
            return;
        }

        Node curr = head;

        while (curr.next != null) {
            curr = curr.next;
        }

        curr.next = new Node(val);
    }

    public static void treversal(Node head) {
        Node curr = head;
        if (head == null) {
            return;
        }

        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();

    }

    public static void reverseList() {
        if (head == null || head.next == null) {
            return;
        }
        Node temp;
        Node ttemp;
        Node p;

        temp = head;
        p = temp;
        ttemp = temp.next;

        while (ttemp.next != null) {
            if (temp == head) {
                temp.next = null;
            }
            temp = ttemp;
            ttemp = ttemp.next;
            temp.next = p;
            p = temp;
        }
        if (ttemp.next == null) {
            ttemp.next = temp;
            temp = ttemp;
        }
        head = temp;

    }

    public static void main(String[] args) {
        newNode(12);
        newNode(13);
        newNode(14);
        newNode(45);
        newNode(56);

        treversal(head);
        reverseList();
        treversal(head);
        // System.out.println(head.data);
    }
}