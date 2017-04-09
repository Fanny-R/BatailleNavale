package batailleNavale;

import java.util.Scanner;

public class Game
{

	public static int length; // <--- ça, c'est ni plus ni moins une variable globale
	// à éviter comme la peste
	// alternatives :
	//	constante globale (public static final int),
	//	variable statique privée (private static int),
	//  à la limite, un espèce de singleton (private static int + des setters qui vérifient qu'on fait pas n'importe quoi, et même comme ça c'est un peu sale)
	// 
	// dans votre cas, vous pouviez gérer ça dans le constructeur par défaut de Game, et en faire des attributs non statiques
	public static int width;
	public static Grid grid;
	
	public static void main(String[] args)
	{
		Boat boat = null;
		int x;
		int y;		
		boolean ok = false;
		int nbOfBoats = 0;
		int selectedBoat = 0;
		Scanner s;
		s = new Scanner(System.in);
		
		// j'ai comme l'impression que votre fichier n'est pas en utf-8
		System.out.println("Indiquez la longueur de grille souhait�e : ");
		length = s.nextInt();
		
		System.out.println("Indiquez la largeur de grille souhait�e : ");
		width = s.nextInt();
		
		grid = new Grid(length, width);
		
		do {
			do {
				System.out.println("Quel type de bateau souhaitez-vous placer ? \n "
						+ "1 : Torpilleur Horizontal\n 2 : Torpilleur Vertical \n "
						+ "3 : Croiseur Horizontal \n 4 : Croiseur Vertical\n "
						+ "5 : Porte-Avion Horizontal\n 6 : Porte-Avion Vertical");
				selectedBoat = s.nextInt();
			} while  (selectedBoat < 1 ||  selectedBoat > 6); //vous faites la vérification ici et plus bas
			
			switch(selectedBoat) {
				case 1 :
					boat = new Boat("Torpilleur Horizontal", 2, 1);
					break;
				case 2 :
					boat = new Boat("Torpilleur Vertical", 1, 2);
					break;
				case 3 :
					boat = new Boat("Croiseur Horizontal", 4, 1);
					break;
				case 4 :
					boat = new Boat("Croiseur Vertical", 1, 4);
					break;
				case 5 :
					boat = new Boat("Porte-Avion Horizontal", 5, 1);
					break;
				case 6 :
					boat = new Boat("Porte-Avion Vertical", 1, 5);
					break;
				default :
					System.out.println("Si ceci s'affiche, je mange mon chapeau");
			}
			
			//TODO : g�rer plus proprement les diff�rents types de bateaux ? // <-- oui 
			
			
			do {
				System.out.println("Veuillez entrer les coordonn�es du coin inf�rieur gauche du bateau : ");
				System.out.print("x : ");
				x = s.nextInt();
				System.out.print("y : ");
				y = s.nextInt();
				
				s.nextLine();
				ok = grid.placeBoat(boat, x, y);
				if(ok == false) {
					System.out.println("Impossible de placer le bateau � cet endroit !");
				}else{
					System.out.println("Bateau plac� ! :-)");
				}
			} while (ok == false);
			
			nbOfBoats++;

			System.out.println("Voulez-vous ajouter un bateau ? o/n : ");
		
		} while (!s.nextLine().equalsIgnoreCase("n")); // ha, c'est pour ça que quand j'ai répondu "dinosaure", le système a pris ça pour un oui. Très bien. Dans l'absolu, ce serait un comportement correct et qui respecte les standards si vous écriviez "[O/n]" à la place de "[o/n]" (pour indiquer la valeur par défaut)
		
		System.out.println("C'est la guerre ! \n");
		
		do {
			System.out.println("Indiquez les coordonn�es de la case cible :");
			System.out.println("x : ");
			x = s.nextInt();
			System.out.println("y : ");
			y = s.nextInt();
			
			if(grid.fire(x, y) == 4) { // c'est là qu'on voit l'intérêt de l'enum au lieu des ints : 4 n'a aucune sémantique, BOAT_SUNK si.
				nbOfBoats--;
			}
			
		} while (nbOfBoats > 0);
		
		System.out.println("Bravo, vous avez coul� tous les bateaux ! :-D");
		
		s.close();
	}

}
