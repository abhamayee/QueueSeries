package queue;

public class CircularQueueUsingArray {
    static class Queue{
        static int[] arr;
        static int capacity;
        static int size;
        static int rear = -1;
        static int front = -1;
        Queue(int capacity){
            this.capacity = capacity;
            this.size = 0;
            arr = new int[capacity];
        }
        public boolean isEmpty(){
            return rear == -1 && front == -1;
        }

        public boolean isFull(){
            // return (rear+1)%capacity == front; OR
            return size == capacity;
        }

        public void add(int data){
            if (isFull()){
                System.out.println("Queue is full");
                return;
            }

            if (front == -1) {
                front=0;
            }
            rear = (rear+1)%capacity;
            arr[rear] = data;
            size++;
        }
        public int remove(){
            if (isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            int result = arr[front];
            if (rear == front){
                rear=front=-1;
            }else {
                front = (front+1)%capacity;
            }
            --size;
            return result;
        }
        public int peek(){
            if (isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            return arr[front];
        }
    }

    public static void main(String[] args){
        Queue q = new Queue(5);
        q.add(1);
        q.add(2);
        q.add(3);
        while (!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
    }
}
