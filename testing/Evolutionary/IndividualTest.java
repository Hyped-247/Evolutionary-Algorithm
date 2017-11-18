package Evolutionary;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class IndividualTest {

	Individual i = new Individual();
	Domain d = new Domain();
	String genCode = "01100001";
	Individual j = new Individual(genCode);

	double EPSILON = 0.000000001;

	//no test for constructor. Everything the constructor does is tested in the getters
	@Before
	public void setUp() throws Exception {
		d.initializeDomain(8,10000,2,5,
				5,0.002,0.001);
	}
	@Test
	public void testGetFitness() {
		assertEquals(i.getFitness(), d.computeFitness(i),EPSILON);
	}

	@Test
	/*
     * Tests getID() by making sure that it returns the correct int for ID num
     * @throws Exception
     */
	public void testGetId() {

	    	ArrayList<Individual> iList = new ArrayList<Individual>();
	    	for(int i = 0; i < 500; i++){
	    		iList.add(new Individual(d));
	    		assertEquals(i, iList.get(i).getId());
	    	}
	}

	@Test
	public void testGetGenMak() {
		assertTrue(i.getGenMak() instanceof String);

		assertTrue(i.getGenMak().length() == 8);
		assertTrue(j.getGenMak() == genCode);
	}
      /*@Test
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
    }*/

		@Test
		public void testSetGenMak() {
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
	      indi.setGenMak(d);
				assertTrue(indi.getGenMak().length() == d.getBitLength()); //check length of genMak
				assertTrue(indi.getGenMak() != bitString); //check that genMak has actually changed
	    }
		}

		@Test
		public void testFlipBit() {
			Individual unflipped = new Individual(d);
			Individual flipped = new Individual(unflipped.getGenMak());
			flipped.flipBit(d);
			assertTrue(flipped.getGenMak() != unflipped.getGenMak());
		}
}
