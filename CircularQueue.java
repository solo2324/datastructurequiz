package dsae;

public class CircularQueue {
    private int[] queue;
    private int front;
    private int rear;
    private int capacity;

    public CircularQueue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        front = -1;
        rear = -1;
    }

    public void enqueue(int item) {
        if ((rear + 1) % capacity == front) {
            System.out.println("Queue is full");
            return;
        }
        if (front == -1)
            front = 0;
        rear = (rear + 1) % capacity;
        queue[rear] = item;
    }

    public int dequeue() {
        if (front == -1) {
            System.out.println("Queue is empty");
            return -1;
        }
        int item = queue[front];
        if (front == rear)
            front = rear = -1;
        else
            front = (front + 1) % capacity;
        return item;
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public int size() {
        if (isEmpty())
            return 0;
        if (front <= rear)
            return rear - front + 1;
        else
            return (capacity - front) + (rear + 1);
    }

    public static void main(String[] args) {
        CircularQueue circularQueue = new CircularQueue(5);
        circularQueue.enqueue(1);
        circularQueue.enqueue(2);
        circularQueue.enqueue(3);
        System.out.println("Size of the queue: " + circularQueue.size());
        System.out.println("Dequeue: " + circularQueue.dequeue());
        System.out.println("Dequeue: " + circularQueue.dequeue());
        System.out.println("Size of the queue: " + circularQueue.size());
    }
}


	