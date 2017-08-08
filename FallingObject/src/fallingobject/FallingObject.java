/*
Mitul Savani
09/04/2016
FallingObject
Compute the distance an object will fall under Earth's gravity.
*/
package fallingobject;

/*
English Description :-
To compute the distance we will need to evaluate the equation 
xt = (0.5*a*t*t+v*t+x). Here 'a' is the acceleration, 't' is time,
'v' is for initial velocity and 'x' is initial position of the object.
In the beginning of the program we would need to declare 5 variables 
to store the value of a,t,v,x, and the fifth is 'xt' where we will store
our resulting distance value. The initial value will be -9.8, 15, 0, 0 , 0 respectively.
The data type of our all variables will be double.
To compute the distance we will multiply 0.5*a*t*t, v*t, the following step
will be adding them with the value of x. Now, we will assign that resulting
value to variable 'xt'.
In the end, we will print the following message to the console :
"The distace of an object with acceleration -9.8m/s^2 after 15sec will be = "+ xt +"m"
where xt is the distance variable.
*/

public class FallingObject 
{
    
    public static void main(String[] args) 
    {
        double a=-9.8;           //value of acceleration
        double t=15;             //value of time
        double v=0;              //value of initial velocity
        double x=0;              //value of initial position
        double xt=0;             //resulting distance
        
        xt=(0.5*a*t*t+v*t+x);    //equation to compute distance
        
        //Output message displaying resulting distance.
        System.out.print("The distance of an object with acceleration -9.8m/s^2 after 15sec will be = "+xt+"m");
        System.out.println();
    }
}
        
        
        
      
