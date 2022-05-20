
public class Dwarf extends Calliance{
    
    public Dwarf(String name, String symbol, String positionX, String positionY) {
        super(name, symbol, positionX, positionY, Constants.dwarfHP, Constants.dwarfMaxMove, Constants.dwarfAP);
    }

    // To see what is this character's symbol on the board
    @Override
    public String toString() {
        return super.getSymbol();
    }

}
