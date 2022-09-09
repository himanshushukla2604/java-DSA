class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Creation {
    public Node head;
    public Node temp;
    public Node ttemp;
    public Node p;

    public void add(int data) {
        if (head == null) {
            head = new Node(data);
            temp = ttemp = head;
        } else {
            temp = ttemp = head;
            while (ttemp.next != null) {
                ttemp = ttemp.next;
            }

            temp = new Node(data);
            ttemp.next = temp;
        }

    }

    public void treversel() {
        p = head;
        if (head == null)
            return;
        else {
            while (p != null) {
                System.out.print(p.data + " ");
                p = p.next;
            }
        }
    }

    public void addonhead(int val) {
        p = new Node(val);
        p.next = head;
        head = p;
    }

    public void removehead() {
        if (head == null) {
            return;
        }
        p = head;
        head = head.next;
    }

    public void addList(Node l2head) {
        if (head == null) {
            head = l2head;
            return;
        }
        p = head;
        while (p.next != null) {
            p = p.next;
        }
        p.next = l2head;
    }

    public int find(int val) {
        if (head == null) {
            return -1;
        }

        int count = 0;
        p = head;
        while (p != null) {

            if (p.data == val) {
                return count;
            }
            p = p.next;
            ++count;
        }

        return -1;
    }

    public int length() {
        if (head == null) {
            return -1;
        }
        int count = 0;
        p = head;
        while (p != null) {
            ++count;
            p = p.next;
        }
        return count;
    }

    // public int BinaryFind(int val, int high, int low){
    // if(head == null){
    // return -1;
    // }
    // p = head;

    // int mid = high+low/2;

    // while(){

    // }

    // return -1;
    // }

    public void reverse() {
        if (head == null) {
            return;
        }

        temp = head;
        ttemp = temp.next;
        // if (ttemp.next == null) {

        // }
        while (ttemp != null) {
            p = temp;
            temp = ttemp;
            ttemp = ttemp.next;

            temp.next = p;

            // if (ttemp.next == null) {
            // ttemp.next = temp;
            // }
        }
        head.next = null;
        head = temp;
    }

    public static void main(String[] args) {
        Creation c = new Creation();

        c.add(23);
        c.add(34);
        c.add(45);
        c.add(67);
        c.add(78);
        c.addonhead(12);

        c.treversel();
        System.out.println();

        // another list
        Creation c1 = new Creation();
        c1.add(89);
        c1.add(90);
        c1.add(98);
        c1.add(99);
        c1.treversel();
        System.out.println();

        c.addList(c1.head);

        c.treversel();
        System.out.println();

        System.out.println(c.find(78));
        int lastIndex = c.length();
        // c.BinaryFind(78, lastIndex);
        c.reverse();
        c.treversel();
    }

}