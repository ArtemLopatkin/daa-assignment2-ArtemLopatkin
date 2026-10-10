public class IntArray {
    private int[] data;
    private int size;

    public IntArray() {
        data = new int[8];
    }

    public void add(int value) {
        ensureCapacity(size + 1);
        data[size++] = value;
    }

    public void add(int index, int value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        ensureCapacity(size + 1);
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = value;
        size++;
    }

    public int get(int index) {
        checkIndex(index);
        return data[index];
    }

    public void set(int index, int value) {
        checkIndex(index);
        data[index] = value;
    }

    public int remove(int index) {
        checkIndex(index);
        int value = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        return value;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(int[] values) {
        ensureCapacity(size + values.length);
        for (int value : values) {
            data[size++] = value;
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                result.append(", ");
            }
            result.append(data[i]);
        }
        return result.append(']').toString();
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
    }

    private void ensureCapacity(int needed) {
        if (needed <= data.length) {
            return;
        }
        int capacity = Math.max(needed, data.length * 2);
        int[] larger = new int[capacity];
        for (int i = 0; i < size; i++) {
            larger[i] = data[i];
        }
        data = larger;
    }
}
