import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class JPanelDraw extends JPanel implements MouseListener,MouseMotionListener{
	public String[][] tabInitialise;
	private EditeurMap owner;
	
	public JPanelDraw(){
		super();
		this.tabInitialise = new String[30][20];
		this.addMouseListener(this);
		// initialise
		for(int i=0;i<this.tabInitialise.length;i++){
			for(int j=0; j<this.tabInitialise[0].length;j++){
				this.tabInitialise[i][j]="vide";
			}
		}
	}
	public JPanelDraw(EditeurMap owner){
		super();
		this.owner=owner;
		this.tabInitialise = new String[20][30];
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		// initialise
		for(int i=0;i<this.tabInitialise.length;i++){
			for(int j=0; j<this.tabInitialise[0].length;j++){
				this.tabInitialise[i][j]="0_HERBE";
			}
		}
	}
	///////////////// PAINT ////////////////////////
	@Override
	public void paint(Graphics g){
		Graphics2D g2d=(Graphics2D) g;
		dessineTab(g2d);
	}
	/////////////////// DESSINER TAB ///////////////////////////
	public void dessineTab(Graphics2D g2d){
		g2d.setColor(Color.WHITE);
		g2d.fillRect(0,0,901,601);
		g2d.setColor(Color.BLACK);
		for(int i=0;i<this.tabInitialise.length;i++){
			for(int j=0; j<this.tabInitialise[0].length;j++){
				String[] sTabTypeCase = this.tabInitialise[i][j].split("_");
				String sTypeCase;
				
				String sAppartient;
				if(sTabTypeCase.length > 1){
					sTypeCase = sTabTypeCase[1].toUpperCase();
					sAppartient = sTabTypeCase[0];
					if(sTabTypeCase.length == 3)
						sTypeCase=sTypeCase+"_"+sTabTypeCase[2].toUpperCase();
				}
				else{
					sTypeCase = sTabTypeCase[0].toUpperCase();
					sAppartient = ""+0;
				}
				
				if(sTypeCase.equals("VIDE"))
					g2d.drawRect(j*30, i*30, 30, 30);
				else if(sTypeCase.equals("HERBE")){
					g2d.drawImage(new ImageIcon(this.getClass().getResource("herbe.jpg")).getImage(),j*30, i*30,null);
				}
				else if(sTypeCase.equals("EAU")){
					g2d.drawImage(new ImageIcon(this.getClass().getResource("eau.jpg")).getImage(),j*30, i*30,null);
				}
				else if(sTypeCase.equals("ROUTEGD")){
					g2d.drawImage(new ImageIcon(this.getClass().getResource("routeGD.jpg")).getImage(),j*30, i*30,null);
				}
				else if(sTypeCase.equals("ROUTEHB")){
					g2d.drawImage(new ImageIcon(this.getClass().getResource("routeHB.jpg")).getImage(),j*30, i*30,null);
				}
				else if(sTypeCase.equals("ROUTEGB")){
					g2d.drawImage(new ImageIcon(this.getClass().getResource("routeGB.jpg")).getImage(),j*30, i*30,null);
				}	
				else if(sTypeCase.equals("ROUTEGH")){
					g2d.drawImage(new ImageIcon(this.getClass().getResource("routeGH.jpg")).getImage(),j*30, i*30,null);
				}	
				else if(sTypeCase.equals("ROUTEHD")){
					g2d.drawImage(new ImageIcon(this.getClass().getResource("routeHD.jpg")).getImage(),j*30, i*30,null);
				}	
				else if(sTypeCase.equals("ROUTEDB")){
					g2d.drawImage(new ImageIcon(this.getClass().getResource("routeDB.jpg")).getImage(),j*30, i*30,null);
				}
				else if(sTypeCase.equals("SAPIN1")){
					g2d.drawImage(new ImageIcon(this.getClass().getResource("sapin1.jpg")).getImage(),j*30, i*30,null);
				}
				else if(sTypeCase.equals("SAPIN2")){
					g2d.drawImage(new ImageIcon(this.getClass().getResource("sapin2.jpg")).getImage(),j*30, i*30,null);
				}
				else if(sTypeCase.equals("BAT_BASE")){
					g2d.drawImage(new ImageIcon(this.getClass().getResource(sAppartient+"_bat_base.jpg")).getImage(),j*30, i*30,null);
				}
				else if(sTypeCase.equals("BAT_QG")){
					System.out.println(sAppartient+"bat_qg.jpg");
					g2d.drawImage(new ImageIcon(this.getClass().getResource(sAppartient+"_bat_qg.jpg")).getImage(),j*30, i*30,null);
				}
				else if(sTypeCase.equals("BAT_VILLE")){
					g2d.drawImage(new ImageIcon(this.getClass().getResource(sAppartient+"_bat_ville.jpg")).getImage(),j*30, i*30,null);
				}
				else{
					g2d.drawRect(j*30, i*30, 30, 30);System.out.println(sTypeCase);
				}
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		int x=arg0.getX();
		int y=arg0.getY();
		
		this.tabInitialise[y/30][x/30]=this.owner.getTextField2()+"_"+this.owner.getTextField()+"";
		this.repaint();
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		int x=e.getX();
		int y=e.getY();
		if(x/30 >=0 && y/30 >=0 && x/30 < this.tabInitialise[0].length && y/30 < this.tabInitialise.length ){
			this.tabInitialise[y/30][x/30]=this.owner.getTextField2()+"_"+this.owner.getTextField()+"";
			this.repaint();
		}
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
