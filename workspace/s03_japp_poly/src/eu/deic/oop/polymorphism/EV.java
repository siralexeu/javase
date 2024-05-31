package eu.deic.oop.polymorphism;

public class EV extends ElectronicDevice {
	private int enginesNo;

	public EV(String vendor, int year, int enginesNo) {
		super(vendor, year);
		this.enginesNo = enginesNo;
	}

	@Override
	public void display() {
		System.out.printf("\n this = %s, vendor = %s, year = %d, Ev::engines # =%d", this.toString(), this.getVendor(),
				this.getYear(), this.enginesNo);
	}
}
