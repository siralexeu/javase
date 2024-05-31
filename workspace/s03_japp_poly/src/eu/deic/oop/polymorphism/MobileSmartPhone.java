package eu.deic.oop.polymorphism;

public class MobileSmartPhone extends ElectronicDevice implements Cloneable /*AutoClosable*/ {
	private static int phonesNo;
	private float screenSize;

	public MobileSmartPhone() {
	}

	public MobileSmartPhone(String vendor, int yearOfProduction, float diagonalScreenSize) {
		super(vendor, yearOfProduction);
		this.screenSize = diagonalScreenSize;
		MobileSmartPhone.phonesNo++;
	}
	public static int getPhonesNo() {
		return /*MobileSmartPhone.*/phonesNo;
	}

	public void display() {
		System.out.printf("\n this = %s, vendor = %s, year = %d, diagonalScreenSizeInches =%f", this.toString(),
				this.getVendor(), this.getYear(), this.screenSize);
	}

	public Object clone() throws CloneNotSupportedException {
		// MobileSmartPhone o2=o1.clone();
		MobileSmartPhone objC = (MobileSmartPhone) super.clone();
		objC.setVendor(this.getVendor());
		objC.setYear(this.getYear());
		objC.screenSize = this.screenSize;

		MobileSmartPhone.phonesNo++;
		return objC;
	}

	@Override
	public void close() throws Exception {
		MobileSmartPhone.phonesNo++;
	}
} // end class Mobile...
