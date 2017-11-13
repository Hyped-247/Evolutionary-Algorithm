package Evolutionary;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;

public class IndividualTest {
	
	Individual i = new Individual();
	Domain d = new Domain();
	String genCode = "01100001";
	Individual j = new Individual(genCode);
	
	double EPSILON = 0.000000001;
	
	//no test for constructor. Everything the constructor does is tested in the getters

	@Test
	public void testGetFitness_level() {
		assertEquals(i.getFitness_level(), d.computeFitness(i),EPSILON);
		
	}

	@Test
	/**
     * Tests getID() by making sure that it returns the correct int for ID num
     * @throws Exception
     */
	public void testGetIndividual_id() {
	
	    	ArrayList<Individual> iList = new ArrayList<Individual>();
	    	for(int i = 0; i < 500; i++){
	    		iList.add(new Individual());
	    		assertEquals(i, iList.get(i).getID());
	    		
	    	}
	    	
	    	

	}

	@Test
	public void testGetGenetic_makeup_string() {
		assertTrue(i.getGenetic_makeup_string() instanceof String);
		assertTrue(i.getGenetic_makeup_string().length() == 8);
		assertTrue(j.getGenetic_makeup_string() == genCode);
	}

	

}
