package view;

import static view.Constants.FRAME_HEIGHT;
import static view.Constants.FRAME_WIDTH;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListModel;

import model.Colors;
import model.Die;
import model.Face;
import model.Numbers;

@SuppressWarnings("serial")
public class DraftFrame extends JFrame {

	/** Panel for holding all the components. */
	private JPanel draftPanel = new JPanel();
	
	/**
	 * Constructor: Gets called whenever an object of this class is initialized.
	 * Also sets the frame properties.
	 */
	public DraftFrame() {
		initUI();
		this.setTitle("Choose Wisely");
		this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		this.add(draftPanel);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
	}
	
	/**
	 * Method to initialize the frame contents and components like the combo
	 * boxes, buttons etc.
	 */
	private void initUI() {
		draftPanel.setLayout(new GridBagLayout());

		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.insets = new Insets(10, 1, 10, 1);
		gridBagConstraints.anchor = GridBagConstraints.NORTH;
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		
		draftPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		
		gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
		gridBagConstraints.gridy = 0;
		JLabel title = new JLabel("Your Turn To Pick");
		title.setFont(new Font("Serif", Font.BOLD, 36));
		draftPanel.add(title, gridBagConstraints);
		
		gridBagConstraints.anchor = GridBagConstraints.WEST;
		
		gridBagConstraints.gridwidth = GridBagConstraints.RELATIVE;
		gridBagConstraints.gridy = 1;
		JLabel lblDiceHand = new JLabel("Available Dice: ");
		lblDiceHand.setFont(new Font("Serif", Font.PLAIN, 18));
		draftPanel.add(lblDiceHand, gridBagConstraints);
		gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
		
		//all for testing
		ArrayList<Face> tempFaceList1 = new ArrayList<Face>();
		tempFaceList1.add(new Face(Colors.GREEN,Numbers.ONE));
		tempFaceList1.add(new Face(Colors.GREEN,Numbers.TWO));
		ArrayList<Face> tempFaceList2 = new ArrayList<Face>();
		tempFaceList2.add(new Face(Colors.BLUE,Numbers.THREE));
		tempFaceList2.add(new Face(Colors.BLUE,Numbers.FOUR));
		Vector<Die> tempDieList = new Vector<Die>();
		tempDieList.add(new Die("1", tempFaceList1));
		tempDieList.add(new Die("2", tempFaceList2));
		JList diceHand = new JList(tempDieList);
		draftPanel.add(diceHand, gridBagConstraints);
		
		gridBagConstraints.gridwidth = GridBagConstraints.RELATIVE;
		gridBagConstraints.gridy = 2;
		JLabel lblDiceFaces = new JLabel("Die Faces: ");
		lblDiceFaces.setFont(new Font("Serif", Font.PLAIN, 18));
		draftPanel.add(lblDiceFaces, gridBagConstraints);
		//combo has list of dice, list has list of faces on selected die
		//gridBagConstraints.gridx = 1;
		gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
		Vector <Face> omg = new Vector<Face>();
		omg.add(new Face(Colors.RED,Numbers.ONE));
		omg.add(new Face(Colors.RED,Numbers.ONE));
		JList dieFaces = new JList(omg);
		draftPanel.add(dieFaces, gridBagConstraints);
	}
}
