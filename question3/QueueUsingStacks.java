package question3;

	public class QueueUsingStacks {
	    private int[] stack1; // Primary stack for enqueue operation
	    private int[] stack2; // Secondary stack for dequeue operation
	    private int top1; // Top of stack1
	    private int top2; // Top of stack2
	    
	    public QueueUsingStacks(int capacity) {
	        stack1 = new int[capacity];
	        stack2 = new int[capacity];
	        top1 = -1;
	        top2 = -1;
	    }
	    
	    public void enqueue(int item) {
	        if (top1 == stack1.length - 1) {
	            System.out.println("Queue is full. Cannot enqueue item: " + item);
	            return;
	        }
	        
	        stack1[++top1] = item;
	    }
	    
	    public int dequeue() {
	        if (top1 == -1 && top2 == -1) {
	            System.out.println("Queue is empty. Cannot dequeue item.");
	            return -1;
	        }
	        
	        if (top2 == -1) {
	            // Transfer elements from stack1 to stack2 in reverse order
	            while (top1 >= 0) {
	                stack2[++top2] = stack1[top1--];
	            }
	        }
	        
	        return stack2[top2--];
	    }
	    
	    public int peek() {
	        if (top1 == -1 && top2 == -1) {
	            System.out.println("Queue is empty. Cannot peek item.");
	            return -1;
	        }
	        
	        if (top2 == -1) {
	            // Transfer elements from stack1 to stack2 in reverse order
	            while (top1 >= 0) {
	                stack2[++top2] = stack1[top1--];
	            }
	        }
	        
	        return stack2[top2];
	    }
	    
	    public static void main(String[] args) {
	        QueueUsingStacks queue = new QueueUsingStacks(5);

	        queue.enqueue(10);
	        queue.enqueue(20);
	        queue.enqueue(30);

	        System.out.println("Dequeued item: " + queue.dequeue());
	        System.out.println("Dequeued item: " + queue.dequeue());
	        System.out.println("Peeked item: " + queue.peek());
	    }
	}
	

		