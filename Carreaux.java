package Jeu;

public class Carreaux {
	///hauiteur maximale
	private static final int HMAX=3;
	private int h;
	private int l;
	private int m;
	private char lettre;
	
	/*
	 * constructeur de carreaux
	 * prend les parametres de
	 * largeur
	 * hauteur
	 * couleur
	 * lettre
	 */
	Carreaux(int lt, int ht, int mt, char letter) {
		this.l=lt;
		this.h=ht;
		this.m=mt;
		this.lettre=letter;
		
	}
	
	/*
	 * cherche les carreaux qui respecte la carte consigne
	 * pour les afficher
	 */
	public void select(int j) {
		if(Pile.myConsigne.get(0)=="Choisir une carte majuscule")
			if(m==1)
				ToString(j);
		if(Pile.myConsigne.get(0)=="Choisir une carte minuscule")
			if(m==0)
				ToString(j);
		if(Pile.myConsigne.get(0)=="Choisir une carte de taille 1")
			if(h == 1 || l == 1)
				ToString(j);
		if(Pile.myConsigne.get(0)=="Choisir une carte de taille 2")
			if(h == 2 || l == 2)
				ToString(j);
		if(Pile.myConsigne.get(0)=="Choisir une carte de taille 3")
			if(h == 3 || l == 3)
				ToString(j);
		
	}
	
	//affiche les carreaux
	public void ToString(int a) {
		System.out.print(" ");
		for(int j=0; j < l ; j++){
			if(a<h)
				System.out.print(lettre+" ");
			else
				System.out.print("  ");
		}
	}
	
	//ajoute le carreau au mur
	public void algo(int a, int o) {
		
		if(Jeu.L<o+h+1) {
			
			int b = Jeu.L;
			
			char [][] t = new char[Jeu.L][Jeu.getMaxCl()];
			for(int i=0; i< Jeu.L ; i++)
				for(int j=0; j<Jeu.getMaxCl() ;j++) 
					t[i][j] = Jeu.tab[i][j];
			
			Jeu.L=o+h+1;
			Jeu.tab = new char[Jeu.L][Jeu.getMaxCl()];
			
			for(int i=0; i< b ; i++)
				for(int j=0; j<Jeu.getMaxCl() ;j++) 
					 Jeu.tab[i][j] = t[i][j];
			
			}
			
			for(int i=0; i<h;i++) 
				for(int j=0; j<l;j++)
					Jeu.tab[o+i][a+j]=lettre;
				
	}

	//renvoie la hauteur maximale
	public static int getH() {
		return HMAX;
	}

	//renvoie si la lettre correspond a un carreau
	public boolean find(char c) {
		if(lettre==c)
			return true;
		return false;
	}

	//renvoie si le carreau respecte les conditions ou pas
	public boolean conditions(char c, int a, int o) {
	
		char x;
		char y;
		char z;
		
		x=Jeu.tab[o-1][a];
		y=Jeu.tab[o][a-1];
		
		char d = ' ';
		char t = ' ';
		
		for(int i=0; i<l-1;i++)	{
			if(Jeu.tab[o-1][a+i-1] == ' ') 
				if(o>2)
					return false;
		}
		
		try{
			z=Jeu.tab[o][a+l];
			if(a+l<Jeu.getMaxCl()) 
				if(Jeu.tab[o][a+l] == z && Jeu.tab[o+h-1][a+l] == z && z!= ' ')
						if(Jeu.tab[o-1][a+l] != z && Jeu.tab[o+h][a+l] != z)
						return false;
		}catch(Exception e) {}
		
		try{
			if(Jeu.tab[o][a-1] == y && Jeu.tab[o+h-1][a-1] == y && y != ' ') 
			if(Jeu.tab[o-1][a-1] != y && Jeu.tab[o+h][a-1] != y)		
				return false;
		}catch(Exception e) {}
		
		if(a+l-1>Jeu.getMaxCl()) 
			return false;
		if(a<0)
			return false;
		if(o<0)
			return false;
		if(Pile.myConsigne.get(0)=="Choisir une carte majuscule")
			if(m!=1)
				return false;
		if(Pile.myConsigne.get(0)=="Choisir une carte minuscule")
			if(m!=0)
				return false;
		if(Pile.myConsigne.get(0)=="Choisir une carte de taille 1")
			if(h != 1 && l != 1)
				return false;
		if(Pile.myConsigne.get(0)=="Choisir une carte de taille 2")
			if(h != 2 && l != 2)
				return false;
		if(Pile.myConsigne.get(0)=="Choisir une carte de taille 3")
			if(h != 3 && l != 3)
				return false;
		if(a+l<Jeu.getMaxCl()) {
			d=Jeu.tab[o-1][a+l];
			t=Jeu.tab[o][a+l];
		}
		if(Jeu.tab[o-1][a] == x && Jeu.tab[o-1][a+l-1] == x)
			if(Jeu.tab[o-1][a-1] != x && d != x)
				return false;
		if((Jeu.tab[o][a-1] == ' ' && a!=1) && t == ' ')
			return false;
		
		return true;
	}
}