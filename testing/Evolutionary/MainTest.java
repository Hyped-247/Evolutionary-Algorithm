package Evolutionary;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by mohammad on 11/2/17.
 */
public class MainTest {

    double EPSILON;
    
    /**
     * setUp is the fixture that sets up the variables to be used throughout the test
     */
    @Before
    public void setUp(){
        EPSILON = 0.0002;
        Domain.initializeDomain(8,10000,2,5,5,0.002,0.001);
    }

    /**
     * testWhoLives checks if the size of the survivor population is correct
     */
    @Test
    public void testWhoLives(){
      Random rand = new Random();
      for (int k=0; k<100; k++) {
        int i = rand.nextInt(1000);
        ArrayList<Individual> population = Main.createInitPop(i);
        ArrayList<Individual> survivors = Main.whoLives(population);
        assertEquals(survivors.size(), Math.floor(Domain.getSurRatio()*population.size()) , EPSILON);
      }
    }


//  @Test
//  public void testReproduce1() {
//    Random rand = new Random();
//    for (int i=0; i<100; i++) {
//      String bitString = new String ((String.valueOf(rand.nextInt(2))) +
//                                     (String.valueOf(rand.nextInt(2))) +
//                                     (String.valueOf(rand.nextInt(2))) +
//                                     (String.valueOf(rand.nextInt(2))) +
//                                     (String.valueOf(rand.nextInt(2))) +
//                                     (String.valueOf(rand.nextInt(2))) +
//                                     (String.valueOf(rand.nextInt(2))) +
//                                     (String.valueOf(rand.nextInt(2))));
//      //bitString for the first Individual
//      String bitString2 = new String ((String.valueOf(rand.nextInt(2))) +
//                                     (String.valueOf(rand.nextInt(2))) +
//                                     (String.valueOf(rand.nextInt(2))) +
//                                     (String.valueOf(rand.nextInt(2))) +
//                                     (String.valueOf(rand.nextInt(2))) +
//                                     (String.valueOf(rand.nextInt(2))) +
//                                     (String.valueOf(rand.nextInt(2))) +
//                                     (String.valueOf(rand.nextInt(2))));
//      //bitString for the second Individual
//      Individual indi1 = new Individual(bitString); //first Individual
//      Individual indi2 = new Individual(bitString2); //second Individual
//      ArrayList<Individual> ai = Main.reproduce(indi1, indi2); //children of the two Individuals
//      assertEquals(String.length(ai.get(0).getGenMak()), indi1.getGenMak()).length();
//      //test that the first child's makeup is the same length as the parents'
//      assertEquals(String.length(ai.get(1).getGenMak()), String.length(indi2.getGenMak()));
//      //test that the second child's makeup is the same length as the parents'
//      assertEquals(ai.length, 2);
//      //test that there are 2 children
//    }
//  }
  
  /**
   * testReproduce checks if the length of the kids bit strings are the correct length
   * @throws Exception 
   */
  @Test
  public void testReproduce() throws Exception{
      Individual indi1 = new Individual();
      Individual indi2 = new Individual();
      ArrayList<Individual> kids = Main.reproduce(indi1 , indi2);
      assertEquals(Domain.getBitLength() , kids.get(0).getGenMak().length()); // Checks if kid0 has the correct length genMak
      assertEquals(Domain.getBitLength() , kids.get(1).getGenMak().length()); // Checks if kid1 has the correct length genMak
  }

  /**
   * testCreateInitPop checks if the size of the initial population is correct
   */
  @Test
  public void testCreateInitPop() {
    Random rand = new Random();
    for (int j=0; j<100; j++) {
      int i = rand.nextInt(1000);
      ArrayList<Individual> population = Main.createInitPop(i);
      assertEquals(population.size(), i);
    }
  }
}
