public class IntStackQueue implements IntQueue {
    private final IntArrayStack incoming;
    private final IntArrayStack outgoing;

    public IntStackQueue() {
        incoming = new IntArrayStack();
        outgoing = new IntArrayStack();
    }

    @Override
    public void enqueue(int value) {
        incoming.push(value);
    }

    @Override
    public int dequeue() {
        prepareOutgoing();
        return outgoing.pop();
    }

    @Override
    public int peek() {
        prepareOutgoing();
        return outgoing.peek();
    }

    @Override
    public int size() {
        return incoming.size() + outgoing.size();
    }

    @Override
    public boolean isEmpty() {
        return incoming.isEmpty() && outgoing.isEmpty();
    }

    @Override
    public String toString() {
        int[] values = new int[size()];
        int outgoingSize = outgoing.size();
        for (int i = 0; i < outgoingSize; i++) {
            values[i] = outgoing.pop();
        }
        for (int i = outgoingSize - 1; i >= 0; i--) {
            outgoing.push(values[i]);
        }
        for (int i = values.length - 1; i >= outgoingSize; i--) {
            values[i] = incoming.pop();
        }
        for (int i = outgoingSize; i < values.length; i++) {
            incoming.push(values[i]);
        }

        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < values.length; i++) {
            if (i > 0) {
                result.append(", ");
            }
            result.append(values[i]);
        }
        return result.append(']').toString();
    }

    private void prepareOutgoing() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        if (outgoing.isEmpty()) {
            while (!incoming.isEmpty()) {
                outgoing.push(incoming.pop());
            }
        }
    }
}
