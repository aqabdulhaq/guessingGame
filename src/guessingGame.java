import java.util.Random;
import java.util.Scanner;

class game{
    public int comp;
    public int num=0;
    public int score=100;
    public int guess=0;
    game(){
        Random play = new Random();
        comp = play.nextInt(100);
    }
    public void takeuserinput(){
        Scanner ny = new Scanner(System.in);
        System.out.print("enter the number: ");
        num = ny.nextInt();
    }
    public void iscorrectnum(){
        if (num>100 || num<0){
            System.out.println("please enter a number between 0-100");
        }
    }
    public void setscore(int i) {
        guess = i;
        if (i == 1) {
            score = 100;
        } else {
            score = 100 - i * 10;
        }
    }
}
public class guessingGame {
    public static void main(String[] args) {
        game turn = new game();
        turn.takeuserinput();
        turn.iscorrectnum();

        if (turn.num<100){
            for(int i=1;i<=10;i++){
                if(turn.num < turn.comp){
                    System.out.println("Your number is Smaller than the chosen number.");
                    turn.setscore(i);
                    turn.takeuserinput();
                }
                else if (turn.num > turn.comp){
                    System.out.println("Your number is greater than the chosen number.");
                    turn.setscore(i);
                    turn.takeuserinput();
                }
                else {
                    turn.setscore(i);
                    System.out.println("Correct guess! game is finished.\nYou solved it in " + turn.guess+" turns");
                    System.out.println("with a score of: "+turn.score);
                    break;
                }
            }
        }
        else{
            System.out.println("you have exhausted your turns");
            System.out.println("The number was: "+turn.comp);
        }
    }
}