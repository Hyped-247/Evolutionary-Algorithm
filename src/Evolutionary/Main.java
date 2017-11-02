package Evolutionary;

import java.util.Collections;

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
    public Array<Individual> reproduce(Individual indi1 , Individual indi2){
        // TODO
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
    
    public static void main(String[] args) {
        // TODO
        for(int i = 0 ; i < popSize-1 ; i++){
            population[i].setFitness(domain.computeFitness(population[i]));
        }
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
