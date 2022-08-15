package queue;

public class QueueCreate {
    int front, rear, size;
    int capacity;
    int[] arr;
    public QueueCreate(int capacity){
        this.capacity = capacity;
        front = this.size = 0;
        rear = capacity-1;
        arr = new int[capacity];
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public boolean isFull(){
        return size ==capacity;
    }
    public void enQueue(int element){
        if (isFull()){
            System.out.println("Overflow");
            return;
        }
        this.rear = (rear+1)%capacity;
        arr[rear] = element;
        ++size;
    }
    public int deQueue(){
        if (isEmpty()){
            System.out.println("Underflow");
            return -1;
        }
        int element = arr[front];
        this.front = (front+1)%capacity;
        --size;
        return element;
    }
    public int front(){
        if (isEmpty()) return Integer.MIN_VALUE;
        return arr[front];
    }
    public int rear(){
        if (isEmpty()) return 0;
        return 0;
    }
    public static void main(String[] args){

    }
}
