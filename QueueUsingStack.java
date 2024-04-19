package linearstructure;

import java.util.Stack;

class QueueUsingStack {
    private Stack<Integer> stack1; // For enqueue operation
    private Stack<Integer> stack2; // For dequeue operation

    // Constructor to initialize the stacks
    public QueueUsingStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return (stack1.isEmpty() && stack2.isEmpty());
    }

    // Get the current size of the queue
    public int size() {
        return (stack1.size() + stack2.size());
    }

    // Insert an element at the rear of the queue
    public void enqueue(int item) {
        stack1.push(item);
        System.out.println("Enqueued: " + item);
    }

    // Remove and return the element at the front of the queue
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue element.");
            return -1;
        }

        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        int removedItem = stack2.pop();
        System.out.println("Dequeued: " + removedItem);
        return removedItem;
    }

    // Get the element at the front of the queue without removing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1;
        }

        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.peek();
    }
}

public class Main {
    public static void main(String[] args) {
        QueueUsingStack queue = new QueueUsingStack();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);

        System.out.println("Queue size: " + queue.size());
        System.out.println("Front of the queue: " + queue.peek());

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        System.out.println("Queue size: " + queue.size());
        System.out.println("Front of the queue: " + queue.peek());

        queue.enqueue(60);
        queue.enqueue(70);

        System.out.println("Queue size: " + queue.size());
        System.out.println("Front of the queue: " + queue.peek());
    }
}

