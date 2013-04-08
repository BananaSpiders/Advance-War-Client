import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.InetAddress;
import javax.swing.JButton;


public class RejoindreUnePartie extends JFrame implements ActionListener,KeyListener {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblAdresseIpDu;
	private JLabel lblPortServeur;
	private JButton btnAnnuler;
	private JButton btnValider;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			@Override
//			public void run() {
//				try {
//					RejoindreUnePartie frame = new RejoindreUnePartie();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	private Menu owner;
	/**
	 * Create the frame.
	 */
	public RejoindreUnePartie(Menu owner) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(RejoindreUnePartie.class.getResource("/javax/swing/plaf/metal/icons/sortDown.png")));
		setTitle("Rejoindre une partie");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.owner = owner;
		
		///////////////////////////////////////////////
		// IP PAR DEFAUT !!!!!!!!!!!!!!!!!
		///////////////////////////////////////////////
		String ipParDefaut ="localhost";
		//////////////////////////////////////////////
		
		
		lblAdresseIpDu = new JLabel("IP Serveur :");
		lblAdresseIpDu.setBounds(80, 81, 82, 14);
		contentPane.add(lblAdresseIpDu);
		
		lblPortServeur = new JLabel("Port Serveur :");
		lblPortServeur.setBounds(80, 141, 93, 14);
		contentPane.add(lblPortServeur);
		
		this.textField = new JTextField("8811");// port
		textField.setEditable(false);
		this.textField.setBounds(185, 138, 126, 20);
		contentPane.add(this.textField);
		this.textField.setColumns(10);
		
		this.textField_1 = new JTextField(""+ipParDefaut);// ip
		this.textField_1.setBounds(185, 78, 126, 20);
		contentPane.add(this.textField_1);
		this.textField_1.setColumns(10);
		
		JLabel lblRejoindreUnePartie = new JLabel("Rejoindre une Partie");
		lblRejoindreUnePartie.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblRejoindreUnePartie.setBounds(118, 24, 238, 30);
		contentPane.add(lblRejoindreUnePartie);
		
		this.btnAnnuler = new JButton("Annuler");
		this.btnAnnuler.setBounds(345, 239, 89, 23);
		contentPane.add(this.btnAnnuler);
		
		this.btnValider = new JButton("Valider");
		this.btnValider.setBounds(222, 185, 89, 23);
		contentPane.add(this.btnValider);
		this.btnValider.addActionListener(this);
		this.btnAnnuler.addActionListener(this);
		this.addKeyListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()== this.btnAnnuler){
			Menu m = new Menu();
			m.setVisible(true);
			this.dispose();
		}
		if(arg0.getSource()== this.btnValider){
			String IP =this.textField_1.getText();
			String sPort =this.textField.getText();
			String typeErreur = "<okay>";
			int port = -99;
			InetAddress inet = null;
			// on recup�re l'erreur
			try{
				port = Integer.parseInt(sPort);
			}catch(Exception e){
				typeErreur = "<port>";
			}
			if(port <0){
				typeErreur = "<port>";
			}
			try{
				inet = InetAddress.getByName(IP);
				
			}catch(Exception e){
				typeErreur = "<IP>";
			}
			// en fonction de l'erreur
			if(typeErreur.equals("<port>")){
				JOptionPane.showMessageDialog(this,"La saisie du port : \""+sPort+"\" est incorrecte","Saisie Incorrecte",JOptionPane.ERROR_MESSAGE);
			}
			else if(typeErreur.equals("<IP>")){
				JOptionPane.showMessageDialog(this,"La saisie de l'IP : \""+IP+"\" est incorrecte","Saisie Incorrecte",JOptionPane.ERROR_MESSAGE);
			}
			else{
//				JOptionPane.showMessageDialog(this,"Connexion au serveur :\n IP : "+IP+"\n Port : "+sPort);
				ConnectionAuServeur cAS = new ConnectionAuServeur(inet,port,this);
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_ENTER)
			this.btnValider.doClick();
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
