class StackLinkedList {
    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static class Stack {
        public static Node head;

        public static boolean isEmpty() {
            if (head == null) {
                return true;
            }
            return false;
        }

        public static void push(int data) {
            if (isEmpty()) {
                head = new Node(data);
            } else {
                Node temp = new Node(data);
                temp.next = head;
                head = temp;
            }
        }

        public static int pop() {
            if (isEmpty()) {
                return -1;
            }
            int data = head.data;
            head = head.next;
            return data;
        }

        public static int peek() {
            if (isEmpty()) {
                return -1;
            }
            return head.data;
        }

    }

    public static void main(String[] args) {
        Stack st = new Stack();
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);
        st.push(50);
        insertAtBottom(60, st);
        reverse(st);
        System.out.println(st.peek());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());

    }

    public static void insertAtBottom(int data, Stack st) {
        if (st.isEmpty()) {
            st.push(data);
            return;
        }

        int val = st.pop();
        insertAtBottom(data, st);
        st.push(val);
    }

    public static void reverse(Stack st) {
        if (st.isEmpty()) {
            return;
        }
        int top = st.pop();
        reverse(st);
        insertAtBottom(top, st);
    }
}