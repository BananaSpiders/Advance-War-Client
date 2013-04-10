
public class Tableau2D {
	
	/*
	 * 
	 *  METHODE STATIC QUI INVERSE UN TABLEAU  LES DONNEES DE LA 1ire dimension vont dans la 2ieme dimension et vis versa
	 * 
	 */
	static Case[][] reverse(Case[][] tabToReverse){
		// on associe i>x j>y
		int tailleI = tabToReverse[0].length;
		int tailleJ = tabToReverse.length;
		Case[][] tabReverse = new Case[tailleI][tailleJ];
		
		for(int i=0; i< tailleI; i++){
			for(int j=0; j< tailleJ; j++){
				tabReverse[i][j] = tabToReverse[j][i];
			}
		}
		
		return tabReverse;
	}
}
