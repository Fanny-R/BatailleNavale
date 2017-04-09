package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import batailleNavale.Grid;

public class TestGrid
{
	Grid grid;
	
    @Before
    public void setUp() {
        grid = new Grid(8,2); // c'est bien d'utiliser @Before, mais du coup vous ne faites aucun test sur la création de la grille
        // typiquement : est-ce que créer une grille 0x0, ou 0x4 fait crash votre programme ? (spoiler : non ça va, mais il faudrait quand même tester)
        // si vous vous dites "ouais mais ça va ça, peut pas mal se passer ça", imaginez que c'est un stagiaire de 3e qui va développer le programme basé sur ces tests. 
    }
    
	@Test
	public void caseInTheGrid()
	{
		assertNotNull(grid.accessCase(5, 1));
	}
	
	@Test
	public void caseInTheGridCorner()
	{
		assertNotNull(grid.accessCase(8, 2));
	}
	
	@Test
	public void caseOutOfTheGrid()
	{
		assertNull(grid.accessCase(15, 1));
	}
	
	@Test
	public void caseOutOfTheColumns()
	{
		assertNull(grid.accessCase(7, 56));
	}
	
	@Test
	public void caseOutOfTheLines()
	{
		assertNull(grid.accessCase(10, 1));
	}

}
