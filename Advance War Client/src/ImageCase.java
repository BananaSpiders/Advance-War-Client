import javax.swing.ImageIcon;

/*
 *  Class contenant toutes les images possible ca permet de tout charger une bonne fois pour toute ;)
 * 	<3
 */


public class ImageCase {
	private ImageIcon bat_base_0;
	private ImageIcon bat_base_1;
	private ImageIcon bat_base_2;
	private ImageIcon bat_base_3;
	private ImageIcon bat_base_4;
	
	private ImageIcon bat_ville_0;
	private ImageIcon bat_ville_1;
	private ImageIcon bat_ville_2;
	private ImageIcon bat_ville_3;
	private ImageIcon bat_ville_4;
	
	public ImageCase(){
			
		this.bat_ville_0 = new ImageIcon(this.getClass().getResource("0_bat_ville.gif"));
		this.bat_ville_1 = new ImageIcon(this.getClass().getResource("1_bat_ville.gif"));
		this.bat_ville_2 = new ImageIcon(this.getClass().getResource("2_bat_ville.gif"));
		this.bat_ville_3 = new ImageIcon(this.getClass().getResource("3_bat_ville.gif"));
		this.bat_ville_4 = new ImageIcon(this.getClass().getResource("4_bat_ville.gif"));
		/*this.bat_base_0 = new ImageIcon(this.getClass().getResource("0_bat_base.gif"));
		this.bat_base_1 = new ImageIcon(this.getClass().getResource("1_bat_base.gif"));
		this.bat_base_2 = new ImageIcon(this.getClass().getResource("2_bat_base.gif"));
		this.bat_base_3 = new ImageIcon(this.getClass().getResource("3_bat_base.gif"));
		this.bat_base_4 = new ImageIcon(this.getClass().getResource("4_bat_base.gif"));*/
		
	}
	public ImageIcon getBat_Base(int numAppartenance){
		switch(numAppartenance){
		case 0:
			return this.bat_base_0;
		case 1:
			return this.bat_base_1;

		case 2:
			return this.bat_base_2;
		case 3:
			return this.bat_base_3;
		case 4:
			return this.bat_base_4;
		default:
			return null;

		}
	}
	public ImageIcon getBat_Ville(int numAppartenance){
		switch(numAppartenance){
		case 0:
			return this.bat_ville_0;
		case 1:
			return this.bat_ville_1;

		case 2:
			return this.bat_ville_2;
		case 3:
			return this.bat_ville_3;
		case 4:
			return this.bat_ville_4;
		default:
			return null;

		}
	}
	public ImageIcon getBat_base_0() {
		return bat_base_0;
	}
	public void setBat_base_0(ImageIcon bat_base_0) {
		this.bat_base_0 = bat_base_0;
	}
	public ImageIcon getBat_base_1() {
		return bat_base_1;
	}
	public void setBat_base_1(ImageIcon bat_base_1) {
		this.bat_base_1 = bat_base_1;
	}
	public ImageIcon getBat_base_2() {
		return bat_base_2;
	}
	public void setBat_base_2(ImageIcon bat_base_2) {
		this.bat_base_2 = bat_base_2;
	}
	public ImageIcon getBat_base_3() {
		return bat_base_3;
	}
	public void setBat_base_3(ImageIcon bat_base_3) {
		this.bat_base_3 = bat_base_3;
	}
	public ImageIcon getBat_base_4() {
		return bat_base_4;
	}
	public void setBat_base_4(ImageIcon bat_base_4) {
		this.bat_base_4 = bat_base_4;
	}
	public ImageIcon getBat_ville_0() {
		return bat_ville_0;
	}
	public void setBat_ville_0(ImageIcon bat_ville_0) {
		this.bat_ville_0 = bat_ville_0;
	}
	public ImageIcon getBat_ville_1() {
		return bat_ville_1;
	}
	public void setBat_ville_1(ImageIcon bat_ville_1) {
		this.bat_ville_1 = bat_ville_1;
	}
	public ImageIcon getBat_ville_2() {
		return bat_ville_2;
	}
	public void setBat_ville_2(ImageIcon bat_ville_2) {
		this.bat_ville_2 = bat_ville_2;
	}
	public ImageIcon getBat_ville_3() {
		return bat_ville_3;
	}
	public void setBat_ville_3(ImageIcon bat_ville_3) {
		this.bat_ville_3 = bat_ville_3;
	}
	public ImageIcon getBat_ville_4() {
		return bat_ville_4;
	}
	public void setBat_ville_4(ImageIcon bat_ville_4) {
		this.bat_ville_4 = bat_ville_4;
	}
	
}
