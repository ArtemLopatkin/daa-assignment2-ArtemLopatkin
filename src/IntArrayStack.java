public class IntArrayStack implements IntStack {
    private final IntArray values;

    public IntArrayStack() {
        values = new IntArray();
    }

    @Override
    public void push(int value) {
        values.add(value);
    }

    @Override
    public int pop() {
        checkEmpty();
        return values.remove(values.size() - 1);
    }

    @Override
    public int peek() {
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
            throw new IllegalStateException("Stack is empty");
        }
    }
}
