package com.personal.capital.domain;

/**
 * This class is to setter and getter for Investment plan .
 * Created by ajesh on 7/23/17.
 */
public class InvestmentPlan {

    private double investment ;
    private int years ;
    private double inflation ;
    private int numberOfSimulation ;

    /**
     * Get the invested amount
     * @return this gets is total investment amount
     */
    public double getInvestment() {
        return investment;
    }

    /**
     * Set the investment amount
     * @param investment
     */
    public void setInvestment(double investment) {
        this.investment = investment;
    }

    /**
     * Get the total number of investment plan
     * @return this return the total years for investment
     */
    public int getYears() {
        return years;
    }

    /**
     * Set the number of years for investment
     * @param years
     */
    public void setYears(int years) {
        this.years = years;
    }

    /**
     * Get the inflation rate of monetary value
     * @return
     */
    public double getInflation() {
        return inflation;
    }

    /**
     * Set the inflation rate for money
     * @param inflation
     */
    public void setInflation(double inflation) {
        this.inflation = inflation;
    }

    /**
     * Get the number of simulation to be conducted for return amount
     * @return this return the total number of simulation to be conducted
     */
    public int getNumberOfSimulation() {
        return numberOfSimulation;
    }

    /**
     *  Set the number of simulation to be conducted for sampling
     * @param numberOfSimulation
     */
    public void setNumberOfSimulation(int numberOfSimulation) {
        this.numberOfSimulation = numberOfSimulation;
    }
}
