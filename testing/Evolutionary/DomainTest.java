package Evolutionary;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mohammad on 11/2/17.
 */
public class DomainTest {
	double epsilon = 0.000000001;
    @Test
    public void computeFitness() throws Exception {

    }
    
    
    

	@Test

	@Test
	public void testInitializeDomain() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetBitLength() {
		Domain d = new Domain();
		d.initializeDomain(8,10000,2,5,0.002,0.001);
		assertEquals(d.getBitLength(),8);
	}

	@Test
	public void testGetPopSize() {
		Domain d = new Domain();
		d.initializeDomain(8,10000,2,5,0.002,0.001);
		assertEquals(d.getPopSize(),1000);
	}

	@Test
	public void testGetCrossNum() {
		Domain d = new Domain();
		d.initializeDomain(8,10000,2,5,0.002,0.001);
		assertEquals(d.getCrossNum(),2);
	}

	@Test
	public void testGetGenNum() {
		Domain d = new Domain();
		d.initializeDomain(8,10000,2,5,0.002,0.001);
		assertEquals(d.getGenNum(),5);
	}

	@Test
	public void testGetSurRatio() {
		Domain d = new Domain();
		d.initializeDomain(8,10000,2,5,0.002,0.001);
		assertEquals(d.getSurRatio(),0.002);
	}

	@Test
	public void testGetMutationRate() {
		Domain d = new Domain();
		d.initializeDomain(8,10000,2,5,0.002,0.001);
		assertEquals(d.getMutatationRate(),0.001);
	}


}