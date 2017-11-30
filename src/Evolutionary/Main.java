package Evolutionary;

import java.text.DecimalFormat;
import java.util.*;
import java.lang.Math;
import java.util.Random;

public class Main {
    private Random rand = new Random();


    // Make an init method that instantiates a domain object
    
    /**
     * The method whoLives calculates the survivors based on a tournament selection algorithm
     * @param population - an array of individuals, representing the population
     * @param domain
     * @return Array<Individual> - the individuals that have been chosen to survive
     */
    public  ArrayList<Individual> whoLives(List<Individual> population, Domain domain){
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
        return tempList;
    }
    
    
    /**
     * selectParticipants randomly chooses participants from a population to compete in a tournament
     * @param list the population from which the participants are being chosen
     * @return ArrayList<Individual> the participants selected for the tournament
     */
    public  ArrayList<Individual> selectParticipants(List<Individual> list,  Domain domain){
        ArrayList<Individual> tParticipants = new ArrayList<Individual>();
        Random x = new  Random();
        for(int i = 0 ; i < domain.getTSize() ; i++){
            int y = x.nextInt(list.size());
            tParticipants.add(list.get(y));
        }
        return tParticipants;
    }
    
    /**
     * selectWinner chooses a winner based on highest fitness out of a tournament of Individuals
     * @param participants <Individual> the participants in the tournament
     * @return Individual - the winner of the tournament
     */
    public Individual selectWinner(List<Individual> participants){
        Individual winner = participants.get(0);
        double winnerFitness = winner.getFitness();
        for(int i = 1 ; i < participants.size() ; i++){
            double nextFitness = participants.get(i).getFitness();
            if(nextFitness > winnerFitness){
                winner = participants.get(i);
                winnerFitness = nextFitness;
            }
        }
        return winner;
    }
    
    /**
     * The method createInitPop creates an ArrayList<Individual> that represents the population. These individuals
     * are created randomly.
     * @param popSize - the population size, as set in the Domain.java class
     * @return Array<Individual> - the initial population representing the first generation of the test
     */
    public ArrayList<Individual>  createInitPop(int popSize, Domain domain){
        ArrayList<Individual> population = new ArrayList<>();
        for (int i = 0 ; i < popSize ; i++) {
            population.add(new Individual(domain));
        }
        return population;
    }
    
    /**
     * This method will take a population as an ArrayList<Individual> and will return the new population after mutations
     * @param population - an ArrayList<Individual> representing the entire population
     * @return ArrayList<Individual> - the new population after mutations have occurred
     */
    public ArrayList<Individual> mutate(ArrayList<Individual> population, Domain domain){
        for (int i = 0; i < population.size() - 1 ; i++){
            double y = rand.nextDouble();
            if (y <= domain.getMutationRate()) {
                population.get(i).flipBit(domain);
            }
        }
        return population;
    }

    /**
     * This method is going to create a list of all the indexes of the spliets.
     * @param father: first parent
     * @param mother: second parent
     * @return an ArrayList that has two new children.
     */
    public ArrayList<Individual> reproduce(Individual father, Individual mother, Domain domain){
         ArrayList<Integer> allSplits = gitSplits(domain);
         ArrayList<Individual> kids = sliceAndDice(domain, allSplits, father.getGenMak(), mother.getGenMak());
        return kids;
    }

    public ArrayList<Integer> gitSplits(Domain domain){
        ArrayList<Integer> splitsIndexes = new ArrayList<>(); // all the splits indexes.
        int splitNum = domain.getCrossNum();
        while (splitNum != 0){
            // generate a number from 1 to len of the father or the mother - 1
            int randomSplit = rand.nextInt( domain.getBitLength() - 1) + 1;
            if (!splitsIndexes.contains(randomSplit)){
                splitsIndexes.add(randomSplit);
                splitNum--;
            }
        }
        splitsIndexes.add(0, 0);
        splitsIndexes.add(domain.getBitLength());
        Collections.sort(splitsIndexes);
        return splitsIndexes;
    }

    /**
     * This method is going to create the a kid basted on the input.
     * @param allIndexes : where all the slplits will take place.
     * @param father : father indeviual object
     * @param mother : mother indeviual object
     * @return
     */
     ArrayList<Individual> sliceAndDice(Domain domain, ArrayList<Integer> allIndexes, String father, String mother){
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
        return twoKids(domain, kid1, kid2);
    }
    /**
     * @param domain
     * @param firstKid
     * @param secondKid
     * @return @return an ArrayList of two new born kids.
     */
    private ArrayList<Individual> twoKids(Domain domain, String firstKid, String secondKid) {
        ArrayList<Individual> newKids = new ArrayList<>();
        newKids.add(new Individual(domain, firstKid));
        newKids.add(new Individual(domain, secondKid));
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
        return Double.parseDouble(new DecimalFormat("0.00").format(sum / pop.size()));
    }

    /**
     * This method returns the max fitness in the population
     * @param pop the population; an ArrayList of Individuals
     * @return the max fithess as a double
     */
    public double maxFitness(ArrayList<Individual> pop) {
        Individual maxfit = Collections.max(pop, new IndividualComp());
        return maxfit.getFitness();
    }

    /**
     * This method returns the min fitness in the population
     * @param pop the population; an ArrayList of Individuals
     * @return the min fithess as a double
     */
    public double minFitness(ArrayList<Individual> pop) {
        Individual minfit = Collections.min(pop, new IndividualComp());
        return minfit.getFitness();
    }

    /**
     * This method runs a generation, used to shorten main method
     * @param adultList list of surviving adults
     * @param kidList list of kids, to be added to
     * @param domain the domain
     */
    private void runGeneration(ArrayList<Individual> population, ArrayList<Individual> adultList, ArrayList<Individual> kidList, Domain domain){
    	int nextGenSize = adultList.size(); //starts at the size of the adults, increases as children added

        while (nextGenSize < domain.getPopSize()) {
            ArrayList<Individual> randGroup;

    		randGroup = selectParticipants(population, domain); //form a random group from the WHOLE population
    		Individual p1 = selectWinner(randGroup); //select  a winner from the random group
    		Individual tempInd = p1;
    		randGroup.set(randGroup.indexOf(p1), randGroup.get(randGroup.size()-1));
    		randGroup.set(randGroup.size()-1, tempInd);
    		Individual p2 = selectWinner(randGroup.subList(0, randGroup.size()-1)); //choose from the list except last element(p1)
      
             kidList.addAll(reproduce(p1, p2, domain));
             nextGenSize+= 2;

         }
    }
    /**
     * This method combines two lists of Individuals
     * @param list1 list of Individuals
     * @param list2 another list of Individuals
     * @return list combining list1 and list2
     */
    private ArrayList<Individual> combineLists(ArrayList<Individual> list1, ArrayList<Individual> list2){
    	ArrayList<Individual> combinedList = new ArrayList<>();
    	combinedList.addAll(list1);
    	combinedList.addAll(list2);
        
        return combinedList;
    }
      private void genData(int gen, ArrayList<Individual> initPop) {
        // print average fitness , max fitness , worst fitness
        System.out.println("This is the data for generation num: "+gen);
        System.out.println("This is the avgFitness "+avgFitness(initPop));
        System.out.println("This is the maxFitness "+maxFitness(initPop));
        System.out.println("This is the minFitness "+minFitness(initPop));
    }
    /**
     * This method prints gen, maxFit, and avgFit 
     * @param gen the generation number 
     * @param initPop mutated for the next generation 
     */
    private  void printStats(int gen, ArrayList<Individual> initPop){
    	System.out.println("gen" + gen + "  maxFit " + maxFitness(initPop) + "  avgFit " + avgFitness(initPop));
    }
    

    public static void main(String[] args) throws Exception {
        Domain domain = new Domain();
        Main main = new Main();
        // The greater tha bitLength the more interesting the results are.
        domain.initializeDomain(100,10000,5,15,20,
                0.8,0.9);
        ArrayList<Individual> initPop = main.createInitPop(domain.getPopSize(), domain); // todo: this shouldn't be here.
        ArrayList<Individual> kids = new ArrayList<>();
        ArrayList<Individual> adults;

        int count = 0;
        int gen = domain.getGenNum();
        while (count < gen) {
            adults = main.whoLives(initPop, domain);
            main.runGeneration(initPop, adults, kids, domain);
            int aSize = adults.size();

//            while (aSize < domain.getPopSize()) {
//                int p1 = rand.nextInt((initPop.size())); // chose random father.
//                int p2 = rand.nextInt((initPop.size()));// chose random mother.
//
//                kids.addAll(main.reproduce(initPop.get(p1), initPop.get(p2), domain));
//                aSize += 2;
//            }
            // make sure that it is even.
            if (kids.size() - adults.size() != domain.getPopSize()) {
                kids.remove((kids.size() - 1)); // remove the last kid.
            }
//            ArrayList<Individual> newGen = new ArrayList<>();
//            newGen.addAll(adults);
//            newGen.addAll(kids);

            initPop = main.mutate(main.combineLists(adults, kids), domain);
            main.printStats(count, initPop);
            count++;
        }
    }
}
