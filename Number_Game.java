package CodSoftIntern;
import java.util.Random;
import java.util.Scanner;
class NumberGame{
    public int generatedNumber;
    private int noofguess=0;
    private int userguess;
    private int score=10;
    public NumberGame(){
        Random randomnumber=new Random();
        this.generatedNumber=randomnumber.nextInt(1,101);
    }
    public void guessnumber(int userguess){
        this.userguess=userguess;
    }
    public int IsCorrectGuess(){
        if (userguess==generatedNumber){
            System.out.println("The guess is correct");
            System.out.println("Round Score : "+score);
            return 0;
        }
        else if (userguess>generatedNumber) {
            System.out.println("Too High! Guess Again.");
            this.score=score-1;
            return 1;
        }
        else{
            System.out.println("Too Low! Guess Again.");
            this.score=score-1;
            return -1;
        }
    }
}
public class Number_Game {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        boolean PlayAgain=true;
        System.out.println("Welcome to number guessing game");
        int totalattempt=10;
        while (PlayAgain){
            System.out.println(" Guess the number in a specified range 1 to 100.");
            NumberGame n=new NumberGame();
            for (int j=0;j<totalattempt;j++){
                int input=sc.nextInt();
                n.guessnumber(input);
                int a=n.IsCorrectGuess();
                if (a==0){
                    System.out.println("You Won! ");
                    j=totalattempt+1;  //for exit from the for loop
                }
                else if (a!=0&&j==totalattempt-1) {
                    System.out.println("Sorry, you've used all your attempts. The number was:"+n.generatedNumber);
                    System.out.println("Round Score: 0");
                }
            }
            System.out.println("You want to Play Again! Yes or No ");
            String playAgainResponse = sc.next();
            PlayAgain = playAgainResponse.equalsIgnoreCase("yes");
        }
    }
}

