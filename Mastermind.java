import java.util.*;
import java.io.*;

public class Mastermind{
    public static void main(String[] args){
        Scanner userInput = new Scanner(System.in);
        boolean playRound = true;
        System.out.println("Let's play Mastermind!\n");
         

        while(playRound){
          System.out.println("Start a new game? (Enter yes or no): ");
          String userResponse = userInput.nextLine().toLowerCase();
          String randPatt = getRandomPattern(false, 4);
          // System.out.println(randPatt);          
          if(!userResponse.equals("yes")){
            playRound = false;
            break;
          }
          mastermind(randPatt);  
        }
      
        System.out.println("Thanks for playing!");
        userInput.close();
      

    }//main

  //
  public static void mastermind(String target){
    Scanner eaglI = new Scanner(System.in);
    int attemptCount = 1;
    StringBuilder result = new StringBuilder(); 
    System.out.print("\nPlease Enter your Attempt: ");
    String userAttempt = eaglI.nextLine().toUpperCase(); 
    
         while(!userAttempt.equals(target) && attemptCount < 8){
            result.setLength(0);
           
            for(int i = 0; i < target.length(); i++){
               Character letter = userAttempt.charAt(i);
               boolean letterInSamePlace = letter.equals(target.charAt(i));
              
               if(target.contains(String.valueOf(letter)) && !letterInSamePlace){
                  result.append('w');
               }//w if
              
               if(letter.equals(target.charAt(i))){
                  result.append('r'); 
               }
        }//for 
              if(result.toString().equals("rrrr")){
                 attemptCount ++;
                 break;
         }//if
               else{
                 System.out.println(result);
                 System.out.print("Please try again: ");
                 attemptCount ++;
                 userAttempt = eaglI.nextLine();
          }//else
           
      }//while
      if(attemptCount == 8 && !userAttempt.equals(target)){
            System.out.printf("You have run out of attempts! Try harder next time!\n");
            System.exit(0);
         } else{
            System.out.printf("Congratulations! You won in %d attempts\n", attemptCount);
         }
   }

    public static String getRandomPattern(boolean allowDupes, int patternLength){
        String availableLetters = "ABCDEF";
        String pattern = "";
        Random rand = new Random();
        Set<Character> noDuplicates = new HashSet<>();
      
        while(pattern.length() < patternLength){
          try{
            int index = rand.nextInt(availableLetters.length());
            char letter = availableLetters.charAt(index);
          
          if(allowDupes == true || !pattern.contains(String.valueOf(letter))){
           pattern += letter;
          }  //if
        } catch (StringIndexOutOfBoundsException e) {
            return getRandomPattern(allowDupes, patternLength);
      }//while 
    }//getRandomPattern
      
      return pattern;
  }
    
 
}//class