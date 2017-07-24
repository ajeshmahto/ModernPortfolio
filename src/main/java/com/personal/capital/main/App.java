package com.personal.capital.main;

import com.personal.capital.domain.InvestmentPlan;
import com.personal.capital.domain.Profile;
import com.personal.capital.utility.MathUtility;
import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.stat.descriptive.rank.Percentile;

/**
 * This is the main class for running the monte carlo simulation for different types of profile
 *Created by ajesh on 7/23/17.
 */

public class App {
    public static void main(String[] args) {


        InvestmentPlan investmentPlan = new InvestmentPlan();
        investmentPlan.setInvestment(100000.00D);
        investmentPlan.setYears(20);
        investmentPlan.setInflation(0.035D);
        investmentPlan.setNumberOfSimulation(10000);

        Profile aggressiveProfile = new Profile();
        aggressiveProfile.setMean(0.15675D);
        aggressiveProfile.setSd(0.09432D);

        Profile conservativeProfile = new Profile();
        conservativeProfile.setMean(0.06189D);
        conservativeProfile.setSd(0.063438D);

        App p1 = new App();
        double[] yearEndAmountsAgreProfile = p1.runSimulations(aggressiveProfile, investmentPlan);
        double[] yearEndAmountsConsProfile = p1.runSimulations(conservativeProfile, investmentPlan);

        p1.print("Aggressive Profile",yearEndAmountsAgreProfile);
        p1.print("Conservative Profile",yearEndAmountsConsProfile);

    }


    /**
     * This method runs the monte carlo simulation on return amount of years invested.
     * @param profile  Profile type of investor ( aggressive, conservative )
     * @param investmentPlan Investement plan of user
     * @return return total amount of return  after simulating for defined number of times
     */

    public double[] runSimulations(Profile profile, InvestmentPlan investmentPlan) {

        if(profile!= null && investmentPlan !=null){
            double yearEndAmounts[] = new double[investmentPlan.getNumberOfSimulation()];
            // Runs Monte Carlo Simulation for defined number of times.
            for (int i = 0; i < investmentPlan.getNumberOfSimulation(); i++) {
                yearEndAmounts[i] = finalReturnAmount(profile, investmentPlan);
            }
            return yearEndAmounts;
        }
        else return  null;

    }

    /**
     * This method calculate the total return of invested for given profile type.
     * @param profile  Profile type of investor ( aggressive, conservative )
     * @param investmentPlan Investement plan of user
     * @return total amount after investing for given years based on profile selected
     */
    public double finalReturnAmount(Profile profile , InvestmentPlan investmentPlan) {
        double yearEndAmount = investmentPlan.getInvestment(); // 0 year  -> initial investment amount
        NormalDistribution distribution = new NormalDistribution(profile.getMean(), profile.getSd());  // Calculate the normal distribution using common math3 apache library
        // Calculate total amount return after investing defined by user.
        for (int i = 1; i <= investmentPlan.getYears(); i++) {
            double outcomeRisk = distribution.inverseCumulativeProbability(Math.random());  // Random distribution probability risk calculated using common apache library
            yearEndAmount = yearEndAmount * (1 + outcomeRisk) - (investmentPlan.getInflation() * yearEndAmount);  // get the yearEnd return and sum till end of the year defined for investment.
        }

        return yearEndAmount;   // returns the total amount calculated for defined  years of investment
    }

    /**
     * This method calulate the percentile using common math3 library
     * @param amounts amounts for which percentile has to be calculated
     * @param value percentile value
     * @return this return the computed percentile
     */
    public double getPercentileAmount(double [] amounts, double value){

        Percentile percentile = new Percentile();
        return percentile.evaluate(amounts, value);
    }

    /**
     * This method prints the result in System console
     * @param profile
     * @param yearEndAmounts
     */
    public void print(String  profile, double[] yearEndAmounts){

        System.out.println("********************* " +profile +" *******************************");
        System.out.println("Mean 20th Year: " + MathUtility.mean(yearEndAmounts));
        System.out.println("Median 20th Year: " + MathUtility.median(yearEndAmounts));
        System.out.println("Standard Deviation: " +MathUtility.standardDeviation(yearEndAmounts));
        System.out.println("10 % Best Case :" + getPercentileAmount(yearEndAmounts, 90));
        System.out.println("10 % Worst Case: " +getPercentileAmount(yearEndAmounts, 10));
        System.out.println("*************************************************************************");
    }

}
