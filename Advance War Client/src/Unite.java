
public abstract class Unite{
	protected int posX;
	protected int posY;
	protected int portee;
	protected int ptsMvt;
	protected int deplacementRestant;

	protected int def;
	protected int att;
	protected int pv=10;
	protected boolean accidente;
	
	public Unite(int posX,int posY){
		this.posX = posX;
		this.posY = posY;
	}

	public int getPosX() {
		return posX;
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

	public int getPtsMvt() {
		return ptsMvt;
	}

	public void setPtsMvt(int ptsMvt) {
		this.ptsMvt = ptsMvt;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}

	public int getAtt() {
		return att;
	}

	public void setAtt(int att) {
		this.att = att;
	}

	public int getPv() {
		return pv;
	}

	public void setPv(int pv) {
		this.pv = pv;
	}

	public boolean isAccidente() {
		return accidente;
	}

	public void setAccidente(boolean accidente) {
		this.accidente = accidente;
	}
	
	@Override
	public String toString(){
		return "";
	}
	
	public int getDeplacementRestant() {
		return deplacementRestant;
	}

	public void setDeplacementRestant(int deplacementRestant) {
		this.deplacementRestant = deplacementRestant;
	}
}
