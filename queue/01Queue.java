class QueueY {
    public static class Queue {
        static int[] arr;
        static int size;
        static int rare = -1;

        Queue(int n) {
            arr = new int[n];
            size = n;
        }

        public static boolean isEmpty() {
            return rare == -1;
        }

        public static void add(int data) {
            if (rare == size - 1) {
                System.out.println("Queue is full");
                return;
            }
            rare = rare + 1;
            arr[rare] = data;
        }

        public static int remove() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            int front = arr[0];

            for (int i = 0; i < rare; i++) {
                arr[i] = arr[i + 1];
            }
            rare--;
            return front;
        }

        public static int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return arr[0];
        }

    }

    public static void main(String[] args) {
        Queue queue = new Queue(10);
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        queue.add(50);
        queue.add(60);
        queue.add(70);
        queue.add(80);
        queue.add(90);
        queue.add(100);

        System.out.println(queue.peek());
        while (!queue.isEmpty()) {
            System.out.print(queue.remove() + " ");
        }
    }
}