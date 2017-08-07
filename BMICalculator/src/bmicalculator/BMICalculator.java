/*
 * Mitul Savani
 * Class CSC 210.02
 * 09/14/2016
 * To Calculate the BMI and print the categories
 */
package bmicalculator;

import java.util.Scanner;

public class BMICalculator {

    public static void main(String[] args) 
    {
        Scanner input=new Scanner(System.in);                   //calling scanner class for taking input from user.
        
        System.out.print("Enter your name: ");                  //asking user name 
        String name=" ";                                        //creating and assigning default value of variable 'name'
        name=input.nextLine();                                  //storing user name in variable 'name'
        
        System.out.print("Enter height(inches): ");             //asking user height
        int height=0;                                           //creating and assigning default value of variable 'height'
        height=input.nextInt();                                 //storing user height in variable 'height'
        
        System.out.print("Enter weight: ");                     //asking user weight
        double weight =0;                                       //creating and assigning default value of variable 'weight'
        weight=input.nextInt();                                 //storing user weight in variable 'weight'
        
        double BMI=0;                                           //creating variable 'BMI' to store the BMI of user
        
        //Creating the string 'category' where we will store the category of the user after looking at their BMI
        String category= " ";                                   
        
        int ft=0;                                               //creating and assigning the value of variable 'ft'
        ft=height/12;                                           //calculating feet of the user height 
        int in=0;                                               //creating and assigning the value of variable 'in'
        in=height%12;                                           //calculating left over inches
        
        //Expression to calculate the BMI of the user with using his/her height and weight
        BMI=(weight/(height*height))*703;                        
       
        
        //Checking the range of the BMI if it falls in the Underweight
        if(BMI<=18.5)                                           
        {
            category="Underweight";     //Storing the category in variable 'category'
        }
        
        //Checking the range of the user BMI if it falls in the Normal weight
        else if(BMI>18.5 && BMI<=24.9)
        {
            category="Normal weight";   //Storing the category in variable 'category'
        }
        
        //Checking the range of the user BMI if it falls in the Overweight
        else if(BMI>24.9 && BMI<=29.9)
        {
            category="Overweight";      //Storing the category in variable 'category'
        }
        
        //Checking the range of the user BMI if it falls in the Obesity
        else 
        {
            category="Obesity";         //Storing the category in variable 'category'
        }
        
        // We will now console the display messagae to the user
         System.out.println();
         System.out.println(" Name    : "+name);
         System.out.println(" Height  : "+ft+"   ft, "+in+"   in");
         System.out.println(" Weight  : "+weight+" lb");
         System.out.println(" BMI     : "+category);
    }
}
        
        
        
        
        
        

