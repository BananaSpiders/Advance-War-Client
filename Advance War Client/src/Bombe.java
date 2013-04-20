import javax.swing.ImageIcon;

/*
 *  CLASS MERE POUR LES BOMBES
 */
public class Bombe {
	protected int posX;
	protected int posY;
	protected int portee; // portee de degat 
	protected int duree; // en nombre de tour 
	protected int dureeRestante; // en nombre de tour restant
	protected int degat; // degat
	protected ImageIcon image; // image
	protected int numJoueur; // 0/1/2/3
	
	public Bombe(){
		
	}
	public Bombe(int posX,int posY,int numJoueur){
		this.posX=posX;
		this.posY=posY;
		this.numJoueur=numJoueur;
	}
	
	public int getDureeRestante() {
		return dureeRestante;
	}
	public void setDureeRestante(int dureeRestante) {
		this.dureeRestante = dureeRestante;
	}
	public int getDegat() {
		return degat;
	}
	public void setDegat(int degat) {
		this.degat = degat;
	}
	public int getNumJoueur() {
		return numJoueur;
	}
	public void setNumJoueur(int numJoueur) {
		this.numJoueur = numJoueur;
	}
	public int getPosX() {
		return posX;
	}

	public ImageIcon getImage() {
		return image;
	}

	public void setImage(ImageIcon image) {
		this.image = image;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getPortee() {
		return portee;
	}

	public void setPortee(int portee) {
		this.portee = portee;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	
	
}
