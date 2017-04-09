package batailleNavale;


// bonne utilisation des générateurs Eclipse ;)
// bons noms de fonctions

public class Boat
{
	private String name;
	private int length;
	private int width;
	private int nbOfActiveCases;
	private boolean isSunk;
	
	public Boat(String name, int length, int width)
	{
		this.name = name;
		this.length = length;
		this.width = width;
		this.nbOfActiveCases = length * width;
		this.isSunk = false;
	}

	public String getName()
	{
		return name;
	}

	public int getLength()
	{
		return length;
	}

	public int getWidth()
	{
		return width;
	}
	
	public int getNbOfActiveCases() {
		return nbOfActiveCases;
	}

	public void setNbOfActiveCases(int cpt) {
		this.nbOfActiveCases = nbOfActiveCases + cpt;
	}

	public void setSunk(boolean isSunk) {
		this.isSunk = isSunk;
	}

	public boolean isSunk()
	{
		return isSunk;
	}

	public void hit(){
		this.setNbOfActiveCases(-1);; 
		if (this.getNbOfActiveCases() == 0){
			this.setSunk(true);
		}
	}
	
}
