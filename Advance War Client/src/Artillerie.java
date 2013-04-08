
public class Artillerie extends Vehicule {

	public Artillerie(int posX,int posY) {
		super(posX,posY);
		this.ptsMvt=5;
		this.deplacementRestant = 5;
		this.def=2;
		this.portee=8;
		this.att=8;	
	}
}
