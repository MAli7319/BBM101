
public class Goblin extends Zorde{
    
    // To compare the default HP with current HP
    public final int mainGoblinHP = 80;
    
    public Goblin(String name, String symbol, String positionX, String positionY) {
        super(name, symbol, positionX, positionY, Constants.goblinHP, Constants.goblinMaxMove, Constants.goblinAP);
    }

    // Comparing the current HP and sets the limit by looking the default HP
    @Override
    public void setHP(int HP) {
        if(HP > mainGoblinHP){
            HP = 80;
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
