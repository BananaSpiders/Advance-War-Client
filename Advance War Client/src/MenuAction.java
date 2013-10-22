import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Color;


public class MenuAction extends JDialog {

	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					MenuAction frame = new MenuAction();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	
	private final JPanel contentPanel = new JPanel();

	Jeu3 owner;

	/**
	 * Create the dialog.
	 */
	public MenuAction(Jeu3 j) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuAction.class.getResource("/javax/swing/plaf/metal/icons/Question.gif")));
		setTitle("Action");
		setBounds(100, 100, 442, 324);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblAction = new JLabel("Action :");
		lblAction.setBounds(171, 11, 147, 36);
		lblAction.setFont(new Font("Tahoma", Font.BOLD, 21));
		contentPanel.add(lblAction);
		
		owner = j;
		
		JButton btnAttaquer = new JButton("Attaquer");
		btnAttaquer.setBounds(52, 85, 100, 23);
		btnAttaquer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
					//////////////////////////
					// ACTION Attaque
					/////////////////////////
				owner.setAttaque(true);
				owner.setModeDeplacement(false);
				close();
			}
		});
		contentPanel.add(btnAttaquer);
		
		JButton btnMine = new JButton("Mine");
		btnMine.setBounds(270, 85, 100, 23);
		btnMine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//////////////////////////
				// ACTION MINE
				/////////////////////////
				for(int i = 0; i<4;i++)
					for (Unite u : owner.getLesJoueurs().get(i).getListeUnites()) {
						if ((u.getPosX() == owner.caseCourante.getX())
								&& (u.getPosY()  == owner.caseCourante.getY())){// on cherche lunitee qui a pose une bombe
							System.out.println("Coucou =>"+u.isBombe());
							if(u.isBombe() == false){// si lunite est bien apte a poser une bombe
								int x =owner.caseCourante.getX();
								int y =owner.caseCourante.getY();
								// on ajoute une nouvelle mine a la case courante
								owner.caseCourante.setBombe(new Mine(x,y,owner.getNumeroJoueurLocal()-1));
								// on envoie aux autres que lon a capture cette ville
								x /= 30;
								y /= 30;
								String pos;
								if(x < 10)
									pos = "x0"+(x);
								else
									pos = "x"+(x);
								if(y < 10)
									pos += "y0"+(y);
								else
									pos += "y"+(y);
								// on transmet aux autres une nouvelle mine
								owner.owner.threadCo.getSocketOut().println("BOM"+owner.getNumeroJoueurLocal()+"NEW"+"MIN"+pos);// bom => bombe / min => mine / pos => x y
								
								u.setBombe(true);
							}
						}
					}
			
				close();
			}
		});
		contentPanel.add(btnMine);
		
		JLabel lblBombe = new JLabel("Bombe :");
		lblBombe.setBounds(255, 58, 89, 23);
		lblBombe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPanel.add(lblBombe);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 251, 416, 35);
			contentPanel.add(buttonPane);
			
			JButton btnRetour = new JButton("Retour");
			btnRetour.setBounds(301, 5, 105, 23);
			btnRetour.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					close();
				}
			});
			buttonPane.setLayout(null);
			
			JLabel lblAutre = new JLabel("Autre :");
			lblAutre.setBounds(10, 6, 42, 17);
			buttonPane.add(lblAutre);
			lblAutre.setFont(new Font("Tahoma", Font.PLAIN, 14));
			
			JButton btnPasser = new JButton("Passer son tour");
			btnPasser.setBounds(79, 5, 170, 23);
			buttonPane.add(btnPasser);
			btnPasser.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					close();
				}
			});
			buttonPane.add(btnRetour);
			
			JLabel label = new JLabel("-");
			label.setBounds(278, 9, 13, 14);
			buttonPane.add(label);
		}
		
		JLabel lblTir = new JLabel("Tir :");
		lblTir.setBounds(42, 58, 89, 23);
		lblTir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPanel.add(lblTir);
		
		JLabel label = new JLabel("|");
		label.setBounds(211, 114, 17, 14);
		contentPanel.add(label);
		
		JLabel label_1 = new JLabel("|");
		label_1.setBounds(211, 130, 17, 14);
		contentPanel.add(label_1);
		
		JLabel label_2 = new JLabel("|");
		label_2.setBounds(211, 99, 17, 14);
		contentPanel.add(label_2);
		
		JLabel label_3 = new JLabel("|");
		label_3.setBounds(211, 83, 17, 14);
		contentPanel.add(label_3);
		
		JLabel label_4 = new JLabel("|");
		label_4.setBounds(211, 148, 17, 14);
		contentPanel.add(label_4);
		
		JLabel label_5 = new JLabel("|");
		label_5.setBounds(211, 166, 17, 14);
		contentPanel.add(label_5);
	}
	public void close(){
		this.dispose();
	}
}
