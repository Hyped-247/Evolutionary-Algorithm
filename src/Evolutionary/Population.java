package Evolutionary;

import java.util.LinkedList;
import java.util.Collections;
import java.util.Random;

/**
 * @author Mo
 * @see Individual : in the Individual class is where everything is created.
 *
 **/
class Population {
    private  LinkedList<Individual> individualLinkedList = new LinkedList<>();
    private  LinkedList<Individual> survivesLinkedList = new LinkedList<>();
    /**
     * Based on a given number this constructor is going to create Individual objects.
     * @param population_number take the number of Individual objects that you want to create.
     *
     **/
    Population(Integer population_number){
        while (population_number!=0){
            individualLinkedList.add(new Individual());
            population_number--;
        }
    }
    /**
     * @return a list of all the Individuals objects.
     **/
    LinkedList<Individual> getIndividuals(){
        return individualLinkedList;
    }
    /**
     * @return a list of all the Individuals objects that have survived(the most fit).
     **/
    LinkedList<Individual> getSurvivesLinkedList(){return survivesLinkedList;}
    /**
     * @param number_of_individuals is going to take the total number of random selected individuals
     * @param number_of_generations how many times do you want to do the process.
     * This method is going to do two things:
     * 1) select a given number of random Individual.
     * 2) add the best fitness level to survivesLinkedList.
     **/
     // Todo: the survive method is going to take only how many are going to survive.
     void survive(int number_of_individuals, int number_of_generations){
        while (number_of_generations != 0){
            LinkedList<Individual> survive = new LinkedList<>();
            LinkedList<Double> best_fitness_level = new LinkedList<>();
            Individual winner;
            for (int i = 0; i < number_of_individuals; i++) {
                int rn = new Random().nextInt(getIndividuals().size());
                survive.add(getIndividuals().get(rn));
                best_fitness_level.add((getIndividuals().get(rn).getFitness_level()));
            }
            // Todo: what if there are tIndividuals with the same fitness level.
            winner = survive.get(best_fitness_level.indexOf(Collections.max(best_fitness_level)));
            getIndividuals().remove(winner);
            getSurvivesLinkedList().add(winner);
            number_of_generations--;
        }
     }
    // Todo: create a method that will do something with survivesLinkedList.

    // Todo: create a reproduce method that will do something.
    // Todo:


}
