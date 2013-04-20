import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class ThreadConnectionAuServeur extends Thread {

	private InetAddress IP;
	private int port;
	private Socket socketConnect;
	private BufferedReader socketIn;
	private PrintWriter socketOut;

	private String fileName;
	private int numClient; // 0.1.2.3
	private ConnectionAuServeur owner;

	///////////////////////////////////////
	// 		CONSTRUCTEUR
	///////////////////////////////////////
	public ThreadConnectionAuServeur(ConnectionAuServeur owner,InetAddress IP, int port){
		String str = null;
		this.IP = IP;
		this.port = port;
		this.owner = owner;
		this.fileName = null;
		

		////////////////////////////////////
		// On initialise les sockets
		///////////////////////////////////
		try{
			this.socketConnect = new Socket(this.IP, this.port);
		}
		catch(Exception e){
			System.out.println("ERROR : "+e);
			this.owner.threadAnnim.jPanelChargement.serveurIsFind = false;
//			JOptionPane.showMessageDialog(null,"Serveur introuvable");
			ServeurIntrouvable sI = new ServeurIntrouvable(this.owner);
			sI.setVisible(true);
			this.owner.dispose();
		}
		try {
			
			//JOptionPane.showMessageDialog(null, "Envoi de la socket");
			
			/*threadIsConnected threadTest = new threadIsConnected(this.socketConnect,this.owner);
			threadTest.run();*/
			
			this.socketIn =new BufferedReader(new InputStreamReader(this.socketConnect.getInputStream())); // init entr�e
			this.socketOut = new PrintWriter(this.socketConnect.getOutputStream(),true); // init sortie
			//JOptionPane.showMessageDialog(null, "Socket :"+this.socketConnect);

			////////////////////////////////////
			// Premier readline on recup�re le num joueur
			/////////////////////////////////////
			str = this.socketIn.readLine();
			this.numClient = Integer.parseInt(str.substring(3, 4));

			



		} catch (IOException e) {
			
			System.out.println("Exception #1000 :"+e);
		}



	}

	///////////////////////////////////////
	//		RUN 
	/////////////////////////////////////////
	@Override
	public void run() {

		String str=null;
		String commande=null;
		// Boucle infini
		while (true) {

			try {
				// on recupère un code envoyé par le serveur (3premier caract�res)
				str = this.socketIn.readLine();
				commande = str.substring(0, 3);
				//JOptionPane.showMessageDialog(null, "Commande :"+commande);
				// On fonction des codes recus 
				if(commande.equals("MAP")){
					// on recup�re le nom du fichier et on le cr�e
					this.fileName = str.substring(3, str.length());
					File fileMap = new File("map/"+this.fileName);
					PrintWriter toFile = new PrintWriter(new FileOutputStream(fileMap));
					int i=0;

					while (true) {// boucle infini qui sera break => :/ pas tr�s beau mais COOOL ! <3

						i++;
						// reception des paquets recu
						str= this.socketIn.readLine();
						//  SII le paquet actuel recu est egale a END on BREAK la boucle, le fichier est rempli on a tout recu
						if(str.substring(0,3).equals("END"))
							break;
						// On ecris dans le fichier le paquet actuel recu
						toFile.println(str);						
						System.out.println("Paquet : "+i);
					}
					// on ferme le fichier
					toFile.close();

					// on modifie les variable de la fenetre courante pour quelle sache que la recpetion est termin�e et que
					// 			l'on peut continuer
					this.owner.setFileMapName(this.fileName);
					this.owner.setNumJoueur(this.numClient+1);

					System.out.println(this.owner.mapRecu);
					this.owner.mapRecu = true;
					System.out.println(this.owner.mapRecu);
				}
				else if(commande.equals("ATK")){
					//ZEBIIIIII

					int numJoueur = Integer.parseInt(str.substring(3,4)); 	
					int posx = Integer.parseInt(str.substring(5,7))*30; 	
					int posy = Integer.parseInt(str.substring(8,10))*30;
					int newvie = Integer.parseInt(str.substring(12,str.length()));
					//					this.owner.notreJeu.afficherPopup("numJoueur "+numJoueur+" pos : "+posx+"/"+posy+" newvie : "+newvie);

					for(int i = 0; i<4;i++)
						for (Unite u : this.owner.notreJeu.getLesJoueurs().get(i).getListeUnites()) {
							if ((u.getPosX() == posx)
									&& (u.getPosY()  == posy))
							{
								if(newvie > 0)
									u.setPv(newvie);
								else
									this.owner.notreJeu.getLesJoueurs().get(i).getListeUnites().remove(u);

							}
						}


				}
				else if(commande.equals("BGN")){
					int nbJoueur = Integer.parseInt(str.substring(3,4));
					System.out.println("COUCOUUUUUU ! "+str+" | "+nbJoueur);
					this.owner.notreJeu.setTotalJoueurs(nbJoueur);
					this.owner.notreJeu.setPartieLancee(true);
				}
				else if(commande.equals("FIN"))
				{
					int numJoueur = Integer.parseInt(str.substring(3,4));
					if(numJoueur == this.owner.notreJeu.getNumeroJoueurLocal())
					{
						this.owner.notreJeu.monTour = true;
						//						this.owner.notreJeu.afficherPopup("C'est votre tour !");
					}
				}
				else if(commande.equals("ACH")){

					int numJoueur = Integer.parseInt(str.substring(3,4))-1; 	
					int posx = Integer.parseInt(str.substring(5,7))*30; 	
					int posy = Integer.parseInt(str.substring(8,10))*30;
					String unitName = str.substring(10,str.length());
					//					this.owner.notreJeu.afficherPopup("joueur ach = "+numJoueur);
					//					this.owner.notreJeu.afficherPopup("J"+numJoueur+" pos : x="+posx+" y="+posy+" type="+unitName);
					if(unitName.equals("Fusillier"))
						this.owner.notreJeu.getLesJoueurs().get(numJoueur).getListeUnites().add(new Fusilier(posx, posy));
					else if(unitName.equals("Bazooka"))
						this.owner.notreJeu.getLesJoueurs().get(numJoueur).getListeUnites().add(new Bazooka(posx, posy));
					if(unitName.equals("Tank"))
						this.owner.notreJeu.getLesJoueurs().get(numJoueur).getListeUnites().add(new Tank(posx, posy));
					if(unitName.equals("Artillerie"))
						this.owner.notreJeu.getLesJoueurs().get(numJoueur).getListeUnites().add(new Artillerie(posx, posy));
					if(unitName.equals("Jeep"))
						this.owner.notreJeu.getLesJoueurs().get(numJoueur).getListeUnites().add(new Jeep(posx, posy));


				}// CAS BOMBE
				else if(commande.equals("BOM")){
					String action = str.substring(4,7);
					String typeBombe = str.substring(7,10);
					int numJoueur =  Integer.parseInt(str.substring(3,4))-1; // 0/1/2/3
					int posx = Integer.parseInt(str.substring(11,13)); 	
					int posy = Integer.parseInt(str.substring(14,16));
					if(action.equals("NEW")){// NOUVELLE BOMBE
						if(typeBombe.equals("MIN")) // MINE
							this.owner.notreJeu.plateau[posx][posy].setBombe(new Mine(posx*30,posy*30,numJoueur));
						else
							System.out.println("BOMBE inconnu => [commande] : "+str);
					}// LA BOMBE EXPLOSE
					else if(action.equals("DEL")){
						int newVie = Integer.parseInt(str.substring(16,str.length()));
						for(int i = 0; i<4;i++)
							for (Unite u : this.owner.notreJeu.getLesJoueurs().get(i).getListeUnites()) {
								if ((u.getPosX() == posx*Constantes.TAILLE_CASE)
										&& (u.getPosY()  == posy*Constantes.TAILLE_CASE))
								{
									if(newVie!=99)// si cest 99 ca veux dire que la bombe a explosee dans le vide
										u.setPv(newVie);
									if(u.getPv() <= 0){
										this.owner.notreJeu.getLesJoueurs().get(i).getListeUnites().remove(u);
										break;
									}
								}
							}
						this.owner.notreJeu.plateau[posx][posy].setBombe(null);
					}
					else
						System.out.println("ACTION inconnu => [commande] : "+str);
				}
				else if(commande.equals("DPL")){
					//exemple : DPL1x14y08x14y07
					int numJoueur = Integer.parseInt(str.substring(3,4))-1; 	
					int posx = Integer.parseInt(str.substring(5,7))*30; 	
					int posy = Integer.parseInt(str.substring(8,10))*30;
					int newposx = Integer.parseInt(str.substring(11,13))*30; 	
					int newposy = Integer.parseInt(str.substring(14,16))*30;
					//					this.owner.notreJeu.afficherPopup("joueur dpl = "+numJoueur);
					for (Unite u : this.owner.notreJeu.getLesJoueurs().get(numJoueur).getListeUnites()) {
						if ((u.getPosX() == posx)
								&& (u.getPosY()  == posy))
						{
							u.setPosX(newposx);
							u.setPosY(newposy);
						}
					}

				}
				
				/////////////////////////////////////////////////////////////
				//		Gestions reception des captures
				///////////////////////////////////////////////////////////
				else if(commande.equals("CAP")){ // si une baseville/qg est captuee ( ex : (CAP2x10y09V) )
					int numeroDeJoueur = Integer.parseInt(str.substring(3,4)); // 0.1.2.3
					int posX = Integer.parseInt(str.substring(5,7));
					int posY = Integer.parseInt(str.substring(8,10));
					String typeBat = str.substring(10,11);
					
					System.out.println("Commande : "+commande+" num joueur : "+numeroDeJoueur+" posX : "+posX+"posY : "+posY+" type : "+typeBat);
					
					
					/// on regarde si nous sommes le joueur concern�
					boolean itsMe=false;
					Joueur joueurLocal = null;
					if(this.owner.notreJeu.plateau[posX][posY].getAppartient() == this.owner.notreJeu.getNumeroJoueurLocal()){
						itsMe=true;
						// on recupere la reference de notre joueure
						joueurLocal = this.owner.notreJeu.getOneJoueur(this.owner.notreJeu.getNumeroJoueurLocal()-1);
					}
					
					// on modifi les variables en fonction de se que lon a recu
					this.owner.notreJeu.plateau[posX][posY].setAppartient(numeroDeJoueur+1);
					/// si VILLE
					if(typeBat.equals("V")){
						this.owner.notreJeu.plateau[posX][posY].setImageIcon(new ImageIcon(this.getClass().getResource((numeroDeJoueur+1)+"_bat_ville.jpg")));
						// Si cest nous qui avons perdu une ville
						if(itsMe){
							joueurLocal.setNombreVilles(joueurLocal.getNombreVilles()-1);
						}
					}
					
					// SI BASE
					else if(typeBat.equals("B")){
						this.owner.notreJeu.plateau[posX][posY].setImageIcon(new ImageIcon(this.getClass().getResource((numeroDeJoueur+1)+"_bat_base.jpg")));
						// Si cest nous qui avons perdu une base
						if(itsMe){
							joueurLocal.setNombreBases(joueurLocal.getNombreBases()-1);
						}
					}
					
					// SI QG
					else if(typeBat.equals("Q")){
						this.owner.notreJeu.plateau[posX][posY].setImageIcon(new ImageIcon(this.getClass().getResource((numeroDeJoueur+1)+"_bat_qg.jpg")));
						// Si cest nous qui avons perdu un	qg
						if(itsMe){
							joueurLocal.setNombreQG(joueurLocal.getNombreQG()-1);
							if(joueurLocal.getNombreQG() < 1){
								this.owner.notreJeu.joueurLocalPerdu = true;
							}
						}
						
						
					}
				}
				// SI ON RECOI QUUN JOUEUR EST MORT
				else if(commande.equals("DIE")){
					int numeroDeJoueur = Integer.parseInt(str.substring(3,4)); // 0.1.2.3
					
					this.owner.notreJeu.getOneJoueur(numeroDeJoueur).isDie=true;// on die que le joueur est mort
					
					
				}
				else if(commande.equals("MSG")){
					this.owner.notreJeu.afficherPopup(str.substring(3,str.length()));
				}
				else{
					System.out.println("Error commande : "+commande);
				}

			} catch (Exception e) {

				e.printStackTrace();

			}
		}

	}
	
	// CODE INUTILE THREAD DONT ON NE SE SERT PAS 
	class threadIsConnected extends Thread {
		private Socket socketConnexion;
		private ConnectionAuServeur owner;
		public threadIsConnected(Socket socket,ConnectionAuServeur owner){
			this.socketConnexion = socket;
			this.owner = owner;
		}
		public void run() {
			System.out.println("ddd");
			System.out.println("Connected 1 ?? : "+this.socketConnexion.isConnected());
			// on test la connexion
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(this.socketConnexion.isConnected()==false){
				JOptionPane.showMessageDialog(null,"Serveur introuvable");
				Menu m = new Menu();
				m.setVisible(true);
				this.owner.dispose();
			}
			System.out.println("Connected 2 ?? : "+this.socketConnexion.isConnected());
		}
		
	}
	//########################################

	public InetAddress getIP() {
		return IP;
	}

	public void setIP(InetAddress iP) {
		IP = iP;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public Socket getSocketConnect() {
		return socketConnect;
	}

	public void setSocketConnect(Socket socketConnect) {
		this.socketConnect = socketConnect;
	}

	public BufferedReader getSocketIn() {
		return socketIn;
	}

	public void setSocketIn(BufferedReader socketIn) {
		this.socketIn = socketIn;
	}

	public PrintWriter getSocketOut() {
		return socketOut;
	}

	public void setSocketOut(PrintWriter socketOut) {
		this.socketOut = socketOut;
	}

	public int getNumClient() {
		return numClient;
	}

	public void setNumClient(int numClient) {
		this.numClient = numClient;
	}


}
///////////// enlever le .xml des map