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

//    @Before
//    public void initTest() {
//        Rational standard = new Rational();
//    }

//    @After
//    public void afterTest() {
//        standard = null;
//    }
    @Test
    public void testIntConstructor(){
        assertEquals("fractions are abbreviated incorrectly", new Rational(-1,2), new Rational(5, -10));
//        assertNull("Int Constructor was executed incorrectly", new Rational(0,0));
        assertEquals("Int Constructor was executed incorrectly", new Rational(0,1), new Rational(1, Integer.MIN_VALUE));
    }
    @Test
    public void testComparisonOperators(){
        Rational standard = new Rational(5, -10);
        assertTrue("Comparison operator \"equals\" was executed incorrectly", standard.equals(new Rational(-1, 2)));
        assertTrue("Comparison operator \"less\" was executed incorrectly", standard.less(new Rational(-2, 3)));
        assertTrue("Comparison operator \"lessOrEqual\" was executed incorrectly", standard.lessOrEqual(new Rational(-2, 3)));
    }
    @Test
    public void testPlus(){
        Rational summand = new Rational(5, 7);
        Rational addend = new Rational(5, 3);
        assertEquals("Operation \"plus\" was executed incorrectly", new Rational(50,21), summand.plus(addend));
        summand = new Rational(2147483647, 1);
        addend = new Rational(1, 1);
//        aseert на исключение - уточнить
    }
    @Test
    public void testMultiply(){
        Rational multiplicanda = new Rational(5, 7);
        Rational multiplier = new Rational(6, -8);
        assertEquals("Operation \"multiply\" was executed incorrectly", new Rational(-30,56), multiplicanda.multiply(multiplier));
        multiplicanda = new Rational(42000, 7);
        multiplier = new Rational(52000, 8);
//        aseert на исключение
    }
    @Test
    public void testMinus(){
        Rational minuend = new Rational(5, 3);
        Rational subtrahend = new Rational(5, 7);
        assertEquals("Operation \"minus\" was executed incorrectly", new Rational(20,21), minuend.minus(subtrahend));
    }
    @Test
    public void testDivide(){
        Rational dividend = new Rational(5, 7);
        Rational divisor = new Rational(6, 8);
        assertEquals("Divide returns wrong answer", new Rational(40,42), dividend.divide(divisor));
    }
}