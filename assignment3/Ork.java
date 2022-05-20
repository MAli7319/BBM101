
public class Ork extends Zorde{
    
    private int orkHealPoints;
    // To compare the default HP with current HP
    public final int mainOrkHP = 200;

    public Ork(String name, String symbol, String positionX, String positionY) {
        super(name, symbol, positionX, positionY, Constants.orkHP, Constants.orkMaxMove, Constants.orkAP);
        this.orkHealPoints = Constants.orkHealPoints;
    }

    public int getOrkHealPoints() {
        return orkHealPoints;
    }

    public void setOrkHealPoints(int orkHealPoints) {
        this.orkHealPoints = orkHealPoints;
    }

    // Comparing the current HP and sets the limit by looking the default HP
    @Override
    public void setHP(int HP) {
        if(HP > mainOrkHP){
            HP = 200;
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
