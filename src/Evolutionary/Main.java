package Evolutionary;

import java.util.*;
import java.lang.Math;
import java.util.Random;

public class Main {
    
    // Make an init method that instantiates a domain object
    
    /**
     * The method whoLives calculates the survivors based on a tournament selection algorithm
     * @param <Individual> - an array of individuals, representing the population
     * @return Array<Individual> - the individuals that have been chosen to survive
     */
    public static ArrayList<Individual> whoLives(ArrayList<Individual>  population){
        ArrayList<Individual> tempList = new ArrayList<Individual>();
        while(tempList.size() < Math.floor(Domain.getSurRatio() * population.size())){
            // Randomly select participants for the tournament
            ArrayList<Individual> participants = selectParticipants(population);
            
            // Select Winner
            Individual winner = selectWinner(participants);
            
            //Add winner to list of winners
            tempList.add(winner);
            int winnerId = winner.getId();
            
            // Remove the winner from the population list
            removeWinner(population , winnerId);
        }
        return tempList;
    }
    
    
    /**
     * selectParticipants randomly chooses participants from a population to compete in a tournament
     * @param ArrayList<Individual> the population from which the participants are being chosen
     * @return ArrayList<Individual> the participants selected for the tournament
     */
    public static ArrayList<Individual> selectParticipants(ArrayList<Individual> population){
        ArrayList<Individual> tParticipants = new ArrayList<Individual>();
        Random x = new  Random();
        for(int i = 0 ; i < Domain.getTSize() ; i++){
            int y = x.nextInt(population.size());
            tParticipants.add(population.get(y));
        }
        return tParticipants;
    }
    
    /**
     * selectWinner chooses a winner based on highest fitness out of a tournament of Individuals
     * @param ArrayList<Individual> the participants in the tournament
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
     * removeWinner removes a tournament winner from the population
     * @param ArrayList<Individual> the population to remove the Individual from
     * @param int - the ID of the winner
     */
    public static void removeWinner(ArrayList<Individual> population , int winnerId){
        int removed=0;
        boolean found = false;
        for(int i = 0 ; i < population.size() ; i++){
            if(population.get(i).getId() == winnerId){
                removed = i;
                found = true;
            }
            else{
                found = false;
            }
        }
        if(found){
            population.remove(removed);
        }
    }
    
    
    // On the board we have crossNum being a parameter but that is not needed as a param
    /**
     * The method reproduce constructs an array of individuals representing the children of two individuals
     * @param Individual - The first parent
     * @param Individual - The second parent
     * @return ArrayList<Individual> - the two children
     */
    public static ArrayList<Individual> reproduce(Individual indi1 , Individual indi2) throws Exception{
        int x = Domain.getCrossNum();
        int y = Domain.getBitLength();
        if(x >= y-1){
            throw new Exception("crossNum cannot be larger than bitLength");
        }
        Set<Integer> crossSpots = new TreeSet<Integer>();
        ArrayList<Integer> crossSpotsList = new ArrayList<>();
        Random z = new  Random();
        while(crossSpots.size() < x){
            crossSpots.add(z.nextInt(y-1) + 1);
        }
        crossSpotsList.addAll(crossSpots);
        Collections.sort(crossSpotsList);
        crossSpotsList.add(0 , 0);
        crossSpotsList.add(y-1);
        String kid1 = "";
        String kid2 = "";
        String temp;
        for(int i = 1 ; i < crossSpotsList.size()-1 ; i++){
            kid1 = kid1 + indi1.getGenMak().substring(crossSpotsList.get(i-1) , crossSpotsList.get(i)+1);
            kid2 = kid2 + indi2.getGenMak().substring(crossSpotsList.get(i-1) , crossSpotsList.get(i)+1);
            temp = kid1;
            kid1 = kid2;
            kid2 = temp;
        }
        ArrayList<Individual> kids = new ArrayList<Individual>();
        kids.add(new Individual(kid1));
        kids.add(new Individual(kid2));
        return kids;
    }
    
    /**
     * The method createInitPop creates an ArrayList<Individual> that represents the population. These individuals
     * are created randomly.
     * @param popSize - the population size, as set in the Domain.java class
     * @return Array<Individual> - the initial population representing the first generation of the test
     */
    public static ArrayList<Individual>  createInitPop(int popSize){
        ArrayList<Individual> population = new ArrayList<Individual>();
        for (int i = 0 ; i < popSize ; i++)
        {
            population.add(new Individual());
        }
        return population;
    }
    
    /**
     * This method will take a population as an ArrayList<Individual> and will return the new population after mutations
     * @param population - an ArrayList<Individual> representing the entire population
     * @return ArrayList<Individual> - the new population after mutations have occurred
     */
    public static ArrayList<Individual> mutate(ArrayList<Individual> population){
        Random darwin = new Random();
        for (int i = 0; i < population.size() - 1 ; i++){
            double y = darwin.nextDouble() * 1;
            if (y <= Domain.getMutationRate()) {
                population.get(i).flipBit();
            }
        }
        return population;
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
        return sum/pop.size();
    }
    
    /**
     * This method returns the max fitness in the population
     * @param pop the population; an ArrayList of Individuals
     * @return the max fithess as a double
     */
    public static double maxFitness(ArrayList<Individual> pop) {
        double max = Double.NEGATIVE_INFINITY;
        for(int i = 0; i < pop.size(); i++) {
            if(pop.get(i).getFitness() > max) {
                max = pop.get(i).getFitness();
            }
        }
        return max;
    }
    
    /**
     * This method returns the min fitness in the population
     * @param pop the population; an ArrayList of Individuals
     * @return the min fithess as a double
     */
    public static double minFitness(ArrayList<Individual> pop) {
        double min = Double.POSITIVE_INFINITY;
        for(int i = 0; i < pop.size(); i++) {
            if(pop.get(i).getFitness() < min) {
                min = pop.get(i).getFitness();
            }
        }
        return min;
    }

    public static void main(String[] args) throws Exception {
        // TODO
//        for(int i = 0 ; i < popSize-1 ; i++){
//            population[i].setFitness(domain.computeFitness(population[i]));
//        }
        Domain.initializeDomain(8,1000,2,5,5,0.2,0.001);
        int gen = Domain.getGenNum();
        ArrayList<Individual> x = createInitPop(Domain.getPopSize());
        ArrayList<Individual> kids = new ArrayList<>();
        ArrayList<Individual> adults = new ArrayList<>();
       
        while (gen != 0) {
            adults = whoLives(x);
            int aSize = adults.size();
            while ( aSize < Domain.getPopSize()) {
               Random par = new Random();
               int p1 = par.nextInt((adults.size()+1));
               int p2 = par.nextInt((adults.size()+1));
                
                kids.addAll(reproduce(adults.get(p1),adults.get(p2)));
                 
                aSize= aSize + 2; 
            }
            if (kids.size()-adults.size() != Domain.getPopSize()) {
                kids.remove((kids.size()-1));
            }
            ArrayList<Individual> newGen = new ArrayList<>();
            newGen.addAll(adults);
            newGen.addAll(kids);
           
            x = mutate(newGen);
            
            // print average fitness , max fitness , worst fitness
            System.out.println(avgFitness(x));
            System.out.println(maxFitness(x));
            System.out.println(minFitness(x));
            gen--;
        }
        
        
        /** Random x = new  Random();
        
        ArrayList<Individual> firstGen = createInitPop(100); // Creates an initial population
        System.out.println("First Generation:");
        for(int i = 0 ; i < firstGen.size() ; i++){
           System.out.println(firstGen.get(i).getGenMak());
        }
        
        ArrayList<Individual> survivors = whoLives(firstGen); // Calculates the individuals that survive
        int numOfKids = firstGen.size() - survivors.size(); // The number of children to finish out the population
        ArrayList<Individual> children = new ArrayList<Individual>();
        while(children.size() < numOfKids){
            int a = x.nextInt(firstGen.size());
            int b = x.nextInt(firstGen.size());
            while(a == b){
                b = x.nextInt(firstGen.size());
            }
//            System.out.println(firstGen.get(a).getGenMak());
//            System.out.println(firstGen.get(b).getGenMak());
            children.addAll(reproduce(firstGen.get(a),firstGen.get(b)));
        }
        ArrayList<Individual> nextGen = new ArrayList<Individual>();
        nextGen.addAll(survivors);
        nextGen.addAll(children);
        nextGen = mutate(nextGen);
        System.out.println();
        System.out.println();
        System.out.println("Second Generation:");
        for(int i = 0 ; i < nextGen.size() ; i++);
            System.out.println(nextGen.get(i).getGenMak());
        } **/

           
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
