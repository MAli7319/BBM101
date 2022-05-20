
import java.util.LinkedList;


public class Stack {
    
    // This stack will have a name and a storage
    private String stackName;
    private LinkedList<Item> stack = null;

    // When this class is called, a new storage will be created
    public Stack() {
        
        stack = new LinkedList<>();
    }
    
    // This method removes and returns the last element of the stack
    public Item pop(){
        
        Item i = null;
        if(stack != null){
            i = stack.get(stack.size() - 1);
            stack.remove(stack.get(stack.size() - 1));
        }
        
        return i;
    }

    // This method adds a new element to the stack
    public void push(Item i){
    
        stack.add(i);
    }
    
    // This method returns the last element of the stack
    public Item peek(){
        
        Item i = null;
        if(stack != null){
            i = stack.get(stack.size() - 1);
        }
        
        return i;
    }
    
    // This method checks if the stack is empty
    public boolean isStackEmpty(){
        
        return stack.isEmpty();
    }

    // Getter - setters and toString
    public String getStackName() {
        return stackName;
    }

    public void setStackName(String stackName) {
        this.stackName = stackName;
    }
    
    public LinkedList<Item> getStack() {
        return stack;
    }

    public void setStack(LinkedList<Item> stack) {
        this.stack = stack;
    }

    @Override
    public String toString() {
        return stackName + " = " + stack;
    }
    
}
