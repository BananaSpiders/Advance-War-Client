import javax.swing.ImageIcon;

/*
 *  Class contenant toutes les images possible ca permet de tout charger une bonne fois pour toute ;)
 * 	<3
 */


public class ImageCase {
	/////////////////////////////////////
	//		Attributs
	/////////////////////////////////////
	/*
	 * base
	 */
	private ImageIcon bat_base_0;
	private ImageIcon bat_base_1;
	private ImageIcon bat_base_2;
	private ImageIcon bat_base_3;
	private ImageIcon bat_base_4;
	/*
	 * Ville
	 */
	private ImageIcon bat_ville_0;
	private ImageIcon bat_ville_1;
	private ImageIcon bat_ville_2;
	private ImageIcon bat_ville_3;
	private ImageIcon bat_ville_4;
	/*
	 * QG
	 */
	private ImageIcon bat_qg_0;
	private ImageIcon bat_qg_1;
	private ImageIcon bat_qg_2;
	private ImageIcon bat_qg_3;
	private ImageIcon bat_qg_4;
	/*
	 * Elementaires
	 */
	private ImageIcon eau;
	private ImageIcon herbe;
	/*
	 *  Routes
	 */
	private ImageIcon routeGQ;
	private ImageIcon routeHB;
	private ImageIcon routeGH;
	private ImageIcon routeGB;
	private ImageIcon routeHD;
	private ImageIcon routeDB;
	/*
	 *  Sapin ;)
	 */
	private ImageIcon sapin1;
	private ImageIcon sapin2;
	
	
	
	
	
	/////////////////////////////////////
	//		Constructeur par defaut
	/////////////////////////////////////
	public ImageCase(){
		
		
		/////////////////////////////////////
		//		Charge les images
		/////////////////////////////////////
		/*
		 * 	Batiments Ville
		 */
		this.bat_ville_0 = new ImageIcon(this.getClass().getResource("0_bat_ville.gif"));
		this.bat_ville_1 = new ImageIcon(this.getClass().getResource("1_bat_ville.gif"));
		this.bat_ville_2 = new ImageIcon(this.getClass().getResource("2_bat_ville.gif"));
		this.bat_ville_3 = new ImageIcon(this.getClass().getResource("3_bat_ville.gif"));
		this.bat_ville_4 = new ImageIcon(this.getClass().getResource("4_bat_ville.gif"));
		/*
		 *  Batiments Base
		 */
		this.bat_base_0 = new ImageIcon(this.getClass().getResource("0_bat_base.gif"));
		this.bat_base_1 = new ImageIcon(this.getClass().getResource("1_bat_base.gif"));
		this.bat_base_2 = new ImageIcon(this.getClass().getResource("2_bat_base.gif"));
		this.bat_base_3 = new ImageIcon(this.getClass().getResource("3_bat_base.gif"));
		this.bat_base_4 = new ImageIcon(this.getClass().getResource("4_bat_base.gif"));
		/*
		 *  Batiments Qg
		 */
		this.bat_base_0 = new ImageIcon(this.getClass().getResource("0_bat_qg.jpg"));
		this.bat_base_1 = new ImageIcon(this.getClass().getResource("1_bat_qg.jpg"));
		this.bat_base_2 = new ImageIcon(this.getClass().getResource("2_bat_qg.jpg"));
		this.bat_base_3 = new ImageIcon(this.getClass().getResource("3_bat_qg.jpg"));
		this.bat_base_4 = new ImageIcon(this.getClass().getResource("4_bat_qg.jpg"));
		/*
		 * Elementaires
		 */
		this.eau = new ImageIcon(this.getClass().getResource("eau.jpg"));
		this.herbe = new ImageIcon(this.getClass().getResource("herbe.jpg"));
		/*
		 *  Routes
		 */
		this.routeGQ = new ImageIcon(this.getClass().getResource("routeGQ.jpg"));
		this.routeHB = new ImageIcon(this.getClass().getResource("routeHB.jpg"));
		this.routeGH = new ImageIcon(this.getClass().getResource("routeGH.jpg"));
		this.routeGB = new ImageIcon(this.getClass().getResource("routeGB.jpg"));
		this.routeHD = new ImageIcon(this.getClass().getResource("routeHD.jpg"));
		this.routeDB = new ImageIcon(this.getClass().getResource("routeDB.jpg"));
	}
	 
	
	
	/////////////////////////////////////////////////
	//		 Getter en fonction des appartenances
	////////////////////////////////////////////////
	/*
	 *  Base
	 */
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
	/*
	 *  Qg
	 */
	public ImageIcon getBat_Qg(int numAppartenance){
		switch(numAppartenance){
		case 0:
			return this.bat_qg_0;
		case 1:
			return this.bat_qg_1;

		case 2:
			return this.bat_qg_2;
		case 3:
			return this.bat_qg_3;
		case 4:
			return this.bat_qg_4;
		default:
			return null;

		}
	}
	/*
	 * Ville
	 */
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
	
	
	
	
	////////////////////////////////////////////////
	// GETTER AND SETTER par defaut 
	///////////////////////////////////////////////
	public ImageIcon getBat_base_0() {
		return bat_base_0;
	}
	public ImageIcon getBat_qg_0() {
		return bat_qg_0;
	}
	public void setBat_qg_0(ImageIcon bat_qg_0) {
		this.bat_qg_0 = bat_qg_0;
	}
	public ImageIcon getBat_qg_1() {
		return bat_qg_1;
	}
	public void setBat_qg_1(ImageIcon bat_qg_1) {
		this.bat_qg_1 = bat_qg_1;
	}
	public ImageIcon getBat_qg_2() {
		return bat_qg_2;
	}
	public void setBat_qg_2(ImageIcon bat_qg_2) {
		this.bat_qg_2 = bat_qg_2;
	}
	public ImageIcon getBat_qg_3() {
		return bat_qg_3;
	}
	public void setBat_qg_3(ImageIcon bat_qg_3) {
		this.bat_qg_3 = bat_qg_3;
	}
	public ImageIcon getBat_qg_4() {
		return bat_qg_4;
	}
	public void setBat_qg_4(ImageIcon bat_qg_4) {
		this.bat_qg_4 = bat_qg_4;
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
	public ImageIcon getEau() {
		return eau;
	}
	public void setEau(ImageIcon eau) {
		this.eau = eau;
	}
	public ImageIcon getHerbe() {
		return herbe;
	}
	public void setHerbe(ImageIcon herbe) {
		this.herbe = herbe;
	}
	public ImageIcon getRouteGQ() {
		return routeGQ;
	}
	public void setRouteGQ(ImageIcon routeGQ) {
		this.routeGQ = routeGQ;
	}
	public ImageIcon getRouteHB() {
		return routeHB;
	}
	public void setRouteHB(ImageIcon routeHB) {
		this.routeHB = routeHB;
	}
	public ImageIcon getRouteGH() {
		return routeGH;
	}
	public void setRouteGH(ImageIcon routeGH) {
		this.routeGH = routeGH;
	}
	public ImageIcon getRouteGB() {
		return routeGB;
	}
	public void setRouteGB(ImageIcon routeGB) {
		this.routeGB = routeGB;
	}
	public ImageIcon getRouteHD() {
		return routeHD;
	}
	public void setRouteHD(ImageIcon routeHD) {
		this.routeHD = routeHD;
	}
	public ImageIcon getRouteDB() {
		return routeDB;
	}
	public void setRouteDB(ImageIcon routeDB) {
		this.routeDB = routeDB;
	}
	public ImageIcon getSapin1() {
		return sapin1;
	}
	public void setSapin1(ImageIcon sapin1) {
		this.sapin1 = sapin1;
	}
	public ImageIcon getSapin2() {
		return sapin2;
	}
	public void setSapin2(ImageIcon sapin2) {
		this.sapin2 = sapin2;
	}
	
}
