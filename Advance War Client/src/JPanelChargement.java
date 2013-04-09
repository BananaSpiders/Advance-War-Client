import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class JPanelChargement extends JPanel {
	private int width;
	private int heigth;
	private int posX;
	private int posY;
	private int posH;
	private int posW;
	public Color couleurCarre;
	private boolean deb;
	public int nbPoint;
	public boolean mapCharge;
	private boolean mapChargePremiere;
	public int posXBalle;
	public int posYBalle;
	public int posWBalle;
	public int posHBalle;
	public int sensBalleY;
	public int sensBalleX;
	public Image maBaballe;
	public boolean serveurIsFind;
	private boolean isServeurFindFirst;
	private ConnectionAuServeur owner;

	public JPanelChargement(int width, int height, ConnectionAuServeur owner){
		super();
		this.width = width+18;
		this.heigth = height;
		this.posX = 10;
		this.posY = this.heigth*2 - 18;
		this.posH = 20;
		this.posW = 100;
		this.couleurCarre = Color.BLACK;
		this.deb = true;
		this.nbPoint=1;
		/*this.paint(getGraphics());*/
		this.mapCharge = false;
		this.mapChargePremiere = true;
		this.isServeurFindFirst = true;
		this.serveurIsFind = true;
		this.posXBalle = (int) ((Math.random()*(230-30))+30);
		this.posYBalle = (int) ((Math.random()*(190-30))+30);
		this.posWBalle = 10;
		this.posHBalle = 10;
		this.sensBalleY = 1;
		this.sensBalleX = 1;
		this.owner = owner;

		this.maBaballe = new ImageIcon(this.getClass().getResource("baballe.gif")).getImage();
	}

	///////////////// PAINT ////////////////////////
	public void paint(Graphics g){

		Graphics2D g2d=(Graphics2D) g;
		if(this.deb == true){
			g2d.setColor(Color.WHITE);
			g2d.fillRect(-500,-500,1000,1000);
			this.deb = false;
		}


		dessinerChargement(g2d);

	}

	public void dessinerChargement(Graphics2D g2d){
		g2d.setColor(this.couleurCarre);

		if(this.mapCharge == false){
			if(this.serveurIsFind == true){
				g2d.fillRect(this.posX,this.posY,this.posW,this.posH);
				g2d.setColor(Color.BLACK);
				g2d.drawString("En attente de connexion..", 50, 80);

				g2d.setColor(Color.WHITE);
				g2d.fillRect(this.posX-2,this.posY,2,this.posH);
				g2d.fillRect(this.posX+this.posW,this.posY,2,this.posH);
			}
			else{
				if(this.isServeurFindFirst == true){
					this.setVisible(false);
					this.setVisible(true);
					g2d.setColor(Color.WHITE);
					g2d.fillRect(-100,-100,900,900);
					g2d.fillRect(-100,-100,900,900);
					g2d.fillRect(-100,-100,900,900);
					this.isServeurFindFirst = false;
					
					 /*this.owner.bntAnnuler.setVisible(true);
					 this.owner.bntAnnuler.addActionListener(this.owner);
					 this.owner.bntRessayer.setVisible(true);
					 this.owner.bntRessayer.addActionListener(this.owner);
					 System.out.println(this.owner.bntAnnuler.isVisible());*/
				}else{
					g2d.setColor(Color.WHITE);
					g2d.fillRect(-500,-500,1000,1000);
					g2d.setColor(Color.BLACK);
					g2d.drawString("Serveur introuvable..", 50, 80);
					
				}

			}

		}
		else{

			if(this.mapChargePremiere == true){
				this.setVisible(false);
				this.setVisible(true);
				g2d.setColor(Color.WHITE);
				g2d.fillRect(-100,-100,900,900);
				g2d.fillRect(-100,-100,900,900);
				g2d.fillRect(-100,-100,900,900);
				this.mapChargePremiere = false;
			}
			else{				
				g2d.setColor(Color.BLACK);
				g2d.drawString("Veuillez attendre", 55, 80); 
				g2d.drawString("que l'hote lance la partie.", 45, 95);

				/*g2d.setColor(this.couleurCarre);
					this.posXBalle = this.posXBalle + this.sensBalleX;
					this.posYBalle = this.posYBalle + this.sensBalleY;
					g2d.fillOval(this.posXBalle, this.posYBalle, this.posWBalle, this.posHBalle);*/
				g2d.drawImage(new ImageIcon(this.getClass().getResource("petitsPoints.gif")).getImage(),180, 35,this);
				g2d.drawImage(new ImageIcon(this.getClass().getResource("patiente.gif")).getImage(),50, 140,this);
				g2d.setColor(Color.WHITE);				
				//g2d.fillOval(this.posXBalle+((-this.sensBalleX)*this.posWBalle)-5, this.posYBalle+((-this.sensBalleY)*this.posHBalle)-5, this.posWBalle+5, this.posHBalle+5);
				//g2d.fillRect(-100,-100,900,900);
			}


		}




	}


	// GET ||| SET
	public int getWidth() {
		return this.width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeigth() {
		return this.heigth;
	}

	public void setHeigth(int heigth) {
		this.heigth = heigth;
	}

	public int getPosX() {
		return this.posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return this.posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getPosH() {
		return this.posH;
	}

	public void setPosH(int posH) {
		this.posH = posH;
	}

	public int getPosW() {
		return this.posW;
	}

	public void setPosW(int posW) {
		this.posW = posW;
	}
	public void setMapCharge(boolean mapCharge){
		this.mapCharge = mapCharge;
	}

}
