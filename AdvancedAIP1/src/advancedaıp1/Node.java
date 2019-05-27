package advancedaıp1;

public class Node{
    
    private int[][] state;
    private Node parent;
    private int cost;
    private int depth;
    
    public Node(int[][] state, int cost, int depth, Node parent){
        
        this.state = state;
        this.cost = cost;
        this.depth = depth;
        this.parent = parent;
        
    }
    
    public int[][] getState(){
        return state;
    }
    
    public Node getParent(){
        return parent;
    }
    
    public int getCost(){
        return cost;
    }
    
    public int getDepth(){
        return depth;
    }
    
}
