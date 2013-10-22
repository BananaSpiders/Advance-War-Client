import java.awt.EventQueue;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class Option extends JFrame implements ActionListener{

	private JPanel contentPane;
	private Clip clip;
	private JTextField txtUnknowPlayer = new JTextField();;
	private JButton btnRetourMenu = new JButton("Quitter options");
	private JButton testSon = new JButton("<3");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Option frame = new Option();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Option() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTestSonore = new JLabel("Test sonore");
		lblTestSonore.setForeground(Color.WHITE);
		lblTestSonore.setBounds(21, 119, 133, 14);
		contentPane.add(lblTestSonore);
		testSon.addActionListener(this);
		
		testSon.setBounds(181, 115, 89, 23);
		contentPane.add(testSon);
		
		JLabel lblPseudo = new JLabel("Pseudo du joueur");
		lblPseudo.setForeground(Color.WHITE);
		lblPseudo.setBounds(21, 58, 133, 14);
		contentPane.add(lblPseudo);
		
		txtUnknowPlayer.setHorizontalAlignment(SwingConstants.CENTER);
		txtUnknowPlayer.setText("Joueur ");
		txtUnknowPlayer.setBounds(181, 55, 89, 20);
		contentPane.add(txtUnknowPlayer);
		txtUnknowPlayer.setColumns(10);
		
		btnRetourMenu.setBounds(266, 209, 124, 23);
		contentPane.add(btnRetourMenu);
		btnRetourMenu.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.btnRetourMenu)
		{	playsound("Buit menu.wav");
			this.dispose();}
		if(e.getSource()==this.testSon)
		{	playsound("mec qui meurt.wav");	}
		
	}
	
	
	public   void playsound(String c)
	   {
	   try {
	         // Open an audio input stream.
	         File soundFile = new File(c);
			 AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
	         // Get a sound clip resource.
	         this.clip = AudioSystem.getClip();
	         // Open audio clip and load samples from the audio input stream.
	         this.clip.open(audioIn);
			 this.clip.start();
	      } catch (UnsupportedAudioFileException e) {
	         e.printStackTrace();
	      } catch (IOException e) {
	         e.printStackTrace();
	      } catch (LineUnavailableException e) {
	         e.printStackTrace();
	      }
		}
}
