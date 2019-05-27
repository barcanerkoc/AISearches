package advancedaıp1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class IterativeDeep{
    
    public static void main(String[] args) {
        
//        int[][] initial = {{7, 2, 4}, {5, 0, 6}, {8, 3, 1}};
//        int[][] goal = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
        int[][] initial = {{1, 2, 5}, {3, 4, 0}, {6, 7, 8}};
        int[][] goal = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}};
        
        int k = IterativeDeep(initial, goal);
        
        System.out.println(k);
        
    }
    
    public static int IterativeDeep(int[][] initial, int[][] goal){
        
        Stack<Node> visibleMap = new Stack<>();
        visibleMap.add(new Node(initial, 1, 0, new Node(null, 0, 0, null)));
        ArrayList<Node> explored = new ArrayList<>();
        
        int limit = 0;
        
        while(!visibleMap.isEmpty()){
            
            Node current = visibleMap.pop();
            explored.add(current);
            
            if(Arrays.deepEquals(current.getState(), goal)){
                System.out.println(current.getDepth());
                while(current.getParent() != null){
                    
                    printArr(current.getState());
                    current = current.getParent();
                    
                }
                
                return 1;
            }
            
            if(limit == current.getDepth()){
                
                if(visibleMap.isEmpty()){
                    explored.clear();
                    visibleMap.add(new Node(initial, 1, 0, new Node(null, 0, 0, null)));
                    limit++;
                }
                
                continue;
            }   
            
            ArrayList<Node> children = possibleChildren(current);
            for(int x = 0; x < children.size(); x++){
                ArrayList<Node> k = new ArrayList<>();
                k.addAll(visibleMap);
                if(!isExplored(children.get(x), explored) && !isExplored(children.get(x), k)){
                    
                    visibleMap.push(children.get(x));
                    
                }
                
            }
            
        }
        
        return 0;
        
    }
    
    public static ArrayList<Node> possibleChildren(Node current){
        
        ArrayList<Node> children = new ArrayList<>();
        
        for(int y = 0; y < current.getState().length; y++){
            
            for(int x = 0; x < current.getState()[0].length; x++){
                
                if(current.getState()[y][x] == 0){
                    
                    int[][] child;
                    
                    if(y < current.getState().length - 1){
                        child = cloneArr(current.getState());
                        child[y][x] = child[y + 1][x];
                        child[y + 1][x] = 0;
                        children.add(new Node(child, 1, current.getDepth() + 1, current));
                    }
                    
                    if(y > 0){
                        child = cloneArr(current.getState());
                        child[y][x] = child[y - 1][x];
                        child[y - 1][x] = 0;
                        children.add(new Node(child, 1, current.getDepth() + 1, current));
                    }
                    
                    if(x < current.getState()[0].length - 1){
                        child = cloneArr(current.getState());
                        child[y][x] = child[y][x + 1];
                        child[y][x + 1] = 0;
                        children.add(new Node(child, 1, current.getDepth() + 1, current));
                    }
                    
                    if(x > 0){
                        child = cloneArr(current.getState());
                        child[y][x] = child[y][x - 1];
                        child[y][x - 1] = 0;
                        children.add(new Node(child, 1, current.getDepth() + 1, current));
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
    
    public static boolean isExplored(Node initial, ArrayList<Node> explored){
        
        for(int x = 0; x < explored.size(); x++){
            //printArr(explored.get(x), initial);
            if(Arrays.deepEquals(initial.getState(), explored.get(x).getState())){
                return true;
            }
            
        }
        
        return false;
        
    }
    
    public static void printArr(int[][] arr){
        
        for(int y = 0; y < arr.length; y++){
            
            for(int x = 0; x < arr[0].length; x++){
                System.out.print(arr[y][x]);
            }
            
            System.out.println();
            
        }
        
        System.out.println();
        
    }
    
}
