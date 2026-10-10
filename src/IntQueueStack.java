public class IntQueueStack implements IntStack {
    private IntLinkedListQueue first = new IntLinkedListQueue();
    private IntLinkedListQueue second = new IntLinkedListQueue();

    @Override
    public void push(int value) {
        first.enqueue(value);
    }

    @Override
    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        while (first.size() > 1) {
            second.enqueue(first.dequeue());
        }
        int value = first.dequeue();
        IntLinkedListQueue temp = first;
        first = second;
        second = temp;
        return value;
    }

    @Override
    public int peek() {
        int value = pop();
        push(value);
        return value;
    }

    @Override
    public int size() {
        return first.size();
    }

    @Override
    public boolean isEmpty() {
        return first.isEmpty();
    }

    @Override
    public String toString() {
        return first.toString();
    }
}
