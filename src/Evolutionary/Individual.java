package Evolutionary;

import java.util.Random;

/**
 * This class is going to create an id, genetic_makeup, and fitness_level for each Individual.
 **/
class Individual {
    private static int idGenerator = 0;
    private String genMak;
    private double fitness = 0.0;
    private int id;
    private Domain mo = new Domain(); 

    /**
     * This constructor is going to call all the methods that will create:
     * 1) id
     * 2) genMak,
     **/
    Individual(String s){
        genMak = s;
        setId();
    }
    Individual(){
        setId();
        setGenMak();
    }
    
    /**
     * create an id
     **/
    private void  setId(){
        id = idGenerator++;
    }
    
    /**
     * create genMak
     **/
    // This method is going to create a random string that is 8 digits long of 0's and 1's.
    private void setGenMak(){
        String s = "";
        Random x = new Random();
        for(int i=0 ; i < Domain.getBitLength() ; i++){
            float y = x.nextFloat();
            if(y > 0.5){
                s = s + "0";
            }
            else{
                s = s + "1";
            }
        }
        genMak = s;
    }
    
 // This is going to randomly flip one bit if it is chosen to be mutated
    public void flipBit(){
        Random charles = new Random();
        int pos = charles.nextInt() * Domain.getBitLength();
        String second = "0";
        if (genMak.substring(pos,pos).equals("0")){
            second = "1";
        }else {
            second = "0";
        }
        String first = genMak.substring(0, pos - 1);
        String third = genMak.substring(pos + 1);
        genMak = first + second + third;
    }
    
    /**
     * create a fitness level
     **/
    private void setFitness(double d){
        fitness = d;
    }

    /**
     * getFitness return
     */
    double getFitness(){
        return fitness;

    }
    int getId(){
        return id;
    }
    String getGenMak(){
        return genMak;
    }

}
