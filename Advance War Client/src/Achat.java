import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class Achat extends JDialog {

	private final JPanel contentPanel = new JPanel();

	public static void main(String[] args) {
		try {
			/*
			 * Achat dialog = new Achat();
			 * dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			 * dialog.setVisible(true);
			 */
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private JLabel label;
	private int argent;
	private int numJoueur;
	private Joueur j;
	private Case c;
	private Jeu3 notreJeu;

	/**
	 * Create the dialog.
	 */
	public Achat(Jeu3 jeu,Joueur j,Case c) {
		setIconImage(Toolkit
				.getDefaultToolkit()
				.getImage(
						Achat.class
								.getResource("/javax/swing/plaf/metal/icons/Question.gif")));
		setTitle("Achat");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setVisible(true);
		setResizable(false);

		this.j = j;
		this.c = c;
		this.notreJeu = jeu;

		this.argent = j.getArgent();
		this.numJoueur = j.getID()+1;

		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblArgent = new JLabel("Argent :");
		lblArgent.setBounds(290, 11, 65, 14);
		contentPanel.add(lblArgent);

		this.label = new JLabel(this.argent + "$");
		label.setBounds(348, 11, 76, 14);
		contentPanel.add(label);
		{
			JLabel lblQueVoulezvousAcheter = new JLabel(
					"Que voulez-vous acheter ?");
			lblQueVoulezvousAcheter.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblQueVoulezvousAcheter.setBounds(110, 36, 250, 19);
			contentPanel.add(lblQueVoulezvousAcheter);
		}

		JButton btnBazooka = new JButton("Bazooka");
		btnBazooka.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				achat(300);
			}
		});
		btnBazooka.setBounds(30, 120, 100, 23);
		contentPanel.add(btnBazooka);

		JButton btnFusillier = new JButton("Fusillier");
		btnFusillier.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				achat(100);
			}
		});
		btnFusillier.setBounds(30, 156, 100, 23);
		contentPanel.add(btnFusillier);

		JButton btnJeep = new JButton("Jeep");
		btnJeep.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				achat(500);
			}
		});
		btnJeep.setBounds(230, 190, 100, 23);
		contentPanel.add(btnJeep);

		JButton btnTank = new JButton("Tank");
		btnTank.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				achat(800);

			}
		});
		btnTank.setBounds(230, 120, 100, 23);
		contentPanel.add(btnTank);

		JButton btnArtillerie = new JButton("Artillerie");
		btnArtillerie.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				achat(1000);
			}
		});
		btnArtillerie.setBounds(230, 156, 100, 23);
		contentPanel.add(btnArtillerie);

		JLabel lblInfantrie = new JLabel("Infanterie :");
		lblInfantrie.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblInfantrie.setBounds(56, 73, 76, 14);
		contentPanel.add(lblInfantrie);

		JLabel lblVhicule = new JLabel("V\u00E9hicule :");
		lblVhicule.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblVhicule.setBounds(269, 73, 70, 16);
		contentPanel.add(lblVhicule);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(this.getClass().getResource(
				this.numJoueur + "_bazooka.png")));
		label_1.setBounds(142, 113, 30, 30);
		contentPanel.add(label_1);

		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(this.getClass().getResource(
				this.numJoueur + "_fusilier.png")));
		label_2.setBounds(142, 149, 30, 30);
		contentPanel.add(label_2);

		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(this.getClass().getResource(
				this.numJoueur + "_tank.png")));
		label_3.setBounds(348, 113, 30, 30);
		contentPanel.add(label_3);

		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(this.getClass().getResource(
				this.numJoueur + "_artillerie.png")));
		label_4.setBounds(348, 149, 30, 30);
		contentPanel.add(label_4);

		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(this.getClass().getResource(
				this.numJoueur + "_jeep.png")));
		label_5.setBounds(348, 183, 30, 30);
		contentPanel.add(label_5);

		JLabel label_6 = new JLabel("300");
		label_6.setBounds(182, 124, 38, 14);
		contentPanel.add(label_6);

		JLabel label_7 = new JLabel("100");
		label_7.setBounds(182, 160, 38, 14);
		contentPanel.add(label_7);

		JLabel label_8 = new JLabel("800");
		label_8.setBounds(388, 124, 38, 14);
		contentPanel.add(label_8);

		JLabel label_9 = new JLabel("1000");
		label_9.setBounds(386, 160, 38, 14);
		contentPanel.add(label_9);

		JLabel label_10 = new JLabel("500");
		label_10.setBounds(388, 194, 24, 14);
		contentPanel.add(label_10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);

			JButton btnAnnuler = new JButton("Annuler");
			btnAnnuler.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					closeAchat();
				}
			});
			buttonPane.add(btnAnnuler);
		}
	}

	public void closeAchat() {
		this.dispose();
	}

	public void achat(int prix) {
		int resultat = this.argent - prix;
		if (resultat < 0) {
			JOptionPane.showMessageDialog(null, "Cout : " + prix
					+ "\nVous n'avez pas assez d'argent...", "Attention !",
					JOptionPane.ERROR_MESSAGE);
		} else {
			this.j.setArgent(resultat);
			this.dispose();
			String unitName = new String();
			switch (prix) {
			case 100: 
//				System.out.println(" "+j+" "+j.getListeUnites()+" ");
//				System.out.println(" "+c+" "+c.getX()+" "+c.getY());
				j.getListeUnites().add(new Fusilier(c.getX(), c.getY()));   //this.j.getListeUnites().add())// a acheté un fusillier
				unitName = "Fusillier";
				break;
			case 300: j.getListeUnites().add(new Bazooka(c.getX(), c.getY()));// a acheté un bazooka
				unitName = "Bazooka";
				break;
			case 500: j.getListeUnites().add(new Jeep(c.getX(), c.getY()));// a acheté une jeep
				unitName = "Jeep";
				break;
			case 800: j.getListeUnites().add(new Tank(c.getX(), c.getY()));// a acheté un tank
				unitName = "Tank";
				break;
			case 1000: j.getListeUnites().add(new Artillerie(c.getX(), c.getY()));// a acheté un artilerie
			unitName = "Artillerie";
				break;

			default: System.out.println("Bonjour , je suis le default du switch à la fin de \"Achat\" Salut et à A+");
				break;
			}
			String pos;
			if(c.getX()/30 < 10)
				pos = "x0"+(c.getX()/30);
			else
				pos = "x"+(c.getX()/30);
			if(c.getY()/30 < 10)
				pos += "y0"+(c.getY()/30);
			else
				pos += "y"+(c.getY()/30);
			this.notreJeu.getOwner().threadCo.getSocketOut().println("ACH"+(this.j.getID()+1)+pos+unitName);
		}
	}
}
