/*******************************************************************************
 * Fen�tre qui s'affiche lorsque l'un des deux joueurs gagne la partie		   *
 *******************************************************************************/

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class gagne extends JFrame
{
	puissance4IHM puis;		//r�f�rence vers l'IHM appelante
	
	//constructeur
	public gagne(int i,puissance4IHM p)
	{
		//affectation du titre
		super("Gagn� !");
		
		//r�f�rence vers l'IHM
		this.puis=p;
		
		//�couteur pour le bouton nouvelle partie
		ActionListener al_new=new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				//on r�inititalise le programme
				puis.reinit();
				
				//on cache la bo�te de dialogue courante
				setVisible(false);
			}
		};
		
		//�couteur pour le bouton quitter
		ActionListener al_quit=new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				//on quitte le programme
				System.exit(0);
			}
		};
		
		//cr�ation des boutons nouvelle partie et quitter
		JButton jb_new=new JButton("Nouvelle partie");
		JButton jb_quitter=new JButton("Quitter");
		
		//ajout des �couteurs
		jb_new.addActionListener(al_new);
		jb_quitter.addActionListener(al_quit);
		
		//Cr�ation du JPanel qui contiendra les boutons et ajout des boutons
		JPanel jp_bouton=new JPanel();
		jp_bouton.add(jb_new);
		jp_bouton.add(jb_quitter);
		
		String nom="";
		
		//Cr�ation des JLabel contenant le texte de victoire
		if (i==1)
			nom=puis.j.j1;
		else
			nom=puis.j.j2;
		
		JLabel jl=new JLabel("F�licitations "+nom+" !",(int) JLabel.CENTER_ALIGNMENT);
		JLabel jl2=new JLabel("Vous avez gagn� !", (int) JLabel.CENTER_ALIGNMENT);
		
		//Cr�ation des JLabel contenant les images
		JLabel jl_etoile=new JLabel(new ImageIcon("image/etoile.gif"));
		JLabel jl_etoile2=new JLabel(new ImageIcon("image/etoile2.gif"));
		
		//Cr�ation des JPanel
		JPanel jp=new JPanel(new BorderLayout());
		JPanel jp2=new JPanel(new BorderLayout());
		
		//ajout des �toiles
		jp.add(jl_etoile,BorderLayout.EAST);
		jp.add(jl_etoile2,BorderLayout.WEST);
		
		//ajout des textes et des boutons
		jp2.add(jl,BorderLayout.NORTH);
		jp2.add(jl2,BorderLayout.CENTER);
		jp2.add(jp_bouton,BorderLayout.SOUTH);
		
		//r�union des deux JPanel
		jp.add(jp2,BorderLayout.CENTER);
		
		//affectation du JPanel � la JFrame
		this.getContentPane().add(jp);
	}
}