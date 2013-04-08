import javax.swing.ImageIcon;


public class Cursor {
	
	int posX;
	int posY;
	final ImageIcon img = new ImageIcon(this.getClass().getResource("curseur.png"));

	public Cursor(){}
	
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
	
	public ImageIcon getImg() {
		return img;
	}
}
