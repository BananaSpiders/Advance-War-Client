import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.Box;


public class JoueurLocalPerdu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JoueurLocalPerdu frame = new JoueurLocalPerdu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	private Jeu3 owner;
	public JoueurLocalPerdu(Jeu3 owner) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(JoueurLocalPerdu.class.getResource("/javax/swing/plaf/metal/icons/ocean/warning.png")));
		setTitle("End..");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 242);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		this.owner = owner;
		
		
		JLabel lblVousAvezPerdu = new JLabel("Vous avez perdu !");
		lblVousAvezPerdu.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblVousAvezPerdu.setBounds(97, 21, 327, 88);
		contentPane.add(lblVousAvezPerdu);
		
		JButton btnRetourAuMenu = new JButton("Retour au menu");
		btnRetourAuMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeOwner();
				Menu m = new Menu();
				m.setVisible(true);
				close();
			}
		});
		btnRetourAuMenu.setBounds(254, 139, 157, 23);
		contentPane.add(btnRetourAuMenu);
		
		JButton btnModeObservateur = new JButton("Mode observateur");
		btnModeObservateur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				close();
			}
		});
		btnModeObservateur.setBounds(29, 139, 157, 23);
		contentPane.add(btnModeObservateur);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		horizontalStrut.setBounds(-21, 112, 445, 1);
		contentPane.add(horizontalStrut);
		
		JLabel label = new JLabel("-");
		label.setBounds(215, 143, 25, 14);
		contentPane.add(label);
	}
	
	public void close(){
		this.dispose();
	}
	public void closeOwner(){
		this.owner.dispose();
	}
}
