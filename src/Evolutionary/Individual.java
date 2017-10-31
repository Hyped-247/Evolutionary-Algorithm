package Evolutionary;

import java.util.Collections;
import java.util.LinkedList;


/**
 * This class is going to create an id, genetic_makeup, and fitness_level for each Individual.
 * The id is the name of the individual shown by a number. The genetic makeup is an 8 bit
 * binary linked list, and the fitness level is a number with a higher fitness being a bigger
 * number.
 **/
class Individual {
    private LinkedList<String> geneticMkup = new LinkedList<>();
    private static int idGenerator = 0;
    private String geneticMkup;
    private double fitnessLevel;
    private int id;

    /**
     * This constructor is going to call all the methods that will create:
     * 1) id (number),
     * 2) geneticMkup (linked list),
     * 3) fitnessLevel (number)
     **/
    Individual(){
        setIndividualId();
        setGeneticMkup();
        setGeneticMkupList();
        setFitnessLevel();
    }
    /**
     * Creates the id for this individual as one more than the last created individual
     **/
    private void  setIndividualId(){
        id = idGenerator++;
    }
    /**
     * Creates the genetic makeup for this individual which is a random string that is
     * 8 digits long of binary numbers.
     **/
    private String setGeneticMkup(){
        geneticMkup =  Integer.toBinaryString(128 + (int) (127 * Math.random()));
        return geneticMkup;
    }

    /**
     * Returns the fitness for this individual. setFitnessLevel is determined by the
     * fitness algorithm that is given to us by a user input. This means that we have
     * to calculate it based on what they give us.
     **/
    // Todo: revisit how we represent fitness.
    // Talk about how we are going to accept user inputs and how that is then passed to here.
    private double setFitnessLevel(){
        double fitnessLevel =  Collections.frequency(getGeneticMkupList(), "1") / 8.0;
        return fitnessLevel;
    }
    /**
     * Make the geneticMkup into a linked list so that we can access and work with individual
     * parts of the geneticMKup. This will be helpful when we are working on reproduction.
     **/
    private void setGeneticMkupList(){
        Collections.addAll(geneticMkupList, getGeneticMkupString().split(""));
    }

    double getFitnessLevel(){ return fitnessLevel; }
    int getId(){
        return id;
    }
    String getGeneticMkupString(){
        return geneticMkup;
    }
    LinkedList<String> getGeneticMkupList(){
        return geneticMkupList;
    }

}
