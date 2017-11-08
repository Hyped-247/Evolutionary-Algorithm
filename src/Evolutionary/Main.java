package Evolutionary;

import java.util.Collections;
import java.util.Random;

public class Main {
    /**
     * The method whoLives calculates the survivors based on a tournament selection algorithm
     * @param Array<Individual> - an array of individuals, representing the population
     * @return Array<Individual> - the individuals that have been chosen to survive
     */
    public Array<Individual> whoLives(Array<Individual> population){
        // TODO
    }
    
    // On the board we have crossNum being a parameter but that is not needed as a param
    /**
     * The method reproduce constructs an array of individuals representing the children of two individuals
     * @param Individual - The first parent
     * @param Individual - The second parent
     */
    public ArrayList<Individual> reproduce(Individual indi1 , Individual indi2) throws Exception{
        int x = Domain.get(crossNum);
        int y = Domain.get(bitLength);
        if(x >= y-1){
            throw Exception("crossNum cannot be larger than bitLength");
        }
        Set<int> crossSpots = new Set<int>();
        List<int> crossSpotsList = new List<int>();
        z = Random();
        while(crossSpots.size() < x){
            crossSpots.add(z.nextInt(y-1) + 1);
        }
        crossSpotsList.addAll(crossSpots);
        crossSpotsList.sort();
        crossSpotsList.addFirst(0);
        crossSpotsList.addLast(bitLength-1);
        String kid1 = "";
        String kid2 = "";
        String temp;
        for(int i = 1 ; i < crossSpotsList.size() ; i++){
            kid1 = kid1 + indi1.getGenMak().substring(crossSpotList.get(i-1) , crossSpotList.get(i)+1);
            kid2 = kid2 + indi2.getGenMak().substring(crossSpotList.get(i-1) , crossSpotList.get(i)+1);
            temp = kid1;
            kid1 = kid2;
            kid2 = temp;
        }
        System.out.println(kid1);
        System.out.println(kid2);
        ArrayList<Individual> kids = new ArrayList<Individual>();
        kids.add(Individual(kid1));
        kids.add(Individual(kid2));
        return kids;
    }
    
    /**
     * The method createInitPop creates an Array<Individual> that represents the population. These individuals
     * are created randomly.
     * @param popSize - the population size, as set in the Domain.java class
     * @return Array<Individual> - the initial population representing the first generation of the test
     */
    public Array<Individual> createInitPop(int popSize){
        // TODO
    }
    
    /**
     * This method will take a population as an ArrayList<Individual> and will return the new population after mutations
     * @param population - an ArrayList<Individual> representing the entire population
     * @return ArrayList<Individual> - the new population after mutations have occurred
     */
    public ArrayList<Individual> mutate(ArrayList<Individual> population){
        // TODO
    }
    
    public static void main(String[] args) {
        // TODO
//        for(int i = 0 ; i < popSize-1 ; i++){
//            population[i].setFitness(domain.computeFitness(population[i]));
//        }
        reproduce(Individual(),Individual());
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
