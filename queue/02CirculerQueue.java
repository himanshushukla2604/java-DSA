class QueueY {
    public static class Queue {
        static int[] arr;
        static int size;
        static int rare = -1;
        static int front = -1;

        Queue(int n) {
            arr = new int[n];
            size = n;
        }

        public static boolean isEmpty() {
            return rare == -1 && front == -1;
        }

        public static void add(int data) {
            if ((rare + 1) % size == front) {
                System.out.println("Queue is full");
                return;
            }

            rare = (rare + 1) % size;
            if (front == -1) {
                front = 0;
            }
            arr[rare] = data;
        }

        public static int remove() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }

            if (rare == front) {
                rare = front = -1;
                return -1;
            } else {
                front = (front + 1) % size;
            }
            // int val = arr[front];
            return arr[front];
        }

        public static int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return arr[front];
        }

    }

    public static void main(String[] args) {
        Queue queue = new Queue(5);
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        System.out.println(queue.remove());
        queue.add(50);
        queue.add(60);
        System.out.println(queue.remove());
        queue.add(70);
        queue.add(80);
        System.out.println(queue.remove());
        queue.add(90);
        System.out.println(queue.remove());
        queue.add(100);

        System.out.println(queue.peek());
        while (!queue.isEmpty()) {
            System.out.print(queue.remove() + " ");
        }
    }
}