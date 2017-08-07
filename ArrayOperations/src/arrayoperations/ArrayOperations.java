/*
Mitul Savani
Class CSC 210.02
10/10/2016
ArrayOperations 
 */
package arrayoperations;

import java.util.Random;


public class ArrayOperations {

   
    public static void main(String[] args) 
    {
        Random rnd=new Random();                    //Creating object of Random class
        
        int arr[]=new int[10000];                   //Creating an array of integers with name 'arr' which consist of 10000 integers.
        int i=0;                                    //A variable 'i' using as an iteration variable in all Loops. Default value: 0
        
        //Filling array with random numbers between 0 and 200.
        for(i=0;i<arr.length;i++)
        {
            arr[i]=rnd.nextInt(201);                //fillling each element with random num between 0 and 200, by calling random class.
        }
        
        //Computing the sum of array element.
        int sum=0;                                  //creting variable 'sum' with default value 0, which I will use to compute the Sum of array.
        for(i=0;i<arr.length;i++)
        {
            sum=sum+arr[i];                         //Adding each Array element, and storing back in variable 'sum'.
        }
        
        double sum2=0;                              //Creating 'sum2' to store the sum of the array.
        double Avg=0;                               //Creating 'Avg' to compute the average of the array.
        
        //Computing the sum of the array
        for(i=0;i<arr.length;i++)
        {
            sum2=sum2+arr[i];
        }
        Avg=sum2/arr.length;                        //computing average by dividing sum2 with the number of elements.
        
        //Finding minimum value of array and where it occurs.
       int min=arr[0];                              //Default value of min is the first element of array.
       int minIndex=0;                              //Default index of min is the first index of arrray (i.e) 0.
       
       for(i=0;i<arr.length;i++)
       {
           if(arr[i]<min)                           //Comparing our min value with each element of the array.
           {
               min=arr[i];                          //Storing the new minimum value in the variable 'min'.
               minIndex=i;                          //Storing the index of new minimum value in variable 'minIndex'.
                
           }
        }
       
       //Finding minimum value of array and where it occurs.
       int max=arr[0];                              //Default value of max is the first element of array.
       int maxIndex=0;                              //Default index of max is the first index of arrray (i.e) 0.
       
       for(i=0;i<arr.length;i++)
       {
           if(arr[i]>max)                           //Comparing our max value with each element of the array.
           {
               max=arr[i];                          //Storing the new maximum value in the variable 'max'.
               maxIndex=i;                          //Storing the index of new maximum value in variable 'maxIndex'.
                
           }
        }
       
       //Finding number of even and odd numbers in the array.
       int EvenCount=0;                             //Creating a variable 'EvenCount' with value 0. To store the number of Even numbers in array.
       int OddCount=0;                              //Creating a variable 'OddCount' with value 0. To store the number of Odd numbers in array.
       for(i=0;i<arr.length;i++)
       {
           if(arr[i]%2==0)                          //Checking if the array element is even or not.
           {
               EvenCount++;                         //Counting number of even numbers.
           }
           else                                     //Else loop will only execute if the number is odd.
           {
               OddCount++;                          //Counting number of odd numbers.
           }
        }
       
       //Computing sum of even numbers in the array.
       int SumEven=0;                               //To store the sum of Even numbers in the array.
       for(i=0;i<arr.length;i++)
       {
           if(arr[i]%2==0)                          //Checking if the array element is even.
           {
               SumEven=SumEven+arr[i];              //Adding even number of array element, and storing back in variable 'SumEven'.
           }
        }
       
       //Computing sum of odd numbers in the array.
       int SumOdd=0;                                //To store the sum of Even numbers in the array.
       for(i=0;i<arr.length;i++)
       {
           if(arr[i]%2==1)                          //Checking if the array element is odd.
           {
               SumOdd=SumOdd+arr[i];                //Adding odd number of array element, and storing back in variable 'SumOdd'.
           }
        }
      
        //   OUTPUT MESSAGE
       
       System.out.println("The Sum is : "+sum);
       System.out.println("The Average is : "+Avg);
       System.out.println("The Minimum value is: "+min+" and its index is "+minIndex);
       System.out.println("The Maximum value is: "+max+" and its index is "+maxIndex);
       System.out.println("The Array contains "+EvenCount+" even numbers.");
       System.out.println("The Array contains "+OddCount+" odd numbers.");
       System.out.println("The Sum of odd numbers: "+SumOdd);
       System.out.println   ("The Sum of even numbers: "+SumEven);
    }
}  