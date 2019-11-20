class MyQueue {

    public int head, tail;
    public int[] array;
    public int size;

    public MyQueue(int capacity) {
        array = new int[capacity];
        size = capacity;
    }

    public void enQueue(int value) throws Exception {
        if ((tail + 1) % size == head) {
            throw new Exception("队列已满");
        }

        array[tail] = value;
        tail = (tail + 1) % size;
    }

    public int deQueue() throws Exception {
        if (head == tail) {
            throw new Exception("队列已空");
        }
        int delData = array[head];
        head = (head + 1) % size;
        return delData;
    }

    public void print() {
        for (int i = head; i != tail; i = (i + 1) % size) {
            System.out.println(array[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        MyQueue myQueue = new MyQueue(5);
        myQueue.enQueue(1);
        myQueue.enQueue(2);
        myQueue.enQueue(3);
        myQueue.enQueue(4);
        // myQueue.enQueue(5);
        myQueue.print();
        System.out.println(myQueue.deQueue());
        System.out.println(myQueue.deQueue());
        System.out.println(myQueue.deQueue());
        myQueue.print();
    }
}