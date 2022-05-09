class verification
{
	colonne[] col;		//tableau de 'colonne' faisant r�f�rence aux JPanel
	boolean trouve;		//vrai si on a trouv� un alignement
	
	int x,y;
	int alg;
	
	//constructeur de verification
	public verification(colonne[] c)
	{
		this.col=c;				//on effectue une r�f�rence vers les colonnes
		this.trouve=false;		//on n'a pas encore d'alignement
	}
	
	//**************************************************************************
	// V�rifie si 4 pions du joueur ayant le num�ro pass� en param�tre
	// sont align�s
	public boolean verifie(int joueur)
	{
		int posx,posy;	//position courante dans les cases
		boolean possible;	//vrai si C possible qu'il y ait un alignement � cette position
		int alg=0;			//valeur de l'alignement
		int savex=0,savey=0;
		int nbr=0;
		
		//test pour voir si 4 pions sont align�s horizontalement (6)
		
		//pour chaque ligne du puissance 4
		for (y=0;y<7 && !this.trouve;y++)
		{
			//on parcourt toutes les colonnes
			for (x=0;x<7 && !this.trouve;x++)
			{
				possible=true;
				nbr=0;
				//pour chaque case correspondant � l'alignement
				for (posx=x;possible && posx<x+4;posx++)
				{
					//l'alignement est possible si la valeur de la case
					//est la m�me que le num�ro du joueur
					
					//on effectue un try/carch, ainsi on n'a pas � se soucier des d�passement
					//de capacit� des tableaux
					try
					{
						possible=(col[posx].element(y)==joueur);
						nbr++;
					}
					//s'il y a une erreur c'est que l'alignement est impossible
					catch (Exception e)
					{
						possible=false;
					}
				}	
				
				//si on a trouv� 4 pions align�s
				if (possible && nbr==4)
				{
					//alors on a trouv� un alignement
					this.trouve=true;
					//on sauvegarde sa direction
					alg=6;
					//ainsi que ses coordonn�es de d�part
					savex=x;
					savey=y;
				}
			}	
		}
		
		//test pour voir si 4 pions sont align�s verticalement (8)
		for (x=0;x<7 && !this.trouve;x++)
		{
			for (y=0;y<7 && !this.trouve;y++)
			{
				possible=true;
				nbr=0;
				for (posy=y;posy<y+4 && possible;posy++)
				{
					try
					{
						possible=(col[x].element(posy)==joueur);
						nbr++;
					}
					catch (Exception e)
					{
						possible=false;
					}
				}
				
				if (possible && nbr==4)
				{
					this.trouve=true;
					alg=8;
					savex=x;
					savey=y;
				}
			}
		}
		
		//test pour voir si 4 pions sont align�s en diagonale (9)	
		for (x=0;x<7 && !this.trouve;x++)
		{
			for (y=0;y<7 && !this.trouve;y++)
			{
				possible=true;
				nbr=0;
				for (int i=0;possible && i<4;i++)
				{
					posx=x+i;
					posy=y+i;
					try
					{
						possible=(col[posx].element(posy)==joueur);
						nbr++;
					}
					catch (Exception e)
					{
						possible=false;
					}
				}
				
				if (possible && nbr==4)
				{
					this.trouve=true;
					alg=9;
					savex=x;
					savey=y;
				}
			}
		}
		
		//test pour voir si 4 pions sont align�s en diagonale (3)	
		for (x=0;x<7 && !this.trouve;x++)
		{
			for (y=6;y>=0 && !this.trouve;y--)
			{
				possible=true;
				nbr=0;
				
				for (int i=0;possible && i<4;i++)
				{
					posx=x+i;
					posy=y-i;
					
					try
					{
						possible=(col[posx].element(posy)==joueur);
						nbr++;
					}
					catch (Exception e)
					{
						possible=false;
					}
				}
				
				if (possible && nbr==4)
				{
					this.trouve=true;
					alg=3;
					savex=x;
					savey=y;
				}
			}
		}
			
		return this.trouve;				
	}
	
	//**************************************************************************
	//r�initialisation de la v�rification
	public void reinit()
	{
		this.trouve=false;
	}
}