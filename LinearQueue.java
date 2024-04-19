package dsae;
public class LinearQueue {
    private int maxSize; // maximum size of the queue
    private int[] queueArray; // array to store the elements of the queue
    private int front; // front of the queue
    private int rear; // rear of the queue
    private int currentSize; // current number of elements in the queue
    
    public LinearQueue(int size) {
        maxSize = size;
        queueArray = new int[maxSize];
        front = 0;
        rear = -1;
        currentSize = 0;
    }
    
    public boolean isEmpty() {
        return currentSize == 0;
    }
    
    public boolean isFull() {
        return currentSize == maxSize;
    }
    
    public int size() {
        return currentSize;
    }
    
    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue element " + item);
            return;
        }
        
        rear = (rear + 1) % maxSize;
        queueArray[rear] = item;
        currentSize++;
        System.out.println("Enqueued element: " + item);
    }
    
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue element.");
            return -1;
        }
        
        int dequeuedItem = queueArray[front];
        front = (front + 1) % maxSize;
        currentSize--;
        System.out.println("Dequeued element: " + dequeuedItem);
        return dequeuedItem;
    }
    
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot peek element.");
            return -1;
        }
        
        return queueArray[front];
    }
    
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Nothing to display.");
            return;
        }
        
        System.out.print("Queue (front to rear): ");
        for (int i = 0; i < currentSize; i++) {
            int index = (front + i) % maxSize;
            System.out.print(queueArray[index] + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        LinearQueue queue = new LinearQueue(5);
        
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.display(); // Output: Queue (front to rear): 10 20 30
        
        queue.dequeue();
        queue.display(); // Output: Queue (front to rear): 20 30
        
        System.out.println("Front element: " + queue.peek()); // Output: Front element: 20
        
        System.out.println("Queue size: " + queue.size()); // Output: Queue size: 2
        
        System.out.println("Is queue empty? " + queue.isEmpty()); // Output: Is queue empty? false
        
        queue.enqueue(40);
        queue.enqueue(50);
        queue.display(); // Output: Queue (front to rear): 20 30 40 50
        
        queue.enqueue(60); // Output: Queue is full. Cannot enqueue element 60
    }
}