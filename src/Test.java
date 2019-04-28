
public class Test{
	public static void main(String[] Args){

		int nj, s, poids, x, y, joueuract=0;
		char c;
		boolean b;
		String p,tc;
		Position pos = null;
		
		System.out.println("Entrez la taille du plateau : ");
		do{
			s = Lire.i();
		}while (s < 1 || s > 50);
		
		System.out.println("Combien y-a-t'il de joueurs ?");
		do {
			nj = Lire.i();
		}while(nj < 0);
		
		Joueur[] joueurs = new Joueur[nj];
		
		for (int i=0;i<nj;i++) {
			System.out.println("Joueur "+(i+1)+", Entrez  votre pseudo : ");
			p = Lire.S();
			joueurs[i] = new Joueur(50,p);
		}
		
		Jeu jeu = new Jeu(s,s);
		
		System.out.println(jeu);
		
		do {
			System.out.println("A "+joueurs[joueuract].getPseudo()+" de jouer, crédits : "+joueurs[joueuract].getCredit());
			System.out.println("Lancer une nouvelle particule sur un bord du plateau ( # )\n Coût :");
			poids = Lire.i(); 
			do {
				System.out.println("Choisir une case de départ : ");
				System.out.print("x :");x = Lire.i();
				System.out.print("y :");y = Lire.i();
				b = (x == 0 ^ y == 0 ^ x == jeu.getSize()-1 ^ y == jeu.getSize()-1);
				if (b)
					pos = new Position(y,x);
				else
					System.out.println("La particule doit être sur un bord (#), mais pas dans le coin");
					
			} while(!b);
			jeu.setParticule(joueurs[joueuract].lancerParticule(poids, pos, jeu));
			
			System.out.println(jeu);
			jeu.moveParticule();
			System.out.println(jeu);
			if (jeu.getParticule().isBord(jeu.getSize()))
				joueurs[joueuract].addCredit(jeu.getParticule().getPoids());
			System.out.println("Voulez-vous faire une estimation ? (O/N)");
			
			c = Lire.c();
			
			if (c == 'O' || c == 'o') {
				do {
					System.out.println("Case probable: ");
					System.out.print("x :");x = Lire.i();
					System.out.print("y :");y = Lire.i();
					b = (x > 0 && x < jeu.getSize() && y > 0 &&  y < jeu.getSize());
					System.out.println("De quel type serait cet obstacle ? (Déviateur -> D, Prison -> P, Téléporteur -> T)");tc = Lire.S();
				} while(!b);
				
				if (jeu.getPlateau()[y][x] != null && jeu.getPlateau()[y][x].getShow() == false && jeu.getPlateau()[y][x].getName().equals(tc)) {
					jeu.getPlateau()[y][x].setShow(true);
					joueurs[joueuract].addCredit(jeu.getPlateau()[y][x].getPoids());
					System.out.println("Votre estimation est juste "+joueurs[joueuract].getPseudo()+", vous avez été crédité de "+jeu.getPlateau()[y][x].getPoids());
				}
				else {
					System.out.println("Pas de chance ! Il n'y avait rien à cette case, ou elle a déjà été découverte, ou ce n'était pas le bon type");
				}
			}
			
			jeu.refreshEnJeu();
			System.out.println(jeu);
			
			joueuract++;
			if (joueuract >= nj )
				joueuract = 0;
			
		} while(jeu.getEnjeu());
		
		System.out.println("Bien joué "+joueurs[joueuract].getPseudo());
			
	}
}
