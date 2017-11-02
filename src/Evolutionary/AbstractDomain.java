package Evolutionary;

/*
 * This is the abstract for the Domain class which holds the 
 * data and compute fitness method which are subject to change
 * based the how the user wants the simulation implemented
 */

public abstract class AbstractDomain {
	
	int bitLength;
	int popSize;
	int crossNum;
	int genNum;
	double surRatio;
	double mutationRate;

	
	/*
	 * Takes an Individual object and returns it's fitness score
	 * @param i an Individual object
	 * @return the double fitness level between 0-1
	 */
	public abstract double computeFitness(Individual i);
	
	
	
	/*
	 * Initializes the local variables to the specified values passed to the method
	 * @param bitLength 	length of the genetic makeup's string
	 * @param popSize 		amount of individuals in a population
	 * @param crossNum 		amount of crosses in the reproduction process
	 * @param genNum 		amount of generations for the simulation to run
	 * @param surRatio		the survival rate of a generation between 0-1
	 * @param mutationRate	the mutation rate for the simulation 0-1
	 */
	
	public void initializeDomain(int bitLength, int popSize, int crossNum, int genNum, double surRatio, double mutationRate){
		this.bitLength = bitLength;
		this.popSize = popSize;
		this.crossNum = crossNum;
		this.genNum = genNum;
		this.surRatio = surRatio;
		this.mutationRate = mutationRate;
		
	}
	
	
	
	

}
