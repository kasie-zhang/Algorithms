import java.util.Scanner;
import java.util.Stack;

/**
 * Using double stack to solve math expressions.
 * The algorithm is designed by E.W.Dijkstra in 1960s.
 * ( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )
 */
public class DijkstraDoubleStack {
    public static void main(String[] args) {
        Stack<String> ops = new Stack<String>();
        Stack<Double> vals = new Stack<Double>();
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        for (String s : input.split(" ")) {
            // Read character, put the ops to the stack.
            if (s.equals("(")) ;
            else if (s.equals("+"))
                ops.push(s);
            else if (s.equals("-"))
                ops.push(s);
            else if (s.equals("*"))
                ops.push(s);
            else if (s.equals("/"))
                ops.push(s);
            else if (s.equals("sqrt"))
                ops.push(s);
            else if (s.equals(")")) {
                // Pop the two operand the operator.
                String op = ops.pop();
                double v = vals.pop();
                if (op.equals("+"))
                    v = vals.pop() + v;
                else if (op.equals("-"))
                    v = vals.pop() - v;
                else if (op.equals("*"))
                    v = vals.pop() * v;
                else if (op.equals("/"))
                    v = vals.pop() + v;
                else if (op.equals("sqrt"))
                    v = Math.sqrt(v);
                vals.push(v);
            } else vals.push(Double.parseDouble(s));
        }
        System.out.println(vals.pop());
    }
}
