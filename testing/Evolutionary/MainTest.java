package Evolutionary;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;
import java.lang.reflect.Array;

import static org.junit.Assert.*;

/**
 * Created by mohammad on 11/2/17.
 */
public class MainTest {


  @Test
  public void testWhoLives(){
    Random rand = new Random();
    for (int k=0; k<100; k++) {
      int i = rand.nextInt(1000);
      ArrayList<Individual> population = Main.createInitPop(i);
      ArrayList<Individual> survivors = Main.whoLives(population);
      assertEquals(survivors.size(), 0.2*population.size());
    }
  }


  @Test
  public void testReproduce() {
    Random rand = new Random();
    for (int i=0; i<100; i++) {
      String bitString = new String ((String.valueOf(rand.nextInt(2))) +
                                     (String.valueOf(rand.nextInt(2))) +
                                     (String.valueOf(rand.nextInt(2))) +
                                     (String.valueOf(rand.nextInt(2))) +
                                     (String.valueOf(rand.nextInt(2))) +
                                     (String.valueOf(rand.nextInt(2))) +
                                     (String.valueOf(rand.nextInt(2))) +
                                     (String.valueOf(rand.nextInt(2))));
      //bitString for the first Individual
      String bitString2 = new String ((String.valueOf(rand.nextInt(2))) +
                                     (String.valueOf(rand.nextInt(2))) +
                                     (String.valueOf(rand.nextInt(2))) +
                                     (String.valueOf(rand.nextInt(2))) +
                                     (String.valueOf(rand.nextInt(2))) +
                                     (String.valueOf(rand.nextInt(2))) +
                                     (String.valueOf(rand.nextInt(2))) +
                                     (String.valueOf(rand.nextInt(2))));
      //bitString for the second Individual
      Individual indi1 = new Individual(bitString); //first Individual
      Individual indi2 = new Individual(bitString2); //second Individual
      ArrayList<Individual> ai = Main.reproduce(indi1, indi2); //children of the two Individuals
      assertEquals(String.length(ai[0].getGenMak()), String.length(indi1.getGenMak()));
      //test that the first child's makeup is the same length as the parents'
      assertEquals(String.length(ai[1].getGenMak()), String.length(indi2.getGenMak()));
      //test that the second child's makeup is the same length as the parents'
      assertEquals(ai.length, 2);
      //test that there are 2 children
    }
  }

  @Test
  public void testCreateInitPop() {
    Random rand = new Random();
    for (int i=0; i<100; i++) {
      int i = rand.nextInt(1000);
      ArrayList<Individual> population = Main.createInitPop(i);
      assertEquals(population.length, i);
    }
  }



}
