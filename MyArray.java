class MyArray {

    private int[] array;
    private int size;

    public MyArray(int capacity) {
        this.array = new int[capacity];
        this.size = 0;
    }

    public void insert(int index, int value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        // resize
        if (size >= array.length) {
            resize();
        }

        for (int i = size - 1; i >= index; i--) {
            this.array[i + 1] = this.array[i];
        }

        this.array[index] = value;
        size++;
        return;
    }

    public int delete(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("error");
        }
        int deleteValue = array[index];
        for (int i = index; i < size; i++) {
            array[i] = array[i + 1];
        }
        size--;
        return deleteValue;
    }

    public void resize() {
        int[] newArray = new int[array.length * 2];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(this.array[i]);
        }
    }


    public static void main(String[] args) {
        // System.out.println("this is a test!");
        MyArray ma = new MyArray(4);
        ma.insert(0, 1);
        ma.insert(1, 2);
        ma.insert(1, 3);
        ma.insert(3, 5);
        ma.insert(1, 7);
        ma.delete(3);
        ma.print();
    }
}