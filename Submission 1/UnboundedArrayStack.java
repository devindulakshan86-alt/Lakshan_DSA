// Array-based stack that doubles its capacity when full.
public class UnboundedArrayStack {
    private int[] data;
    private int top;   // index of the next free slot, also the current size

    public UnboundedArrayStack() {
        data = new int[2];   // small initial capacity to show resizing
        top = 0;
    }

    public void push(int value) {
        if (top == data.length) resize(data.length * 2);
        data[top++] = value;
    }

    public int pop() {
        if (top == 0) throw new IllegalStateException("Stack is empty");
        return data[--top];
    }

    public int peek() {
        if (top == 0) throw new IllegalStateException("Stack is empty");
        return data[top - 1];
    }

    public int size() {
        return top;
    }

    public boolean isEmpty() {
        return top == 0;
    }

    private void resize(int newCapacity) {
        int[] bigger = new int[newCapacity];
        for (int i = 0; i < top; i++) bigger[i] = data[i];
        data = bigger;
        System.out.println("Resized to capacity " + newCapacity);
    }

    public static void main(String[] args) {
        UnboundedArrayStack stack = new UnboundedArrayStack();
        stack.push(5); stack.push(10); stack.push(15); stack.push(20); stack.push(25);
        System.out.println("Pop: " + stack.pop());
        System.out.println("Top: " + stack.peek());
        System.out.println("Size: " + stack.size());
    }
}