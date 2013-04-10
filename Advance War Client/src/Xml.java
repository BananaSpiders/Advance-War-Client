import java.io.*;
import java.util.Iterator;
import java.util.List;


import org.jdom2.*;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.*;
/* Explications :
 * 
 *  Class util a la creation de map et stockages !
 *  
 *  Je pensai faire une sauvegarde genre : 
 *  
 *  <y id="0">
 *  	<x0>2</x1>
 *  	<x2>2</x2>
 *  	<x3>2</x3>
 *  </y>
 *  <y id="1">
 *  	<x0>2</x1>
 *  	<x2>2</x2>
 *  	<x3>2</x3>
 * 	</y>
 * etc ...
 * 
 * 	Chaque <xi></x> est un cellule de tableau ainsi le fichier de sauvegarde est propre et c'est du xml donc la classe :p
 * 
 * 	Vu que la map est compos�e de case, sois rocher, sois arbre, sois route, sois je sais pas quoi, 
 * 	on enregistre ce type de case dans les cellules du tableau a leurs positions et comme ca on c'est direct quoi est ou !
 * 
 * 	ps: ici je me suis dis que l'on pouvait enregistrer les types de cases en int (ex: 3=sapin / 6=route / 9=eau)
 * 		cependant on peut changer :)
 * 
 * 
 * 	Un grande partie du code n'est pas utilis� mais reste aparant si on y trouve un besoin
 * 	
 * USE :
 * */
//////////////////////////////////////////////////////////////////########
//																//
//								USE 							//
//																//
//////////////////////////////////////////////////////////////////########

//########################################################################
/*
 * 
 */
public class Xml
{
	//////////////////////////////////////////////////////////////////########
	//																//
	//								USE 							//
	//																//
	//////////////////////////////////////////////////////////////////########
	
	/*
	 * 
	 * 					ATTRIBUTS
	 * 
	 */
	//Nous allons commencer notre arborescence en cr�ant la racine XML
	//qui sera ici "personnes".
	static Element racine = new Element("map");

	//On cr�e un nouveau Document JDOM bas� sur la racine que l'on vient de cr�er
	static org.jdom2.Document document = new Document(racine);
	
	

	/*
	 * 
	 *  				CONSTRUCTEUR
	 * 
	 */
	public Xml(String nameFileXmlToRegister, Case[][] tabCaseMap)
	{
		//On cr�e un nouvel Element nom, on lui assigne du texte
		//et on l'ajoute en tant qu'Element de etudiant
		for(int yi=0; yi<tabCaseMap.length;yi++){
			Element y = new Element("y");
			//On cr�e un nouvel Attribut id et on l'ajoute � y
			//gr�ce � la m�thode setAttribute
			Attribute classe = new Attribute("id",yi+"");
			y.setAttribute(classe);

			for(int xi = 0; xi<tabCaseMap[0].length; xi++){
				Element nom = new Element("x"+xi);

				Element posX = new Element("case_x");
				posX.setText(tabCaseMap[yi][xi].getX()+"");
				Element posY = new Element("case_y");
				posY.setText(tabCaseMap[yi][xi].getY()+"");
				Element typeCase = new Element("case_type");
				typeCase.setText(tabCaseMap[yi][xi].getTypeCase()+"");
				Element appartient = new Element("appartient");
				appartient.setText(tabCaseMap[yi][xi].getAppartient()+"");
				nom.addContent(posX);
				nom.addContent(posY);
				nom.addContent(typeCase);
				nom.addContent(appartient);

				y.addContent(nom);
			}
			racine.addContent(y);
		}
		enregistre(nameFileXmlToRegister+"");
	}
	
	
	
	
	
	

	/*
	 * 
	 *  			LIRE FICHIER XML return tab2D de Case
	 * 
	 * 
	 */
	static Case[][] Deserialiser(String fichier) 
	{
		//On cr�e une instance de SAXBuilder
		SAXBuilder sxb = new SAXBuilder();
		// on initialise
		Document document = null;
		Element racine = null;
		Case[][] tabMap;
		System.out.println("map/"+fichier+".xml");
		System.out.println(fichier);
		try
		{
			//On cr�e un nouveau document JDOM avec en argument le fichier XML
			document = sxb.build(new File("map/"+fichier+".xml"));
		}
		catch(Exception e){}
		System.out.println("map/"+fichier+".xml");
		//On initialise un nouvel �l�ment racine avec l'�l�ment racine du document.
		if(document != null)
			racine = document.getRootElement();
		else
			System.out.println("Error lors de l'ouverture du fichier XML document => null");

		//On cr�e une List contenant tous les noeuds "y" de l'Element racine
		List listY = racine.getChildren("y");

		// Connaitre le nombre de Y
		List listCompteur = listY;
		Iterator iCompteur = listY.iterator();
		int compteurY=0;
		int xi=0;
		while(iCompteur.hasNext())
		{
			Element courant = (Element)iCompteur.next();
			xi=0;
			while(courant.getChild("x"+xi) != null){
				xi++;
			}
			compteurY++;
		}

		// On initialise le tableau avec le nombre d�l�ments qu'on a trouv�
		tabMap = new Case[compteurY][xi];
		//On cr�e un Iterator sur notre liste
		Iterator i = listY.iterator();
		compteurY=0;

		// Pour chaque Y(ligne)
		//( y1_X1|y1_X2|y1_X3|...
		//  y2_X1|y2_X2|y2_X3|...
		//  y3_X1|y3_X2|y3_X3|...)
		while(i.hasNext())
		{
			//On recr�e l'Element courant � chaque tour de boucle afin de
			//pouvoir utiliser les m�thodes propres aux Element comme :
			//s�lectionner un n�ud fils, modifier du texte, etc...
			Element courant = (Element)i.next();


			//Pour chaque X ( x1 |x2 |x3 |x4 |x5 |x6 )
			xi=0;
			while(courant.getChild("x"+xi) != null){
				tabMap[compteurY][xi] = new Case();
				//On affiche le nom de l��l�ment courant
				//System.out.println(courant.getChild("x"+xi).getText());

				// on rempli la bonne case du tableau en essayant de parser en int cet element 
				//du fichier XML si le parse rate on met le case du tableau a 0
				try{
					tabMap[compteurY][xi].setX(Integer.parseInt(courant.getChild("x"+xi).getChild("case_x").getText()));
					tabMap[compteurY][xi].setY(Integer.parseInt(courant.getChild("x"+xi).getChild("case_y").getText()));
					String sTypeCase = courant.getChild("x"+xi).getChild("case_type").getText().toUpperCase();
					tabMap[compteurY][xi].setTypeCase(TypeCase.valueOf(sTypeCase)  );
					tabMap[compteurY][xi].setAppartient(Integer.parseInt(courant.getChild("x"+xi).getChild("appartient").getText()));
				}
				catch(Exception e){
					System.out.println("Exception :"+e+" (la case a etait mise a 0 par defaut).");
					tabMap[compteurY][xi].setX(0);
					tabMap[compteurY][xi].setY(0);
					tabMap[compteurY][xi].setTypeCase(TypeCase.HERBE);
					tabMap[compteurY][xi].setAppartient(0);
				}
				xi++;
			}
			compteurY++;

		}
		return tabMap;
	}
	//########################################################################


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/////#######################################################################################################
	/////#######################################################################################################
	/////#######################################################################################################
	/////#######################################################################################################
	/////#######################################################################################################
	/////#######################################################################################################
	/////#################################							############################################
	/////#################################		Code MORT			############################################
	/////#################################							############################################
	/////#################################							############################################
	/////#######################################################################################################
	/////#######################################################################################################
	/////#######################################################################################################
	/////#######################################################################################################
	/////#######################################################################################################
	/////#######################################################################################################
	/////#######################################################################################################
	/////#######################################################################################################
	/////#######################################################################################################

	//////////////////////////////////////////////////////////////////
	/// CONSTRUCTEURS
	////////////////////////////////////////////////////////////////////
	/*
	 * Constructeur par defaut
	 */
	public Xml()
	{

		//On cr�e un nouvel Element on lui assigne du texte
		//et on l'ajoute en tant qu'Element de map
		for(int yi=0; yi<10;yi++){
			Element y = new Element("y");
			//On cr�e un nouvel Attribut id et on l'ajoute � y
			//gr�ce � la m�thode setAttribute
			Attribute classe = new Attribute("id",yi+"");
			y.setAttribute(classe);
			racine.addContent(y);
			for(int xi = 0; xi<10; xi++){
				Element nom = new Element("x"+xi);
				nom.setText("0");
				y.addContent(nom);
			}
		}
		enregistre("mapDefaut.xml");
	}
	/*
	 * Constructeur 3 param�tre (cazy inutile)
	 */
	public Xml(int taille_X, int taille_Y, String nameFileXmlToRegister)
	{
		for(int yi=0; yi<taille_Y;yi++){
			Element y = new Element("y");
			Attribute classe = new Attribute("id",yi+"");
			y.setAttribute(classe);
			racine.addContent(y);
			for(int xi = 0; xi<taille_X; xi++){
				Element nom = new Element("x"+xi);
				nom.setText("0");
				y.addContent(nom);
			}
		}

		enregistre(nameFileXmlToRegister+"");

	}
	//////////////////////////////////////////////////////////////////
	/// CONSTRUCTEURS A UTILISER POUR CREER FACILLEMENT UN FICHIER XML => Acces sur les fichiers de sauvegarde de map car tab2D en param�tre
	////////////////////////////////////////////////////////////////////
	/*
	 * Constructeur 2 param�tres => GOOD <3
	 *  1 : nom du fichier xml que lon veut cr�er
	 *  2 : tableau int deux dimension /!\ premiere les Y deuxieme les X 
	 */
	public Xml(String nameFileXmlToRegister, int[][] tabDeuxDim1Y2X)
	{
		//On cr�e un nouvel Element nom, on lui assigne du texte
		//et on l'ajoute en tant qu'Element de etudiant
		for(int yi=0; yi<tabDeuxDim1Y2X.length-1;yi++){
			Element y = new Element("y");
			//On cr�e un nouvel Attribut id et on l'ajoute � y
			//gr�ce � la m�thode setAttribute
			Attribute classe = new Attribute("id",yi+"");
			y.setAttribute(classe);
			racine.addContent(y);
			for(int xi = 0; xi<tabDeuxDim1Y2X[0].length-1; xi++){
				Element nom = new Element("x"+xi);
				nom.setText(""+tabDeuxDim1Y2X[yi][xi]);
				y.addContent(nom);
			}
		}
		enregistre(nameFileXmlToRegister+"");
	}

	/////////////////////////////////////////////////////////////////////////////////////////////
	// ENREGISTRER FICHIER XML
	////////////////////////////////////////////////////////////////////////////////////////////
	static void enregistre(String fichier)
	{
		try
		{
			//On utilise ici un affichage classique avec getPrettyFormat()
			XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());

			sortie.output(document, new FileOutputStream(fichier));
		}
		catch (java.io.IOException e){
			System.out.println("IOException :"+e);
		}
	}

	/////////////////////////////////////////////////////////////////////////////////////////////
	// LIRE FICHIER XML return tab2D de int
	////////////////////////////////////////////////////////////////////////////////////////////
	static int[][] lireFichier(String fichier) 
	{
		//On cr�e une instance de SAXBuilder
		SAXBuilder sxb = new SAXBuilder();
		// on initialise
		Document document = null;
		Element racine = null;
		int[][] tabMap;
		try
		{
			//On cr�e un nouveau document JDOM avec en argument le fichier XML
			document = sxb.build(new File("map1.xml"));
		}
		catch(Exception e){}

		//On initialise un nouvel �l�ment racine avec l'�l�ment racine du document.
		if(document != null)
			racine = document.getRootElement();
		else
			System.out.println("Error lors de l'ouverture du fichier XML document => null");

		//On cr�e une List contenant tous les noeuds "y" de l'Element racine
		List listY = racine.getChildren("y");

		// Connaitre le nombre de Y
		List listCompteur = listY;
		Iterator iCompteur = listY.iterator();
		int compteurY=0;
		while(iCompteur.hasNext())
		{
			Element courant = (Element)iCompteur.next();
			compteurY++;
		}

		// On initialise le tableau avec le nombre d�l�ments qu'on a trouv�
		tabMap = new int[compteurY][listY.size()];


		//On cr�e un Iterator sur notre liste
		Iterator i = listY.iterator();
		compteurY=0;

		// Pour chaque Y(ligne)
		//( y1_X1|y1_X2|y1_X3|...
		//  y2_X1|y2_X2|y2_X3|...
		//  y3_X1|y3_X2|y3_X3|...)
		while(i.hasNext())
		{
			//On recr�e l'Element courant � chaque tour de boucle afin de
			//pouvoir utiliser les m�thodes propres aux Element comme :
			//s�lectionner un n�ud fils, modifier du texte, etc...
			Element courant = (Element)i.next();

			//System.out.println("Size "+compteurY+":"+listY.size());

			//Pour chaque X ( x1 |x2 |x3 |x4 |x5 |x6 )
			for(int xi=0;xi<listY.size();xi++){

				//On affiche le nom de l��l�ment courant
				//System.out.println(courant.getChild("x"+xi).getText());

				// on rempli la bonne case du tableau en essayant de parser en int cet element 
				//du fichier XML si le parse rate on met le case du tableau a 0
				try{
					tabMap[compteurY][xi]=Integer.parseInt(courant.getChild("x"+xi).getText());
				}
				catch(Exception e){
					System.out.println("Exception :"+e+" (la case a etait mise a 0 par defaut).");
					tabMap[compteurY][xi]=0;
				}
			}
			compteurY++;

		}
		return tabMap;
	}

	/////////////////////////////////////////////////////////////////////////////////////////////
	//AFFICHE FICHIER XML
	////////////////////////////////////////////////////////////////////////////////////////////
	//Ajouter ces deux m�thodes � notre classe JDOM1
	static void affiche()
	{
		try
		{
			//On utilise ici un affichage classique avec getPrettyFormat()
			XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
			sortie.output(document, System.out);
		}
		catch (java.io.IOException e){
			System.out.println("Exception :"+e);
		}
	}


}
