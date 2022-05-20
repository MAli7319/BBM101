
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class Gameplay {
    
    String[][] table = null; // Default defining of game table
    
    // To store and reach the objects by their types
    ArrayList<Characters> characters = new ArrayList<>();
    ArrayList<Calliance> calliances = new ArrayList<>();
    ArrayList<Zorde> zordes = new ArrayList<>();
    ArrayList<Elf> elfs = new ArrayList<>();
    ArrayList<Dwarf> dwarfs = new ArrayList<>();
    ArrayList<Human> humans = new ArrayList<>();
    ArrayList<Goblin> goblins = new ArrayList<>();
    ArrayList<Troll> trolls = new ArrayList<>();
    ArrayList<Ork> orks = new ArrayList<>();
    
    LinkedList<String> movement = new LinkedList<>(); // To store the movements
    
    // Checks if there is an error thrown by the program
    // If no, value = 1 and prints the board and HP values
    // If yes, value = 0 and does not print the board and HP values
    private int errorController = 0;
    
    public Gameplay(){
        
        // To calling the methods related with the game in order
        defineBoard();
        defineCharacters();
        placeCharacters();
        boardWithTabularFormat(table);
        charactersAndHPValues();
        defineMoves();
        
        // To move the characters and print the output
        for(int i = 0; i < movement.size(); i++){
            Characters c = detectTheCharacter(movement.get(i).split(" ")[0]);
            if(c != null){
                if(c.getClass().equals(Elf.class) ||
                   c.getClass().equals(Dwarf.class) ||
                   c.getClass().equals(Human.class)){
                    
                    checkTheMove(calliances, movement.get(i).split(" ")[0], exactMove(movement.get(i)), zordes);
                }
                else{
                    
                    checkTheMove(zordes, movement.get(i).split(" ")[0], exactMove(movement.get(i)), calliances);
                }
                if(errorController == 0){
                    boardWithTabularFormat(table);
                    charactersAndHPValues();
                }
            }
            if(i == movement.size() - 1){
                checkTheWinner();
            }
        }
    }
    
    // To provide the range attack for elf(range = 2)
    // According to the position, it decreases enemy's HP which is in the range
    public void elfRangedAttack(Elf e, int positionX, int positionY, ArrayList<? extends Characters> enemies){
        
        // Define and store the all possibilities 
        List<String> environment = new ArrayList<>();
        
        environment.add(table[positionY + 1][positionX]);
        environment.add(table[positionY - 1][positionX]);
        environment.add(table[positionY][positionX + 1]);
        environment.add(table[positionY][positionX - 1]);
        environment.add(table[positionY + 1][positionX + 1]);
        environment.add(table[positionY + 1][positionX - 1]);
        environment.add(table[positionY - 1][positionX + 1]);
        environment.add(table[positionY - 1][positionX - 1]);
        
        environment.add(table[positionY + 2][positionX]);
        environment.add(table[positionY - 2][positionX]);
        environment.add(table[positionY][positionX + 2]);
        environment.add(table[positionY][positionX - 2]);
        
        environment.add(table[positionY + 2][positionX - 2]);
        environment.add(table[positionY - 2][positionX - 2]);
        environment.add(table[positionY - 2][positionX + 2]);
        environment.add(table[positionY + 2][positionX + 2]);
        
        environment.add(table[positionY + 2][positionX + 1]);
        environment.add(table[positionY + 2][positionX - 1]);
        environment.add(table[positionY - 2][positionX + 1]);
        environment.add(table[positionY - 2][positionX - 1]);
        
        environment.add(table[positionY + 1][positionX + 2]);
        environment.add(table[positionY + 1][positionX - 2]);
        environment.add(table[positionY - 1][positionX + 2]);
        environment.add(table[positionY - 1][positionX - 2]);
        
        // Attack part
        for(int i = 0; i < environment.size(); i++){
            Characters possibleEnemy = detectTheCharacter(environment.get(i));
            if(enemies.contains(possibleEnemy)){
                possibleEnemy.setHP(possibleEnemy.getHP() - e.getElfRangedAp());
            }
        }
    }
    
    
    // At the end of the game, it checks the winner side
    public void checkTheWinner(){
        
        try{
            Characters survived = null;
            WriteOutputFile.writeOutput("\nGame Finished\n");

            // Scanning the table and finding the survived character
            for(int y = 0; y  < table.length; y++){
                for(int x = 0;  x < table.length; x++){
                    if(detectTheCharacter(table[y][x]) != null){
                        survived = detectTheCharacter(table[y][x]);
                        break;
                    }
                }
            }
            if(survived != null){
                if(calliances.contains(survived)){
                    WriteOutputFile.writeOutput("Calliance Wins");
                }
                else if(zordes.contains(survived)){
                    WriteOutputFile.writeOutput("Zorde Wins");
                }
            }
        }
        catch(NullPointerException e){
            
        }
    }
    
    
    // Design of the commands input file to get more readable
    public String exactMove(String move){
        
        String moves = "";
        
        for(int i = 1; i < move.split(" ").length; i++){
            String replace = move.split(" ")[i].replace("[", "").replace("]", "");
            moves += replace;
        }
        return moves;
    }
    
    
    // By looking at the symbol of character, finds the position of it
    public String findTheCharacter(String pawn){
        
        int characterX = 0, characterY = 0;
        
        for(int y = 0; y  < table.length; y++){
            for(int x = 0;  x < table.length; x++){
                if(table[y][x].equals(pawn)){
                    characterX = x;
                    characterY = y;
                }
            }
        }
        return characterX + "," + characterY;
    }
    
    
    // Fight for the death part
    // By looking at the attacker's and defender's HP, redesign the table
    public void fightForTheDeath(Characters attacker, Characters defender){
        
        if(defender.getHP() > 0){
            
            if(attacker.getHP() < defender.getHP()){
                defender.setHP(defender.getHP() - attacker.getHP());
                killedCharacter(attacker);
            }
            else if(attacker.getHP() > defender.getHP()){
                attacker.setHP(attacker.getHP() - defender.getHP());
                
                // Place the attacker's new position
                int x1 = Integer.parseInt(findTheCharacter(defender.getSymbol()).split(",")[0]);
                int y1 = Integer.parseInt(findTheCharacter(defender.getSymbol()).split(",")[1]);
                killedCharacter(defender);
                int x2 = Integer.parseInt(findTheCharacter(attacker.getSymbol()).split(",")[0]);
                int y2 = Integer.parseInt(findTheCharacter(attacker.getSymbol()).split(",")[1]);
                
                table[y1][x1] = attacker.getSymbol();
                table[y2][x2] = "  ";
            }
            else{
                killedCharacter(attacker);
                killedCharacter(defender);
            }
        }
    }
    
    
    // Basic attack for all characters to 8 squares
    public void attack(Characters attacker, Characters defender){
        
        defender.setHP(defender.getHP() - attacker.getAP());
        if(defender.getHP() <= 0){
            // Place the attacker's new position
            int x1 = Integer.parseInt(findTheCharacter(defender.getSymbol()).split(",")[0]);
            int y1 = Integer.parseInt(findTheCharacter(defender.getSymbol()).split(",")[1]);
            killedCharacter(defender);
            int x2 = Integer.parseInt(findTheCharacter(attacker.getSymbol()).split(",")[0]);
            int y2 = Integer.parseInt(findTheCharacter(attacker.getSymbol()).split(",")[1]);
                
            table[y1][x1] = attacker.getSymbol();
            table[y2][x2] = "  ";
        }
    }
    
    
    public void orkHeal(Ork o, int positionX, int positionY, ArrayList<? extends Characters> allies){
        
        // Define and store the all possibilities 
        List<String> environment = new ArrayList<>();
        environment.add(table[positionY + 1][positionX]);
        environment.add(table[positionY - 1][positionX]);
        environment.add(table[positionY][positionX + 1]);
        environment.add(table[positionY][positionX - 1]);
        environment.add(table[positionY + 1][positionX + 1]);
        environment.add(table[positionY + 1][positionX - 1]);
        environment.add(table[positionY - 1][positionX + 1]);
        environment.add(table[positionY - 1][positionX - 1]);
        
        // Healing the allies
        for(int i = 0; i < environment.size(); i++){
            Characters possibleAlly = detectTheCharacter(environment.get(i));
            if(allies.contains(possibleAlly)){
                possibleAlly.setHP(possibleAlly.getHP() + o.getOrkHealPoints());
            }
        }
        // Healing itself
        o.setHP(o.getHP() + o.getOrkHealPoints());
    }
    
    
    // If the character's HP < 0, then delete the character from the game table
    public void killedCharacter(Characters c){
        
        // Finds the position of dead character
        int x = Integer.parseInt(findTheCharacter(c.getSymbol()).split(",")[0]);
        int y = Integer.parseInt(findTheCharacter(c.getSymbol()).split(",")[1]);
        
        table[y][x] = "  ";
        c.setHP(0);
    }
    
    
    // By looking the game table it finds the symbol of the character
    // Considering the characters list and verifies the character
    public Characters detectTheCharacter(String symbol){
        
        Characters c = null;
        for(int a = 0;  a < characters.size(); a++){
            if(characters.get(a).toString().equals(symbol)){
                c = characters.get(a);
            }
        }
        return c;
    }
    
    
    // Checks the range of 8 squares and if there is an enemy, decreases its HP
    public void checkTheRange(ArrayList<? extends Characters> enemies, int positionX, int positionY){
        
        // Define and store the all possibilities
        List<String> environment = new ArrayList<>();
        environment.add(table[positionY + 1][positionX]);
        environment.add(table[positionY - 1][positionX]);
        environment.add(table[positionY][positionX + 1]);
        environment.add(table[positionY][positionX - 1]);
        environment.add(table[positionY + 1][positionX + 1]);
        environment.add(table[positionY + 1][positionX - 1]);
        environment.add(table[positionY - 1][positionX + 1]);
        environment.add(table[positionY - 1][positionX - 1]);
        
        // Verifying the attacker and enemy
        for(int i = 0; i < environment.size(); i++){
            Characters attacker = detectTheCharacter(table[positionY][positionX]);
            Characters possibleEnemy = detectTheCharacter(environment.get(i));
            
            // Set new HP values
            if(possibleEnemy != null && enemies.contains(possibleEnemy)){
                possibleEnemy.setHP(possibleEnemy.getHP() - attacker.getAP());
                if(possibleEnemy.getHP() <= 0){
                    int x = Integer.parseInt(findTheCharacter(possibleEnemy.getSymbol()).split(",")[0]);
                    int y = Integer.parseInt(findTheCharacter(possibleEnemy.getSymbol()).split(",")[1]);
                    table[y][x] = "  ";
                    possibleEnemy.setHP(0);
                }
            }
        }
    }
    
    // When the move is did, it increases by 1
    // If it is equal to the max step of the character, provides the special attack for elf
    public int moveCount;
    
    // Moving and attacking of the characters is implemented here
    public void checkTheMove(ArrayList<? extends Characters> allies, String pawn, String move, ArrayList<? extends Characters> enemies){
        
        moveCount = 1;
        
        // Finds and verifies the character's position by x and y (x,y)
        String position = findTheCharacter(pawn);
        int positionX = Integer.parseInt(position.split(",")[0]);
        int positionY = Integer.parseInt(position.split(",")[1]);
        int moveX, moveY, maxSteps = 0;
        
        // Verifies the max step of the character
        for(int a = 0;  a < allies.size(); a++){
            if(allies.get(a).toString().equals(pawn)){
                maxSteps = allies.get(a).getMoveSteps();
            }
        }
        
        for(int i = 0; i < move.split(",").length; i++){
            
            // Try block to handle the possible errors
            try{
                // Define the next move
                moveX = Integer.valueOf(move.split(",")[i]);
                moveY = Integer.valueOf(move.split(",")[i+1]);
                
                // Finds the character at current and next position
                Characters currentPlace = detectTheCharacter(table[positionY][positionX]);
                Characters plannedPlace = detectTheCharacter(table[positionY + moveY][positionX + moveX]);

                // Throwing errors
                if(move.split(",").length / 2 != maxSteps){
                    throw new MoveCountException();
                }
                else if(table[positionY + moveY][positionX + moveX].equals("*")
                || table[positionY + moveY][positionX + moveX].equals("**")){
                    throw new BoundaryException();
                }
                
                else{
                    errorController = 0;
                    
                    // Ork heals at the beginning of the move
                    if(currentPlace != null && currentPlace.getClass().equals(Ork.class)){
                        orkHeal((Ork) currentPlace, positionX, positionY, allies);
                    }
                    if(!allies.contains(plannedPlace)){
                        
                        if(enemies.contains(plannedPlace)){
                            fightForTheDeath(currentPlace, plannedPlace);
                            break;
                        }
                        else{
                            
                            // Move the character to its new position
                            // Old position is two-space
                            table[positionY][positionX] = "  ";
                            positionY += moveY;
                            positionX += moveX;
                            table[positionY][positionX] = pawn;
                            
                            // After the new move, checks the elf's ranged attack
                            if(currentPlace != null && currentPlace.getClass().equals(Elf.class) && moveCount == maxSteps){
                                elfRangedAttack((Elf) currentPlace, positionX, positionY, enemies);
                            }
                            
                            else{
                                checkTheRange(enemies, positionX, positionY);
                            }
                            moveCount++;
                        }
                    }
                    else{
                        break;
                    }
                }
            }
            
            // Catching the related errors
            catch(ArrayIndexOutOfBoundsException e){
                continue;
            }
            catch(MoveCountException me){
                
                // If the error did not thrown at first move, prints the board
                if(moveCount != 1){
                    boardWithTabularFormat(table);
                    charactersAndHPValues();
                }
                WriteOutputFile.writeOutput(me.toString() + "\n\n");
                errorController = 1;
                break;
            }
            catch(BoundaryException be){
                
                // If the error did not thrown at first move, prints the board
                if(moveCount != 1){
                    boardWithTabularFormat(table);
                    charactersAndHPValues();
                }
                WriteOutputFile.writeOutput(be.toString() + "\n\n");
                errorController = 1;
                break;
            }
            i++;
        }
    }
    
    
    // Splits into the array in commands fileAdds into the array list
    // Adds into the array list with their character symbols
    public void defineMoves(){
        
        ArrayList<String[]> movements = new ArrayList<>();
        for(int i = 0; i < Main.commands_input.size(); i++){
            
            String[] moves = Main.commands_input.get(i).split(" ")[1].split(";");
            movements.add(moves);
            
        }
        for(int k = 0; k < movements.size(); k++){
            String[] movements1;
            movements1 = movements.get(k);
            List<List<String>> subList = new LinkedList<>();
            for(int j = 0; j < movements1.length; j+=2){
                subList.add(Arrays.asList(movements1).subList(j, j + 2));
            }
            movement.add(Main.commands_input.get(k).split(" ")[0] + " " + subList);
        }
    }
    
    
    // By using initials file, place the characters onto the table
    public void placeCharacters(){
        
        for(Characters c : characters){
            table[Integer.valueOf(c.getPositionY()) + 1][Integer.valueOf(c.getPositionX()) + 1] = c.getSymbol();
        }
        
    }
    
    
    // By reading initials file, defines the characters by looking at the teams
    // Adds into the 3 different array lists
    public void defineCharacters(){
        
        for(int i = 0; i < Main.initials_input.size(); i++){
            
            if(Main.initials_input.get(i).equals("CALLIANCE")){
                
                while(!Main.initials_input.get(i).isEmpty()){
                    i++;
                    if(!Main.initials_input.get(i).isEmpty()){
                        if(Main.initials_input.get(i).split(" ")[0].equals("ELF")){
                            Characters elf = new Elf(Main.initials_input.get(i).split(" ")[0], 
                                                     Main.initials_input.get(i).split(" ")[1], 
                                                     Main.initials_input.get(i).split(" ")[2], 
                                                     Main.initials_input.get(i).split(" ")[3]);
                            characters.add(elf);
                            calliances.add((Calliance) elf);
                            elfs.add((Elf) elf);
                        }
                        else if(Main.initials_input.get(i).split(" ")[0].equals("DWARF")){
                            Characters dwarf = new Dwarf(Main.initials_input.get(i).split(" ")[0], 
                                                         Main.initials_input.get(i).split(" ")[1], 
                                                         Main.initials_input.get(i).split(" ")[2], 
                                                         Main.initials_input.get(i).split(" ")[3]);
                            characters.add(dwarf);
                            calliances.add((Calliance) dwarf);
                            dwarfs.add((Dwarf) dwarf);
                        }
                        else if(Main.initials_input.get(i).split(" ")[0].equals("HUMAN")){
                            Characters human = new Human(Main.initials_input.get(i).split(" ")[0], 
                                                         Main.initials_input.get(i).split(" ")[1], 
                                                         Main.initials_input.get(i).split(" ")[2], 
                                                         Main.initials_input.get(i).split(" ")[3]);
                            characters.add(human);
                            calliances.add((Calliance) human);
                            humans.add((Human) human);
                        }
                    }
                }
            }
            
            else if(Main.initials_input.get(i).equals("ZORDE")){
                
                while(i != Main.initials_input.size() - 1){
                    i++;
                    if(Main.initials_input.get(i).split(" ")[0].equals("GOBLIN")){
                        Characters goblin = new Goblin(Main.initials_input.get(i).split(" ")[0], 
                                                       Main.initials_input.get(i).split(" ")[1], 
                                                       Main.initials_input.get(i).split(" ")[2], 
                                                       Main.initials_input.get(i).split(" ")[3]);
                        characters.add(goblin);
                        zordes.add((Zorde) goblin);
                        goblins.add((Goblin) goblin);
                    }
                    else if(Main.initials_input.get(i).split(" ")[0].equals("TROLL")){
                        Characters troll = new Troll(Main.initials_input.get(i).split(" ")[0], 
                                                     Main.initials_input.get(i).split(" ")[1], 
                                                     Main.initials_input.get(i).split(" ")[2], 
                                                     Main.initials_input.get(i).split(" ")[3]);
                        characters.add(troll);
                        zordes.add((Zorde) troll);
                        trolls.add((Troll) troll);
                    }
                    else if(Main.initials_input.get(i).split(" ")[0].equals("ORK")){
                        Characters ork = new Ork(Main.initials_input.get(i).split(" ")[0], 
                                                 Main.initials_input.get(i).split(" ")[1], 
                                                 Main.initials_input.get(i).split(" ")[2], 
                                                 Main.initials_input.get(i).split(" ")[3]);
                        characters.add(ork);
                        zordes.add((Zorde) ork);
                        orks.add((Ork) ork);
                    }
                }
            }
        }
    }
    
    
    // By considering the initials file, reads the size and creates the board
    public void defineBoard(){
        
        for(int i = 0; i < Main.initials_input.size(); i++){
            
            int boardSize = Integer.parseInt(Main.initials_input.get(1).split("x")[0]);
            table = new String[boardSize + 2][boardSize + 2];
            
            for(int a = 0; a < table.length - 1; a++){
                table[0][a] = "**";
                table[table.length - 1][a] = "**";
                
                for(int b = 1; b < table.length - 1; b++){
                    table[b][0] = "*";
                }
                for(int c = 1; c < table.length - 1; c++){
                    table[c][table.length - 1] = "*";
                    table[0][table.length - 1] = "";
                    table[table.length - 1][table.length - 1] = "";
                }
            }
            
            for(int y = 1; y  < table.length - 1; y++){
                for(int x = 1;  x < table.length - 1; x++){
                    table[y][x] = "  ";
                }
            }
            break;
        }
    }
    
    
    // This method writes the game table with the tabular format
    public void boardWithTabularFormat(String[][] table){
        
        try{
            for(int y = 0; y  < table.length; y++){
                for(int x = 0;  x < table.length; x++){
                    WriteOutputFile.writeOutput(table[y][x]);
                }
                WriteOutputFile.writeOutput("\n");
            }
            WriteOutputFile.writeOutput("\n");
        }
        catch(NullPointerException e){
            
        }
    }
    
    
    // This method designs the output of characters' HP which will be shown below the table
    public void charactersAndHPValues(){
        
        Collections.sort(characters);
        for(Characters c : characters){
            if(c.getHP() > 0){
                if(c.getName().equals("ELF")){
                    WriteOutputFile.writeOutput(c.getSymbol() + "\t" + c.getHP() + "\t(" + Constants.elfHP + ")\n");
                }
                else if(c.getName().equals("DWARF")){
                    WriteOutputFile.writeOutput(c.getSymbol() + "\t" + c.getHP() + "\t(" + Constants.dwarfHP + ")\n");
                }
                else if(c.getName().equals("HUMAN")){
                    WriteOutputFile.writeOutput(c.getSymbol() + "\t" + c.getHP() + "\t(" + Constants.humanHP + ")\n");
                }
                else if(c.getName().equals("GOBLIN")){
                    WriteOutputFile.writeOutput(c.getSymbol() + "\t" + c.getHP() + "\t(" + Constants.goblinHP + ")\n");
                }
                else if(c.getName().equals("TROLL")){
                    WriteOutputFile.writeOutput(c.getSymbol() + "\t" + c.getHP() + "\t(" + Constants.trollHP + ")\n");
                }
                else if(c.getName().equals("ORK")){
                    WriteOutputFile.writeOutput(c.getSymbol() + "\t" + c.getHP() + "\t(" + Constants.orkHP + ")\n");
                }
            }
        }
        WriteOutputFile.writeOutput("\n");
    }

    public int getErrorController() {
        return errorController;
    }

    public void setErrorController(int errorController) {
        this.errorController = errorController;
    }
    
}


// User defined exceptions thrown by the system and print the error message
class BoundaryException extends Exception{

    @Override
    public String toString() {
        return "Error : Game board boundaries are exceeded. Input line ignored.";
    }
    
}


class MoveCountException extends Exception{

    @Override
    public String toString() {
        return "Error : Move sequence contains wrong number of move steps. Input line ignored.";
    }
    
}