import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.Socket;
import java.sql.Connection;


public class ConnectionAuServeur extends JFrame implements ActionListener {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					/*ConnectionAuServeur frame = new ConnectionAuServeur();
					frame.setVisible(true);*/
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	InetAddress IP;
	int port;
	public ThreadConnectionAuServeur threadCo;
	private Socket socketConnection;
	RejoindreUnePartie owner;
	private JPanelChargement panel;
	private String fileMapName;
	private int numJoueur; // 0.1.2.3.4 (0 joueur => neutre)
	public boolean mapRecu;
	public Jeu3 notreJeu;
	public ThreadAnnimConnection threadAnnim;
	public JButton bntAnnuler;
	public JButton bntRessayer;
	
	/**
	 * Create the frame.
	 */
	
	////////////////////////////////////////
	//		CONSTRUCTEUR
	///////////////////////////////////////
	public ConnectionAuServeur(InetAddress IP,int port,RejoindreUnePartie owner) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ConnectionAuServeur.class.getResource("/com/sun/java/swing/plaf/windows/icons/Computer.gif")));
		setTitle("Connection Serveur");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 266, 224);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
//		this.setVisible(true);
		this.IP = IP;
		this.port = port;
		this.owner = owner;
		this.owner.dispose();
		this.fileMapName = null;
		this.numJoueur =0;
		this.mapRecu=false;
		
		int width = 240;
		int height = 107;
		
		this.panel = new JPanelChargement(width,height,this);
		
		this.panel.setBounds(0, 36, width, height);
		contentPane.add(this.panel);
		// Boutons
		this.bntAnnuler = new JButton("Retour");
		this.bntRessayer = new JButton("Ressayer");
		this.bntAnnuler.setBounds(180, 195, 75,195+27);
		this.bntRessayer.setBounds(15, 195, 75,195+27);
		contentPane.add(this.bntAnnuler);
		contentPane.add(this.bntRessayer);
		this.bntAnnuler.setVisible(false);
		this.bntRessayer.setVisible(false);
		
		this.connection(this.IP,this.port);
	}
	
	
	
	//////////////////////////////////////////////////////////
	//		CONNECTION
	//////////////////////////////////////////////////////////
	public void connection(InetAddress IP,int port){
		System.out.println("Connexion...");
		
		//#################################################"""""""""""
		this.setVisible(true);
		
		this.threadAnnim = new ThreadAnnimConnection(this.panel, this.getGraphics(),this);
		this.threadAnnim.start();
		//#################################################"""""""""""
		
		// Creer le thread qui se connect au serveur et normallement recup�re direct la map en la t�l�chargeant
		this.threadCo = new ThreadConnectionAuServeur(this,this.IP, this.port);// Co THREAD
		this.threadCo.start();
		// Boucle infini tant que le numm client et le nom de la map n'est pas connue
		do{
			if(this.mapRecu)
				System.out.println(this.mapRecu);
		}while(this.mapRecu==false);
		
		//#################################################"""""""""""
		this.setVisible(false);
		threadAnnim.jPanelChargement.setMapCharge(true);
		//#################################################"""""""""""
		
		
		// on envoi la r�f�rence de l'objet actuel
		this.notreJeu = new Jeu3(this.fileMapName,this,this.numJoueur);
		
		//#################################################"""""""""""
		this.setVisible(true);
		//#################################################"""""""""""
		
		
		
		do{
			System.out.print(" ");
		}while(notreJeu.isPartieLancee()==false);
		
		//#################################################"""""""""""
		this.setVisible(false);
		//#################################################"""""""""""
		notreJeu.setVisible(true);
	}
	
	
	
	
	
	
	
	
	public String getFileMapName() {
		return fileMapName;
	}
	public void setFileMapName(String fileMapName) {
		this.fileMapName = fileMapName;
	}
	public int getNumJoueur() {
		return numJoueur;
	}
	public void setNumJoueur(int numJoueur) {
		this.numJoueur = numJoueur;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.bntAnnuler){
			RejoindreUnePartie m = new RejoindreUnePartie(new Menu());
			m.setVisible(true);
			owner.dispose();
		}if(e.getSource() == this.bntRessayer){
			ConnectionAuServeur coServ = new ConnectionAuServeur(this.IP,this.port,this.owner);
			coServ.setVisible(true);
			this.dispose();
		}
		
	}
}
