package eu.ase.io;

import java.io.BufferedInputStream;
import java.io.*;
import java.util.Arrays;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

// create Invoice class which contains:
// A. Fields:
// A.1 - prices: double[]
// A.2 - units: int[]
// A.3 - descs: String[] - descriptions of the products within invoice
// B. Methods:
// B.1 - constructor: public Invoice(int[] units, double[] prices, String[] productsDesc)
// B.2 - get and set methods
// B.3 - public void saveInvoice2File(String invoiceFileName) - save the invoice values (in order of the described fields) 
// into a file
// B.4 - public double readInvoiceFromFileAndCalcTotal(String invoiceFileName) - read from the file and calculate 
// the total of the invoice
// B.5 - clone method for deep copy

public class Invoice implements Cloneable {
    private double[] prices;
    private int[] units;
    private String[] descs;

    public Invoice(int[] units, double[] prices, String[] descs) {
        this.units = units.clone();
        this.prices = prices.clone();
        this.descs = descs.clone();
    }

    public double[] getPrices() {
        return prices.clone();
    }

    public void setPrices(double[] prices) {
        this.prices = prices.clone();
    }

    public int[] getUnits() {
        return units.clone();
    }

    public void setUnits(int[] units) {
        this.units = units.clone();
    }

    public String[] getDescs() {
        return descs.clone();
    }

    public void setDescs(String[] descs) {
        this.descs = descs.clone();
    }

    public void saveInvoice2File(String invoiceFileName) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(invoiceFileName)))) {
            for (int i = 0; i < this.prices.length; i++) {
                dos.writeDouble(prices[i]);
                dos.writeInt(units[i]);
                dos.writeUTF(descs[i]);
            }
        }
    }

    public double readInvoiceFromFileAndCalcTotal(String invoiceFileName) throws IOException {
        double total = 0.0;
        try (DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(invoiceFileName)))) {
            while (true) {
                try {
                    double price = dis.readDouble();
                    int unit = dis.readInt();
                    String desc = dis.readUTF(); // Read but not used directly
                    total += (unit * price);
                } catch (EOFException eof) {
                    break;
                }
            }
        }
        return total;
    }

    @Override
    public Object clone() {
        try {
            Invoice cloned = (Invoice) super.clone();
            cloned.prices = this.prices.clone();
            cloned.units = this.units.clone();
            cloned.descs = this.descs.clone();
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(); // This should never happen since we implement Cloneable
        }
    }
}