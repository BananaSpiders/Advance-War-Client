
public class Bazooka extends Infanterie {

	public Bazooka(int posX,int posY) {
		super(posX,posY);
		this.ptsMvt = 3;
		this.deplacementRestant = 3;
		this.portee=2;
		this.att=7;
	}
}
