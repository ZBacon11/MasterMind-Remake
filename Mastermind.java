import java.util.*;
import java.io.*;

public class Mastermind{
    public static void main(String[] args){
        Scanner userInput = new Scanner(System.in);
        System.out.println("Let's play Mastermind!\n");
        System.out.println("Start a new game? (Enter yes or no): ");

        

        if(userInput.nextLine().toLowerCase() == "yes"){
            playMastermind();
        }


    }

    public static void playMastermind(){
        String targetPattern = getRandomPattern(true, 6);
        
    }

    public static String getRandomPattern(boolean allowDupes, int patternLength){
        String patternCombo = "ABCDEF";
        String pattern = "";
        Random rand = new Random();

        while(patternLength > 0){
            int index = rand.nextInt(patternCombo.length());
            pattern = pattern + patternCombo.charAt(index);
            patternLength -= 1;
        }

        return pattern;
    }
}