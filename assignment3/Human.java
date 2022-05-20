
public class Human extends Calliance{
    
    public Human(String name, String symbol, String positionX, String positionY) {
        super(name, symbol, positionX, positionY, Constants.humanHP, Constants.humanMaxMove, Constants.humanAP);
    }

    // To see what is this character's symbol on the board
    @Override
    public String toString() {
        return super.getSymbol();
    }

}
