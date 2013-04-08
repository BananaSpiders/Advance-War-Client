import java.util.ArrayList;


public class Joueur {
	private int ID;
	private String pseudo;

	private int nombreVilles;
	private int nombreQG;
	

	private int nombreBases;
	
	private int argent;
	private ArrayList<Unite> listeUnites;
	
	Joueur(){
		this(0);
	}
	
	
	Joueur(int numero){
		this.ID = numero-1; // correspond a l'index dans l'array liste, 1ier => 0
		
		this.pseudo = "";
		// A FAIRE CORRESPONDRE CARTE ET ATTRIB
		this.nombreVilles = 1;
		this.nombreBases = 1;
		this.nombreQG = 1;
		this.argent = 2000;
		this.listeUnites = new ArrayList<Unite>();
	}
	
	Joueur(String pseudo,int numero){
		this.ID = numero-1;	//OUIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII !
		if(pseudo==null)
			this.pseudo = "";
		this.pseudo = pseudo;
		this.nombreVilles = 1;
		this.nombreBases = 1;
		this.nombreQG = 1;
		this.argent = 2000;
		this.listeUnites = new ArrayList<Unite>();
	}
	
	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	
	public int getNombreVilles() {
		return nombreVilles;
	}

	public void setNombreVilles(int nombreVilles) {
		this.nombreVilles = nombreVilles;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getNombreBases() {
		return nombreBases;
	}

	public void setNombreBases(int nombreBases) {
		this.nombreBases = nombreBases;
	}

	public int getArgent() {
		return argent;
	}

	public void setArgent(int argent) {
		this.argent = argent;
	}

	public ArrayList<Unite> getListeUnites() {
		return listeUnites;
	}

	public void setListeUnites(ArrayList<Unite> listeUnites) {
		this.listeUnites = listeUnites;
	}
	
	public int getNombreQG() {
		return nombreQG;
	}

	public void setNombreQG(int nombreQG) {
		this.nombreQG = nombreQG;
	}
}
