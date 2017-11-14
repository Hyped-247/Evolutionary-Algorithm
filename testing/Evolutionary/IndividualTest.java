package Evolutionary;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Random;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

public class IndividualTest {
	
	private Individual i = new Individual();
	private Domain d = new Domain();
	private String genCode = "01100001";
	private Individual j = new Individual(genCode);
	
	private double EPSILON = 0.000000001;
	
	//no test for constructor. Everything the constructor does is tested in the getters

	@Test
	public void testGetFitness_level() {
		assertEquals(i.getFitness(), d.computeFitness(i),EPSILON);
	}

	@Test
	/*
     * Tests getID() by making sure that it returns the correct int for ID num
     * @throws Exception
     */
	public void testGetIndividual_id() {
	
	    	ArrayList<Individual> iList = new ArrayList<Individual>();
	    	for(int i = 0; i < 500; i++){
	    		iList.add(new Individual());
	    		assertEquals(i, iList.get(i).getId());
	    	}
	}

	@Test
	public void testGetGenetic_makeup_string() {
		assertTrue(i.getGenMak() != null);
		assertTrue(i.getGenMak().length() == 8);
		assertTrue(j.getGenMak() == genCode);
	}
      @Test
    public void getGenetic_makeup_string() throws Exception {
      Random rand = new Random();
      for (int i=0; i<100; i++) {
        String bitString = (String.valueOf(rand.nextInt(2))) +
				(String.valueOf(rand.nextInt(2))) +
				(String.valueOf(rand.nextInt(2))) +
				(String.valueOf(rand.nextInt(2))) +
				(String.valueOf(rand.nextInt(2))) +
				(String.valueOf(rand.nextInt(2))) +
				(String.valueOf(rand.nextInt(2))) +
				(String.valueOf(rand.nextInt(2)));
        Individual indi = new Individual(bitString);
        assertEquals(indi.getGenMak(), bitString);
      }
    }
}
