
public class Token implements Comparable<Token>{
    
    // Each token will have a name, id, item number it can be buy(relevant item number)
    // and enqueue-dequeue number which will be used for sorting the tokens
    private String tokenID, tokenName;
    private int relevantItemNumber, readingOrder;

    public Token(String tokenID, String tokenName, int relevantItemNumber, int readingOrder) {
        this.tokenID = tokenID;
        this.tokenName = tokenName;
        this.relevantItemNumber = relevantItemNumber;
        this.readingOrder = readingOrder;
    }

    // Getters - setters and toString 
    public String getTokenID() {
        return tokenID;
    }

    public void setTokenID(String tokenID) {
        this.tokenID = tokenID;
    }

    public String getTokenName() {
        return tokenName;
    }

    public void setTokenName(String tokenName) {
        this.tokenName = tokenName;
    }

    public int getRelevantItemNumber() {
        return relevantItemNumber;
    }

    // This setter is special, it decreases the relevant item number as much as the buy number
    // buyNo(buy number) = input value of the item which will be bought by token 
    public void setRelevantItemNumber(int buyNo) {
        relevantItemNumber -= buyNo;
    }

    public int getReadingOrder() {
        return readingOrder;
    }

    public void setReadingOrder(int readingOrder) {
        this.readingOrder = readingOrder;
    }

    
    @Override
    public String toString() {
        return tokenID + " " + tokenName + " " + relevantItemNumber;
    }
    
    // This method compares the relevant item number in order to sort the tokens
    @Override
    public int compareTo(Token t) {
        
        if(this.relevantItemNumber - t.getRelevantItemNumber() == 0){
            return t.readingOrder - this.readingOrder;
        }
        return this.relevantItemNumber - t.getRelevantItemNumber();
        
    }

}
