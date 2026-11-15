import java.util.LinkedList;
import java.util.Queue;

// Push is O(1); pop rotates the queue so the newest item reaches the front.
public class QueueStackPushFriendly {
    private Queue<Integer> items = new LinkedList<>();

    public void push(int value) {
        items.add(value);
    }

    public int pop() {
        if (items.isEmpty()) throw new IllegalStateException("Stack is empty");
        int oldItems = items.size() - 1;
        for (int i = 0; i < oldItems; i++) items.add(items.remove());
        return items.remove();
    }

    public int peek() {
        if (items.isEmpty()) throw new IllegalStateException("Stack is empty");
        int oldItems = items.size() - 1;
        for (int i = 0; i < oldItems; i++) items.add(items.remove());
        int top = items.peek();
        items.add(items.remove()); // move it back so the order is unchanged
        return top;
    }

    public static void main(String[] args) {
        QueueStackPushFriendly stack = new QueueStackPushFriendly();
        stack.push(5); stack.push(10); stack.push(15);
        System.out.println("Pop: " + stack.pop());
        System.out.println("Top: " + stack.peek());
    }
}