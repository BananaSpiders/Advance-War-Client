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


public class Victoire extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Victoire frame = new Victoire();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	private Jeu3 owner;
	public Victoire(Jeu3 owner) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Victoire.class.getResource("/javax/swing/plaf/metal/icons/Warn.gif")));
		setTitle("Victoire !");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 426, 212);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		this.owner=owner;
		
		JLabel lblVictoire = new JLabel("Victoire !");
		lblVictoire.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblVictoire.setBounds(126, 11, 189, 60);
		contentPane.add(lblVictoire);
		
		JButton btnRetourAuMenu = new JButton("Retour Menu");
		btnRetourAuMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ownerClose();
				Menu m = new Menu();
				m.setVisible(true);
				close();
			}
		});
		btnRetourAuMenu.setBounds(126, 120, 144, 23);
		contentPane.add(btnRetourAuMenu);
	}
	public void close(){
		this.dispose();
	}
	public void ownerClose(){
		this.owner.dispose();
	}
}
