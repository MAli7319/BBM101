
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;


public class Task {
    
    // Calling the inputs which were defined at Main class
    public ArrayList<String> inputParts = Main.parts;
    public ArrayList<String> inputItems = Main.items;
    public ArrayList<String> inputTokens = Main.tokens;
   
    // New data structors in order to use the stack and priority queue
    public ArrayList<Item> items = new ArrayList<>();
    public ArrayList<Stack> vendingMachines = new ArrayList<>();
    public Queue myPriorityQueue = new Queue();
    
    public Task(){
        
        defineItems();
        defineTokens();
        defineVendingMachines();
        LinkedList<Token> tokenBox = myPriorityQueue.getPriorityQueue();
        
        // This variable checks the token which was used and defines it a new enqueue-dequeue number
        // So when the token is used, it comes to the front of the token box 
        int tokenUsageOrder = tokenBox.size() * 5;
        
        // Considering the input task: BUY or PUT
        for(int t = 0; t < Main.tasks.size(); t++){
            if(Main.tasks.get(t).split("\t")[0].equals("BUY")){
                
                // If the task is BUY, then defines the stack name and buy number
                for(int i = 1; i < Main.tasks.get(t).split("\t").length; i++){
                    String stackName = Main.tasks.get(t).split("\t")[i].split(",")[0];
                    int buyNo = Integer.parseInt(Main.tasks.get(t).split("\t")[i].split(",")[1]);
                    
                    // It finds the corresponding stack
                    // By looking at the buy number it removes the item from the stack
                    for(Stack s : vendingMachines){
                        if(s.getStackName().equals(stackName)){
                            
                            for(int x = 0; x < buyNo; x++){
                                s.pop();
                            }
                        }
                    }
                    
                    // It finds the corresponding stack by looking at the token name
                    // Decreases the relevant item number
                    // Resorts the token box with new enqueue-dequeue number
                    for(int k = tokenBox.size()-1; k > -1; k--){
                        if(tokenBox.get(k).getTokenName().equals(stackName)){
                            tokenBox.get(k).setRelevantItemNumber(buyNo);
                            
                            if(tokenBox.get(k).getRelevantItemNumber() < 0){
                                tokenBox.remove(tokenBox.get(k));
                            }
                            else{
                                tokenBox.get(k).setReadingOrder(tokenUsageOrder);
                                break;
                            }
                        }
                    }
                    tokenUsageOrder++;
                    Collections.sort(tokenBox);
                }
            }
            
            else{
                // If the task is PUT, then first, it finds the desired stack
                for(int i = 1; i < Main.tasks.get(t).split("\t").length; i++){
                    String stackName = Main.tasks.get(t).split("\t")[i].split(",")[0];
                    Stack s = getDesiredStack(stackName);
                    
                    // If stack is exist, defines the new item and adds the stack
                    if(s != null){
                    
                        for(int j = 1; j < Main.tasks.get(t).split("\t")[i].split(",").length; j++){
                            Item newItem = new Item(Main.tasks.get(t).split("\t")[i].split(",")[j], 
                                                    Main.tasks.get(t).split("\t")[i].split(",")[0]);
                            s.getStack().add(newItem);
                            /*I could not understand that when i try to add this element with push method
                              which i defined in Stack class gives wrong order of the items but with add
                              method which belongs the List interface gives the correct order. Because i used add*/
                        }
                    }
                }
            }
        }
        // Writes the output
        outputFormat(tokenBox);
    }
    
    // This method defines the items which are in the input
    // Adds the items list
    public void defineItems(){
        
        for(int i = 0; i < inputItems.size(); i++){
            Item item = new Item(inputItems.get(i).split(" ")[0], 
                                 inputItems.get(i).split(" ")[1]);
            items.add(item);
        }
    }
    
    // This method defines the tokens which are in the input
    // Adds the priority queue
    public void defineTokens(){
        
        for(int t = 0; t < inputTokens.size(); t++){
            Token token = new Token(inputTokens.get(t).split(" ")[0], 
                                    inputTokens.get(t).split(" ")[1], 
                                    Integer.parseInt(inputTokens.get(t).split(" ")[2]),
                                    t);
            myPriorityQueue.offer(token);
        }
    }
    
    // This method looks the parts input and creates the stack named corresponsing part
    // After it looks the item list and adds the items in the corresponding stack(same name) 
    // Finally, each stack will add in the vending machine
    public void defineVendingMachines(){
        
        for(int a = 0; a < inputParts.size(); a++){
            
            Stack myStack = new Stack();
            String part = inputParts.get(a);
            for(int b = 0; b < items.size(); b++){
                if(items.get(b).getItemName().equals(part)){
                    myStack.push(items.get(b));
                }
            }
            
            myStack.setStackName(part);
            vendingMachines.add(myStack);
        }
    }
    
    // This method designs and writes the output file 
    public void outputFormat(LinkedList<Token> tokenBox){
        
        // Writes the stack name and its elements 
        for(int p = 0; p < inputParts.size(); p++){
            Stack s = getDesiredStack(inputParts.get(p));
            WriteOutputFile.writeOutput(s.getStackName() + ":\n");
            Collections.reverse(s.getStack());
            
            if(s.isStackEmpty()){
                WriteOutputFile.writeOutput("\n");
            }
            
            for(int d = 0; d < s.getStack().size(); d++){
                WriteOutputFile.writeOutput(s.getStack().get(d).getItemID() + "\n");
            }
            
            WriteOutputFile.writeOutput("--------------\n");
        }
        
        // Writes the token box and its elements 
        WriteOutputFile.writeOutput("Token Box:\n");
        Collections.sort(tokenBox);
        for(int i = 0; i < tokenBox.size(); i++){
            
            if(i == tokenBox.size()-1){
                WriteOutputFile.writeOutput(tokenBox.get(i).toString());
            }
            else{
                WriteOutputFile.writeOutput(tokenBox.get(i).toString() + "\n");
            }
        }
    }
    
    // This method looks at the vending machine
    // Finds and returns the stack by looking at its name which is given as a parameter
    public Stack getDesiredStack(String s){
        
        for(Stack stack : vendingMachines){
            if(stack.getStackName().equals(s)){
                return stack;
            }
        }
        return null;
    }
    
}
