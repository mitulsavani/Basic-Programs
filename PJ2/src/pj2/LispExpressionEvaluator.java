/************************************************************************************
 *
 *  		CSC220 Programming Project#2
 *  
 *              NAME: MITUL SAVANI
 *              DATE: 03/29/2017
 *              CLASS: 220.05
 * 
 * Due Date: 23:55pm, Wednesday, 4/5/2017 
 *           Upload LispExpressionEvaluator.java to ilearn 
 *
 * Specification: 
 *
 * Taken from Project 7, Chapter 5, Page 178
 * I have modified specification and requirements of this project
 *
 * Ref: http://www.gigamonkeys.com/book/        (see chap. 10)
 *
 * In the language Lisp, each of the four basic arithmetic operators appears 
 * before an arbitrary number of operands, which are separated by spaces. 
 * The resulting expression is enclosed in parentheses. The operators behave 
 * as follows:
 *
 * (+ a b c ...) returns the sum of all the operands, and (+ a) returns a.
 *
 * (- a b c ...) returns a - b - c - ..., and (- a) returns -a. 
 *
 * (* a b c ...) returns the product of all the operands, and (* a) returns a.
 *
 * (/ a b c ...) returns a / b / c / ..., and (/ a) returns 1/a. 
 *
 * Note: + * - / must have at least one operand
 *
 * You can form larger arithmetic expressions by combining these basic 
 * expressions using a fully parenthesized prefix notation. 
 * For example, the following is a valid Lisp expression:
 *
 * 	(+ (- 6) (* 2 3 4) (/ (+ 3) (* 1) (- 2 3 1)) (+ 1))
 *
 * This expression is evaluated successively as follows:
 *
 *	(+ (- 6) (* 2 3 4) (/ 3 1 -2) (+ 1))
 *	(+ -6 24 -1.5 1)
 *	17.5
 *
 * Requirements:
 *
 * - Design and implement an algorithm that uses Java API stacks to evaluate a 
 *   valid Lisp expression composed of the four basic operators and integer values. 
 * - Valid tokens in an expression are '(',')','+','-','*','/',and positive integers (>=0)
 * - Display result as floting point number with at 2 decimal places
 * - Negative number is not a valid "input" operand, e.g. (+ -2 3) 
 *   However, you may create a negative number using parentheses, e.g. (+ (-2)3)
 * - There may be any number of blank spaces, >= 0, in between tokens
 *   Thus, the following expressions are valid:
 *   	(+   (-6)3)
 *   	(/(+20 30))
 *
 * - Must use Java API Stack class in this project.
 *   Ref: http://docs.oracle.com/javase/7/docs/api/java/util/Stack.html
 * - Must throw LispExpressionEvaluatorException to indicate errors
 * - Must not add new or modify existing data fields
 * - Must implement these methods : 
 *
 *   	public LispExpressionEvaluator()
 *   	public LispExpressionEvaluator(String inputExpression) 
 *      public void reset(String inputExpression) 
 *      public double evaluate()
 *      private void evaluateCurrentOperation()
 *
 * - You may add new private methods
 *
 *************************************************************************************/

package PJ2;
import java.util.*;

public class LispExpressionEvaluator
{
    // Current input Lisp expression
    private String inputExpr;

    // Main expression stack & current operation stack
    private Stack<Object> inputExprStack;
    private Stack<Double> evaluationStack;


    // default constructor
    // set inputExpr to "" 
    // create stack objects
    public LispExpressionEvaluator()
    {
        inputExpr = "";
        inputExprStack = new Stack<Object>();
        evaluationStack = new Stack<Double>();
    }

    // constructor with an input expression 
    // set inputExpr to inputExpression 
    // create stack objects
    public LispExpressionEvaluator(String inputExpression) 
    {
        inputExpr = inputExpression;
        inputExprStack = new Stack<Object>();
        evaluationStack = new Stack<Double>();
    }

    // set inputExpr to inputExpression 
    // clear stack objects
    public void reset(String inputExpression) 
    {
        inputExprStack.clear();
        evaluationStack.clear();
        inputExpr = inputExpression;
    }


    // This function evaluates current operator with its operands
    // See complete algorithm in evaluate()
    //
    // Main Steps:
    // 		Pop operands from inputExprStack and push them onto 
    // 			evaluationStack until you find an operator
    //  	Apply the operator to the operands on evaluationStack
    //          Push the result into inputExprStack
    //
    private void evaluateCurrentOperation()
    {
        double result = 0;
        
        while (!inputExprStack.isEmpty() && inputExprStack.peek().toString().charAt(0) != '(') 
        {
            if (checkforDouble(inputExprStack.peek().toString())) 
            {
                evaluationStack.push(Double.parseDouble(inputExprStack.pop().toString()));
            }
            else 
            {
                char item = inputExprStack.peek().toString().charAt(0);
                if (evaluationStack.isEmpty())
                    throw new LispExpressionEvaluatorException("Oprands Missing somewhere ");
                switch (item) 
                {
                    case '+':
                        inputExprStack.pop();
                        result = 0;
                        while (!evaluationStack.empty())
                            result = result + evaluationStack.pop();
                        evaluationStack.push(result);
                        break;

                    case '-':
                            inputExprStack.pop();
                            if (evaluationStack.size() == 1)
                                evaluationStack.push(0 - evaluationStack.pop());
                            else 
                            {
                                result = evaluationStack.pop();
                                while (!evaluationStack.empty())
                                    result = result - evaluationStack.pop();
                                evaluationStack.push(result);
                            }
                            break;
                    case '*':
                        inputExprStack.pop();
                        result = 1;
                        while (!evaluationStack.empty())
                        result = result * evaluationStack.pop();
                        evaluationStack.push(result);
                        break;

                    case '/':
                        inputExprStack.pop();
                        if (evaluationStack.peek() == 0)
                        throw new LispExpressionEvaluatorException(" Divided by 0");
                        
                        if (evaluationStack.size() == 1)
                            evaluationStack.push(1 / evaluationStack.pop());
                        
                        else {
                            result = evaluationStack.pop();
                            while (!evaluationStack.empty()) {
                                if (evaluationStack.peek() == 0)
                                    throw new LispExpressionEvaluatorException("Divided by 0");
                                result = result / evaluationStack.pop();
                            }
                            evaluationStack.push(result);
                        }
                        break;
                    default:
                }
            }
        }
        //get rid of the last '('
        if (inputExprStack.isEmpty())
            throw new LispExpressionEvaluatorException("parameters not correct, check it!");
        else
            inputExprStack.pop();
        inputExprStack.push(evaluationStack.pop());
	// add statements
    }

    /**
     * This funtion evaluates current Lisp expression in inputExpr
     * It return result of the expression 
     *
     * The algorithm:  
     *
     * Step 1   Scan the tokens in the string.
     * Step 2		If you see an operand, push operand object onto the inputExprStack
     * Step 3  	    	If you see "(", next token should be an operator
     * Step 4  		If you see an operator, push operator object onto the inputExprStack
     * Step 5		If you see ")"  // steps in evaluateCurrentOperation() :
     * Step 6			Pop operands and push them onto evaluationStack 
     * 					until you find an operator
     * Step 7			Apply the operator to the operands on evaluationStack
     * Step 8			Push the result into inputExprStack
     * Step 9    If you run out of tokens, the value on the top of inputExprStack is
     *           is the result of the expression.
     */
    public double evaluate()
    {
        // only outline is given...
        // you need to add statements/local variables
        // you may delete or modify any statements in this method


        // use scanner to tokenize inputExpr
        Scanner inputExprScanner = new Scanner(inputExpr);
        
        // Use zero or more white space as delimiter,
        // which breaks the string into single character tokens
        inputExprScanner = inputExprScanner.useDelimiter("\\s*");

        // Step 1: Scan the tokens in the string.
        while (inputExprScanner.hasNext())
        {
		
     	    // Step 2: If you see an operand, push operand object onto the inputExprStack
            if (inputExprScanner.hasNextInt())
            {
                // This force scanner to grab all of the digits
                // Otherwise, it will just get one char
                String dataString = inputExprScanner.findInLine("\\d+");
                
                try
                {
                    inputExprStack.push(dataString);
                }
                catch(NumberFormatException e)
                {
                    throw new LispExpressionEvaluatorException("*******Invalid Number********");
                }
   		
            }
            else
            {
                // Get next token, only one char in string token
                String aToken = inputExprScanner.next();
                char item = aToken.charAt(0);
                
                switch (item)
                {
     		   case'(':inputExprStack.push(item);
                    item = inputExprScanner.next().charAt(0);
                    switch(item)
                    {
                        case '+':
                        case '-':
                        case '/':
                        case '*': inputExprStack.push(item);
                            break;
                        default:    throw new LispExpressionEvaluatorException("*********Invalid Operator******");
                    }
                            break;
                            
                        case ')':evaluateCurrentOperation();
                            break;

                        default:  // error
                        throw new LispExpressionEvaluatorException(item + " is not a legal expression operator");
                } // end switch
            } // end else
        } // end while
        
        // Step 9: If you run out of tokens, the value on the top of inputExprStack is
        //         is the result of the expression.
        //
        //         return result
       
	double result = Double.parseDouble(inputExprStack.peek().toString());
        
        return result;
    }
    
     private boolean checkforDouble(String d){
        try{
            Double.parseDouble(d);
        }
        catch(NumberFormatException e){
            return false;
        }
        return true;
    }


    //=====================================================================
    // DO NOT MODIFY ANY STATEMENTS BELOW
    //=====================================================================

    
    // This static method is used by main() only
    private static void evaluateExprTest(String s, LispExpressionEvaluator expr, String expect)
    {
        Double result;
        System.out.println("Expression " + s);
        System.out.printf("Expected result : %s\n", expect);
	expr.reset(s);
        try {
           result = expr.evaluate();
           System.out.printf("Evaluated result : %.2f\n", result);
        }
        catch (LispExpressionEvaluatorException e) {
            System.out.println("Evaluated result :"+e);
        }
        
        System.out.println("-----------------------------");
    }

    // define few test cases, exception may happen
    public static void main (String args[])
    {
        LispExpressionEvaluator expr= new LispExpressionEvaluator();
        String test1 = "(+ (- 6) (* 2 3 4) (/ (+ 3) (* 1) (- 2 3 1)) (+ 0))";
        String test2 = "(+ (- 632) (* 21 3 4) (/ (+ 32) (* 1) (- 21 3 1)) (+ 0))";
        String test3 = "(+ (/ 2) (* 2) (/ (+ 1) (+ 1) (- 2 1 )) (/ 1))";
        String test4 = "(+ (/2)(+ 1))";
        String test5 = "(+ (/2 3 0))";
        String test6 = "(+ (/ 2) (* 2) (/ (+ 1) (+ 3) (- 2 1 ))))";
        String test7 = "(+ (*))";
        String test8 = "(+ (- 6) (* 2 3 4) (/ (+ 3) (* 1) (- 2 3 1)) (+ ))";

	evaluateExprTest(test1, expr, "16.50");
	evaluateExprTest(test2, expr, "-378.12");
	evaluateExprTest(test3, expr, "4.50");
	evaluateExprTest(test4, expr, "1.50");
	evaluateExprTest(test5, expr, "Infinity or LispExpressionEvaluatorException");
	evaluateExprTest(test6, expr, "LispExpressionEvaluatorException");
	evaluateExprTest(test7, expr, "LispExpressionException");
	evaluateExprTest(test8, expr, "LispExpressionException");
    }
}
