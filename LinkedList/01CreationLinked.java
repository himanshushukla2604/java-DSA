class Node {
    int data;
    Node next;

    Node(int val) {
        data = val;
        next = null;
    }

}

class implement {
    public static Node head;
    public static Node temp;
    public static Node ttemp;
    public static Node p;

    public void add(int val) {
        if (head == null) {
            head = new Node(val);
            p = ttemp = head;
        } else {
            temp = new Node(val);
            ttemp.next = temp;
            ttemp = temp;
        }
    }

    

    public void treverse() {
        while (p.next != null) {
            System.out.println(p.data);
            p = p.next;
        }
    }

    public static void main(String[] args) {
        implement li = new implement();
        // ---------------------------------------
        li.add(12);
        li.add(34);
        li.add(45);
        li.add(56);
        li.add(78);
        // ---------------------------------------
        li.treverse();

    }
}