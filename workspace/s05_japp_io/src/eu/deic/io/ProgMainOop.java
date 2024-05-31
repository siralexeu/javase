package eu.deic.io;

public class ProgMainOop {

	public static void main(String[] args) {
		String filePath = "./invoices1.txt";
		
		String[] descs = new String[] { "Pen", "T-Shirt", "Mug" };
		int[] units = new int[] { 55, 40, 35 };
		float[] prices = new float[] { 43.50f, 68.22f, 40.15f };
		
		Invoice objInvoice1 = new Invoice(descs, units, prices);
		objInvoice1.save2File(filePath);
		double totalI = objInvoice1.readFromFileAndDoTotal(filePath);
		System.out.printf("TotalI= %f \n", totalI);

	}

}
