package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import batailleNavale.Boat;
import batailleNavale.Grid;

public class TestPlaceBateau {

	Grid grid;
	Boat bateau1;
	Boat bateau2;
	
	// rien à redire, c'est une bonne classe de test
	
	@Before
	public void setUp() throws Exception {
		grid = new Grid(10,20);
		bateau1 = new Boat("Torpilleur Horizontal", 2, 1);
		bateau2 = new Boat("Porte-Avion Horizontal", 5, 1);
	}

	@Test
	public void testPlaceBateauDispo() {
		assertEquals(true, grid.placeBoat(bateau1,2,2));
	}
	
	@Test
	public void testPlaceBateauOccupied() {
		assertEquals(true, grid.placeBoat(bateau1,2,2));
		assertEquals(false, grid.placeBoat(bateau2,3,2));
	}
	
	@Test
	public void testPlaceBateauHorsColonne() {
		assertEquals(true, grid.placeBoat(bateau1,2,2));
		assertEquals(false, grid.placeBoat(bateau2,11,20));
	}
	
	@Test
	public void testPlaceBateauHorsLigne() {
		assertEquals(true, grid.placeBoat(bateau1,2,2));
		assertEquals(false, grid.placeBoat(bateau2,10,25));
	}
	
	@Test
	public void testPlaceBateauHorsGrille() {
		assertEquals(true, grid.placeBoat(bateau1,2,2));
		assertEquals(false, grid.placeBoat(bateau2,15,25));
	}

}
