package Jeu;

//pour utiliser une lsite
import java.util.ArrayList;

public class Paquet {
	//cree une lsite qui contient les carreaux
	private static ArrayList<Carreaux> myPaquet = new ArrayList<Carreaux>(); 
	//carreaux place sur le mur
	private static int place =0;
	
	//constructeur du paquet de carreaux
	Paquet(){

		myPaquet.add(new Carreaux(1,1,0,'a'));
		
		myPaquet.add(new Carreaux(1,2,0,'b'));
		
		myPaquet.add(new Carreaux(2,1,0,'c'));
		
		myPaquet.add(new Carreaux(2,2,0,'d'));
		
		myPaquet.add(new Carreaux(1,3,0,'e'));
		
		myPaquet.add(new Carreaux(3,1,0,'f'));
		
		myPaquet.add(new Carreaux(2,3,0,'g'));
		
		myPaquet.add(new Carreaux(3,2,0,'h'));
		
		myPaquet.add(new Carreaux(3,3,0,'i'));
		
		myPaquet.add(new Carreaux(1,1,1,'A'));
		
		myPaquet.add(new Carreaux(1,2,1,'B'));
		
		myPaquet.add(new Carreaux(2,1,1,'C'));
		
		myPaquet.add(new Carreaux(2,2,1,'D'));
		
		myPaquet.add(new Carreaux(1,3,1,'E'));
		
		myPaquet.add(new Carreaux(3,1,1,'F'));
	
		myPaquet.add(new Carreaux(2,3,1,'G'));
		
		myPaquet.add(new Carreaux(3,2,1,'H'));
		
		myPaquet.add(new Carreaux(3,3,1,'I'));
		
	}
	
	//renvoie si tous les carreaux sont poses ou pas
	public static boolean isEmpty() {
		if(!myPaquet.isEmpty())
			return true;
		else
			return false;
	}
	
	//cherche le carreaux a poser et le retire
	public static void compare(char c , int a , int o) {
		for(int i=0; i < myPaquet.size();i++) {
			if(myPaquet.get(i).find(c)) {
				myPaquet.get(i).algo(a,o);
				myPaquet.remove(myPaquet.get(i));
			}
		}
		place++;
	}

	//affiche les carreaux que l'on peut poser
	public void ToString() {
		for(int j=Carreaux.getH(); j>=0;j--) {
			for(int i=0; i < myPaquet.size();i++) 
				myPaquet.get(i).select(j);
			System.out.println("");
			
		}	
	}

	//renvoie si l'on peut poser le carreau ou pas
	public static boolean condition(char c, int a, int o) {
		int actual = 0;
		for(int i=0; i < myPaquet.size();i++) {
			myPaquet.get(i);
			if(myPaquet.get(i).find(c))
				actual=i;
		}
		
		if(myPaquet.get(actual).conditions(c,a,o))
			return true;
		else
			return false;
	}
	
	//renvoie le nb de carreaux place
	public static int getPlace() {
		return 33-place;
	}
}
