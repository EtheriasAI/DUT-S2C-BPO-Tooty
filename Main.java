package Jeu;

/**
 * @author Justine Barthelme 111
 * @author Fahim Gharsa 107
 * @deprecated projet BPO
 */

public class Main {
	
public static void main(String[] args) {
		
		//cree un mur
		Jeu t = new Jeu();
		//cree la pile de cartes consignes		
		Pile p = new Pile();
		//cree le paquet de carreaux
		Paquet pc = new Paquet();
		
		/* Tant que :
		 * la pile de cartes consignes n est pas vide
		 * le paquet de carreaux n est pas vide
		 * la commande stop n a pas été entree.
		 */
		while(p.isEmpty() &&  Paquet.isEmpty() && !CMD.stop() ) {	
			
				t.ToString();
				p.tirer();
				pc.ToString();
				CMD.entree();
				p.finTirage();
				
		}
		//variable locale qui prend en compte le score
		int score = (Jeu.getNiveau()*5)-CMD.getSurCote()-Paquet.getPlace();
		System.out.print("votre score est de ");
		//le score doit etre >0
		if(score<0)
			System.out.print("0");
		else
			System.out.print(score);
	}	
}