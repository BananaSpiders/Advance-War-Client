
public class Fusilier extends Infanterie {
	
	public Fusilier(int posX,int posY){
		super(posX,posY);
		this.portee=1;
		this.att=3;
	}
	
	@Override
	public String toString(){
		return "Fusiller :\n X: "+this.posX+" Y: "+this.posY;
	}
}
