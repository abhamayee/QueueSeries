package queue;

import java.util.Arrays;

public class SlidingWindow {
    static int[] getmax(int[] arr, int k){
        int[] res = new int[arr.length-k+1];
        for (int i=0;i<=arr.length-k;i++){
            res[i]=Math.max(arr[i], Math.max(arr[i+1], arr[i+2]));
        }
        return res;
    }
    public static void main(String[] args){
        int[] arr={4,0,-1,3,5,3,6,8};
        int[] res=getmax(arr,3);
        Arrays.stream(res).forEach(x->System.out.print(x+" "));
    }
}
