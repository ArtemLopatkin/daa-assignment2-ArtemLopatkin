public class IntLinkedList {
    Node head;
    Node tail;
    int size;

    static class Node {
        int value;
        Node next;
        Node prev;
        Node() {
            value = 0;
            next = null;
            prev = null;
        }

        Node(int value) {
            this.value = value;
            next = null;
            prev = null;
        }

        Node(int value, Node prev, Node next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

    public IntLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void add(int value) {
        add(size, value);
    }

    public void add(int index, int value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", size: " + size);
        }

        Node next = index == size ? null : nodeAt(index);
        Node prev = next == null ? tail : next.prev;
        Node node = new Node(value, prev, next);

        if (prev == null) {
            head = node;
        } else {
            prev.next = node;
        }

        if (next == null) {
            tail = node;
        } else {
            next.prev = node;
        }
        size++;
    }

    public int get(int index) {
        return nodeAt(index).value;
    }

    public void set(int index, int value) {
        nodeAt(index).value = value;
    }

    public int remove(int index) {
        Node node = nodeAt(index);

        if (node.prev == null) {
            head = node.next;
        } else {
            node.prev.next = node.next;
        }

        if (node.next == null) {
            tail = node.prev;
        } else {
            node.next.prev = node.prev;
        }
        size--;
        return node.value;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node node = head;
        while (node != null) {
            result.append(node.value);
            if (node.next != null) {
                result.append(", ");
            }
            node = node.next;
        }
        return result.append(']').toString();
    }

    private Node nodeAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", size: " + size);
        }

        if (index < size / 2) {
            Node node = head;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        }

        Node node = tail;
        for (int i = size - 1; i > index; i--) {
            node = node.prev;
        }
        return node;
    }
}
