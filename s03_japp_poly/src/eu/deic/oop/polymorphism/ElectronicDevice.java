package eu.deic.oop.polymorphism;

public class ElectronicDevice /* extends Object */ implements Device {
	private String vendor;
	private int year;

	public ElectronicDevice() {
		// super();
		this.vendor = null;
		this.year = 0;
	}

	public ElectronicDevice(String vendor, int yearOfProduction) {
		this.vendor = vendor;
		this.year = yearOfProduction;
	}

	public String getVendor() {
		return this.vendor;
	}

	public int getYear() {
		return this.year;
	}

	public void setVendor(String vendorOfElectronicDevice) {
		this.vendor = vendorOfElectronicDevice;
	}

	public void setYear(int yearOfProduction) {
		this.year = yearOfProduction;
	}

	public void turnOn() {
		System.out.printf("\n ElectronicDevice::turnOn() - vendor = %s, year = %d", this.vendor, this.year);

	}

	public void tunOff() {
		System.out.printf("\n ElectronicDevice::turnOn() - vendor = %s, year = %d", this.vendor, this.year);
	}

	public void display() {
		System.out.printf("\n this = %s, vendor = %s, year = %d", this.toString(), this.vendor, this.year);
	}

	@Override
	public void close() throws Exception {
	}
}
