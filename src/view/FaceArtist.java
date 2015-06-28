package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Arc2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.DiceGame;
import model.Face;
import model.Numbers;
import model.Symbols;
import static view.Constants.FACE_HEIGHT;
import static view.Constants.FACE_WIDTH;



class MyCanvas extends JComponent {

  public void paint(Graphics g) {
	  
	  
	  
  }
}

class FillRect {
  public static void main(String[] a) {
    JFrame window = new JFrame();
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setBounds(30, 30, 300, 300);
    window.getContentPane().add(new MyCanvas());
    window.setVisible(true);
  }
}





public class FaceArtist {

	//Flyweight factory for curved and straight arrows TODO  Will hope to add flyweight functionality later
	//but first we'll just draw the edges and get them looking right.
	private HashMap<Face, ImageIcon> faces = new HashMap<Face, ImageIcon>();
	private ArrayList<Line2D> lines = new ArrayList<Line2D>();
	
	
	//Instead of passing everything around, this seems cleaner, as long as it's handled carefully.
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	
	//the unit vector pointing from the source to the target.
	private double unitX;
	private double unitY;
	
	private ImageIcon symbolIcon;
	private Image symbolImage;
	private ImageIcon numberIcon;
	private Image numberImage;
	
	private Face face;
	
	//Needs reference to Neuron and Face maps and a place to draw
	private DiceGame game;
	private JPanel myPanel;
	
	public FaceArtist(DiceGame game, JPanel panel) {
		this.game = game;
		this.myPanel = panel;
	}
	
	
	//uses other functions to draw the approriate representation of the Face
	public void drawFace(Face face, Graphics2D g2d) {
		this.face = face;
		
		//draw Face
		drawSquare(g2d);
		//add Symbol
		drawSymbol(g2d);
		//add Number
		drawNumber(g2d);
	}
	
	public void drawSquare(Graphics2D g2d) {
		Color color = this.face.getColor().getColor();
		g2d.setColor(color);
		g2d.fillRect(0, 0, FACE_WIDTH, FACE_HEIGHT);
		
	}
	
	
	//turns a line or curve into an arrow
	public void drawSymbol(Graphics2D g2d) {
		
		
		//get the symbol image
		ClassLoader cl = getClass().getClassLoader();
		Symbols symbol = face.getSymbol();
		
		symbolIcon = new ImageIcon(cl.getResource(symbol.getPath()));
		symbolImage = symbolIcon.getImage();
		
		//translate to the intersection of the face with the target
		g2d.translate(x2, y2);
		//rotate the image to the slope of the chord that connects the two neurons' centers
		// positive because we are rotating the coordinate system
		g2d.rotate(Math.atan2(y2-y1,x2-x1) - Math.PI / 2 );
        //move to corner of where image will be
        g2d.translate(-1 * symbolIcon.getIconWidth() / 2, -1 * symbolIcon.getIconHeight());
        //draw image at origin
	    g2d.drawImage(symbolImage, 0,  0, myPanel);
	    //translate back to (x2,y2)
	    g2d.translate(symbolIcon.getIconWidth() / 2, symbolIcon.getIconHeight());
	    //rotate back
	    g2d.rotate(-1 * Math.atan2(y2-y1,x2-x1) + Math.PI / 2 );
	    //translate back
	    g2d.translate(-x2, -y2);
	}
	
	//turns a line or curve into an arrow
	public void drawNumber(Graphics2D g2d) {
		
		
		//get the number image
		ClassLoader cl = getClass().getClassLoader();
		Numbers number = this.face.getNumber();
		
		numberIcon = new ImageIcon(cl.getResource(number.getPath()));
		numberImage = numberIcon.getImage();
		
		//translate to the intersection of the face with the target
		g2d.translate(x2, y2);
		//rotate the image to the slope of the chord that connects the two neurons' centers
		// positive because we are rotating the coordinate system
		g2d.rotate(Math.atan2(y2-y1,x2-x1) - Math.PI / 2 );
        //move to corner of where image will be
        g2d.translate(-1 * numberIcon.getIconWidth() / 2, -1 * numberIcon.getIconHeight());
        //draw image at origin
	    g2d.drawImage(numberImage, 0,  0, myPanel);
	    //translate back to (x2,y2)
	    g2d.translate(numberIcon.getIconWidth() / 2, numberIcon.getIconHeight());
	    //rotate back
	    g2d.rotate(-1 * Math.atan2(y2-y1,x2-x1) + Math.PI / 2 );
	    //translate back
	    g2d.translate(-x2, -y2);
	}
	
}
