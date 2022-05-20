
import java.util.LinkedList;
import java.util.Collections;


public class Queue{
    
    // This queue will have a storage
    private LinkedList<Token> priorityQueue = null;

    // When this class is called, a new storage will be created
    public Queue() {
        
        priorityQueue  = new LinkedList<>();
    }
    
    // This method adds a new element to the queue and sorts after
    public void offer(Token t){
        
        priorityQueue.add(t);
        Collections.sort(priorityQueue);
    }
    
    // This method returns the first element of the queue
    public Token peek(){
        
        Token t = null;
        if(priorityQueue != null){
            t = priorityQueue.get(0);
        }
        
        return t;
    }
    
    // This method removes and returns the first element of the queue
    public Token poll(){
        
        Token t = null;
        if(priorityQueue != null){
            t = priorityQueue.get(0);
            priorityQueue.remove(t);
        }
        return t;
    }
    
    // Getters - setters and toString
    public LinkedList<Token> getPriorityQueue() {
        return priorityQueue;
    }

    public void setPriorityQueue(LinkedList<Token> priorityQueue) {
        this.priorityQueue = priorityQueue;
    }

    @Override
    public String toString() {
        return "" + priorityQueue;
    }

}