package Evolutionary;

import java.util.LinkedList;
import java.util.Collections;
import java.util.Random;

/**
 *
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
    Population(Integer populationNumber){
        while (populationNumber!=0){
            individualLinkedList.add(new Individual());
            populationNumber--;
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
     void survive(int numOfIndividuals, int numOfGenerations){
        while (numOfGenerations != 0){
            LinkedList<Individual> survive = new LinkedList<>();
            LinkedList<Double> bestFitLevel = new LinkedList<>();
            Individual winner;
            for (int i = 0; i < numOfIndividuals; i++) {
                int rn = new Random().nextInt(getIndividuals().size());
                survive.add(getIndividuals().get(rn));
                bestFitLevel.add((getIndividuals().get(rn).getFitLevel()));
            }
            // Todo: what if there are tIndividuals with the same fitness level.
            winner = survive.get(bestFitLevel.indexOf(Collections.max(bestFitLevel)));
            getIndividuals().remove(winner);
            getSurvivesLinkedList().add(winner);
            numOfGenerations--;
        }
     }

    // Todo: create a method that will do something with survivesLinkedList.
}
