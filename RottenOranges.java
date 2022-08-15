package queue;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    static int orangesRotting(int[][] grid){
        if (grid==null || grid.length==0)return 0;
        int rows=grid.length;
        int cols=grid[0].length;
        int totalCount=0;
        int minDays =0;
        int rottenCount=0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                if (grid[i][j]==2){
                    queue.offer(new int[]{i,j});
                    totalCount++;
                }
                if (grid[i][j]==1){
                    totalCount++;
                }
            }
        }
        if (totalCount==0)return 0;
        int[] x={0,-1,0,1};
        int[] y={-1,0,1,0};
        while (!queue.isEmpty()){
            int size= queue.size();
            rottenCount+=size;
            for (int i=0;i<size;i++){
                int[] front=queue.poll();
                for (int j=0;j<4;j++){
                    int xIdx=front[0]+x[j];
                    int yIdx=front[1]+y[j];
                    if (xIdx<0||yIdx<0||xIdx>=rows||yIdx>=cols||grid[xIdx][yIdx]==0||grid[xIdx][yIdx]==2)continue;
                    grid[xIdx][yIdx]=2;
                    queue.offer(new int[]{xIdx,yIdx});
                }
            }
            if (!queue.isEmpty())minDays++;
        }
        return totalCount==rottenCount?minDays:-1;
    }

    public static void main(String[] args){
        int[][] grid={{2,1,1},{1,1,0},{0,1,1}};
        /* {{1,0,1,2},{2,1,1,0},{0,0,0,1}} -1
        {{1,0,1,2},{2,1,1,0},{0,0,1,1}} 4*/
        int rottingDays = orangesRotting(grid);
        System.out.print("Minimum days required to rotting oranges: "+rottingDays);
    }
}
