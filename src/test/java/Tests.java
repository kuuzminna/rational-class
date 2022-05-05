import org.junit.*;
import static org.junit.Assert.*;

public class Tests {
    @Test
    public void testStandardConstructor() {
        Rational standard = new Rational();
        assertEquals("Standard constructor returns wrong numerator", 0, standard.getNumerator());
        assertEquals("Standard constructor returns wrong denominator", 1, standard.getDenominator());
    }
    @BeforeClass
    public static void beforeClass() {
        System.out.println("Before Test.class");
    }

    @AfterClass
    public  static void afterClass() {
        System.out.println("After Test.class");
    }

    @Test
    public void testIntConstructor(){
        assertEquals("Int Constructor was executed incorrectly", new Rational(-1,2), new Rational(5, -10));
        assertEquals("Int Constructor was executed incorrectly", new Rational(1,2), new Rational(-5, -10));
        assertEquals("Int Constructor was executed incorrectly", new Rational(0,1), new Rational(1, Integer.MIN_VALUE));
    }
    @Test
    public void testComparisonOperators(){
        Rational operand = new Rational(5, -10);

        assertTrue("Comparison operator \"equals\" was executed incorrectly", operand.equals(new Rational(-1, 2)));
        assertFalse("Comparison operator \"less\" was executed incorrectly with negative numbers", operand.less(new Rational(-2, 3)));
        assertTrue("Comparison operator \"less\" was executed incorrectly", operand.less(new Rational(1, 4)));
        assertTrue("Comparison operator \"less\" was executed incorrectly with negative numbers", operand.less(new Rational(-1, 4)));
        assertTrue("Comparison operator \"lessOrEqual\" was executed incorrectly", operand.lessOrEqual(new Rational(1, 4)));
        assertFalse("Comparison operator \"lessOrEqual\" was executed incorrectly", operand.lessOrEqual(new Rational(-1, 3)));
    }
    @Test
    public void testPlus(){
        Rational summand = new Rational(5, 3);

        assertEquals("Operation \"plus\" was executed incorrectly with positive numbers",
                new Rational(50,21), summand.plus(new Rational(5, 7)));
        assertEquals("Operation \"plus\" was executed incorrectly with positive and negative numbers",
                new Rational(20,21), summand.plus(new Rational(-5, 7)));

        summand = new Rational(-5, 3);
        assertEquals("Operation \"plus\" was executed incorrectly with negative numbers",
                new Rational(-50,21), summand.plus(new Rational(-5, 7)));

//        overflow
//        summand = new Rational(Integer.MAX_VALUE, 7);
//        assertEquals("int overflow is not handled", summand, summand.plus(new Rational(1, 7)));
    }
    @Test
    public void testMultiply(){
        Rational multiplicanda = new Rational(5, 7);
        Rational multiplier = new Rational(6, -8);
        assertEquals("Operation \"multiply\" was executed incorrectly", new Rational(-30,56), multiplicanda.multiply(multiplier));

        // overflow
//        multiplicanda = new Rational(42000, 1);
//        multiplier = new Rational(52000, 1);
//        assertEquals("int overflow is not handled", multiplicanda, multiplicanda.multiply(multiplier));
    }
    @Test
    public void testMinus(){
        Rational minuend = new Rational(5, 3);
        Rational subtrahend = new Rational(5, 7);
        assertEquals("Operation \"minus\" was executed incorrectly", new Rational(20,21), minuend.minus(subtrahend));

        minuend = new Rational(-5, 3);
        subtrahend = new Rational(5, 7);
        assertEquals("Operation \"minus\" was executed incorrectly", new Rational(-50,21), minuend.minus(subtrahend));

        minuend = new Rational(-5, 7);
        subtrahend = new Rational(-5, 3);
        assertEquals("Operation \"minus\" was executed incorrectly with negative numbers", new Rational(20,21), minuend.minus(subtrahend));

//        overflow
//        minuend = new Rational(Integer.MIN_VALUE, 7);
//        assertEquals("int overflow is not handled", minuend, minuend.minus(new Rational(1, 7)));
    }
    @Test
    public void testDivide(){
        Rational dividend = new Rational(5, 7);
        Rational divisor = new Rational(6, -8);
        assertEquals("Divide returns wrong answer", new Rational(-40,42), dividend.divide(divisor));
        // overflow
//        dividend = new Rational(42000, 1);
//        divisor = new Rational(1, 52000);
//        assertEquals("int overflow is not handled", dividend, dividend.divide(divisor));
    }
    @Test(expected = ArithmeticException.class)
    public void testZeroCheck(){
        assertNull("The constructor is executed incorrectly with 0 in the denominator", new Rational(0,0));

        Rational dividend = new Rational(5, 7);
        assertEquals("Division by zero does not work correctly",dividend, dividend.divide(new Rational(0, 8)));
    }
}