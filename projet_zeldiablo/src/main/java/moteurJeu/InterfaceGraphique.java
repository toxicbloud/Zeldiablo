package moteurJeu;

import javax.swing.JFrame;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import com.DessinJeu;


/**
 * cree une interface graphique avec son controleur et son afficheur
 * @author Graou
 *
 */
public class InterfaceGraphique  {

	/**
	 * le Panel lie a la JFrame
	 */
	private PanelDessin panel;
	
	/**
	 * le controleur lie a la JFrame
	 */
	private Controleur controleur;

	/** Frame du jeu */
	JFrame f;
	
	/**
	 * la construction de l'interface grpahique
	 * - construit la JFrame
	 * - construit les Attributs
	 * 
	 * @param afficheurUtil l'afficheur a utiliser dans le moteur
	 * 
	 */
	public InterfaceGraphique(moteurJeu.DessinJeu afficheurUtil,int x,int y)
	{
		//creation JFrame
		f=new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// creation panel
		this.panel=new PanelDessin(x, y,afficheurUtil);
		f.setContentPane(this.panel);

		final DessinJeu dj = (DessinJeu) afficheurUtil;
		
		//ajout du controleur
		Controleur controlleurGraph=new Controleur();
		this.controleur=controlleurGraph;
		this.panel.addKeyListener(controlleurGraph);
		this.panel.addMouseListener(new MouseListener(){
			@Override
			public void mouseClicked(MouseEvent e) {
				dj.onclick(e.getX(), e.getY());
			}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseReleased(MouseEvent e) {}
		});
		
		//recuperation du focus
		f.pack();
		f.getContentPane().setFocusable(true);
		f.getContentPane().requestFocus();

		f.setVisible(true);
		
	}
	
	
	/**
	 * retourne le controleur de l'affichage construit
	 * @return
	 */
	public Controleur getControleur() {
		return controleur;
	}

	/**
	 * demande la mise a jour du dessin
	 */
	public void dessiner() {
		this.panel.dessinerJeu();	
	}

	public void quit() {
		System.exit(0);
	}
	
}
