
public class Troll extends Zorde{
    
    // To compare the default HP with current HP
    public final int mainTrollHP = 150;
    
    public Troll(String name, String symbol, String positionX, String positionY) {
        super(name, symbol, positionX, positionY, Constants.trollHP, Constants.trollMaxMove, Constants.trollAP);
    }

    // Comparing the current HP and sets the limit by looking the default HP
    @Override
    public void setHP(int HP) {
        if(HP > mainTrollHP){
            HP = 150;
        }
        else{
            super.setHP(HP);
        }
    }

    @Override
    public int getHP() {
        return super.getHP();
    }
    
    // To see what is this character's symbol on the board
    @Override
    public String toString() {
        return super.getSymbol();
    }

}
