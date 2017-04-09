package batailleNavale;

import java.util.ArrayList;
import java.util.List;

import sun.java2d.pipe.OutlineTextRenderer;

public class Grid
{
	private Case[][] grid;
	// x,y sont à utiliser pour les coordonnées, pas pour les dimensions :
	// à la limite : sizeX, sizeY, mais au mieux : width et height
	private int x;
	private int y;
	private List<Boat> listBoats;

	public Grid(int x, int y)
	{
		this.x = x;
		this.y = y;
		this.grid = new Case[x][y];
		this.listBoats = new ArrayList<Boat>();
		fillGrid();

	}
	
	public boolean placeBoat(Boat bat, int x, int y){
		Case theCase = null;
		String message = " Le bateau est bien positionn� en cases ";
		
		for(int i = 0; i < bat.getLength(); i++) {
			for (int j = 0; j < bat.getWidth(); j++){
				theCase = this.accessCase(x+i, y+j);
				if (theCase == null || theCase.isOccupied()){
					return false;	
				}
			}
		}
		
		for(int i = 0; i < bat.getLength(); i++) {
			for (int j = 0; j < bat.getWidth(); j++){
				this.accessCase(x+i, y+j).setBoat(bat);
				message += "[" + (x+i) + "," + (y+j) + "] ";
			}
		}
			
		this.listBoats.add(bat);
		System.out.println(message + "!\n");
		return true;
		
	}

	private void fillGrid()
	{
		for (int i = 0; i < x; i++)
		{
			for (int j = 0; j < y; j++)
			{
				grid[i][j] = new Case();
			}
		}
	}

 
	public Case accessCase(int x, int y)
	{
		Case theCase;
		
		if(x < 0 || x > this.getX() || y < 0 || y > this.getY()) {
			theCase = null;
			System.out.println("La case n'est pas dans la grille !\n");
		}
		else {
			//pourquoi -1 ? ça provoque une erreur si on essaie d'accéder à la case d'indice 0,
			//alors que votre "if" juste au-dessus vérifiait bien qu'on était dans la grille
			theCase = grid[x-1][y-1]; 
		}

		return theCase;
	}
	
	public int fire(int x, int y){
		Case theCase = this.accessCase(x, y);	
		
		if (theCase == null){
			return 0; // renvoyer un int en fonction de la situation c'est bien, mais renvoyer une Enum c'est mieux
		}else if (theCase.isShot()) {
			System.out.println("Vous avez d�j� tir� i�i !\n");
			return 1;
		} else if (!theCase.isOccupied()){
			System.out.println("Rat� !\n");
			theCase.setShot(true);
			return 2;
		}else{
			System.out.println("Touch� !\n");
			theCase.setShot(true);
			theCase.getBoat().hit();
			if (theCase.getBoat().isSunk()){
				System.out.println("Coul� !\n");
				return 4;
			}
			return 3;
		}
	}

	public int getX()
	{
		return x;
	}

	public int getY()
	{
		return y;
	}

}
