import java.io.*;
import java.util.*;

class StackOperations
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
	}

	public boolean isValidParanthesis(String s)
    	{
        	Stack<Character> stack = new Stack<Character>();
     
        	for(char c : s.toCharArray())
            		switch(c)
            		{
                		case '[':
                    			stack.push(']');
                    			break;
                		case '(':
                    			stack.push(')');
                    			break;
                		case '{':
                    			stack.push('}');
                    			break;
                		default:
                    			if(stack.isEmpty() || c!= stack.pop())
                        			return false;
                    		break;
            		}
        
        	return stack.isEmpty();
    	}
}