/*******************************************************************************
 * Interface graphique permettant de rentrer les noms des joueurs 			   *
 *******************************************************************************/

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class joueur extends JFrame
{
	String j1,j2;			//Chaine de caractère ou seront stockés les noms des jouers
	JTextField jtf_j1;		//JTextField ou seront entrés les noms des joueurs
	JTextField jtf_j2;
	joueur j;				//référence vers soi-même necessaire pour l'appel de puissance4IHM
	
	//Constructuer
	public joueur()		
	{
		//titre
		super("Joueurs");
		
		//référence vers soi
		j=this;
		
		//initialisation des JTextField
		jtf_j1=new JTextField(20);
		jtf_j2=new JTextField(20);
		
		//initialisation de JLAbel
		JLabel jl_j1=new JLabel("Joueur 1 : ");
		JLabel jl_j2=new JLabel("Joueur 2 : ");
		
		//Ecouteur du bouton OK
		ActionListener al_ok=new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				//on récupère les noms des deux joueurs
				j1=jtf_j1.getText();
				j2=jtf_j2.getText();
				
				//on cache la fenêtre courante
				setVisible(false);
				
				//Création de la JFrame du puissance 4
				JFrame jf=new puissance4IHM("Puissance 4",j);
				
				//calcul de la dimension de la JFrame
				jf.pack();
				//on rend visible la JFrame
				jf.setVisible(true);
				//on lui affecte l'opération de fermeture par défaut lorsqu'on
				//clique sur la croix
				jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				}
			};
		
		//création du bouton
		JButton jb_ok=new JButton("OK");
		
		//ajout de l'écouteur
		jb_ok.addActionListener(al_ok);
		
		//Création des JPanel
		JPanel jp1=new JPanel();
		JPanel jp2=new JPanel();
		JPanel jpb=new JPanel(); 
		
		
		//rajout des différents éléments dans les JPanel
		jp1.add(jl_j1);
		jp1.add(jtf_j1);
		jp2.add(jl_j2);
		jp2.add(jtf_j2);
		jpb.add(jb_ok);
		
		//Ajout des JPanel dans la JFrame
		this.getContentPane().add(jp1,BorderLayout.NORTH);
		this.getContentPane().add(jp2,BorderLayout.CENTER);
		this.getContentPane().add(jpb,BorderLayout.SOUTH);
	}
}