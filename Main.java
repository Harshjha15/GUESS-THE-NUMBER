
import java.util.Scanner;
        import java.util.Random;
class Game{
    int userNumber;
    int compNumber;
    int counter = 1;
    public Game(){
        Random r = new Random();
        compNumber = r.nextInt(100)+1 ;
     //   System.out.println(compNumber);
    }

    public int isCorrect(){
        if(userNumber > compNumber) {
            return -1;
        }
        else if(userNumber < compNumber)
        {return 1;
        }

        else {
            return 0;
        }
    }
    public void Counter(){
        counter=counter+1;
    }
}


public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(" Guess the number game " );
        System.out.print("Enter 1 for start the game     ");
        int  x = sc.nextInt();
        if(x==1){

            Game obj = new Game();

            while(true){
                System.out.println("Number of count: " + (obj.counter));
                System.out.println("Enter a number between 1-100: ");
                int  n = sc.nextInt();
                obj.userNumber=n;

                if(obj.isCorrect() == 0){
                    obj.Counter();
                    System.out.println("                 GAME OVER");
                    System.out.println("Congratulations, You've guessed the number.");
                    System.out.println("Total Number of counts: " + (obj.counter-1));
                    break;
                }
                else if(obj.isCorrect() == 1){
                    obj.Counter();
                    System.out.println("Higher number please!");
                }
                else {
                    obj.Counter();
                    System.out.println("Lower number please!");
                }
            }
        }
        else{
            System.out.println("Visit again ");
        }

    }

}