package eu.deic.io;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.net.URL;

public class ProgMainSaveObjs {

	public static void main(String[] args) {
		System.out.println("Saving objects to storage...!");
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("objs4.txt"));
			URL wa1 = new URL("http://www.dice.ase.ro");
			URL wa2 = wa1;
			URL wa3 = wa1;
			ObjectsGraph og = new ObjectsGraph(wa1, wa2);
			
			out.writeObject(wa3);
			out.writeObject(og);
			boolean eb = (og.getO1()== og.getO2()) && (og.getO1() == wa3);
			System.out.println("eb = " + eb + ", og = " + og.toString() + ", wa3 = " + wa3);
			out.close();
			
			System.out.println("Finished writing objects!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}//end main

}//end class ProgMainSaveObjs
