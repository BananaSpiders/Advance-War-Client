
public class Artillerie extends Vehicule {

	public Artillerie(int posX,int posY) {
		super(posX,posY);
		this.ptsMvt=4;
		this.deplacementRestant = 4;
		this.def=2;
		this.portee=6;
		this.att=8;	
		this.bombe=false;
	}
}
