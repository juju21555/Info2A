
public class Test{
	public static void main(String[] Args){

		int nombreJoueurs, tailleJeu, poids, x, y, joueuract=0;
		char charCaseProb,charModeTest;
		boolean boolModeTest;
		String p,tc;
		Position pos = null;
		
		System.out.println("Voulez-vous activez le mode test ?");
		charModeTest = Lire.c();
		if (charModeTest == 'O' || charModeTest == 'o')
			boolModeTest = true;
		else
			boolModeTest = false;
		
		
		System.out.println("Entrez la taille du plateau : ");
		do{
			tailleJeu = Lire.i();
		}while (tailleJeu < 1 || tailleJeu > 50);
		
		System.out.println("Combien y-a-t'il de joueurs ?");
		do {
			nombreJoueurs = Lire.i();
		}while(nombreJoueurs < 0);
		
		Joueur[] joueurs = new Joueur[nombreJoueurs];

		for (int i=0;i<nombreJoueurs;i++) {
			System.out.println("Joueur "+(i+1)+", Entrez  votre pseudo : ");
			p = Lire.S();
			joueurs[i] = new Joueur(50,p);
		}
		
		Jeu jeu = new Jeu(tailleJeu,tailleJeu,boolModeTest);
		
		System.out.println(jeu);
		
		do {
			System.out.println("A "+joueurs[joueuract].getPseudo()+" de jouer, crédits : "+joueurs[joueuract].getCredit());
			System.out.println("Lancer une nouvelle particule sur un bord du plateau ( # )\n Coût :");
			poids = Lire.i(); 
			do {
				System.out.println("Choisir une case de départ : ");
				System.out.print("x :");x = Lire.i();
				System.out.print("y :");y = Lire.i();
				if (new Position(x,y).isBord())
					pos = new Position(x,y);
				else
					System.out.println("La particule doit être sur un bord (#)");
					
			} while(!new Position(x,y).isBord());
			jeu.setParticule(joueurs[joueuract].lancerParticule(poids, pos));
			
			System.out.println(jeu);
			jeu.moveParticule();
			System.out.println(jeu);
			if (jeu.getParticule().isBord())
				joueurs[joueuract].addCredit(jeu.getParticule().getPoids());
			System.out.println("Voulez-vous faire une estimation ? (O/N)");
			
			charCaseProb = Lire.c();
			
			if (charCaseProb == 'O' || charCaseProb == 'o') {
				do {
					System.out.println("Case probable: ");
					System.out.print("x :");x = Lire.i();
					System.out.print("y :");y = Lire.i();
					System.out.println("De quel type serait cet obstacle ? (Déviateur -> D, Prison -> P, Téléporteur -> T)");tc = Lire.S();
				} while(!new Position(x,y).isDedans());
				
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
			if (joueuract >= nombreJoueurs )
				joueuract = 0;
			
		} while(jeu.getEnjeu());
		
		System.out.println("Bien joué "+joueurs[joueuract].getPseudo());
			
	}
}
