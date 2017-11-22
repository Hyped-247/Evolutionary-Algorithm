package Evolutionary;

/**
 * This is the abstract for the Domain class which holds the
 * data and compute fitness method which are subject to change
 * based the how the user wants the simulation implemented
 **/

public abstract class AbstractDomain {

    private int bitLength;
    private int popSize;
    private int crossNum;
    private int genNum;
    private int tSize;
    private double surRatio;
    private double mutationRate;


    /*
     * Takes an Individual object and returns it's fitness score
     * @param i an Individual object
     * @return the double fitness level between 0-1
     */
    public abstract double computeFitness(String gen);


	/*
	 * Initializes the local variables to the specified values passed to the method
	 * @param bitLength 	length of the genetic makeup's string
	 * @param popSize 		amount of individuals in a population
	 * @param crossNum 		amount of crosses in the reproduction process
	 * @param numGen 		amount of generations for the simulation to run
	 * @param surRatio		the survival rate of a generation between 0-1
	 * @param mutationRate	the mutation rate for the simulation 0-1
	 */

    public  void initializeDomain(int bitLength1, int popSize1, int crossNum1, int numGen, int tSize1,
                                        double surRatio1, double mutationRate1) throws Exception {
        bitLength = bitLength1;
        popSize = popSize1;
        crossNum = crossNum1;
        genNum = numGen;
        tSize = tSize1;
        surRatio = surRatio1;
        mutationRate = mutationRate1;
        correctInput(crossNum, bitLength); // check if the num of splits is not greater than the len of GenMak
    }
    private void correctInput(int crossNum, int bitLength) throws Exception{
        if(crossNum >= bitLength || crossNum <= 0 || bitLength <= 0){
            // throw an error iff the num of number of splits is greater than the bit length
            throw new Exception("crossNum cannot be larger than bitLength or less than 1");
        }
    }

    int getBitLength() {
        return bitLength;
    }

    int getPopSize() {
        return popSize;
    }

    int getCrossNum() {
        return crossNum;
    }

    int getGenNum() {
        return genNum;
    }
    
    int getTSize() {
        return tSize;
    }

    double getSurRatio() {
        return surRatio;
    }

    double getMutationRate() {
        return mutationRate;
    }

}

