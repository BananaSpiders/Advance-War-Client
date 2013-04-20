import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JFrame implements ActionListener{

	/*
	 * 
	 * 		ATTRIBUTS 
	 * 
	 */
	// Panel
	private JPanel contentPane;
	// Bouton
	JButton btnQuitter = new JButton("Quitter");
	JButton btnCharger = new JButton("Creer une partie");
	JButton btnEditeur = new JButton("Editeur");
	JButton btnJouer = new JButton("Rejoindre une partie");
	JButton btnOption = new JButton("Options");
	JButton btnRetourOpt = new JButton("Quitter options");
	// Champ txt
	JTextField txtUnknowPlayer=new JTextField();
	
	
	
	/*
	 * 
	 * 	MAIN
	 * 
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	/*
	 * 
	 * 		CONSTRUCTEUR PAR DEFAUT
	 * 
	 */
	public Menu() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 464);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblMenu = new JLabel("MENU PRINCIPAL");
		lblMenu.setBounds(111, 44, 208, 23);
		lblMenu.setForeground(Color.WHITE);
		lblMenu.setFont(new Font("Snap ITC", Font.ITALIC, 18));
		contentPane.add(lblMenu);
		
		btnOption.setBounds(170,286 , 80, 23);
		btnOption.addActionListener(this);
		contentPane.add(btnOption);
		
		btnJouer.setBounds(130, 122, 177, 23);
		btnJouer.addActionListener(this);
		contentPane.add(btnJouer);
		
		btnEditeur.setBounds(170, 232, 80, 23);
		btnEditeur.addActionListener(this);
		contentPane.add(btnEditeur);
		
		btnCharger.setBounds(130, 178, 177, 23);
		btnCharger.addActionListener(this);
		contentPane.add(btnCharger);
		
		
		btnQuitter.setBounds(170, 340, 80, 23);
		btnQuitter.addActionListener(this);
		contentPane.add(btnQuitter);
		
	}
	
	/*
	 * 
	 * 			EVENEMENTS BOUTONS
	 * 	
	 */
	@Override
	public void actionPerformed(ActionEvent e){
		
		/*
		 *	Bouton Quitter 
		 */
		if(e.getSource()==btnQuitter)
		{	
			System.exit(0);
			
		}
		/*
		 * 	Bouton Option
		 */
		if(e.getSource()==btnOption)
		{
			Option frame = new Option();
			frame.setVisible(true); 
		}
		/*
		 * Bouton Editeur
		 */
		if(e.getSource()==btnEditeur)
		{
			EditeurMap.StartEdideurMap();
			this.dispose();
			
		}
		/*
		 *  Bouton jouer / rejoindre Une partie
		 */
		if(e.getSource()== btnJouer){
			RejoindreUnePartie rUP = new RejoindreUnePartie(this);
			rUP.setVisible(true);
			this.dispose();
		}
		/*
		 * Bouton Creer une partie / charger
		 */
		if(e.getSource()== btnCharger){
			FenetreServeur f = new FenetreServeur();
			this.dispose();
		}
			
	}
	
	
}
