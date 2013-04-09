import java.awt.BorderLayout;
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


public class MenuAction extends JDialog {

	private final JPanel contentPanel = new JPanel();

	Jeu3 owner;

	/**
	 * Create the dialog.
	 */
	public MenuAction(Jeu3 j) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuAction.class.getResource("/javax/swing/plaf/metal/icons/Question.gif")));
		setTitle("Action");
		setBounds(100, 100, 180, 224);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblAction = new JLabel("Action :");
		lblAction.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAction.setBounds(49, 11, 80, 33);
		contentPanel.add(lblAction);
		
		owner = j;
		
		JButton btnAttaquer = new JButton("Attaquer");
		btnAttaquer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				owner.setAttaque(true);
				owner.setModeDeplacement(false);
				close();
			}
		});
		btnAttaquer.setBounds(40, 55, 100, 23);
		contentPanel.add(btnAttaquer);
		
		JButton btnPasser = new JButton("Passer");
		btnPasser.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				close();
			}
		});
		btnPasser.setBounds(40, 99, 100, 23);
		contentPanel.add(btnPasser);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			JButton btnRetour = new JButton("Retour");
			btnRetour.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					close();
				}
			});
			buttonPane.add(btnRetour);
		}
	}
	public void close(){
		this.dispose();
	}


}
