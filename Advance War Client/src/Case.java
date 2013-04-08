import javax.swing.ImageIcon;


public class Case {
	private ImageIcon image;
	private TypeCase typeCase;
	private int x,y;
	private Unite unite;
	private int appartient;//0 neutre, J1 Rouge,J2 Bleu, J3 Vert, J4 Jaune
	
	public Case(){}
	
	public Case(ImageIcon i,int x,int y,TypeCase type,int appartient)
	{
		this.image=i;
		this.x=x;
		this.y=y;
		this.typeCase=type;
		this.appartient = appartient;
	}
	
	public Case(ImageIcon i,int x,int y)
	{
		this.image=i;
		this.x=x;
		this.y=y;
	}
	
	public int getY() {
		return this.y;
	}

	public void setY(int y) {
		this.y = y;
	}

	

	public ImageIcon getImageIcon() {
		return image;
	}

	public void setImageIcon(ImageIcon image) {
		this.image = image;
	}

	public int getX() {
		return this.x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public TypeCase getTypeCase() {
		return typeCase;
	}

	public void setTypeCase(TypeCase typeCase) {
		this.typeCase = typeCase;
	}

	public Unite getUnite() {
		return unite;
	}

	public void setUnite(Unite unite) {
		this.unite = unite;
	}

	public ImageIcon getImage() {
		return image;
	}

	public void setImage(ImageIcon image) {
		this.image = image;
	}

	public int getAppartient() {
		return appartient;
	}

	public void setAppartient(int appartient) {
		this.appartient = appartient;
	}
	
	
}
