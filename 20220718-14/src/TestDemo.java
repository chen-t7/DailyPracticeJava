import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2022 -07 -18
 * Time: 22:14
 */
public class TestDemo {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        stack.pop();
        System.out.println(stack.peek());
        System.out.println(stack);
        System.out.println(stack.isEmpty());
        System.out.println("===================");

        stack.push(4);
        stack.push(5);
        stack.push(6);
        System.out.println(stack);

    }

    public static void main1(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        stack.pop();
        stack.peek();
        System.out.println(stack);
        System.out.println(stack.empty());
        System.out.println("===================");
        System.out.println(stack.isEmpty());

        String s;
    }
}
