package eu.deic.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.EOFException;

public class ProgMain {

	public static void main(String[] args) {
		String[] descs = new String[] { "Pen", "T-Shirt", "Mug" };
		int[] units = new int[] { 55, 40, 35 };
		float[] prices = new float[] { 43.50f, 68.22f, 40.15f };

		String filePath = "./invoices1.txt";

		DataOutputStream out = null;
		try {
			FileOutputStream fos = new FileOutputStream(filePath);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			out = new DataOutputStream(bos);

			for (var i = 0; i < descs.length; i++) {
				out.writeUTF(descs[i]);
				out.writeInt(units[i]);
				out.writeFloat(prices[i]);
				out.flush(); //golesteste buffer-ul
			}

			out.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		DataInputStream in = null;
		try {
			FileInputStream fis = new FileInputStream(filePath);
			BufferedInputStream bis = new BufferedInputStream(fis);
			in = new DataInputStream(bis);

			double total = 0.0;
			String desc = null; int unit = 0; float price = 0.0f;
			try {
				while (true) {
					desc = in.readUTF();
					unit = in.readInt();
					price = in.readFloat();
					total +=(unit * price);
					System.out.printf("%s had price %f and ordered quantity %d \n", desc, price, unit);
				}
		    } catch (EOFException eofe) {
		    	System.out.printf("Total= %f \n", total);
		    }

			in.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

	}// end main

}// end class
