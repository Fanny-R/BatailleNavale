package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import batailleNavale.Boat;
import batailleNavale.Grid;

public class TestFire {

	Grid grid;
	Boat bateau1;
	Boat bateau2;
	
	@Before
	public void setUp() throws Exception {
		grid = new Grid(5,2);
		bateau1 = new Boat("Torpilleur Horizontal", 2, 1);
		
		grid.placeBoat(bateau1,1,1);
	}

	@Test
	public void testSunkingBoat() {
		assertEquals(3, grid.fire(1, 1)); // blah blah enum blah blah
		assertEquals(4, grid.fire(2, 1));
	}
	
	@Test
	public void testFireOutOfTheGrid() {
		assertEquals(0, grid.fire(4, 12));
		assertEquals(0, grid.fire(7, 1));
		assertEquals(0, grid.fire(7, 12));
	}
	
	@Test
	public void testUnreachedBoat() {
		assertEquals(2, grid.fire(3, 1));
		assertEquals(2, grid.fire(4, 2));
	}
	
	@Test
	public void testAlreadyShot() { // j'aurais bien aimé un petit test pareil mais après avoir touché un bateau
		assertEquals(2, grid.fire(3, 1));
		assertEquals(1, grid.fire(3, 1));
	}

}
