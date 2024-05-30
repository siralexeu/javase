package eu.deic.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Invoice {
	
	private String[] descs;
	private int[] units;
	private float[] prices;

	public Invoice(String[] descs, int[] units, float[] prices) {
		this.descs = descs;
		this.units = units;
		this.prices = prices;
	}

	public void save2File(String filePath) {
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
		
	}

	public double readFromFileAndDoTotal(String filePath) {
		double total = 0.0;
		DataInputStream in = null;
		try {
			FileInputStream fis = new FileInputStream(filePath);
			BufferedInputStream bis = new BufferedInputStream(fis);
			in = new DataInputStream(bis);

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
		return total;
	}
	

}
