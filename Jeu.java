package Jeu;

//librairie pour utiliser des valeurs aleatoires
import java.util.Random;

public class Jeu {
	//attributs des mesures du mur
	private final static int MAX_CL = 6;
	public static int L = 3;
	//cree le tableau
	public static char[][] tab = new char[L][MAX_CL];
	
	//constructeur de mur + piece neutre
	Jeu(){
		//on va créé une variable n aleatoire
		Random r = new Random();
		//variable locale pour définir la piece neutre
		int n=r.nextInt(4);
	
		//initialisation du mur a vide
		for(int i=0; i<L; i++) {
			for(int j=0; j<MAX_CL; j++) {
					tab[i][j]=' ';
			}
		}
		
		//creation de la piece neutre
		switch(n) {
		
			case 0:
			
				Carreaux x = new Carreaux(3,1,0,'x');
				x.algo(1,1);
				
					break;
		
			case 1:
				
				Carreaux z = new Carreaux(1,3,0,'x');
				z.algo(1,1);
					break;
				
			case 2:
			
				Carreaux y = new Carreaux(1,3,0,'x');
				y.algo(5,1);
				
					break;
			
			case 3:
			
				Carreaux w = new Carreaux(3,1,0,'x');
				w.algo(3,1);
			
					break;	
		}
	}
	
	//affichage du mur
	public void ToString() {
		
		for(int i=L-1; i>=0; i--) {
			
			//afficher les chiffres(sauf 0)
			if(i!=0)
				if(i>9)
					System.out.print(i);
				else
					System.out.print(" "+i);

			else
				System.out.print("  ");
			for(int j=0; j<MAX_CL; j++) {
				if(j!=0)
					tab[0][j]=Character.forDigit(j,10);
				System.out.print(tab[i][j] + " ");
			}
			System.out.println("");
			
		}
	}

	//renvoie la largeur maximale du mur
	public static int getMaxCl() {
		return MAX_CL;
	}
	
	//compte le nombre de niveau reussi
	public static int getNiveau() {
		int nb=1;
		int i=1;
		
		while(tab[nb][i] != ' ') {
			++i;
			++nb;
		}
		--nb;
		return nb;
	}
}