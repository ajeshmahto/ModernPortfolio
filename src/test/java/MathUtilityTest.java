import com.personal.capital.utility.MathUtility;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by ajesh on 7/23/17.
 * Test class for math Utility functions.
 */
public class MathUtilityTest {
    /**
     * the maximum delta between expected and actual for which both numbers
     * are still considered equal when comparing double
     */
    private static final double DELTA = 1e-15;

    /**
     * This method test the mean(avearge) of numbers
     */
    @Test
    public void meanTest() {
        double[] numbers = {2.0, 4.0, 6.0, 10.0};
        assertEquals(5.5, MathUtility.mean(numbers), DELTA);
        assertEquals(-5.5, MathUtility.mean(new double[]{-2.0, -4.0, -6.0, -10.0}), DELTA); // test for if values are -ve
        assertEquals(0.0, MathUtility.mean(new double[]{0.0}), DELTA); // equals 0.0 when value is only 0.0
        assertEquals(0.0, MathUtility.mean(new double[]{}), DELTA); // equals 0.0 when empty array

    }

    /**
     * This method test the median of numbers
     */
    @Test
    public void medianTest() {
        double[] numbersEvenSize = {2.0, 4.0, 6.0, 10.0};
        double[] numbersOddSize = {2.0, 4.0, 6.0, 10.0 ,12.0};
        assertEquals(5.0, MathUtility.median(numbersEvenSize), DELTA); // test case for even size array
        assertEquals(6.0, MathUtility.median(numbersOddSize), DELTA); // test case for odd size array
        assertEquals(-5.0, MathUtility.median(new double[]{-2.0, -4.0, -6.0, -10.0}), DELTA); // test for if values are -ve
        assertEquals(0.0, MathUtility.median(new double[]{0.0}), DELTA); // equals 0.0 when value is only 0.0
        assertEquals(0.0, MathUtility.median(new double[]{}), DELTA); // equals 0.0 when empty array
    }

    @Test
    public void standardDeviationTest() {
        double[] numbers = {2.0, 4.0, 6.0, 10.0};
        assertEquals(2.958039891549808, MathUtility.standardDeviation(numbers), DELTA);
        assertEquals(2.958039891549808, MathUtility.standardDeviation(new double[]{-2.0, -4.0, -6.0, -10.0}), DELTA); // test for if values are -ve
        assertEquals(0.0, MathUtility.standardDeviation(new double[]{0.0}), DELTA); // equals 0.0 when value is only 0.0
        assertEquals(0.0, MathUtility.standardDeviation(new double[]{}), DELTA); // equals 0.0 when empty array
    }
}
