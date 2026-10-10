public class IntMinHeapTopDown implements IntQueue {
    private final IntArray heap = new IntArray();

    public IntMinHeapTopDown() {
    }

    public IntMinHeapTopDown(int[] values) {
        for (int value : values) {
            heap.add(value);
            siftUp(heap.size() - 1);
        }
    }

    @Override
    public void enqueue(int value) {
        heap.add(value);
        siftUp(heap.size() - 1);
    }

    @Override
    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }

        int minimum = heap.get(0);
        int last = heap.remove(heap.size() - 1);
        if (!isEmpty()) {
            heap.set(0, last);
            siftDown(0);
        }
        return minimum;
    }

    @Override
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        return heap.get(0);
    }

    @Override
    public int size() {
        return heap.size();
    }

    @Override
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    @Override
    public String toString() {
        return heap.toString();
    }

    private void siftUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (heap.get(parent) <= heap.get(index)) {
                break;
            }
            swap(parent, index);
            index = parent;
        }
    }

    private void siftDown(int index) {
        int size = heap.size();
        while (index < size / 2) {
            int left = 2 * index + 1;
            int right = left + 1;
            int smaller = left;

            if (right < size && heap.get(right) < heap.get(left)) {
                smaller = right;
            }
            if (heap.get(index) <= heap.get(smaller)) {
                break;
            }
            swap(index, smaller);
            index = smaller;
        }
    }

    private void swap(int first, int second) {
        int value = heap.get(first);
        heap.set(first, heap.get(second));
        heap.set(second, value);
    }
}
