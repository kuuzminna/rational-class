public class Main {
    public static void main(String[] args) {
        Rational num1 = new Rational(1, -2147483648);
        Rational num2 = new Rational(52000, -3);
        Rational new_num;

        System.out.println(num1);
        System.out.println(num2);
        new_num = num1.multiply(num2);
        System.out.println(new_num);
//        new_num = new Rational(1, 2);
    }
}
