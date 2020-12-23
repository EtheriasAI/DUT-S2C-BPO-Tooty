package Jeu;

//pour utiliser une lsite
import java.util.ArrayList;
//pour melanger la liste
import java.util.Collections;

public class Pile {
		//nb de carte consigne bleues et rouges
		private static final int maj=9;
		private static final int mini=9;
		//nb de carte consigne des tailles
		private static final int t1=5;
		private static final int t2=5;
		private static final int t3=5;
		//liste qui contient les cartes consignes
		public static ArrayList<String> myConsigne = new ArrayList<String>(); //ATTENTION!!!! METTRE EN PRIVATE
		
		public Pile(){
			
			//on entre les cartes consignes dans la liste
			for(int i=0; i<maj; ++i)
				myConsigne.add("Choisir une carte majuscule"); 
			for(int i=0; i<mini; ++i)
		        myConsigne.add("Choisir une carte minuscule"); 
			for(int i=0; i<t1; ++i)
		        myConsigne.add("Choisir une carte de taille 1"); 
			for(int i=0; i<t2; ++i)
		        myConsigne.add("Choisir une carte de taille 2"); 
			for(int i=0; i<t3; ++i)
		        myConsigne.add("Choisir une carte de taille 3");
			//on melange la liste
			Collections.shuffle(myConsigne);
		        
		}
		
		//renvoie si la liste est vide ou pas
		public boolean isEmpty() {
			if(!myConsigne.isEmpty())
				return true;
			else
				return false;
		}
		
		//affiche une carte
		public void tirer () { 
			if (!myConsigne.isEmpty()) {
				System.out.println(myConsigne.get(0));
				
			}
	
		} 
		
		//retire la carte du paquet
		public void finTirage() {
			if (!myConsigne.isEmpty())
				myConsigne.remove(0);
		}
		
}
