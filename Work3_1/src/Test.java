public class Test {
    public static void main(String[] args) {
        int i = 10, j = 5;
        UseCompute useCompute = new UseCompute();

        Divide divide = new Divide();
        Plus plus = new Plus();
        Minus minus = new Minus();
        Multiply multiply = new Multiply();
//        分别进行加减乘除
        useCompute.useCom(plus, i, j);
        useCompute.useCom(minus, i, j);
        useCompute.useCom(multiply, i, j);
        useCompute.useCom(divide, i, j);

    }
}