package Evolutionary;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mohammad on 11/2/17.
 */
public class DomainTest {
	double epsilon = 0.000000001;
    Domain d = new Domain();

    @Test
    public void computeFitness() throws Exception {

    }
    
<<<<<<< HEAD
=======
 

>>>>>>> Mo
	@Test
	public void testInitializeDomain() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetBitLength() {
		d.initializeDomain(8,10000,2,5,0.002,0.001);
		assertEquals(d.getBitLength(),8);
	}

	// Todo: fix test popSize
	@Test
	public void testGetPopSize() {
		d.initializeDomain(8,10000,2,5,0.002,0.001);
		assertEquals(d.getPopSize(),10000);
	}

	@Test
	public void testGetCrossNum() {
		d.initializeDomain(8,10000,2,5,0.002,0.001);
		assertEquals(d.getCrossNum(),2);
	}

	@Test
	public void testGetGenNum() {
		d.initializeDomain(8,10000,2,5,0.002,0.001);
		assertEquals(d.getGenNum(),5);
	}

	@Test
	public void testGetSurRatio() {
		d.initializeDomain(8,10000,2,5,0.002,0.001);
		assertEquals(d.getSurRatio(),0.002);
	}

	@Test
	public void testGetMutationRate() {
		d.initializeDomain(8,10000,2,5,0.002,0.001);
		assertEquals(d.getMutationRate(),0.001);
	}


}