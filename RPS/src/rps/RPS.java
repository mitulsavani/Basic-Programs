/*
 Mitul Savani
CSC 210.02
09/21/2016
Scissor-Rock-Paper game.
 */
package rps;

import java.util.Scanner;
import java.util.Random;

public class RPS 
{    
    public static void main(String args[])
    {
    
        Scanner input=new Scanner(System.in);                   //Calling scanner class for taking input from user
        Random rnd=new Random();                                /*Calling random class so that computer chooses one number between 0 and 2
                                                                  which represets scissors, rock or paper*/
        int cwin=0;                                             //variable to store computer win count
        int uwin=0;                                             //variable to store user win count
        int user=0;                                             //assigning defaut user input
        String utype="";                                        //assigning default value of user game type
        String ctype="";                                        //assigning default value of computer game type
        
        /*
        keeping the while loop open, so that it keeps running until we exit the loop when either computer or user
        win 2 game out of 3.
        */
        while(true)
        {                                            
            System.out.print("scissor (0), rock (1), paper(2): ");          //Display message to the user.
            if(input.hasNextInt())                                          //checking the input whether it is integer or not.
            {                                         
                user=input.nextInt();                                       //taking input from user and storing in variable in user.
            }
            else                                                            //this loop will execute only if the input is other than the integer.
            {
                System.out.println("That was something other than DIGITS"); //displaying message to the user.
                break;                                                      //this statement will break the code.
            }

            int comp=rnd.nextInt(3);                                        //taking random number[0,3] from computer and storing in variable in comp.

            if(user>=0 && user<=2)                                          //checking the user input if it is between 0 and 3, only afterthen this loop will execute.
            {  
                
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
                    uwin++;             //incrementing the win count of user.
                }
                //These are the only three posibilities where the game can be draw.
                else if(user==0 && comp==0 || user==1 && comp==1 || user==2 && comp==2)
                {
                    System.out.println("The computer is "+ctype+". You are "+utype+ " too. The game is draw");
                }
                //These are the only three posibilities where Computer can win the game against User.
                else if(user==2 && comp==0 || user==0 && comp==1 || user==1 && comp==2)
                {
                    System.out.println("The computer is "+ctype+". You are "+utype+ ". Computer won the game");
                    cwin++;                     //Incrementing the win count of computer.
                }

                System.out.println();           //A blank line between two games, To make the output more tidy.
                
                if(cwin==2)                     //Checking if Computer have won 2 times or not.
                {
                    System.out.println(" COMPUTER WON THE SET OF TWO ");     // Display message.
                    break;                      //These statement will exit the program.
                }
                else if(uwin==2)                //Checking if User have won 2 times or not.
                {
                    System.out.println(" USER WON THE SET OF TWO");         //Display message.
                    break;                      //These statement will exit the program.
                }
            }
            else                                //This loop will only execute if the user input is NOT between 0 and 3.
            {
                System.out.println("INVALID INPUT");    //Display message.
            }
        }
    }
}
        
        

   

