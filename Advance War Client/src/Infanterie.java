
public abstract class Infanterie extends Unite{

	public Infanterie(int posX,int posY){
		super(posX,posY);
		this.ptsMvt=3;
		this.deplacementRestant = 3;
		this.def=1;
		this.accidente=true;
		
	}

}
