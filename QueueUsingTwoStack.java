package queue;

import java.util.Stack;

public class QueueUsingTwoStack {
    static class Queue{
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();
        public boolean isEmpty(){
            return s1.isEmpty() && s2.isEmpty();
        }
        public void add(int data){
            while (!s1.isEmpty()){
                s2.push(s1.pop());
            }
            s1.push(data);
            while (!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }
        public int pop(){
            if (isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            return s1.pop();
        }

        public int peek(){
            if (isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            return s1.peek();
        }
    }

    static class QueueBetter {
        static Stack<Integer> input = new Stack<>();
        static Stack<Integer> output = new Stack<>();
        public boolean isEmpty(){
            return input.isEmpty() && output.isEmpty();
        }
        public void add(int data){
            input.push(data);
        }
        public int pop(){
            if (isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            if (!output.isEmpty()){
                return output.pop();
            } else {
                while (!input.isEmpty()){
                    output.push(input.pop());
                }
            }
            return output.pop();
        }

        public int peek(){
            if (isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            if (!output.isEmpty()){
                return output.peek();
            } else {
                while (!input.isEmpty()){
                    output.push(input.pop());
                }
            }
            return output.peek();
        }
    }

    public static void main(String[] args){
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println(q.peek());
        q.pop();
        q.add(4);
        while (!q.isEmpty()){
            System.out.println(q.peek());
            q.pop();
        }
        System.out.println("Better way");
        QueueBetter qb = new QueueBetter();
        qb.add(1);
        qb.add(2);
        qb.add(3);
        System.out.println(qb.peek());
        qb.pop();
        qb.add(4);
        while (!qb.isEmpty()){
            System.out.println(qb.peek());
            qb.pop();
        }
    }
}
