
public class Characters implements Comparable<Characters>{
    // Comparable interface overriden in order to compare the characters' symbol and sorting them
    
    // Defining attributes
    private String name, symbol, positionX, positionY;
    private int HP, moveSteps, AP;

    public Characters(String name, String symbol, String positionX, String positionY, int HP, int moveSteps, int AP) {
        this.name = name;
        this.symbol = symbol;
        this.positionX = positionX;
        this.positionY = positionY;
        this.HP = HP;
        this.moveSteps = moveSteps;
        this.AP = AP;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getPositionX() {
        return positionX;
    }

    public void setPositionX(String positionX) {
        this.positionX = positionX;
    }

    public String getPositionY() {
        return positionY;
    }

    public void setPositionY(String positionY) {
        this.positionY = positionY;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getMoveSteps() {
        return moveSteps;
    }

    public void setMoveSteps(int moveSteps) {
        this.moveSteps = moveSteps;
    }

    public int getAP() {
        return AP;
    }

    public void setAP(int AP) {
        this.AP = AP;
    }
    
    @Override
    public String toString() {
        return name + " " + symbol + " " + positionX + " " + positionY;
    }

    // Comparing and sorting
    @Override
    public int compareTo(Characters t) {
        return this.symbol.compareTo(t.getSymbol());
    }

}
