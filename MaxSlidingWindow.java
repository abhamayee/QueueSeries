package queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class MaxSlidingWindow {
    static int[] maxSlidingWindow(int[] arr, int k){
        int len= arr.length;
        int[] res=new int[arr.length-k+1];
        int index=0;
        Deque<Integer> dq=new ArrayDeque<>();
        for (int i=0;i<len;i++){
            //Remove out of bound index
            if (!dq.isEmpty() && dq.peek()==i-k){
                dq.poll();
            }
            // remove smaller number within k range as its useless
            while (!dq.isEmpty() && arr[dq.peekLast()]<arr[i]){
                dq.pollLast();
            }
            dq.offer(i);
            if(i>=k-1){
                res[index++]=arr[dq.peek()] ;
            }
        }
        return res;
    }

    public static void main(String[] args){
        int[] arr = {4,0,-1,3,5,3,6,8};
        int[] res = maxSlidingWindow(arr, 3);
        Arrays.stream(res).forEach(x-> System.out.print(x+" "));
    }
}
