
import com.personal.capital.domain.InvestmentPlan;
import com.personal.capital.domain.Profile;
import com.personal.capital.main.App;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.*;

/**
 * Created by ajesh on 7/23/17.
 * Test class for App class methods.
 */
public class AppTest {

    /**
     * the maximum delta between expected and actual for which both numbers
     * are still considered equal when comparing double
     */
    private static final double DELTA = 1e-15;
    private  App p1;

    /**
     *This method initialize the Main method class used by other test methods to invoke it's method
     */
    @Before
    public void initialize(){
        p1 = new App();
    }

    /**
     * This method test the monte carlo simulation result
     */
    @Test
    public void runSimulationTest(){

        Profile aggressiveProfile=null;
        InvestmentPlan investmentPlan=null ;
        assertNull(p1.runSimulations(aggressiveProfile,investmentPlan)); // test the null condition check

        investmentPlan = new InvestmentPlan();
        investmentPlan.setInvestment(100000.0D);
        investmentPlan.setYears(20);
        investmentPlan.setNumberOfSimulation(10000);

        aggressiveProfile = new Profile();
        aggressiveProfile.setMean(0.15675D);
        aggressiveProfile.setSd(0.09432D);

        Profile conservativeProfile = new Profile();
        conservativeProfile.setMean(0.06189D);
        conservativeProfile.setSd(0.063438D);
        App p2 = mock(App.class);
        // using mockito to mock the return of finalReturnAmount which actually returns different values in real test case because of randomization.
        when(p2.finalReturnAmount(conservativeProfile,investmentPlan)).thenReturn(1000.0);
        when(p2.runSimulations(conservativeProfile,investmentPlan)).thenReturn(new double[] {10010.0,1000.0,1020.0});
        assertEquals(10010.0, p1.getPercentileAmount(p2.runSimulations(conservativeProfile,investmentPlan),90),DELTA);
        assertEquals(1000.0, p1.getPercentileAmount(p2.runSimulations(conservativeProfile,investmentPlan),10),DELTA);

    }

    /**
     * This method test the final year end amount calculation of investment
     */
    @Test
    public void finalReturnAmountTest(){
        InvestmentPlan investmentPlan = new InvestmentPlan();
        investmentPlan.setInvestment(0.0D);
        investmentPlan.setYears(20);
        investmentPlan.setNumberOfSimulation(10000);

        Profile aggressiveProfile = new Profile();
        aggressiveProfile.setMean(0.15675D);
        aggressiveProfile.setSd(0.09432D);

        Profile conservativeProfile = new Profile();
        conservativeProfile.setMean(0.06189D);
        conservativeProfile.setSd(0.063438D);

        assertEquals(0.0,p1.finalReturnAmount(conservativeProfile,investmentPlan),DELTA);



    }

    /**
     * This method test the percentile calculation
     */
    @Test
    public void getPercentileAmountTest(){
        double data[] = {1,4,-3,2,-9,-7,0,-4,-1,2,1,-5,-3,10,10,5};
        assertEquals(10.0D, p1.getPercentileAmount(data,90),DELTA);

    }




}
