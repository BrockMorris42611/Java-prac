import java.util.StringTokenizer;

public class Postfix
{
  public static double postfix(String s) throws Exception
  {
	  StringTokenizer st = new StringTokenizer(s, " +-/*", true);
	  Stack<Double> myStack = new Stack<Double>();
	  //delimiters are space, +, -, /, *.  The "true" says return the 
	  //delimiter itself as a token.  
	  int nItemStacked = 0;

	  while (st.hasMoreTokens())
	  {
		String tok = st.nextToken();
		double operand;
		double poppedOperand1;
		double poppedOperand2;
		double result;
		try
		{
			operand = Double.parseDouble(tok);
		    myStack.push(operand);
		    nItemStacked++;
		}
		catch(Exception e)
		{
			if(tok.equals(" "))
				continue;
			if(nItemStacked >= 2) {
				if(tok.equals("*")) {
					poppedOperand1 = myStack.pop();
					poppedOperand2 = myStack.pop();
					result = poppedOperand1 * poppedOperand2;
					myStack.push(result);
				}
				else if(tok.equals("/")) {
					poppedOperand1 = myStack.pop();
					poppedOperand2 = myStack.pop();
					if(poppedOperand1 == 0) {
						System.out.println("Division by zero is not possible please. Please try again with another divisor.");
						return 0;
					}else {
						result = poppedOperand2 / poppedOperand1;
						myStack.push(result);
					}
				}
				else if(tok.equals("+")) {
					poppedOperand1 = myStack.pop();
					poppedOperand2 = myStack.pop();
					result = poppedOperand1 + poppedOperand2;
					myStack.push(result);
				}
				else if(tok.equals("-")) {
					poppedOperand1 = myStack.pop();
					poppedOperand2 = myStack.pop();
					result = poppedOperand2 - poppedOperand1;
					myStack.push(result);
				}
			}else {
				System.out.println("You must have two or more operands entered before any operator.");
			}
		}
	  }return myStack.peek();
	  
  }
  public static void main(String[]args) throws Exception {
	  System.out.println(postfix("5 8 /"));
	  System.out.println(postfix("5 0 / 8 *"));
	  System.out.println(postfix("200 4 / 5 7 +"));
  }
}