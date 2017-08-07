/*
Mitul Savani 
CSC 210.02
10/31/2016  
Rock-Paper-Scissors by using Methods.
 */
package rpsmethods;

import java.util.Random;
import java.util.Scanner;


public class RPSMethods 
{

    // This is a opening message method with no return value.
    public static void displayOpeningMessage()
    {
       System.out.println("This program will play a game of Rock-Paper-Scissors.");
       System.out.println("For this program 0 will scissors, 1 will be rock, and 2 will be paper.");
       System.out.println();
    }
    
    //This method will take input from user.
     public static int getUserMove()
    {
        Scanner input=new Scanner(System.in);           //calling scanner class which will help us to take input fom the user
        int userInput=-1;                               // I had to initialize userInput as -1, and i can't intialize with value 0, cause then it will issume that usermove is 0, which is scissors
        
     //this do-while loop will run until user input valid number, that is from 0 to 2.   
     do{
           
           System.out.print("scissor(0), rock(1), paper(2) : ");        //just print statement.
           
           if(input.hasNextInt())                                       //This loop will check if the input is digit
           {
                userInput=input.nextInt();                              //storing input
           
           
                if(userInput<0 || userInput>2)                          //checking if the input is not in out valid range.
                {
                System.out.println("Invalid move. Input not in range"); //consoling the message that the number is not in range
                System.out.println();                                   //Skiping a line to make our output tidy.
                }
            }
            else                                                        // This loop will only run if the input from the suer is other than digits
           {
                System.out.println("Invalid input. Please enter a number");     //Printing that the input is not a digit.
                System.out.println();                                           //Skiping a line to make our output tidy.
                input.next();
            }
        }while(userInput<0 || userInput>2);                                     //this expression will only be false if the input from the user is any of these numbers: 0,1,2.
        return userInput;                        //returning user move to the main class.
    }
    
    //This method will generate random number from 0 to 2: This is computer move. 
    public static int getCPUMove()
    {
       Random ran = new Random();           //Calling random class
       int comMove=ran.nextInt(3);          //This sentence/syntax will generate random number from 0 to 2, and will be stored in variable 'comMove'
       return comMove;                      //Returning comMove to the main class.
    }
    
    //This method will run a logic and will determine whether who won the game, USER or COMP?
    public static void determineWinner(int user, int comp)
    {
        String utype="";                    //assigning default value of user game type
        String ctype="";                    //assigning default value of computer game type
        
        
                //checking the user response and will store that type in string 'uype'.
                if(user==0){                                                
                utype="scissor";}
                else if(user==1){
                utype="rock";}
                else if(user==2){
                utype="paper";}
                
                //checking the computer response and will store that type in string 'ctype'.
                if(comp==0){                                                
                ctype="scissor";}                                           
                else if(comp==1){
                ctype="rock";}
                else if(comp==2){
                ctype="paper";}

                //Using my logic by comparing the user response and random response of computer.
                //I am compressing the checking condition and piling up to minimize the number of loop.
                
                //These are the only three posibilities where User can win the game against Computer.
                if(user==0 && comp==2 || user==1 && comp==0 || user==2 && comp==1)  
                {
                    System.out.println("The computer is "+ctype+". You are "+utype+ ". You won the game");
                    
                }
                //The posibility where the game can be draw.
                else if(user==comp)
                {
                    System.out.println("The computer is "+ctype+". You are "+utype+ " too. The game is draw");
                }
                //These are the only three posibilities where Computer can win the game against User.
                else if(user==2 && comp==0 || user==0 && comp==1 || user==1 && comp==2)
                {
                    System.out.println("The computer is "+ctype+". You are "+utype+ ". Computer won the game");
                    
                }
    }

            
            
            
    public static void main(String[] args)                          //main class
    {
       displayOpeningMessage();                                     //calling displayOpeningMessage method.
       /*I am creating a variable with name 'userMove' and then calling a method getUserMove. 
       The return value from the method will be saved in variable 'userMove' */
       int userMove = getUserMove();    
       
       /*I am creating a variable with name 'cpuMove' and then calling a method getCPUMove. 
       The return value from the method will be saved in variable 'cpuMove' */
       int cpuMove = getCPUMove();
       
       //calling dtermineWinner method, to know who won the game.
       determineWinner(userMove, cpuMove);
    }
}
