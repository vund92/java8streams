package hackerank;

//Complete this code or write your own from scratch
import java.util.*;
import java.io.*;

class Stack_Hackerank{
//	public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        while(scanner.hasNextLine()) {
//            Stack<Character> stack = new Stack<>();
//            String line = scanner.nextLine();
//            for(char c : line.toCharArray()) {
//                if(c == '{' || c == '(' || c == '[') {
//                   stack.push(c);
//                   continue;
//                }                    
//                
//                if(c == '}' && !stack.isEmpty() && stack.peek() == '{') {
//                    stack.pop();
//                    continue;
//                }
//                
//                if(c == ')' && !stack.isEmpty() && stack.peek() == '('){
//                    stack.pop();
//                    continue;
//                }
//                
//                if(c == ']' && !stack.isEmpty() && stack.peek() == '['){
//                    stack.pop();
//                    continue;
//                }
//                
//                if(c == '}' || c == ')' || c == ']') {
//                    stack.push(c);
//                    break;
//                }   
//            }
//            System.out.println(stack.isEmpty());
//        }
//    }
	
	//Cach 2
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            boolean isBalanced = isBalanced(input);
            System.out.println(isBalanced);
        }

        scanner.close();
    }

    public static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if (!isMatchingPair(top, c)) {
                    return false;
                }
            }
        }

        // If the stack is empty at the end, all parentheses are balanced
        return stack.isEmpty();
    }

    public static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '{' && close == '}') ||
               (open == '[' && close == ']');
    }
}



