/*******************************************************************************
 *																			   *
 * 							Puissance 4 v1.0								   *
 *																			   *
 *					réalisé par Cyril Kern "DeathAngel"						   *
 *							cyril.kern@free.fr								   *
 *																			   *
 *******************************************************************************/
 
 
 /* Régles du jeu :
  *
  *	Le puissance 4 est un jeu pour deux joueurs
  * Le but est d'aligner en premier 4 pions de sa couleur (bleu ou rouge)
  *
  * Chaque joueur joue à tour de rôle, la partie s'arrête dès que 4 pions sont alignés
  *
  */							


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Puissance4 extends JFrame
{
	public static void main(String[] args)
	{
		//appel de la JFrame joueur
		JFrame jf=new joueur();
		
		//on calcule ses dimensions et on l'affiche
		jf.pack();
		jf.setVisible(true);
		
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}