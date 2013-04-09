import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;


public class EditeurMap extends JFrame implements MouseListener,ActionListener {

	private JPanel contentPane;
	private JTextField textField;
	private JPanelDraw panel_1;
	private JTextField textField_1;
	private JButton btnGnrerLaMap;
	private int iNbJoueur;
	private JTextField textField_2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					/*EditeurMap frame = new EditeurMap();
					frame.setVisible(true);*/
					EditeurMap.StartEdideurMap();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EditeurMap() {	
	}
	public EditeurMap(int nombreJoueur) {
		
		setTitle("Editeur Map");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1194, 715);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		this.iNbJoueur=nombreJoueur;
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 68, 242, 600);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnHerbe = new JButton("Herbe");
		btnHerbe.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selected("HERBE");
				appartientA(0);
			}
		});
		btnHerbe.setBounds(71, 42, 89, 23);
		panel.add(btnHerbe);

		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(146, 11, 86, 20);
		this.textField.setText("VIDE");
		panel.add(textField);
		textField.setColumns(10);

		JButton btnEau = new JButton("Eau");
		btnEau.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selected("EAU");
				appartientA(0);
			}
		});
		btnEau.setBounds(71, 76, 89, 23);
		panel.add(btnEau);

		JButton btnRoutedb = new JButton("RouteGD");
		btnRoutedb.setIcon(null);
		btnRoutedb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selected("ROUTEGD");
				appartientA(0);
			}
		});
		btnRoutedb.setBounds(71, 110, 89, 23);
		panel.add(btnRoutedb);

		JButton btnRoutehb = new JButton("RouteHB");
		btnRoutehb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selected("ROUTEHB");
				appartientA(0);
			}
		});
		btnRoutehb.setBounds(71, 144, 89, 23);
		panel.add(btnRoutehb);

		JButton btnRoutegb = new JButton("RouteGB");
		btnRoutegb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selected("ROUTEGB");
				appartientA(0);
			}
		});
		btnRoutegb.setBounds(71, 178, 89, 23);
		panel.add(btnRoutegb);

		JButton btnRoutegh = new JButton("RouteGH");
		btnRoutegh.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selected("ROUTEGH");
				appartientA(0);
			}
		});
		btnRoutegh.setBounds(71, 212, 89, 23);
		panel.add(btnRoutegh);

		JButton btnRoutehd = new JButton("RouteHD");
		btnRoutehd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selected("ROUTEHD");
				appartientA(0);
			}
		});
		btnRoutehd.setBounds(71, 246, 89, 23);
		panel.add(btnRoutehd);

		JButton btnRoutedb_1 = new JButton("RouteDB");
		btnRoutedb_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selected("ROUTEDB");
				appartientA(0);
			}
		});
		btnRoutedb_1.setBounds(71, 280, 89, 23);
		panel.add(btnRoutedb_1);

		JButton btnSapin = new JButton("Sapin1");
		btnSapin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selected("SAPIN1");
				appartientA(0);
			}
		});
		btnSapin.setBounds(71, 314, 89, 23);
		panel.add(btnSapin);

		JButton btnSapin_1 = new JButton("Sapin2");
		btnSapin_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selected("SAPIN2");
				appartientA(0);
			}
		});
		btnSapin_1.setBounds(71, 348, 89, 23);
		panel.add(btnSapin_1);

		JButton btnBatimentBase = new JButton("Bat_Base");
		btnBatimentBase.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selected("BAT_BASE");
				//appartientA(0);
			}
		});
		btnBatimentBase.setBounds(71, 382, 89, 23);
		panel.add(btnBatimentBase);

		JButton btnBatqg = new JButton("Bat_QG");
		btnBatqg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selected("BAT_QG");
				//appartientA(0);
			}
		});
		btnBatqg.setBounds(71, 416, 89, 23);
		panel.add(btnBatqg);

		JButton btnBatville = new JButton("Bat_Ville");
		btnBatville.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selected("BAT_VILLE");
				//appartientA(0);
			}
		});
		btnBatville.setBounds(71, 450, 89, 23);
		panel.add(btnBatville);

		JButton btnVide = new JButton("Vide");
		btnVide.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selected("VIDE");
				appartientA(0);
			}
		});
		btnVide.setBounds(71, 484, 89, 23);
		panel.add(btnVide);

		JLabel lblPrimaire = new JLabel("Elementaire :");
		lblPrimaire.setBounds(10, 28, 75, 14);
		panel.add(lblPrimaire);

		JLabel lblRoute = new JLabel("Route :");
		lblRoute.setBounds(10, 99, 46, 14);
		panel.add(lblRoute);

		JLabel lblSapin = new JLabel("Sapin :");
		lblSapin.setBounds(10, 300, 46, 14);
		panel.add(lblSapin);

		JLabel lblBatiment = new JLabel("Batiment :");
		lblBatiment.setBounds(10, 374, 63, 14);
		panel.add(lblBatiment);

		JLabel lblAnnuler = new JLabel("Annuler :");
		lblAnnuler.setBounds(10, 469, 63, 14);
		panel.add(lblAnnuler);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(this.getClass().getResource("herbe.jpg")));
		label_1.setBounds(176, 42, 30, 23);
		panel.add(label_1);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(this.getClass().getResource("eau.jpg")));
		label.setBounds(176, 76, 30, 23);
		panel.add(label);

		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(this.getClass().getResource("routeGD.jpg")));
		label_2.setBounds(176, 110, 30, 23);
		panel.add(label_2);

		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(this.getClass().getResource("routeHB.jpg")));
		label_3.setBounds(176, 144, 30, 23);
		panel.add(label_3);

		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(this.getClass().getResource("routeGB.jpg")));
		label_4.setBounds(176, 178, 30, 23);
		panel.add(label_4);

		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(this.getClass().getResource("routeGH.jpg")));
		label_5.setBounds(176, 212, 30, 23);
		panel.add(label_5);

		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(this.getClass().getResource("routeHD.jpg")));
		label_6.setBounds(176, 246, 30, 23);
		panel.add(label_6);

		JLabel label_7 = new JLabel("");
		label_7.setIcon(new ImageIcon(this.getClass().getResource("routeDB.jpg")));
		label_7.setBounds(176, 280, 30, 23);
		panel.add(label_7);

		JLabel label_8 = new JLabel("");
		label_8.setIcon(new ImageIcon(this.getClass().getResource("sapin1.jpg")));
		label_8.setBounds(176, 314, 30, 23);
		panel.add(label_8);

		JLabel label_9 = new JLabel("");
		label_9.setIcon(new ImageIcon(this.getClass().getResource("sapin2.jpg")));
		label_9.setBounds(176, 348, 30, 23);
		panel.add(label_9);
		
		JLabel lblJoueur = new JLabel("Joueur :");
		lblJoueur.setBounds(10, 547, 46, 14);
		panel.add(lblJoueur);
		
		textField_2 = new JTextField();
		textField_2.setText("0");
		textField_2.setEditable(false);
		textField_2.setBounds(71, 544, 86, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JButton button = new JButton("<-");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				moveAppartient(-1);
			}
		});
		button.setBounds(39, 572, 46, 23);
		panel.add(button);
		
		JButton button_1 = new JButton("->");
		button_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				moveAppartient(1);
			}
		});
		button_1.setBounds(160, 572, 46, 23);
		panel.add(button_1);
		
		JLabel label_10 = new JLabel("");
		label_10.setIcon(new ImageIcon(this.getClass().getResource("0_bat_qg.jpg")));
		label_10.setBounds(176, 416, 30, 23);
		panel.add(label_10);
		
		JLabel label_11 = new JLabel("");
		label_11.setIcon(new ImageIcon(this.getClass().getResource("0_bat_base.jpg")));
		label_11.setBounds(176, 382, 30, 23);
		panel.add(label_11);
		
		JLabel label_12 = new JLabel("");
		label_12.setIcon(new ImageIcon(this.getClass().getResource("0_bat_ville.jpg")));
		label_12.setBounds(176, 450, 30, 23);
		panel.add(label_12);

		this.panel_1 = new JPanelDraw(this);
		this.panel_1.setBounds(262, 68, 901, 601);
		contentPane.add(this.panel_1);

		JLabel lblNomDuFichier = new JLabel("Nom de la map :");
		lblNomDuFichier.setBounds(24, 40, 97, 14);
		contentPane.add(lblNomDuFichier);

		textField_1 = new JTextField();
		textField_1.setBounds(121, 37, 116, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		btnGnrerLaMap = new JButton("G\u00E9n\u00E9rer la map");
		btnGnrerLaMap.addActionListener(new ActionListener() {
			// ECOUTE DU BOUTON GENERER
			@Override
			public void actionPerformed(ActionEvent arg0) {
				///// On verrifie si il y a bien une base et un QG pour chaque joueurs //////////
				// initialise
				int iNbJ =iNbJoueur;
				boolean[] bTabJoueursQg = new boolean[iNbJ];
				boolean[] bTabJoueursBase = new boolean[iNbJ];
				/// ATTENTION COMMENCE A 0
				for(int i=0;i<iNbJ;i++){
					bTabJoueursQg[i]= false;
					bTabJoueursBase[i]=false;
				}
				// pour toutes les case on regarde si elles contiennent une base ou un qg de joueur
				for(int i=0;i<panel_1.tabInitialise.length;i++){
					for(int j=0;j<panel_1.tabInitialise[0].length;j++){
						// on recupère les valeures du tableau dans le panel que l'on paint
						// on recupère le num d'appartenance au debut de chaque nom
						String sAppartient = panel_1.tabInitialise[i][j].split("_")[0];
						// on recupère le nom du type de case en fin de mot
						String sTypeCase = panel_1.tabInitialise[i][j].split("_")[1].toUpperCase();
						// si le nom coontenait un underscore on recolle la fin du mot coupé par le split
						if(panel_1.tabInitialise[i][j].split("_").length ==3)
							sTypeCase=sTypeCase+"_"+panel_1.tabInitialise[i][j].split("_")[2].toUpperCase();
						// Si le num d'appartenance des different de 0 (neutre)
						if(Integer.parseInt(sAppartient) != 0){
							// si le nom est celui de batiment qg ou batiment base on met a true la cellule bTabJoueur avec -1 car il y a un de décallage (notre tableau ne prend pas en compte le joueur neutre alors que les valeures récupérées si
							if(sTypeCase.equals("BAT_QG")){
								bTabJoueursQg[Integer.parseInt(sAppartient) -1]=true;
							}
							if(sTypeCase.equals("BAT_BASE")){
								bTabJoueursBase[Integer.parseInt(sAppartient) -1]=true;
							}
						}
					}
				}
				String erreurManqueBatiment = null;
				boolean manqueBase = false;
				String erreurManqueBatimentQG = "1 QG pour joueur(s) : ";
				String erreurManqueBatimentBase = "1 Base pour joueur(s) : ";
				// on regarde si toutes les données sont bien a true
				for(int i=0;i<iNbJ;i++){
					if(bTabJoueursQg[i]==false){
						erreurManqueBatimentQG = erreurManqueBatimentQG+""+(i+1)+" | ";
						manqueBase=true;
					}
					if(bTabJoueursBase[i]==false){
						erreurManqueBatimentBase = erreurManqueBatimentBase+""+(i+1)+" | ";
						manqueBase=true;
					}
				}
				erreurManqueBatiment = "Objet(s) manquant :\n "+erreurManqueBatimentQG+"\n "+erreurManqueBatimentBase;
				if(manqueBase==true){
					JOptionPane.showMessageDialog(null,erreurManqueBatiment ,"Attention !", JOptionPane.ERROR_MESSAGE);
				}
				else{
					if(nomVide()){// On verrifie si le fichier n'est pas vide
						JOptionPane.showMessageDialog(null, "Nommez votre map !","Attention !", JOptionPane.ERROR_MESSAGE);
					}
					else{
						//////// on verrifie si le nom de map n'est deja pas pris /////////////
						boolean continu=true;
						if(fileExistant()){
							switch(JOptionPane.showConfirmDialog(null, "Cette map existe deja, continuer quand même ?","Attention !", JOptionPane.WARNING_MESSAGE)  )
							{
								case 0 ://OKay
									break;
								case 2://Annuler
									continu=false;
									break;
								case -1://Croix
									continu=false;
									break;
							}
						}
						// si on continue la generation
						if(continu==true){
							int caseVide=0;
							int cmbDeCase=0;
							for(int i=0;i<panel_1.tabInitialise.length;i++){
								for(int j=0;j<panel_1.tabInitialise[0].length;j++){
									if(panel_1.tabInitialise[i][j].split("_")[1].equals("vide"))
										caseVide++;
									cmbDeCase++;
								}
							}
							if(caseVide!=0)
								JOptionPane.showMessageDialog(null, "Veuillez remplir toutes les cases !\n ("+caseVide+" vides / "+cmbDeCase+")","Attention !", JOptionPane.ERROR_MESSAGE);
							else{
								genererLeFichierXml();
							}
						}
					}
				}
			}
		});
		btnGnrerLaMap.setBounds(501, 11, 190, 32);
		contentPane.add(btnGnrerLaMap);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				annuler();
			}
		});
		btnAnnuler.setBounds(1050, 16, 89, 23);
		contentPane.add(btnAnnuler);




	}
	//////////////////////////////////
	// METHODES
	/////////////////////////////////
	
	// generer Le Fichier Xml
	public void genererLeFichierXml(){
		// on initialise le tableau de case
		Case[][] tableauDeCase;
		
		int tailleDeX=panel_1.tabInitialise[0].length;
		int tailleDeY=panel_1.tabInitialise.length;
		
		tableauDeCase = new Case[tailleDeY][tailleDeX];
		// on le rempli
		for(int i=0;i<tailleDeY;i++){
			for(int j=0;j<tailleDeX;j++){
				tableauDeCase[i][j]= new Case();
				
				tableauDeCase[i][j].setX(j);
				tableauDeCase[i][j].setY(i);
				String sTypeCase = this.panel_1.tabInitialise[i][j].split("_")[1].toUpperCase();
				if(this.panel_1.tabInitialise[i][j].split("_").length ==3)
					sTypeCase=sTypeCase+"_"+this.panel_1.tabInitialise[i][j].split("_")[2].toUpperCase();
				String sAppartient = this.panel_1.tabInitialise[i][j].split("_")[0].toUpperCase();
				tableauDeCase[i][j].setTypeCase(TypeCase.valueOf(sTypeCase) );// va cherche la valeur du string dans l'enumeration typeCas
				tableauDeCase[i][j].setAppartient(Integer.parseInt(sAppartient));
			}
		}
		// on lenvoi a la classe Xml
		Xml xml1 = new Xml("map\\"+this.textField_1.getText()+".xml",tableauDeCase);
		
		JOptionPane.showMessageDialog(null, "Création de la map \""+this.textField_1.getText()+"\" réussie !","Map", JOptionPane.INFORMATION_MESSAGE);
		/////////////////////////////////////////////////////////////////
		// FIN DE LA CREATION DE MAP (=>>>> retour sur le menu )
		//////////////////////////////////////////////////////////////////
		
		/*
		 * 
		 * 
		 */
		
		Menu m1 = new Menu();
		m1.setVisible(true);
		this.dispose();
	}
	// verifie si le champs est saisie
	public boolean nomVide(){
		if(this.textField_1.getText().equals("") 
				|| this.textField_1.getText().equals(" ")
				|| this.textField_1.getText().equals("   ")
				|| this.textField_1.getText()== null)
			return true;
		else 
			return false;
	}
	// verirife si le fichier existe deja
	public boolean fileExistant(){
		File repertoire = new File(System.getProperty("user.dir")+"\\map");// on recupere le repertoire courant + \map pour aller dans les map
		String [] listefichiers; 
		int i;
		boolean leFichierExisteDeja=false;
		listefichiers=repertoire.list(); // transmet la liste des fichier dans un tableau de Strings
		for(i=0;i<listefichiers.length;i++){ // pour toute cette liste on verrifie les egalitées
			//System.out.println(listefichiers[i]);
			if(listefichiers[i].equals(this.textField_1.getText()+".xml"))
				leFichierExisteDeja=true;
		}
		return leFichierExisteDeja;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		//System.out.println(e.getX()+"/"+e.getY());
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	public void selected(String type){
		this.textField.setText(type);
	}
	public void appartientA(int nb){
		this.textField_2.setText(nb+"");
	}
	public String getTextField(){
		return this.textField.getText();
	}
	public String getTextField2(){
		return this.textField_2.getText();
	}
	public void moveAppartient(int nb){
		int nbAppartientQui = Integer.parseInt(this.getTextField2());
		nbAppartientQui = nbAppartientQui + nb;
		if(nbAppartientQui<0)
			nbAppartientQui=this.iNbJoueur;
		else if(nbAppartientQui>this.iNbJoueur)
			nbAppartientQui=0;
		appartientA(nbAppartientQui);
	}
	////////////////////////////////////
	//	Methode a use pour start editeur
	///////////////////////////////////
	public static void StartEdideurMap(){
		/////////////////////////////////////////////////////////////////
		// DEBUT DE LA CREATION DE MAP (=>>>> retour sur le menu )
		//////////////////////////////////////////////////////////////////
		
		/*
		* 
		* 
		*/
		boolean bGood=true;
		int iRep=0;
		String sRep;
		do{
			if(bGood == false )
				if( iRep <= 1 || iRep >= 5)
					JOptionPane.showMessageDialog(null, "Le nombre de joureur doit :\n - Etre compris entre 2 et 4\n - Etre un nombre entier\n","Editeur map", JOptionPane.INFORMATION_MESSAGE);
			
			sRep=null;
			sRep =JOptionPane.showInputDialog(null, "Combien de joueurs ?\n(4 max)","Editeur map", JOptionPane.INFORMATION_MESSAGE);
			
			
			
			bGood=true;
			iRep=0;
			
			try{
				iRep = Integer.parseInt(sRep);
			}
			catch(Exception e){
				System.out.println("Exception :"+e);
				if(sRep!=null){
					bGood=false;
				}
			}
			if(! (iRep >= 2 && iRep <=4) )
				bGood=false;
			if(sRep==null){
				bGood=true;
				sRep="Annuler";
			}
		}while(!bGood);
		
		if(!sRep.equals("Annuler")){
			EditeurMap eM = new EditeurMap(iRep);
			eM.setVisible(true);
		}
		else{
			Menu m1 = new Menu();
			m1.setVisible(true);
		}
		
	}
	public void annuler(){
		Menu m1 = new Menu();
		m1.setVisible(true);
		this.dispose();
	}
}
