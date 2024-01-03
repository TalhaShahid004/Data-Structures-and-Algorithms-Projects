public class Main {
    public static void main(String[] args) {
        // Create a stack with a maximum size of 5
        ArrayStack<Integer> arrayStack1 = new ArrayStack<>(5);

        System.out.println("Using Array Stack");
        // Push some elements onto the stack
        arrayStack1.Push(1);
        arrayStack1.Push(2);
        arrayStack1.Push(3);
        arrayStack1.Push(4);
        arrayStack1.Push(5);

        // Try to push one more element when the arrayStack1 is full
        arrayStack1.Push(6);

        // Pop elements from the arrayStack1
        arrayStack1.Pop();
        arrayStack1.Pop();

        // Check if the arrayStack1 is empty
        System.out.println("Is stack empty: " + arrayStack1.isEmpty()); // This should print "Is arrayStack1 empty: false"

        // Pop the remaining elements
        arrayStack1.Peek();
        arrayStack1.Pop();
        arrayStack1.Peek();
        arrayStack1.Pop();
        arrayStack1.Peek();
        arrayStack1.Pop();

        // Check if the arrayStack1 is empty after popping all elements
        System.out.println("Is stack empty: " + arrayStack1.isEmpty());

        System.out.println();
        LinkedStack<Integer> linkedStack1 = new LinkedStack<>();

        System.out.println("Using Linked Stack");

        System.out.println("Is stack empty: " + linkedStack1.isEmpty());

        // Push some elements onto the stack
        linkedStack1.Push(1);
        linkedStack1.Push(2);
        linkedStack1.Push(3);
        linkedStack1.Push(4);
        linkedStack1.Push(5);

        // Check if the linkedStack1 is empty
        System.out.println("Is stack empty: " + linkedStack1.isEmpty()); // This should print "Is linkedStack1 empty: false"

        // Peek at the top element
        linkedStack1.Peek();

        // Pop elements from the linkedStack1
        linkedStack1.Pop();
        linkedStack1.Peek();
        linkedStack1.Pop();

        // Pop the remaining elements
        linkedStack1.Pop();
        linkedStack1.Pop();
        linkedStack1.Pop();

        // Check if the linkedStack1 is empty after popping all elements
        System.out.println("Is stack empty: " + linkedStack1.isEmpty());


        ArrayStack<Character> stack = new ArrayStack<>(10);

        // Test cases
        String[] expressions = {
                "()",                 // balanced
                "({[]})",             // balanced
                "{[()]}",             // balanced
                "({[}])",             // not balanced
                "(()",                // not balanced
                "(()])",              // not balanced
                "((()))",             // balanced
                "{[(){}]}",           // balanced
                "({[()]}){[(){}]}",   // balanced
        };

        for (String expression : expressions) {
            boolean isValid = stack.validate(expression);
            System.out.println("Expression: " + expression + " -> Is Valid? " + isValid);
        }


        ArrayStack<Character> stackList = new ArrayStack<>(20);
        String infixExpression = "[(A+B)/B+A-C+(B-C)]";
        String postfixExpression = stackList.convertInfixToPostfix(infixExpression);
        System.out.println("Infix Expression: " + infixExpression);
        System.out.println("Postfix Expression: " + postfixExpression);

        int answer = stackList.convertPostfixToAnswer(postfixExpression);
        System.out.println("Answer: " + answer);

    }
}