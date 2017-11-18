package Evolutionary;

import java.text.DecimalFormat;
import java.util.*;
import java.lang.Math;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
public class Main {

    // Make an init method that instantiates a domain object
    
    /**
     * The method whoLives calculates the survivors based on a tournament selection algorithm
     * @param population - an array of individuals, representing the population
     * @param domain
     * @return Array<Individual> - the individuals that have been chosen to survive
     */
    public static ArrayList<Individual> whoLives(ArrayList<Individual> population, Domain domain){
        ArrayList<Individual> tempList = new ArrayList<Individual>();
        while(tempList.size() < Math.floor(domain.getSurRatio() * population.size())){
            // Randomly select participants for the tournament
            ArrayList<Individual> participants = selectParticipants(population, domain);
            
            // Select Winner
            Individual winner = selectWinner(participants);
            
            //Add winner to list of winners
            tempList.add(winner);

            // Remove the winner from the population list
            population.remove(winner);
        }
        return tempList;
    }
    
    
    /**
     * selectParticipants randomly chooses participants from a population to compete in a tournament
     * @param population the population from which the participants are being chosen
     * @return ArrayList<Individual> the participants selected for the tournament
     */
    public static ArrayList<Individual> selectParticipants(ArrayList<Individual> population,  Domain domain){
        ArrayList<Individual> tParticipants = new ArrayList<Individual>();
        Random x = new  Random();
        for(int i = 0 ; i < domain.getTSize() ; i++){
            int y = x.nextInt(population.size());
            tParticipants.add(population.get(y));
        }
        return tParticipants;
    }
    
    /**
     * selectWinner chooses a winner based on highest fitness out of a tournament of Individuals
     * @param participants <Individual> the participants in the tournament
     * @return Individual - the winner of the tournament
     */
    public static Individual selectWinner(ArrayList<Individual> participants){
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
    public static ArrayList<Individual>  createInitPop(int popSize, Domain domain){
        ArrayList<Individual> population = new ArrayList<Individual>();
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
    public static ArrayList<Individual> mutate(ArrayList<Individual> population, Domain domain){
        Random darwin = new Random();
        for (int i = 0; i < population.size() - 1 ; i++){
            double y = darwin.nextDouble() * 1; // Todo: This can throw an erorr.
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
    private static ArrayList<Individual> reproduce(Individual father, Individual mother, Domain domain){
        LinkedList<Integer> splitsIndexes = new LinkedList<>(); // all the splits indexes.
        int splitNum = domain.getCrossNum();
        while (splitNum != 0){
            // generate a number from 1 to len of the father or the mother - 1
            int randomSplit = random(father.getGenMak().length() - 1);
            if (!splitsIndexes.contains(randomSplit)){
                splitsIndexes.add(randomSplit);
                splitNum--;
            }
        }
        Collections.sort(splitsIndexes);
        return getKids(splitsIndexes, father.getGenMak(), mother.getGenMak());
    }


    /**
     * This method is going to create the first kid.
     * @param allIndexes : where all the slplits will take place.
     * @param father : father indeviual object
     * @param mother : mother indeviual object
     * @return
     */
    static ArrayList<Individual> getKids(LinkedList allIndexes, String father, String mother){
        int index = 0;
        Boolean allowfather = false;
        Boolean allowmother = false;
        String firstKid = "";
        int counter = allIndexes.size(); // how many times I am going to split.
        int genMakLen = father.length(); // how is the bit len.
        while (counter >= -1){
            // Add all the bits for the father's part.
            while ((!allIndexes.contains(index) && (genMakLen != index)) ||  (allowfather && (genMakLen != index))){
                firstKid += father.charAt(index);
                allowfather = false;
                allowmother = true;
                index++;
            }
            counter--;
            // Add all the bits for the mother's part.
            while ((!allIndexes.contains(index) && (genMakLen != index)) || (allowmother && (genMakLen != index))){
                firstKid += mother.charAt(index);
                allowfather = true;
                allowmother = false;
                index++;
            }
            counter--;
        }
        return createSecondKid(firstKid);
    }

    /**
     * This method is going to create a second kid by fliping all the bits of the first kid.
     * @param firstKid : genMak for the first kid.
     * @return an ArrayList of two new born kids.
     */
    private static ArrayList<Individual> createSecondKid(String firstKid) {
        return twoKids(firstKid, flipBit(firstKid));
    }

    /**
     * @param firstKid
     * @param secondKid
     * @return @return an ArrayList of two new born kids.
     */
    private static ArrayList<Individual> twoKids(String firstKid, String secondKid) {
        ArrayList<Individual> newKids = new ArrayList<>();
        newKids.add(new Individual(firstKid));
        newKids.add(new Individual(secondKid));
        return newKids;
    }


    /**
     * @param max: max number
     * @return : a random nummber from 1 to the a max number. Ex.
     * If max is = to 5, then numbers that will be generaged are : 1, 2, 3, 4, 5
     */
    private static int random(int max) {
        return ThreadLocalRandom.current().nextInt(1, max + 1);
    }

    
    /**
     * This method takes a population and returns the average fitness
     * @param pop the population; an ArrayList of Individuals
     * @return the average fitness as a double
     */
    public static double avgFitness(ArrayList<Individual> pop) {
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
    public static double maxFitness(ArrayList<Individual> pop) {
        Individual maxfit = Collections.max(pop, new IndividualComp());
        return maxfit.getFitness();
    }


    /**
     * This method returns the min fitness in the population
     * @param pop the population; an ArrayList of Individuals
     * @return the min fithess as a double
     */
    public static double minFitness(ArrayList<Individual> pop) {
        Individual minfit = Collections.max(pop, new IndividualComp());
        return minfit.getFitness();
    }

    /**
     * @param genMak: take a string of 0's and 1's.
     * @return : A string of the oppsitie string of 0's and 1's. Ex.
     * If the input is: "10001", then the output is: "01110"
     */
    private static String flipBit(String genMak){
        return genMak.replaceAll("0", "x").
                replaceAll("1", "0")
                .replaceAll("x", "1");
    }
    public static void main(String[] args) throws Exception {
        Domain domain = new Domain();
        domain.initializeDomain(4,20,2,5,5,
                0.2,0.001);
        int gen = domain.getGenNum();
        ArrayList<Individual> initPop = createInitPop(domain.getPopSize(), domain); // todo: this shouldn't be here.
        ArrayList<Individual> adults = new ArrayList<>();
        ArrayList<Individual> kids = new ArrayList<>();

        while (gen != 0) {
            adults = whoLives(initPop, domain);
            int aSize = adults.size();

            while ( aSize < domain.getPopSize()) {
               Random par = new Random(); // get Random number.
               int p1 = par.nextInt((adults.size())); // chose random father.
               int p2 = par.nextInt((adults.size()));// chose random mother.

                kids.addAll(reproduce(adults.get(p1), adults.get(p2), domain));
                aSize+= 2;

            }
            if (kids.size()-adults.size() != domain.getPopSize()) {
                kids.remove((kids.size()-1)); // remove the last kid.
            }
            ArrayList<Individual> newGen = new ArrayList<>();
            newGen.addAll(adults);
            newGen.addAll(kids);

            initPop = mutate(newGen, domain);
            
            // print average fitness , max fitness , worst fitness
            System.out.println("This is the data for genration num: "+gen);
            System.out.println("This is the avgFitness "+avgFitness(initPop));
            System.out.println("This is the maxFitness "+maxFitness(initPop));
            System.out.println("This is the minFitness "+minFitness(initPop));
            gen--;
        }
        // Todo: fix the bit for the second child.
        // Todo: compute the fitness for each ind
        // Todo:
//         Compute fitness and store
//         Compute the standard diviation over fitness and store
//         Select for survival
//         Select for reproduction
//         Mutate
//         Create a population from these individuals
//         Compute maximum fitness and store
//         Compute minimum fitness and store
//         Print this for every generation: genNum_k_avgFit_ft_stdv_f2_maxFit_f3_minFit_f4
//         Restart
        
    }
}
