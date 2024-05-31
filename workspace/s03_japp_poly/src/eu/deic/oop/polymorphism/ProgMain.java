package eu.deic.oop.polymorphism;

public class ProgMain {
	public static void main(String[] args) {
		System.out.printf("\n 1. Mobiles # = %d", MobileSmartPhone.getPhonesNo());
	    // Device objD = null;
	    // try {
	    //  objD = new MobileSmartPhone("Nokia 3210", 2004, 3);
	    try (Device objD = new MobileSmartPhone("Nokia 3210", 2004, 3);
	            MobileSmartPhone objMSP2 = new MobileSmartPhone("Samsung Fold Z5", 2023, 8.5f)) {
	           objD.turnOn();
	           System.out.printf("\n 1.1 Mobiles # = %d", MobileSmartPhone.getPhonesNo());
	       } catch(Exception e) {
	           e.printStackTrace();
	       }
	    // objD = null;
	    System.gc();
	    System.out.printf("\n 2. Mobiles # = %d", MobileSmartPhone.getPhonesNo());

	    ElectronicDevice objED = null;
	    objED = new MobileSmartPhone("Apple iPhone 15 Pro", 2024, 8);
	    objED.display();
	    // 2000
	    objED = new EV("Tesla X", 2024, 2);
	    objED.display();
	    ElectronicDevice objED2 = null;
	    MobileSmartPhone objMSP2 = new MobileSmartPhone("Samsung Fold Z5", 2023, 8.5f);
	    objED2 = objMSP2;
	    try {
	        EV objEV2 = (EV)objED2;
	        objEV2.display();
	    } catch(ClassCastException cce) {
	        // cce.printStackTrace();
	    }

	    System.out.println("\n finished!!!");

	}// end main
}// end class
