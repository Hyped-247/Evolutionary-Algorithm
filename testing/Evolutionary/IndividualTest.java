//package Evolutionary;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import java.util.Random;
//
//import static org.junit.Assert.*;
//
//public class IndividualTest {
//    private Domain domain = new Domain();
//    private Individual individual;
//    private String genMek = "010101";
//
//    @Before
//    public void initialize() throws Exception {
//        domain.initializeDomain(100,10,5,15,20,
//                0.8,0.9);
//        individual = new Individual(domain, genMek);
//    }
//
//
//    @Test
//    public void flipBit() throws Exception {
//
//
//    }
//
//    @Test
//    public void getFitness() throws Exception {
//            assertEquals(String.valueOf(0.5), String.valueOf(individual.getFitness()));
//    }
//
//    @Test
//    public void getId() throws Exception {
//        assertEquals( 1, individual.getId());
//
//      // This is from main
//        /**
//      	ArrayList<Individual> iList = new ArrayList<Individual>();
//	    	for(int i = 0; i < 500; i++){
//	    		iList.add(new Individual(d));
//	    		assertEquals(i, iList.get(i).getId());
//	    	}
//        */
//
//    }
//
//    @Test
//    public void getGenMak() throws Exception {
//        assertEquals(genMek, individual.getGenMak());
//    }
//    /*
//      public void getGenetic_makeup_string() throws Exception {
//      Random rand = new Random();
//      for (int i=0; i<100; i++) {
//        String bitString = (String.valueOf(rand.nextInt(2))) +
//				(String.valueOf(rand.nextInt(2))) +
//				(String.valueOf(rand.nextInt(2))) +
//				(String.valueOf(rand.nextInt(2))) +
//				(String.valueOf(rand.nextInt(2))) +
//				(String.valueOf(rand.nextInt(2))) +
//				(String.valueOf(rand.nextInt(2))) +
//				(String.valueOf(rand.nextInt(2)));
//        Individual indi = new Individual(bitString);
//        assertEquals(indi.getGenMak(), bitString);
//      }
//
//
//		@Test
//		public void testSetGenMak() {
//			for (int i=0; i<100; i++) {
//	      String bitString = (String.valueOf(rand.nextInt(2))) +
//				(String.valueOf(rand.nextInt(2))) +
//				(String.valueOf(rand.nextInt(2))) +
//				(String.valueOf(rand.nextInt(2))) +
//				(String.valueOf(rand.nextInt(2))) +
//				(String.valueOf(rand.nextInt(2))) +
//				(String.valueOf(rand.nextInt(2))) +
//				(String.valueOf(rand.nextInt(2)));
//	      Individual indi = new Individual(bitString);
//	      indi.setGenMak(d);
//				assertTrue(indi.getGenMak().length() == d.getBitLength()); //check length of genMak
//				assertTrue(indi.getGenMak() != bitString); //check that genMak has actually changed
//	    }
//		}
//    @Test
//		public void testFlipBit() {
//			Individual unflipped = new Individual(d);
//			Individual flipped = new Individual(unflipped.getGenMak());
//			flipped.flipBit(d);
//			assertTrue(flipped.getGenMak() != unflipped.getGenMak());
//		}
//        */
//	/*
//     * Tests getID() by making sure that it returns the correct int for ID num
//     * @throws Exception
//     */
//      /*
//  	 @Test
//     public void testGetId() {
//	    	ArrayList<Individual> iList = new ArrayList<Individual>();
//	    	for(int i = 0; i < 500; i++){
//	    		iList.add(new Individual(d));
//	    		assertEquals(i, iList.get(i).getId());
//	    	}
//	}
//
//}
//
//*/