
public class Elf extends Calliance{
    
    // To use of the value which is defined at Constants.java
    private int elfRangedAp = Constants.elfRangedAP;

    public Elf(String name, String symbol, String positionX, String positionY) {
        super(name, symbol, positionX, positionY, Constants.elfHP, Constants.elfMaxMove, Constants.elfAP);
        this.elfRangedAp = Constants.elfRangedAP;
    }

    public int getElfRangedAp() {
        return elfRangedAp;
    }

    public void setElfRangedAp(int elfRangedAp) {
        this.elfRangedAp = elfRangedAp;
    }
    
    // To see what is this character's symbol on the board
    @Override
    public String toString() {
        return super.getSymbol();
    }

}
