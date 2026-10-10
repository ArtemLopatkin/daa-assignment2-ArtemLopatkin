public class IntLinkedListQueue implements IntQueue {
    private final IntLinkedList list;

    public IntLinkedListQueue() {
        list = new IntLinkedList();
    }

    @Override
    public void enqueue(int value) {
        list.add(value);
    }

    @Override
    public int dequeue() {
        checkEmpty();
        return list.remove(0);
    }

    @Override
    public int peek() {
        checkEmpty();
        return list.get(0);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public String toString() {
        return list.toString();
    }

    private void checkEmpty() {
        if (list.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
    }
}
