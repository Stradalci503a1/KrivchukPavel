import java.util.ArrayList;
import java.util.Stack;

public class Calculator {
    public static void main(String[] args) {}

    public static double calculate(String expression) {

        if (!isCorrect(expression)) {
            return Double.NaN;
        }

        Stack<Character> stack = new Stack<>();
        ArrayList<String> postfixExpression = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            char currentChar = expression.charAt(i);
            if (Character.isDigit(currentChar)) {
                int counter = 0;
                while (i + counter != expression.length() && Character.isDigit(expression.charAt(i + counter))) {
                    counter++;
                }
                postfixExpression.add(expression.substring(i, i + counter));
                i += counter - 1;
            } else if (currentChar == '(') {
                stack.push(currentChar);
            } else if (currentChar == ')') {
                while (stack.peek() != '(') {
                    postfixExpression.add(stack.pop().toString());
                }
                stack.pop();
            } else if (currentChar != ' ') {
                while (!stack.empty() && operatorPriority(currentChar) <= operatorPriority(stack.peek())) {
                    postfixExpression.add(stack.pop().toString());
                }
                stack.push(currentChar);
            }
        }

        while (!stack.empty()) {
            postfixExpression.add(stack.pop().toString());
        }
        if (postfixExpression.size() == 0){

            return Double.NaN;
        }
        return postfixCalculate(postfixExpression);
    }

    private static double postfixCalculate(ArrayList<String> expression) {

        Stack<Double> stack = new Stack<>();
        for (String i : expression) {
            if (isNumber(i)){
                stack.push(Double.parseDouble(i));
            } else if (stack.size() < 2){
                return Double.NaN;
            } else {
                double secondNumber = stack.pop();
                switch (i){
                    case "+":
                        stack.push(stack.pop() + secondNumber);
                        break;
                    case "-":
                        stack.push(stack.pop() - secondNumber);
                        break;
                    case "*":
                        stack.push(stack.pop() * secondNumber);
                        break;
                    case "/":
                        if (secondNumber == 0){
                            return Double.NaN;
                        }
                        stack.push(stack.pop() / secondNumber);
                }
            }
        }

        return stack.pop();
    }

    private static int operatorPriority(char operation) {

        switch (operation) {
            case '+':
            case '-':
                return 1;
            case '/':
            case '*':
                return 2;
            default:
                return 0;
        }
    }

    private static boolean isCorrect(String expression) {

        if (expression == null) {
            return false;
        }

        int counter = 0;
        for (int i = 0; i < expression.length(); i++) {
            char currentChar = expression.charAt(i);
            if (currentChar == '(') {
                counter++;
            } else if (currentChar == ')') {
                if (counter < 1){
                    return false;
                }
                counter--;
            } else if (currentChar != ' ' && !isOperator(currentChar) && !Character.isDigit(currentChar)) {
                return false;
            }
        }

        if (counter > 0) {
            return false;
        }

        return true;
    }

    private static boolean isOperator(char character){

        return character == '+' || character == '-' || character == '/' || character == '*';
    }

    private static boolean isNumber(String string){

        try{
            Double.parseDouble(string);
            return true;
        }
        catch (NumberFormatException e){
            return false;
        }
    }
}
