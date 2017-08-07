

package PJ2;
import java.util.*;

public class LispExpressionEvaluator {
    // Current input Lisp expression
    private String inputExpr;

    // Main expression stack & current operation stack
    private Stack<Object> inputExprStack;
    private Stack<Double> evaluationStack;
    Stack<Object> exprStack = new Stack<Object>();
    Stack<Double> opStack = new Stack<Double>();


    // default constructor
    // set inputExpr to "" 
    // create stack objects
    public LispExpressionEvaluator() {
        inputExpr = "";

        // add statements
    }

    // constructor with an input expression
    // set inputExpr to inputExpression
    // create stack objects
    public LispExpressionEvaluator(String inputExpression) {
        this.inputExpr = inputExpression;
        // add statements
    }

    // set inputExpr to inputExpression
    // clear stack objects
    public void reset(String inputExpression) {
        exprStack = new Stack<Object>();
        opStack = new Stack<Double>();
        inputExpr = inputExpression;
        // add statements
    }


    // This function evaluates current operator with its operands
    // See complete algorithm in evaluate()
    //
    // Main Steps:
    //        Pop operands from inputExprStack and push them onto
    //           evaluationStack until you find an operator
    //     Apply the operator to the operands on evaluationStack
    //          Push the result into inputExprStack
    //
    private void evaluateCurrentOperation() {
        double result = 0;
        while (!exprStack.isEmpty() && exprStack.peek().toString().charAt(0) != '(') {
            if (tryParseDouble(exprStack.peek().toString())) {
                opStack.push(Double.parseDouble(exprStack.pop().toString()));
            }
            else {
                char item = exprStack.peek().toString().charAt(0);
                if (opStack.isEmpty())
                    throw new LispExpressionEvaluatorException("Operators must have operands! Missing operand at: " + item);
                switch (item) {
                    case '+':
                        exprStack.pop();
                        result = 0;
                        while (!opStack.empty())
                            result = result + opStack.pop();
                        opStack.push(result);
                        break;

                    case '-':
                            exprStack.pop();
                            if (opStack.size() == 1)
                                opStack.push(0 - opStack.pop());
                            else {
                                result = opStack.pop();
                                while (!opStack.empty())
                                    result = result - opStack.pop();
                                opStack.push(result);
                            }
                            break;
                    case '*':
                        exprStack.pop();
                        result = 1;
                        while (!opStack.empty())
                        result = result * opStack.pop();
                        opStack.push(result);
                        break;

                    case '/':
                        exprStack.pop();
                        if (opStack.peek() == 0)
                        throw new LispExpressionEvaluatorException("Division by zero");
                        if (opStack.size() == 1)
                            opStack.push(1 / opStack.pop());
                        else {
                            result = opStack.pop();
                            while (!opStack.empty()) {
                                if (opStack.peek() == 0)
                                    throw new LispExpressionEvaluatorException("Division by zero");
                                result = result / opStack.pop();
                            }
                            opStack.push(result);
                        }
                        break;
                        default:
                }
            }
        }
        //get rid of the last '('
        if (exprStack.isEmpty())
            throw new LispExpressionEvaluatorException("Invalid parameters");
        else
            exprStack.pop();
        exprStack.push(opStack.pop());
    }
    // add statements

    /**
     * This funtion evaluates current Lisp expression in inputExpr
     * It return result of the expression
     *
     * The algorithm:
     *
     * Step 1   Scan the tokens in the string.
     * Step 2     If you see an operand, push operand object onto the inputExprStack
     * Step 3             If you see "(", next token should be an operator
     * Step 4         If you see an operator, push operator object onto the inputExprStack
     * Step 5     If you see ")"  // steps in evaluateCurrentOperation() :
     * Step 6        Pop operands and push them onto evaluationStack
     *                 until you find an operator
     * Step 7        Apply the operator to the operands on evaluationStack
     * Step 8        Push the result into inputExprStack
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
        boolean needNum = false;
        // Step 1: Scan the tokens in the string.
        while (inputExprScanner.hasNext())
        {

            // Step 2: If you see an operand, push operand object onto the inputExprStack
            if (inputExprScanner.hasNextInt())
            {
                // This force scanner to grab all of the digits
                // Otherwise, it will just get one char
                String dataString = inputExprScanner.findInLine("\\d+");
                try{
                    exprStack.push(dataString);
                }
                catch(NumberFormatException e){
                    throw new LispExpressionEvaluatorException("Invalid number!");
                }

                // more ...
            }
            else
            {
                // Get next token, only one char in string token
                String aToken = inputExprScanner.next();
                char item = aToken.charAt(0);

                switch (item)
                {
                    // Step 3: If you see "(", next token shoube an operator
                    // Step 4: If you see an operator, push operator object onto the inputExprStack
                    // Step 5: If you see ")"  // steps in evaluateCurrentOperation() :

         case'(':exprStack.push(item);
                    item = inputExprScanner.next().charAt(0);
            switch(item){
                case '+':
                case '-':
                case '/':
                case '*': exprStack.push(item);
                    break;
                default:    throw new LispExpressionEvaluatorException("Invalid operator!");}
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
        double result = Double.parseDouble(exprStack.peek().toString());
        result = round(result);
        return result;


    }

    private double round(double r){
        r = r*100;
        r = Math.round(r);
        r = r /100;
        return r;
    }
    private boolean tryParseDouble(String d){
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
