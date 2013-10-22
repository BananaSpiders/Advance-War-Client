import java.io.*;
import java.net.*;


/**
 * 
 * Cette classe repr�sente un thread associ� � UN client, elle est cr��e par Serveur2D.
 * Son r�le est d'attendre les messages du client et de le renvoyer � tous les autres clients.
 *  
 * @author Geoffrey Yoccoz
 * @see ServeurAW
 */

public class ThreadClient extends Thread {

		private boolean running; 
		private Socket socket;
		private String strIn;
		private int numClient;
		private ServeurAW serveur;
		private PrintWriter sockOut;
		private BufferedReader sockIn;
		
		public PrintWriter getSockOut()
		{
			return this.sockOut;
		}
		public BufferedReader getSockIn()
		{
			return this.sockIn;
		}
		
		public Socket getSocket()
		{
			return this.socket;
		}
		
		public ThreadClient(Socket client,int numClient, ServeurAW serveur)
		{
			this.running = true;
			this.socket = client;
			this.serveur = serveur;
			this.numClient = numClient;
			
			try
			{
				/*Flux entree/sortie*/
				this.sockIn = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
				this.sockOut = new PrintWriter(this.socket.getOutputStream(),true);
//								
			}
			catch(IOException e)
			{
				System.out.println("Erreur thread client !");
				e.printStackTrace();
			}
		}

		public void run()
		{
			while(this.running)
			{
				try
				{
					this.strIn = this.sockIn.readLine();
					this.serveur.sendToAllClients(this.numClient, strIn);
				} catch (IOException e)
				{
					// TODO Bloc catch g�n�r� automatiquement
					e.printStackTrace();
					this.running = false;
				}
				
			}
		}

		
		
		
}
