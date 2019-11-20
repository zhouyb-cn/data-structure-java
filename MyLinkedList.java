class Node {
    public int val;
    public Node next;
    public Node(int val) {
        this.val = val;
    }
}

class MyLinkedList {
    private Node dummy;
    private int size;
    public MyLinkedList() {
        dummy = new Node(-1);
        size = 0;
    }

    public void insert(int index, int value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        Node pre = dummy;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        Node next = pre.next;
        pre.next = new Node(value);
        pre.next.next = next;

        size++;
    }

    public int delete(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node pre = dummy;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        Node delNode = pre.next;
        pre.next = pre.next.next;
        return delNode.val;
    }

    public void print() {
        Node head = dummy.next;
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.insert(0, 1);  
        myLinkedList.insert(1, 2);
        myLinkedList.insert(1, 3);   
        myLinkedList.insert(1, 4);  
        System.out.println(myLinkedList.delete(1));
        myLinkedList.print();
    }
}