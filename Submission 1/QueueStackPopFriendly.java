import java.util.LinkedList;
import java.util.Queue;

// Push rearranges using a second queue so pop can remove the top in O(1).
public class TwoQueueStackPopFriendly {
    private Queue<Integer> mainQueue = new LinkedList<>();
    private Queue<Integer> helperQueue = new LinkedList<>();

    public void push(int value) {
        helperQueue.add(value);
        while (!mainQueue.isEmpty()) helperQueue.add(mainQueue.remove());
        Queue<Integer> temp = mainQueue;   // swap the two queues
        mainQueue = helperQueue;
        helperQueue = temp;
    }

    public int pop() {
        if (mainQueue.isEmpty()) throw new IllegalStateException("Stack is empty");
        return mainQueue.remove();
    }

    public int peek() {
        if (mainQueue.isEmpty()) throw new IllegalStateException("Stack is empty");
        return mainQueue.peek();
    }

    public static void main(String[] args) {
        TwoQueueStackPopFriendly stack = new TwoQueueStackPopFriendly();
        stack.push(5); stack.push(10); stack.push(15);
        System.out.println("Pop: " + stack.pop());
        System.out.println("Top: " + stack.peek());
    }
}