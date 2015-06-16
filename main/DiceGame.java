import model.*;

import java.util.ArrayList;
import java.lang.System;

public class DiceGame {

	public static void main(String[] args) {
		//horrible data in code don't look aaaahhh
		ArrayList<Face> f1 = new ArrayList<Face> ();
		f1.add(new Face(Colors.GREEN,Numbers.ONE));
		f1.add(new Face(Colors.GREEN,Numbers.TWO));
		f1.add(new Face(Colors.GREEN,Numbers.THREE));
		f1.add(new Face(Colors.GREEN,Numbers.FOUR));
		f1.add(new Face(Colors.GREEN,Numbers.FIVE));
		f1.add(new Face(Colors.GREEN,Numbers.SIX));
		System.out.println(f1);
		
		ArrayList<Face> f2 = new ArrayList<Face> ();
		f2.add(new Face(Colors.BLUE,Numbers.ONE));
		f2.add(new Face(Colors.BLUE,Numbers.TWO));
		f2.add(new Face(Colors.BLUE,Numbers.THREE));
		f2.add(new Face(Colors.BLUE,Numbers.FOUR));
		f2.add(new Face(Colors.BLUE,Numbers.FIVE));
		f2.add(new Face(Colors.BLUE,Numbers.SIX));
		System.out.println(f2);
		
		ArrayList<Face> f3 = new ArrayList<Face> ();
		f3.add(new Face(Colors.RED,Numbers.ONE));
		f3.add(new Face(Colors.RED,Numbers.TWO));
		f3.add(new Face(Colors.RED,Numbers.THREE));
		f3.add(new Face(Colors.RED,Numbers.FOUR));
		f3.add(new Face(Colors.RED,Numbers.FIVE));
		f3.add(new Face(Colors.RED,Numbers.SIX));
		System.out.println(f3);
		
		Die die1 = new Die(f1);
		Die die2 = new Die(f2);
		Die die3 = new Die(f3);
		
		System.out.println("These three should all be 1: ");
		System.out.println("	Die 1 top: " + die1.getTopFace());
		System.out.println("	Die 2 top: " + die2.getTopFace());
		System.out.println("	Die 3 top: " + die3.getTopFace());
		
		System.out.println("Now rolling all three: ");
		System.out.println(die1.roll());
		System.out.println(die2.roll());
		System.out.println(die3.roll());
		
		System.out.println("Now checking their faces (should be the same): ");
		System.out.println(die1.getTopFace());
		System.out.println(die2.getTopFace());
		System.out.println(die3.getTopFace());

	}

}
