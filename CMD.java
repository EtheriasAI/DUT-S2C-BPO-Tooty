package Jeu;

//pour enregistrer des entrees
import java.util.Scanner; 

public class CMD {

	private static String motUti="initialisation";
	//abscisse de lemplacement d'un carreaux
	private static int a;
	//ordonnee de lemplacement d'un carreaux
	private static int o;
	private static Scanner sc;
	//carte mise de cote
	private static int surCote=0;
	
	public static void entree() {
		//entre de la lettre/commande
		sc = new Scanner(System.in);
		motUti = sc.next();
		
		if(motUti.equals("stop"))
			stop();
		//passe le tour
		if(motUti.equals("next")) 
			next();
		else {
			a=sc.nextInt();
			o=sc.nextInt();
			//verifie que les conditions de pose sont respectees
			if(Paquet.condition(motUti.charAt(0) , a , o)) 
				Paquet.compare(motUti.charAt(0) , a , o);	
			else {
				System.out.println("Vous vous êtes trompe lors de la saisie.");
				entree();
			}
		}
	}
	
	//renvoie qi le jeu est fini ou pas
	public static boolean stop() {
		if(motUti.equals("stop"))
			return true;
		return false;
	}
	
	//surCote + 1 pour le nb de carte sur le cote
	public static void next() {
		surCote++;
	}
	
	//renvoie le nb de carte sur le cote
	public static int getSurCote() {
		return surCote;
	}
}