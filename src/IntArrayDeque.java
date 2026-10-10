public class IntArrayDeque implements IntDeque {
    private IntArray values;
    private int head;
    private int size;

    public IntArrayDeque() {
        values = new IntArray();
        values.add(new int[8]);
    }

    @Override
    public void addFirst(int value) {
        ensureSpace();
        head = (head - 1 + values.size()) % values.size();
        values.set(head, value);
        size++;
    }

    @Override
    public void addLast(int value) {
        ensureSpace();
        values.set((head + size) % values.size(), value);
        size++;
    }

    @Override
    public int removeFirst() {
        checkEmpty();
        int value = values.get(head);
        head = (head + 1) % values.size();
        size--;
        return value;
    }

    @Override
    public int removeLast() {
        int value = peekLast();
        size--;
        return value;
    }

    @Override
    public int peekFirst() {
        checkEmpty();
        return values.get(head);
    }

    @Override
    public int peekLast() {
        checkEmpty();
        return values.get((head + size - 1) % values.size());
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                result.append(", ");
            }
            result.append(values.get((head + i) % values.size()));
        }
        return result.append(']').toString();
    }

    private void checkEmpty() {
        if (isEmpty()) {
            throw new IllegalStateException("Deque is empty");
        }
    }

    private void ensureSpace() {
        if (size < values.size()) {
            return;
        }
        IntArray larger = new IntArray();
        larger.add(new int[values.size() * 2]);
        for (int i = 0; i < size; i++) {
            larger.set(i, values.get((head + i) % values.size()));
        }
        values = larger;
        head = 0;
    }
}
