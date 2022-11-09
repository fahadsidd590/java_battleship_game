package javabattleship;
/*
In your game the computer will randomly place 5 different ships into a 10 x 10 grid. 
The player will then be able to select and individual square from the grid to fire at. 
If a ship is on that square the ship is sunk the player gains points.  After the player has had ten shots
the game ends and the player’s score is displayed.  The game can end before ten moves if the player sinks all the ships.
Although in the game there is never any reason to display the grid.  
The computer randomly assigns five ships to the grid ensuring that they do not overlap.
The ships can be placed horizontally or vertically but not diagonally.  
The ships are all different sizes and worth different amount of points if shot as shown below.
Ship			No of squares	Points
Aircraft Carrier	5 			2	
Battleship		4 			4
Submarine		3 			6
Destroyer 		2 			8
Patrol boat		1 			10

*/
import java.time.temporal.TemporalAdjusters;
import java.util.Random;
import java.util.Scanner;

class battleship {

    int score = 0;
    int[][] battle_filed = new int[10][10];
    Random random = new Random();

    public void show_filed() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print("  " + battle_filed[i][j]);
            }
            System.out.println();
        }
    }

    public void set_aircraft() {

        int x = random.nextInt(10);
        int y = random.nextInt(6);

        for (int i = 0; i < 5; i++) {
            battle_filed[x][y] = 2;
            y = y + 1;
        }

    }

    public void set_battleship() {
        int x = random.nextInt(7);
        int y = random.nextInt(10);
        int r;
        boolean check = true;
        while (check) {
            r = x;
            for (int i = 0; i < 4; i++) {
                if (battle_filed[r][y] == 0) {
                    check = false;
                } else {
                    check = true;
                    break;
                }
                r = r + 1;
            }
            if (check) {
                x = random.nextInt(7);
                y = random.nextInt(10);
            }
        }
        for (int i = 0; i < 4; i++) {
            battle_filed[x][y] = 4;
            x = x + 1;
        }
    }

    public void set_Submarine() {
        int x = random.nextInt(10);
        int y = random.nextInt(7);
        int r;
        boolean check = true;
        while (check) {
            r = y;
            for (int i = 0; i < 3; i++) {
                if (battle_filed[x][r] == 0) {
                    check = false;
                } else {
                    check = true;
                    break;
                }
                r = r + 1;
            }
            if (check) {
                x = random.nextInt(10);
                y = random.nextInt(7);
            }
        }
        for (int i = 0; i < 3; i++) {
            battle_filed[x][y] = 6;
            y = y + 1;
        }
    }

    public void set_Destroyer() {
        int x = random.nextInt(8);
        int y = random.nextInt(10);
        int r;
        boolean check = true;
        while (check) {
            r = x;
            for (int i = 0; i < 2; i++) {
                if (battle_filed[r][y] == 0) {
                    check = false;
                } else {
                    check = true;
                    break;
                }
                r = r + 1;
            }
            if (check) {
                x = random.nextInt(8);
                y = random.nextInt(10);
            }
        }
        for (int i = 0; i < 2; i++) {
            battle_filed[x][y] = 8;
            x = x + 1;
        }
    }

    public void set_Patrol_boat() {
        int x = random.nextInt(9);
        int y = random.nextInt(9);
        int r;
        boolean check = true;
        while (check) {
            r = x;
            for (int i = 0; i < 1; i++) {
                if (battle_filed[r][y] == 0) {
                    check = false;
                } else {
                    check = true;
                    break;
                }
                r = r + 1;
            }
            if (check) {
                x = random.nextInt(9);
                y = random.nextInt(9);
            }
        }
        for (int i = 0; i < 1; i++) {
            battle_filed[x][y] = 10;
            x = x + 1;
        }
    }
   public String get_ship_name(int num){
       String ship_name="";
       if(num==2){
        ship_name="Aircraft Carrier";
       }
       else if(num==4){
        ship_name="Battleship";
       }
       else if(num==6){
        ship_name="Submarine";
       }
       else if(num==8){
        ship_name="Destroyer ";
       }
       else{
        ship_name="Patrol boat";
       }
       return ship_name;
   }
    public int fire(int x, int y) {
        int value;
        if (battle_filed[x][y] > 0) {
            value = battle_filed[x][y];
            score = value + score;
            return value;
        } else {
            return 0;
        }
    }
    public int get_scroe() {
        return score;
    }
    public void reset_battle_filed(int num) {
        if (num > 0) {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (battle_filed[i][j] == num) {
                        battle_filed[i][j] = 0;
                    }
                }
            }
        }
    }
    
}

public class Javabattleship {
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        battleship bat = new battleship();
        bat.set_aircraft();
        bat.set_battleship();
        bat.set_Submarine();
        bat.set_Destroyer();
        bat.set_Patrol_boat();
        int mode;
        int n=1,x,y,score=0,totalscore=30,score1;
        String ship_name="";
        do{
            System.out.println("Please select the mode");
            System.out.println("1)Debug Mode");
            System.out.println("2)Normal mode");
            System.out.println("3)Exit");
            mode = a.nextInt();
            switch(mode){
                case 1:
                    System.out.println("Here the conputer set ship");
                    System.out.println("2-> aircraf, 4 -> battle ship,  6->Submarine,  8->Destroyer , 10->Patrol boat  ");
                   for(int i=0;i<10;i++){                       
                       bat.show_filed();
                       System.out.println("Enter the x point");
                       x= a.nextInt();
                       System.out.println("Enter the y point ");
                       y= a.nextInt();
                       score1 =bat.fire(x, y);
                       if(score1>0){
                           score= score+score1;
                           bat.reset_battle_filed(score1);
                           ship_name= bat.get_ship_name(score1);
                           System.out.println("You hit the "+ship_name+" your score is "+ score);
                       }
                       else{
                         System.out.println("You miss the hit  your score is "+ score); 
                       }
                       if(score==totalscore){
                           break;
                       }
                   }
                    if(score==totalscore){
                        System.out.println("You hit  the all ship congratulatio you win  your score is "+ score); 
                       }else{
                         System.out.println("You loss the game  your score is "+ score); 
                    }
                break;
                case 2:
                    for(int i=0;i<10;i++){                       
//                       bat.show_filed();
                       System.out.println("Enter the x point");
                       x= a.nextInt();
                       System.out.println("Enter the y point ");
                       y= a.nextInt();
                       score1 =bat.fire(x, y);
                       if(score1>0){
                           score= score+score1;
                           bat.reset_battle_filed(score1);
                           ship_name= bat.get_ship_name(score1);
                           System.out.println("You hit the "+ship_name+" your score is "+ score);
                       }
                       else{
                         System.out.println("You miss the hit  your score is "+ score); 
                       }
                       if(score==totalscore){
                           break;
                       }
                   }
                    if(score==totalscore){
                        System.out.println("You hit  the all ship congratulatio you win  your score is "+ score); 
                       }else{
                         System.out.println("You loss the game  your score is "+ score); 
                    }
                    
                break;
                case 3:
                    n=0;
                break;
                default:
                    System.out.println("Invalid input");
            }
        }while(n!=0);
        bat.show_filed();
    }

}
