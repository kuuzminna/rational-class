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
        System.out.println("Before CalculatorTest.class");
    }

    @AfterClass
    public  static void afterClass() {
        System.out.println("After CalculatorTest.class");
    }

    @Before
    public void initTest() {
        Rational standard = new Rational();
    }

    @After
    public void afterTest() {
        standard = null;
    }
    @Test
    public void testIntConstructor(){
        Rational standard = new Rational();
        assertEquals("Standard constructor returns wrong numerator", 0, standard.getNumerator());
        assertEquals("Standard constructor returns wrong denominator", 1, standard.getDenominator());
    }
    @Test
    public void testEquals(){

    }
    @Test
    public void testLess(){

    }
    @Test
    public void testLessOrEquals(){

    }
    @Test
    public void testPlus(){
        Rational standard = new Rational(5, 7);
        Rational standard2 = new Rational(5, 3);
        assertEquals("Operation \"plus\" was executed incorrectly", new Rational(50,21), standard.plus(standard2));
    }
    @Test
    public void testMultiply(){
        Rational standard = new Rational(5, 7);
        Rational standard2 = new Rational(-6, 8);
        assertEquals("Operation \"multiply\" was executed incorrectly", new Rational(-30,56), standard.multiply(standard2));
    }
    @Test
    public void testMinus(){
        Rational standard = new Rational(5, 3);
        Rational standard2 = new Rational(5, 7);
        assertEquals("Operation \"minus\" was executed incorrectly", new Rational(20,21), standard.minus(standard2));
    }
    @Test
    public void testDivide(){
        Rational standard = new Rational(5, 7);
        Rational standard2 = new Rational(6, 8);
        assertEquals("Divide returns wrong answer", new Rational(40,42), standard.divide(standard2));
    }
    @Test
    public void testReduce(){

    }
    @Test
    public void testGetGCD(){

    }
    @Test
    public void testSimplifyMinuses(){

    }
}