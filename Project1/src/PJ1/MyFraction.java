/*
	MITUL SAVANI
	STUDENT ID: 916540461
	CSC 220.05
	02/19/2017
	
        Savani Production
	PROJECT 1.

*************************************************************************************
 *
 * Important: please look at "Cheating and Plagiarism Policy"
 *            http://cs.sfsu.edu/cheating-and-plagiarism-policy
 *
 * Warning: Don't copy projects from previous semestsres and others!
 *
/*************************************************************************************
 *
 * This class represents a fraction whose numerator and denominator are integers.
 *
 * Requirements:
 * 1. Implement interfaces: MyFractionInterface and Comparable (i.e. compareTo())
 * 2. Implement methods equals() and toString() from class Object
 * 3. Implement static method gcd() using non-recursive algorithm. 
 *    Plaese Refer to strategy in given GCD recursive method.
 *
 * 4. Should work for both positive and negative fractions
 * 5. Must always reduce fraction to lowest term (see Hints 1. below)
 * 6. For a fraction such as 3/-10, it is same as -3/10 (see Hints 2. below)
 * 7. Must display negative fraction as -x/y,
 *         example: (-3)/10 or 3/(-10), must display as -3/10
 * 8. Must throw MyFractionException objects in case of errors, 
 *    must not throw other exception objects
 * 9. Must not add new or modify existing data fields
 * 10. Must not add new public methods
 * 11. May add private methods
 *
 * Hints:
 *
 * 1. To reduce a fraction such as 4/8 to lowest terms, you need to divide both
 *    the numerator and the denominator by their greatest common denominator.
 *    The greatest common denominator of 4 and 8 is 4, so when you divide
 *    the numerator and denominator of 4/8 by 4, you get the fraction 1/2.
 *    The recursive method GCD() which finds the greatest common denominator of
 *    two positive integers is given (see code)
 *       
 * 2. It will be easier to determine the correct sign of a fraction if you force
 *    the fraction's denominator to be positive. However, your implementation must 
 *    handle negative denominators that the client might provide.
 *           
 * 3. You need to downcast reference parameter MyFractionInterface to MyFraction if  
 *    you want to use it as MyFraction. See add, subtract, multiply and divide methods
 *
 * 4. Use "this" to access this object if it is needed
 *
 ************************************************************************************/

package PJ1;

public class MyFraction implements MyFractionInterface, Comparable<MyFraction>
{
	// integer numerator and denominator
	private	int num;	
	private	int den;	

	public MyFraction()
	{
            num=0;
            den=1;
        }   

	public MyFraction(int num, int den)
	{
            setMyFraction(num,den);                     //calling setMyFraction with passing two values; num, den.
       	
	}	// end constructor

	public void setMyFraction(int num, int den)
	{
            if(den==0)                                  //checking if te denominator is 0
            {
                throw new MyFractionException("ERROR");        // returning MyFractionException if initialDenominator is 0
            }
            
            //storing arguments values into class variables
            this.num=num;                               
            this.den=den;                               
            reduceMyFractionToLowestTerms();            
        }	// end setMyFraction

	public double toDouble()
	{
		return (double)num/den;         //type casting into double
	}	// end toDouble 

	public MyFractionInterface add(MyFractionInterface secondFraction)
	{
            MyFraction NewFrac = (MyFraction) secondFraction;           
            MyFraction frac=new MyFraction((num*NewFrac.den+den*NewFrac.num), den*NewFrac.den); // a/b + c/d is (ad + cb)/(bd)
            
            frac.reduceMyFractionToLowestTerms();               //calling other method by passing frac value   
            return frac;        // returning which is a new MyFraction object
	}   // end add

	public MyFractionInterface subtract(MyFractionInterface secondFraction)
	{
            MyFraction NewFrac = (MyFraction) secondFraction;
            MyFraction frac=new MyFraction((num*NewFrac.den - den*NewFrac.num), den*NewFrac.den); // a/b - c/d is (ad - cb)/(bd)
            
            frac.reduceMyFractionToLowestTerms();               //calling other method by passing frac value   
            return frac;                // returning result which is a new MyFraction object
	}	// end subtract

	public MyFractionInterface multiply(MyFractionInterface secondFraction)
	{
            MyFraction NewFrac = (MyFraction) secondFraction;
            MyFraction frac=new MyFraction((num*NewFrac.num),(den*NewFrac.den)); // a/b * c/d is (ac)/(bd)
		
            frac.reduceMyFractionToLowestTerms();               //calling other method by passing frac value   
            return frac;                // returning result which is a new MyFraction object
	}	// end multiply

	public MyFractionInterface divide(MyFractionInterface secondFraction)
	{   
            MyFraction NewFrac = (MyFraction) secondFraction;
            if(NewFrac.num==0)
            {
                throw new MyFractionException("ERROR");                // returning MyFractionException because secondFraction is 0
            }
            MyFraction frac=new MyFraction(num*NewFrac.den,den*NewFrac.num); // a/b / c/d is (ad)/(bc)
            frac.reduceMyFractionToLowestTerms();               //calling other method by passing frac value   
            return frac;                // returning result which is a new MyFraction object
        }	// end divide

	
        /* Static method to compute GCD of 2 integers
         * Must Use non-recursive algorithm!! Refer to the given GCD() recursive method.
         * return -1 to indicate invalid gcd if (X < 0) or (y < 0) or (x=0 and y=0) */
	public static int gcd(int fNum, int sNum) 
	{
             // must implement non-recursive method ... see GCD()
            if((fNum < 0 || sNum < 0) || (fNum == 0 && sNum == 0)){             //implementing conitions
                return -1;}         

            int temp;               //creating temp variable to store the first number;
            while (fNum % sNum != 0) 
            {
               temp = fNum;
               fNum = sNum;
               sNum = temp % sNum;              //storing remainder when first number is divided with the other
            }
               return sNum;                     //returning the greatest common divisor
	} // end gcd

        //method to check if two fractions are equal
	public boolean equals(Object other)     
	{
            MyFraction newFrac = (MyFraction) other;
            return (num == newFrac.num && den == newFrac.den);
	} // end equals


	public int compareTo(MyFraction other)
	{
            MyFraction frac = (MyFraction) other;
            if(num*frac.den > den*frac.num)
            {
            return 1;
            }
            else if(num*frac.den < den*frac.num)
            {
            return -1;
            }
            else
            {
            return 0;
            }
	} // end compareTo

	
	public String toString()
	{
		return num + "/" + den;
	} // end toString


	/** Task: Reduces a fraction to lowest terms. */

        //-----------------------------------------------------------------
        //  private methods start here
        //-----------------------------------------------------------------
        
         // implement this method!
                //
                // Outline:
                // compute GCD of num & den
                // GCD works for + numbers.
                // So, you should eliminate - sign
                // then reduce numbers : num/GCD and den/GCD
		// end reduceMyFractionToLowestTerms

  	/** Task: Computes the greatest common divisor of two integers.
	 *        This is a recursive method!!
	 *  @param integerOne	 an integer
	 *  @param integerTwo	 another integer
	 *  @return the greatest common divisor of the two integers */
	private void reduceMyFractionToLowestTerms()
	{
            int a=Math.abs(num);        //storing absolute value of numerator
            int b=Math.abs(den);        //storing absolute value of denominator
            int gcd = GCD(a,b);         //calling metod GCD, and passing a and b.
            int x = (a/gcd);            
            int y = (b/ gcd);
            if((num < 0 && den > 0) || (num > 0 && den < 0))        //checking conditions, and implementing required steps.
                num = -x;
            else
                num = x;
            
             den = y;
        }
        
        //given method
	private int GCD(int integerOne, int integerTwo)            
	{
		 int result;

		 if (integerOne % integerTwo == 0)
			result = integerTwo;
		 else
			result = GCD(integerTwo, integerOne % integerTwo);

		 return result;
	}	// end GCD


	//-----------------------------------------------------------------
	//  Some tests are given here 

                        // MAIN CLASS
	public static void main(String[] args)
	{
		MyFractionInterface firstOperand = null;
		MyFractionInterface secondOperand = null;
		MyFractionInterface result = null;
                double doubleResult = 0.0;

		MyFraction nineSixteenths = new MyFraction(9, 16);  // 9/16
		MyFraction oneFourth = new MyFraction(1, 4);        // 1/4

		System.out.println("\n=========================================\n");
		// 7/8 + 9/16
		firstOperand = new MyFraction(7, 8);
		result = firstOperand.add(nineSixteenths);
		System.out.println("The sum of " + firstOperand + " and " +
				nineSixteenths + " is \t\t" + result);
		System.out.println("\tExpected result :\t\t23/16\n");

		// 9/16 - 7/8
		firstOperand = nineSixteenths;
		secondOperand = new MyFraction(7, 8);
		result = firstOperand.subtract(secondOperand);
		System.out.println("The difference of " + firstOperand	+
				" and " +	secondOperand + " is \t" + result);
		System.out.println("\tExpected result :\t\t-5/16\n");


		// 15/-2 * 1/4
		firstOperand = new MyFraction(15, -2); 
		result = firstOperand.multiply(oneFourth);
		System.out.println("The product of " + firstOperand	+
				" and " +	oneFourth + " is \t" + result);
		System.out.println("\tExpected result :\t\t-15/8\n");

		// (-21/2) / (3/7)
		firstOperand = new MyFraction(-21, 2); 
		secondOperand= new MyFraction(3, 7); 
		result = firstOperand.divide(secondOperand);
		System.out.println("The quotient of " + firstOperand	+
				" and " +	secondOperand + " is \t" + result);
		System.out.println("\tExpected result :\t\t-49/2\n");

		// -21/2 + 7/8
		firstOperand = new MyFraction(-21, 2); 
		secondOperand= new MyFraction(7, 8); 
		result = firstOperand.add(secondOperand);
		System.out.println("The sum of " + firstOperand	+
				" and " +	secondOperand + " is \t\t" + result);
		System.out.println("\tExpected result :\t\t-77/8\n");


                // 0/10, 5/(-15), (-22)/7
		firstOperand = new MyFraction(0, 10); 
                doubleResult = firstOperand.toDouble();
		System.out.println("The double floating point value of " + firstOperand	+ " is \t" + doubleResult);
		System.out.println("\tExpected result \t\t\t0.0\n");
		firstOperand = new MyFraction(1, -3); 
                doubleResult = firstOperand.toDouble();
		System.out.println("The double floating point value of " + firstOperand	+ " is \t" + doubleResult);
		System.out.println("\tExpected result \t\t\t-0.333333333...\n");
		firstOperand = new MyFraction(-22, 7); 
                doubleResult = firstOperand.toDouble();
		System.out.println("The double floating point value of " + firstOperand	+ " is \t" + doubleResult);
		System.out.println("\tExpected result \t\t\t-3.142857142857143");
		System.out.println("\n=========================================\n");
		firstOperand = new MyFraction(-21, 2); 
		System.out.println("First = " + firstOperand);
		// equality check
		System.out.println("check First equals First: ");
		if (firstOperand.equals(firstOperand))
			System.out.println("Identity of fractions OK");
		else
			System.out.println("ERROR in identity of fractions");

		secondOperand = new MyFraction(-42, 4); 
		System.out.println("\nSecond = " + secondOperand);
		System.out.println("check First equals Second: ");
		if (firstOperand.equals(secondOperand))
			System.out.println("Equality of fractions OK");
		else
			System.out.println("ERROR in equality of fractions");

		// comparison check
		MyFraction first  = (MyFraction)firstOperand;
		MyFraction second = (MyFraction)secondOperand;
		
		System.out.println("\ncheck First compareTo Second: ");
		if (first.compareTo(second) == 0)
			System.out.println("MyFractions == operator OK");
		else
			System.out.println("ERROR in fractions == operator");

		second = new MyFraction(7, 8);
		System.out.println("\nSecond = " + second);
		System.out.println("check First compareTo Second: ");
		if (first.compareTo(second) < 0)
			System.out.println("MyFractions < operator OK");
		else
			System.out.println("ERROR in fractions < operator");

		System.out.println("\ncheck Second compareTo First: ");
		if (second.compareTo(first) > 0)
			System.out.println("MyFractions > operator OK");
		else
			System.out.println("ERROR in fractions > operator");

		System.out.println("\n=========================================");

		System.out.println("\ncheck MyFractionException: 1/0");
		try {
			MyFraction a1 = new MyFraction(1, 0);		    
		        System.out.println("Error! No MyFractionException");
		}
		catch ( MyFractionException fe )
           	{
              		System.err.printf( "Exception: %s\n", fe );
           	} // end catch
		System.out.println("Expected result : MyFractionException!\n");

		System.out.println("\ncheck MyFractionException: division");
		try {
			MyFraction a2 = new MyFraction();		    
			MyFraction a3 = new MyFraction(1, 2);		    
			a3.divide(a2);
		        System.out.println("Error! No MyFractionException");
		}
		catch ( MyFractionException fe )
           	{
              		System.err.printf( "Exception: %s\n", fe );
           	} // end catch
		System.out.println("Expected result : MyFractionException!\n");

		System.out.println("\ncheck static gcd(204,504)");
		System.out.println("Result: " + gcd(204,504));
		System.out.println("Expected result : 12\n");

		System.out.println("\ncheck static gcd(0,504)");
		System.out.println("Result: " + gcd(0,504));
		System.out.println("Expected result : 504\n");

		System.out.println("\ncheck static gcd(204,-10)");
		System.out.println("Result: " + gcd(204,-10));
		System.out.println("Expected result : -1\n");

	}	// end main
} // end MyFraction

