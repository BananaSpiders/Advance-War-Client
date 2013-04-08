import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ServeurIntrouvable extends JFrame implements ActionListener {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServeurIntrouvable frame = new ServeurIntrouvable();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	private ConnectionAuServeur superOwner;
	private JButton btnRetour;
	private JButton btnRessayer;
	public ServeurIntrouvable(ConnectionAuServeur superOwner) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ServeurIntrouvable.class.getResource("/com/sun/java/swing/plaf/windows/icons/Warn.gif")));
		setTitle("Serveur Introuvable");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 373, 211);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.superOwner = superOwner;
		JLabel lblServeurIntrouvable = new JLabel("Serveur introuvable");
		lblServeurIntrouvable.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblServeurIntrouvable.setBounds(50, 22, 297, 47);
		contentPane.add(lblServeurIntrouvable);
		
		this.btnRetour = new JButton("Retour");
		this.btnRetour.addActionListener(this);
		this.btnRetour.setBounds(126, 105, 89, 23);
		contentPane.add(this.btnRetour);
		
		/*this.btnRessayer = new JButton("Ressayer");
		this.btnRessayer.addActionListener(this);
		this.btnRessayer.setBounds(10, 174, 89, 23);
		contentPane.add(this.btnRessayer);*/
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == this.btnRetour){
			RejoindreUnePartie m = new RejoindreUnePartie(new Menu());
			m.setVisible(true);
			this.superOwner.dispose();
			this.dispose();
			
		}
		/*if(e.getSource()== this.btnRessayer){
			ConnectionAuServeur coServ = new ConnectionAuServeur(this.superOwner.IP,this.superOwner.port,this.superOwner.owner);
			coServ.setVisible(true);
			this.superOwner.dispose();
			this.dispose();
		}*/
	}
}
