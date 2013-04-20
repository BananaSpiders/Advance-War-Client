
public class Tank extends Vehicule{

	public Tank(int posX,int posY) {
		super(posX,posY);
		this.ptsMvt=3;
		this.deplacementRestant = 3;
		this.def=4;
		this.portee=3;
		this.att=6;
		this.bombe=false;
	}
}
