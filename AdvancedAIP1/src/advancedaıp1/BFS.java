package advancedaıp1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BFS{
    
    //
    // Node bazlı olmayan çözüm hocam BFS2 Node bazlı
    //
    //
    
    public static void main(String[] args) {
        
//        int[][] initial = {{7, 2, 4}, {5, 0, 6}, {8, 3, 1}};
//        int[][] goal = {{1, 2, 3}, {4, 5, 6}, {6, 7, 0}};
        int[][] initial = {{1, 2, 5}, {3, 4, 0}, {6, 7, 8}};
        int[][] goal = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}};
        
        int k = BFS(initial, goal);
        
        System.out.println(k);
        
        
    }
    
    public static int BFS(int[][] initial, int[][] goal){
        
        Queue<int[][]> visibleMap = new LinkedList<>();
        visibleMap.add(initial);
        ArrayList<int[][]> explored = new ArrayList<>();
        ArrayList<int[][]> path = new ArrayList<>();
        
        while(!visibleMap.isEmpty()){
            
            int[][] current = visibleMap.poll();
            explored.add(current);
            
            if(Arrays.deepEquals(current, goal)){
                return 1;
            }
            
            ArrayList<int[][]> children = possibleChildren(current);
            for(int x = 0; x < children.size(); x++){
                ArrayList<int[][]> k = new ArrayList<>();
                k.addAll(visibleMap);
                if(!isExplored(children.get(x), explored) && !isExplored(children.get(x), k)){
                    
                    visibleMap.add(children.get(x));
                    
                }
                
            }
            
        }
        
        return 0;
        
    }
    
    public static ArrayList<int[][]> possibleChildren(int[][] current){
        
        ArrayList<int[][]> children = new ArrayList<>();
        
        for(int y = 0; y < current.length; y++){
            
            for(int x = 0; x < current[0].length; x++){
                
                if(current[y][x] == 0){
                    
                    int[][] child;
                    
                    if(y < current.length - 1){
                        child = cloneArr(current);
                        child[y][x] = child[y + 1][x];
                        child[y + 1][x] = 0;
                        children.add(child);
                    }
                    
                    if(y > 0){
                        child = cloneArr(current);
                        child[y][x] = child[y - 1][x];
                        child[y - 1][x] = 0;
                        children.add(child);
                    }
                    
                    if(x < current[0].length - 1){
                        child = cloneArr(current);
                        child[y][x] = child[y][x + 1];
                        child[y][x + 1] = 0;
                        children.add(child);
                    }
                    
                    if(x > 0){
                        child = cloneArr(current);
                        child[y][x] = child[y][x - 1];
                        child[y][x - 1] = 0;
                        children.add(child);
                    }
                    
                    return children;
                    
                }
                
            }
            
        }
        
        return children;
        
    }
    
    public static int[][] cloneArr(int[][] arr){
        
        int[][] cloneArr = new int[arr.length][];
        
        for(int x = 0; x < arr.length; x++){
            
            cloneArr[x] = arr[x].clone();
            
        }
        
        return cloneArr;
        
    }
    
    public static boolean isExplored(int[][] initial, ArrayList<int[][]> explored){
        
        for(int x = 0; x < explored.size(); x++){
            //printArr(explored.get(x), initial);
            if(Arrays.deepEquals(initial, explored.get(x))){
                return true;
            }
            
        }
        
        return false;
        
    }
    
    public static void printArr(int[][] arr, int[][] arr2){
        
        String k = "";
        String j = "";
        for(int y = 0; y < arr.length; y++){
            
            for(int x = 0; x < arr[0].length; x++){
                k += arr[y][x];
                j += arr2[y][x];
            }
            k += "  " + j +"\n";
            j = "";
        }
        
        System.out.println(k);
        
    }
    
}
