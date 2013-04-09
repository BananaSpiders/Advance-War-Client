import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;


public class ThreadAnnimConnection extends Thread{

	public JPanelChargement jPanelChargement;
	private Graphics graph;
	private int sensBarre;
	private ConnectionAuServeur owner;

	public ThreadAnnimConnection(JPanelChargement panel, Graphics graphics,ConnectionAuServeur owner) {
		// TODO Auto-generated constructor stub
		this.jPanelChargement = panel;
		this.graph = graphics;
		this.sensBarre=+1;
		this.owner = owner;
	}
	public void run() {
		do{
			//System.out.printf("YOYOYOYO");
			//			int unNombre=this.jPanelChargement.nbPoint;
			//			this.jPanelChargement.nbPoint++;
			//
			//			if(this.jPanelChargement.nbPoint == 4)
			//				this.jPanelChargement.nbPoint=1;
			int nbAlea = -99;


			// Gere le carre
			if(this.jPanelChargement.mapCharge == false ){
				if(this.jPanelChargement.getPosX() + this.jPanelChargement.getPosW() > this.jPanelChargement.getWidth()){
					this.sensBarre = -1;
					nbAlea = (int) (Math.random()*7);			}
				if (this.jPanelChargement.getPosX() <10){
					this.sensBarre = +1;
					nbAlea = (int) (Math.random()*7);	
				}
			}
			else{
				if(this.jPanelChargement.serveurIsFind == true){

					if(this.jPanelChargement.serveurIsFind == true){
						// BaBalle !!
						if(this.jPanelChargement.posXBalle + this.jPanelChargement.posWBalle >= 262)
							this.jPanelChargement.sensBalleX = -1;
						if(this.jPanelChargement.posXBalle  <= 5)
							this.jPanelChargement.sensBalleX = 1;
						if(this.jPanelChargement.posYBalle + this.jPanelChargement.posHBalle >= 220)
							this.jPanelChargement.sensBalleY = -1;
						if(this.jPanelChargement.posYBalle <= 20)
							this.jPanelChargement.sensBalleY = 1;

						if(this.jPanelChargement.posXBalle + this.jPanelChargement.posWBalle >= 262 
								|| this.jPanelChargement.posXBalle  <= 5 
								||this.jPanelChargement.posYBalle + this.jPanelChargement.posHBalle >= 220
								|| this.jPanelChargement.posYBalle <= 20)
							nbAlea = (int) (Math.random()*7);	
					}
				}else{
					/*try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					RejoindreUnePartie m = new RejoindreUnePartie(new Menu());
					m.setVisible(true);
					this.owner.dispose();*/
					//ServeurIntrouvable(this.owner);
				}
					

				}
				// rand  color
				if(nbAlea!=-99){
					switch(nbAlea){
					case 4:
						this.jPanelChargement.couleurCarre = Color.CYAN;
						break;
					case 5:
						this.jPanelChargement.couleurCarre = Color.GREEN;
						break;
					case 0:
						this.jPanelChargement.couleurCarre = Color.ORANGE;
						break;
					case 1:
						this.jPanelChargement.couleurCarre = Color.GRAY;
						break;
					case 2:
						this.jPanelChargement.couleurCarre = Color.MAGENTA;
						break;
					case 6:
						this.jPanelChargement.couleurCarre = Color.BLACK;
						break;
					case 3:
						this.jPanelChargement.couleurCarre = Color.RED;
						break;
					}
				}
				// bouge x carre
				this.jPanelChargement.setPosX(this.jPanelChargement.getPosX()+(2*this.sensBarre));


				// bouge y / x balle
				this.jPanelChargement.posXBalle = this.jPanelChargement.posXBalle + this.jPanelChargement.sensBalleX;
				this.jPanelChargement.posYBalle = this.jPanelChargement.posYBalle + this.jPanelChargement.sensBalleY;
			//}


			this.jPanelChargement.paint(this.graph);

			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}while(1==1);
	}
}
