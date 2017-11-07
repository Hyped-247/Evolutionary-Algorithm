package Evolutionary;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mohammad on 11/2/17.
 */
public class MainTest {

  @Test
  public void testReproduce() {
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
      Array<Individual> ai = reproduce(indi1, indi2); //children of the two Individuals
      String h1i1 = indi1.getGenMak().substring(0,4); //first half of the first parent's makeup
      String h2i1 = indi1.getGenMak().substring(4,String.length(indi1.getGenMak())); //second half of the first parent's makeup
      String h1i2 = indi2.getGenMak().substring(0,4); //first half of the second parent's makeup
      String h2i2 = indi2.getGenMak().substring(4,String.length(indi2.getGenMak())); //second half of the second parent's makeup
      String h1i1h2i2 = String.append(h1i1, h2i2); //splicing
      String h1i2h2i1 = String.append(h1i2, h2i1); //splicing
      assertEquals(String.length(ai[0].getGenMak()), String.length(indi1.getGenMak()));
      //test that the first child's makeup is the same length as the parents'
      assertEquals(String.length(ai[1].getGenMak()), String.length(indi2.getGenMak()));
      //test that the second child's makeup is the same length as the parents'
      assertEquals(ai.length(), 2);
      //test that there are 2 children
      assertEquals(ai[0].getGenMak(), h1i1h2i2);
      //OPTIONAL: test that the first child's makeup equals the splicing of the
      //first half of the first parent and the second half of the second parent
      //These tests are subject to change, depending on how you want splicing to actually work
      assertEquals(ai[1].getGenMak(), h1i2h2i1);
      //OPTIONAL: test that the second child's makeup equals the splicing of the
      //first half of the second parent and the second half of the first parent
    }
  }



}
