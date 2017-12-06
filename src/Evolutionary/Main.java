package Evolutionary;

import java.text.DecimalFormat;
import java.util.*;
import java.lang.Math;

public class Main {
    // global random variable
    private Random rand = new Random();
    
    /**
     * The method whoLives calculates the survivors based on a tournament selection algorithm
     * @param population - an array of individuals, representing the population
     * @param domain the domain object particular to the application of this algorithm 
     *               for example, you could pass in a KingRookKingDomain object
     * @return Array<Individual> - the individuals that have been chosen to survive
     */
    public  ArrayList<Individual> whoLives(List<Individual> population, AbstractDomain domain){
        ArrayList<Individual> tempList = new ArrayList<>();
        
        int tempEnd = population.size(); //full list, to be shrunk
        while(tempList.size() < Math.floor(domain.getSurRatio() * population.size())){
            
        	// Randomly select participants for the tournament
            ArrayList<Individual> participants = selectParticipants(population.subList(0, tempEnd), domain);
            
            // Select Winner
            Individual winner = selectWinner(participants);

            //Add winner to list of winners
            tempList.add(winner);

            // swap the first and the last participants
            Collections.swap(population, population.indexOf(winner), (tempEnd-1));
            tempEnd--;
        }
        // array of winners
        return tempList;
    }
    
    
    /**
     * selectParticipants randomly chooses participants from a population to compete in a tournament
     * @param list the population from which the participants are being chosen
     * @param domain the domain object particular to the application of this algorithm 
     *               for example, you could pass in a KingRookKingDomain object
     * @return ArrayList<Individual> the participants selected for the tournament
     */
    public  ArrayList<Individual> selectParticipants(List<Individual> list,  AbstractDomain domain){
        ArrayList<Individual> tParticipants = new ArrayList<Individual>();
        for(int i = 0 ; i < domain.getTSize() ; i++){
            int y = rand.nextInt(list.size());
            tParticipants.add(list.get(y));
        }
        // arrayList of individuals chosen
        return tParticipants;
    }
    
    /**
     * selectWinner chooses a winner based on highest fitness out of a ArrayList of Individuals (chosen above)
     * @param participants <Individual> the participants in the tournament
     * @return Individual - the winner of the tournament
     */
    public Individual selectWinner(List<Individual> participants){
        Individual winner = participants.get(0);
        double winnerFitness = winner.getFitness();
        // Compare fitness of current most fit person with next person in the list
        for(int i = 1 ; i < participants.size() ; i++){
            double nextFitness = participants.get(i).getFitness();
            if(nextFitness > winnerFitness){
                winner = participants.get(i);
                winnerFitness = nextFitness;
            }
        }
        // Individual
        return winner;
    }
    
    /**
     * The method createInitPop creates an ArrayList<Individual> that represents the population. These individuals
     * are created randomly.
     * @param popSize - the population size, as set in the Domain.java class
     * @param domain the domain object particular to the application of this algorithm 
     *               for example, you could pass in a KingRookKingDomain object
     * @return Array<Individual> - the initial population representing the first generation
     */
    public ArrayList<Individual>  createInitPop(int popSize, AbstractDomain domain) throws Exception {
        ArrayList<Individual> population = new ArrayList<>();
        for (int i = 0 ; i < popSize ; i++) {
            population.add(new Individual(domain));
        }
        // Array
        return population;
    }
    
    /**
     * This method will take a population as an ArrayList<Individual> and will return the new population after mutations
     * @param population - an ArrayList<Individual> representing the entire population
     * @param domain the domain object particular to the application of this algorithm 
     *               for example, you could pass in a KingRookKingDomain object
     * @return ArrayList<Individual> - the new population after mutations have occurred
     */

    public ArrayList<Individual> mutate(ArrayList<Individual> population, AbstractDomain domain) throws Exception {
        int y = (int) (population.size() * domain.getMutationRate());
        Set<Integer> indices = new TreeSet<Integer>();
        // Randomly selecting percentage of population to mutate based on mutation rate
        while(indices.size() < y){
            indices.add(rand.nextInt(population.size()));
        }
        // Calling flipBit and doing the actual mutation
        for(int index : indices){
            population.get(index).flipBit(domain);
        }
        // ArrayList
        return population;
    }

    /**
     * This method is going to create a list of all the split locations.
     * @param father: first parent (Individual)
     * @param mother: second parent (Individual)
     * @param domain the domain object particular to the application of this algorithm 
     *               for example, you could pass in a KingRookKingDomain object
     * @return an ArrayList that has two new children.
     */
    public ArrayList<Individual> reproduce(Individual father, Individual mother, AbstractDomain domain) throws Exception {
         ArrayList<Integer> allSplits = getSplits(domain);
         // Does the work of splicing and constructing new individuals
         return sliceAndDice(domain, allSplits, father.getGenMak(), mother.getGenMak());
    }
    /**
     * This method returns the indices of where to make crossover in the genetic make-up between two parents
     * @param domain an object that extends AbstractDomain and is particular to the application of this algorithm
     *        for example you could input a KingRookKing object type
     * @return an ArrayList of Integers that gives all of the indices of where to crossover the genetic code
     */
    public ArrayList<Integer> getSplits(AbstractDomain domain){
        ArrayList<Integer> splitsIndices = new ArrayList<>(); // all the splits indexes.
        int splitNum = domain.getCrossNum();
        while (splitNum != 0){
            // generate a number from 1 to len of the father or the mother - 1
            int randomSplit = rand.nextInt( domain.getBitLength() - 1) + 1;
            if (!splitsIndices.contains(randomSplit)){
                splitsIndices.add(randomSplit);
                splitNum--;
            }
        }
        splitsIndices.add(0, 0);
        splitsIndices.add(domain.getBitLength());
        Collections.sort(splitsIndices);
        // ArrayList
        return splitsIndices;
    }

    /**
     * This method is going to create the a kid basted on the input.
     * @param domain the domain object particular to the application of this algorithm 
     *               for example, you could pass in a KingRookKingDomain object
     * @param allIndexes : where all the splits will take place. (ArrayList)
     * @param father : father genMakUp from Individual object (String)
     * @param mother : mother genMakUp from Individual object (String)
     * @return
     */
     ArrayList<Individual> sliceAndDice(AbstractDomain domain, ArrayList<Integer> allIndexes, String father, String mother) throws Exception {
        String kid1 = "";
        String kid2 = "";
         int sub = 0;
         while (allIndexes.size()  - 1 >= sub){
             if (father.length() != kid1.length() && mother.length() != kid2.length()) {
                 kid1 += father.substring(allIndexes.get(sub), allIndexes.get(sub + 1));
                 kid2 += mother.substring(allIndexes.get(sub), allIndexes.get(sub + 1));
             }

             if (father.length() != kid1.length() && mother.length() != kid2.length()){

                 kid1 += mother.substring( allIndexes.get(sub + 1), allIndexes.get(sub + 2));
                 kid2 += father.substring( allIndexes.get(sub + 1), allIndexes.get(sub + 2));
             }
             sub+=2;
         }
         // passes two strings and domain to twoKids method
        return twoKids(domain, kid1, kid2);
    }
    /**
     * @param domain the domain object particular to the application of this algorithm 
     *               for example, you could pass in a KingRookKingDomain object
     * @param firstKid String
     * @param secondKid String
     * @return @return an ArrayList of two new born kids.
     */
    private ArrayList<Individual> twoKids(AbstractDomain domain, String firstKid, String secondKid) throws Exception {
        ArrayList<Individual> newKids = new ArrayList<>();
        newKids.add(new Individual(domain, firstKid));
        newKids.add(new Individual(domain, secondKid));
        // ArrayList
        return newKids;
    }

    /**
     * This method takes a population and returns the average fitness
     * @param pop the population; an ArrayList of Individuals
     * @return the average fitness as a double
     */
    public double avgFitness(ArrayList<Individual> pop) {
        double sum = 0;
        for(int i = 0; i < pop.size(); i++) {
            sum += pop.get(i).getFitness();
        }
        // Double
        return Double.parseDouble(new DecimalFormat("0.000").format(sum / pop.size()));
    }

    /**
     * This method returns the max fitness in the population
     * @param pop the population; an ArrayList of Individuals
     * @return the max fitness as a double (fitness of an Individual)
     */
    public double maxFitness(ArrayList<Individual> pop) {
        Individual maxfit = Collections.max(pop, new IndividualComp());
        // Double (fitness of an Individual)
        return maxfit.getFitness();
    }

    /**
     * This method returns the min fitness in the population
     * @param pop the population; an ArrayList of Individuals
     * @return the min fitness as a double (fitness of an Individual)
     */
    public double minFitness(ArrayList<Individual> pop) {
        Individual minfit = Collections.min(pop, new IndividualComp());
        // Double (fitness of an Individual)
        return minfit.getFitness();
    }

    /**
     * This method runs a generation, used to shorten main method
     * @param population ArrayList of initial population
     * @param adultList ArrayList of surviving adults
     * @param kidList ArrayList of kids, to be added to
     * @param domain the domain
     */
    private void runGeneration(ArrayList<Individual> population, ArrayList<Individual> adultList, ArrayList<Individual> kidList, AbstractDomain domain) throws Exception {
    	int nextGenSize = adultList.size(); //starts at the size of the adults, increases as children added

        while (nextGenSize < domain.getPopSize()) {
            ArrayList<Individual> randGroup;
    		randGroup = selectParticipants(population, domain); //form a random group from the WHOLE population
    		Individual p1 = selectWinner(randGroup); //select  a winner from the random group
    		Individual tempInd = p1;
    		randGroup.set(randGroup.indexOf(p1), randGroup.get(randGroup.size()-1));
    		randGroup.set(randGroup.size()-1, tempInd);
    		Individual p2 = selectWinner(randGroup.subList(0, randGroup.size()-1)); //choose from the list except last element(p1)
    		//kidList.add(reproduce(p1,p2,domain).get(0));
            kidList.addAll(reproduce(p1, p2, domain));
            nextGenSize+= 2;
         }
    }
    
    /**
     * This method combines two lists of Individuals
     * @param list1 ArrayList of Individuals
     * @param list2 another ArrayList of Individuals
     * @return ArrayList combining list1 and list2
     */
    private ArrayList<Individual> combineLists(ArrayList<Individual> list1, ArrayList<Individual> list2){
    	ArrayList<Individual> combinedList = new ArrayList<>();
    	combinedList.addAll(list1);
    	combinedList.addAll(list2);
        // ArrayList
        return combinedList;
    }

    /**
     * This method prints gen, maxFit, and avgFit 
     * @param gen the generation number (int)
     * @param initPop mutated for the next generation (ArrayList)
     */
    private  void printStats(int gen, ArrayList<Individual> initPop){
    	System.out.println("gen" + gen + "  maxFit " + maxFitness(initPop)  + "  minFit " + minFitness(initPop) +
                "  avgFit " + avgFitness(initPop));
    }


    /**
     * This is the main method, this does the work of running through each generation
     * and doing the appropriate tasks in order.
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        // Change this line of code to match your domain
        Domain domain = new Domain();
        Main main = new Main();
        // The greater tha bitLength the more interesting the results are.
        domain.initializeDomain(50,100,5,20,5,
                0.2,0.01);
        ArrayList<Individual> initPop = main.createInitPop(domain.getPopSize(), domain);
        int count = 0;
        main.printStats(count, initPop);
        ArrayList<Individual> kids;
        ArrayList<Individual> adults;
        count++;
        
        int gen = domain.getGenNum();
        while (count < gen) {
            adults = main.whoLives(initPop, domain);
            kids = new ArrayList<>();
            main.runGeneration(initPop, adults, kids, domain);
            int aSize = adults.size();

            // make sure that it is even.
            if (kids.size() + adults.size() != domain.getPopSize()) {
                kids.remove((kids.size() - 1)); // remove the last kid.
            }
            initPop = main.combineLists(adults, kids);
            initPop = main.mutate(initPop, domain);
            main.printStats(count, initPop);
            count++;
        }
    }
}
