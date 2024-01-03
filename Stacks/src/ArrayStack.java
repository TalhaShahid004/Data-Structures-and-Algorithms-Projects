import java.util.Stack;

public class ArrayStack<T extends Comparable<T>> {
    T stackList[];
    int top;

    public ArrayStack(int size) {
        stackList = (T[]) new Comparable[size];
        top = -1;
    }

    public void Push(T data) {
        //check if stack is full
        if (top == stackList.length - 1) {
            System.out.println("Stack is full");
            return;
        }

        System.out.println("Pushed: " + data);

        top++;

        stackList[top] = data;
    }

    public T Pop() {
        //check if stack is empty
        if (top == -1) {
            System.out.println("Stack is empty");
            return null;
        }

        //return the top value
        T valueToReturn = stackList[top];
        System.out.println("Popped: " + valueToReturn);
        //move top pointer
        top--;

        return valueToReturn;
    }

    public Boolean isEmpty() {
        if (top == -1) {
            return true;
        }

        return false;
    }

    public Boolean isFull() {
        if (top == stackList.length - 1) {
            return true;
        }

        return false;
    }

    public T Peek() {
        //check if stack is empty
        if (top == -1) {
            System.out.println("Stack is empty");
            return null;
        }

        //return the top value
        T valueToReturn = stackList[top];
        System.out.println("Peeked: " + valueToReturn);
        //move top pointer

        return valueToReturn;
    }

    public Boolean validate(String expression) {
        ArrayStack<Character> stack = new ArrayStack<>(expression.length());

        for (int i = 0; i < expression.length(); i++) {
            char symbol = expression.charAt(i);

            if (symbol == '(' || symbol == '{' || symbol == '[') {
                stack.Push(symbol);
            } else if (symbol == ')' || symbol == '}' || symbol == ']') {
                if (stack.isEmpty()) {
                    return false; // Unmatched closing bracket, stack is empty
                } else {
                    char popped = stack.Pop();
                    if (!isMatching(popped, symbol)) {
                        return false; // Mismatched opening and closing brackets
                    }
                }
            }
        }

        return stack.isEmpty(); // If stack is empty, all brackets are matched
    }

    private boolean isMatching(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '{' && close == '}') ||
                (open == '[' && close == ']');
    }

    public String convertInfixToPostfix(String expression) {
        String result = "";

        ArrayStack<Character> stack = new ArrayStack<>(expression.length());


        for (int i = 0; i < expression.length(); i++) {
            char symbol = Character.toLowerCase(expression.charAt(i));
            if (symbol == 'a' || symbol == 'b' || symbol == 'c') {
                symbol = Character.toUpperCase(symbol);
                result += symbol;
            } else if (symbol == '(' || symbol == '[' || symbol == '{') {
                stack.Push(symbol);
            } else if (symbol == ')' || symbol == ']' || symbol == '}') {
                while (!stack.isEmpty() && stack.Peek() != '(' && stack.Peek() != '[' && stack.Peek() != '{') {
                    result += stack.Pop();
                }
                stack.Pop();
            } else if (symbol == '+' || symbol == '-' || symbol == '*' || symbol == '/' || symbol == '%') {
                if (precedence(symbol) > precedence(stack.Peek()) || stack.isEmpty() == true) {
                    stack.Push(symbol);
                } else if (precedence(symbol) == precedence(stack.Peek())) {
                    result += stack.Pop();
                    stack.Push(symbol);
                } else if (precedence(symbol) < precedence(stack.Peek())) {
                    while (!stack.isEmpty() && precedence(symbol) <= precedence(stack.Peek()) && stack.Peek() != '(' && stack.Peek() != '[' && stack.Peek() != '{') {
                        result += stack.Pop();
                    }
                    stack.Push(symbol);
                }
            }
        }


        while (!stack.isEmpty()) {
            result += stack.Pop();
        }

        System.out.println(result);
        return result;
    }


    // determine precendence method
    //using switch case
    private int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
            case '%':
                return 2;
            default:
                return 0; // Default precedence for non-operators.
        }
    }


//    for (each character ch in the string)
//    {
//    if (ch is an operand)
//    Push the value of the operand ch onto the stack else // ch is an operator named op
//    {
//    // Evaluate and push the result
//    operand2 = top of stack Pop the stack
//    operand1 = top of stack Pop the stack
//    result = operand1 op operand2 Push result onto the stack
//    }
//    }

    public int convertPostfixToAnswer(String expression) {
        ArrayStack<Integer> stack = new ArrayStack<>(expression.length());

        for (int i = 0; i < expression.length(); i++) {
            char symbol = expression.charAt(i);

            System.out.println("Curr char: " + symbol);
            System.out.println("Stack: " + stack);

            if (isOperand(symbol)) {
                // Handle multi-digit operands
                int operand = 0;
                while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                    operand = operand * 10 + Character.getNumericValue(expression.charAt(i));
                    i++;
                }
                i--; // Decrement i to account for the last character of the operand
                stack.Push(operand);
            } else if (isOperator(symbol)) {
//                if (stack.top < 1) {
//                    throw new IllegalArgumentException("Invalid postfix expression");
//                }
                int operand2 = stack.Pop();
                int operand1 = stack.Pop();
                int result;

                switch (symbol) {
                    case '+':
                        result = operand1 + operand2;
                        break;
                    case '-':
                        result = operand1 - operand2;
                        break;
                    case '*':
                        result = operand1 * operand2;
                        break;
                    case '/':
                        if (operand2 == 0) {
                            throw new ArithmeticException("Division by zero");
                        }
                        result = operand1 / operand2;
                        break;
                    case '%':
                        result = operand1 % operand2;
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid operator: " + symbol);
                }

                stack.Push(result);
                System.out.println("We made it: " + symbol);
            }
        }

        // At this point, the final result should be on top of the stack
        if (stack.top != 0) {
            throw new IllegalArgumentException("Invalid postfix expression");
        }

        return stack.Pop();
    }

    public boolean isOperand(char c) {
        return Character.isDigit(c);
    }

    public boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '%';
    }
//
//    public int convertPostfixToAnswer(String expression) {
//        int result = 0;
//
//        ArrayStack<Character> stack = new ArrayStack<>(expression.length());
//
//        for (int i = 0; i < expression.length(); i++) {
//            char symbol = expression.charAt(i);
//
//            if (isOperand(symbol) == true){
//                stack.Push(symbol);
//            }else{
//
//            }
//        }
//
//
//        return result;
//    }
//
//    public boolean isOperand(Character c) {
//        if (c == '+' || c == '-' || c == '*' || c == '/' || c == '%') {
//            return true;
//        }
//
//        return false;
//    }


}

