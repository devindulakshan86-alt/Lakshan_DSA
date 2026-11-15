import java.util.Stack;

// Enqueue is O(1); dequeue moves items between stacks to reach the oldest one.
public class StackQueueEnqueueFriendly {
    private Stack<Integer> mainStack = new Stack<>();
    private Stack<Integer> helperStack = new Stack<>();

    public void enqueue(int value) {
        mainStack.push(value);
    }

    public int dequeue() {
        if (mainStack.isEmpty()) throw new IllegalStateException("Queue is empty");
        while (!mainStack.isEmpty()) helperStack.push(mainStack.pop());
        int front = helperStack.pop();   // oldest element is now on top
        while (!helperStack.isEmpty()) mainStack.push(helperStack.pop());
        return front;
    }

    public int peek() {
        if (mainStack.isEmpty()) throw new IllegalStateException("Queue is empty");
        while (!mainStack.isEmpty()) helperStack.push(mainStack.pop());
        int front = helperStack.peek();
        while (!helperStack.isEmpty()) mainStack.push(helperStack.pop());
        return front;
    }

    public static void main(String[] args) {
        StackQueueEnqueueFriendly queue = new StackQueueEnqueueFriendly();
        queue.enqueue(5); queue.enqueue(10); queue.enqueue(15);
        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("Front: " + queue.peek());
    }
}