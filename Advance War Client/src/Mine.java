import javax.swing.ImageIcon;


public class Mine extends Bombe{
	
	public Mine(){
		super();
	}
	public Mine(int posX,int posY,int numJoueur){
		super(posX,posY,numJoueur);
		this.duree =3;
		this.portee = 1;
		this.degat = 3;
		this.image= new ImageIcon(this.getClass().getResource("mine.png"));
		this.dureeRestante = this.duree;
	}
}
