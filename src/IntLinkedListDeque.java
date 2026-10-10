public class IntLinkedListDeque implements IntDeque {
    private final IntLinkedList values;

    public IntLinkedListDeque() {
        values = new IntLinkedList();
    }

    @Override
    public void addFirst(int value) {
        values.add(0, value);
    }

    @Override
    public void addLast(int value) {
        values.add(value);
    }

    @Override
    public int removeFirst() {
        checkEmpty();
        return values.remove(0);
    }

    @Override
    public int removeLast() {
        checkEmpty();
        return values.remove(values.size() - 1);
    }

    @Override
    public int peekFirst() {
        checkEmpty();
        return values.get(0);
    }

    @Override
    public int peekLast() {
        checkEmpty();
        return values.get(values.size() - 1);
    }

    @Override
    public int size() {
        return values.size();
    }

    @Override
    public boolean isEmpty() {
        return values.isEmpty();
    }

    @Override
    public String toString() {
        return values.toString();
    }

    private void checkEmpty() {
        if (isEmpty()) {
            throw new IllegalStateException("Deque is empty");
        }
    }
}
