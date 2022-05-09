/************************************
 * IHM du programme de puissance 4 	*
 ************************************/			


import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class puissance4IHM extends JFrame
{
	JPanel tout;		//JPanel contenant toutes les colonnes du puissance 4
	colonne[] col;		//tableau de 'colonne' contenant les r�f�rences vers chaque objet 'colonne'
	int joueurCur;		//num�ro du joueur courant (1 ou 2)
	verification v;
	joueur j;
	JLabel jl;

	String defaut="C'est le tour de ";
	
	//constructeur de l'IHM principale
	public puissance4IHM(String titre,joueur jo)
	{
		//affectation du titre � la Frame
		super(titre);
	
		this.j=jo;
		
		//Le joueur courant est le joueur 1
		this.joueurCur=1;
		
		//instanciation du JPanel g�n�ral 
		this.tout=new JPanel(new GridLayout(1,7));

		//instanciation du tableau de 'colonne'
		this.col=new colonne[7];
		
		//pour toutes les colonnes du puissance 4
		for (int i=0;i<7;i++)
		{
			//on cr�e un nouvel objet colonne
			this.col[i]=new colonne(this);
			//et on r�cup�re le JPanel correspondant qu'on ajoute dans 'tout'
			(this.tout).add((this.col[i]).renvoyer());
		}
		
		//Cr�ation d'une instance de v�rification
		v=new verification(this.col);

		jl=new JLabel(defaut + this.j.j1);
		
		JPanel jpl=new JPanel();
		jpl.add(jl);
		
		//ajout de 'tout' dans la JFrame principale
		this.getContentPane().add(this.tout,BorderLayout.CENTER);
		this.getContentPane().add(jpl,BorderLayout.SOUTH);
	}


	
	
	//**************************************************************************
	// R�initialisation du programme
	public void reinit()
	{
		//on r�inititalise la v�rification
		v.reinit();
		
		//on r�initialise les colonnes
		for (int i=0;i<7;i++)
		{
			this.col[i].reinit();
		}
		
		if (joueurCur==1)
		{
			jl.setText(defaut+j.j1);
		}
		else
		{
			jl.setText(defaut+j.j2);
		}
	}
}