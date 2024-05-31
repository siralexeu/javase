package eu.deic.jcf;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.LinkedList;


class Patient {
	private int id; // no ssn, no cnp, ...
	private String name;

	public Patient() {
	}

	public Patient(int idRegistrationFile4Patient, String nameOfPatient) {
		this.id = idRegistrationFile4Patient;
		this.name = nameOfPatient;
	}

	public void print() {
		System.out.printf("\n %s has id = %d and name = %s", this.toString(), id, name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}

	@Override
	public boolean equals(Object obj) {
		// if(objP1.equals(objP2))
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Patient other = (Patient) obj;
		boolean r = (this.id == other.id) && Objects.equals(this.name, other.name);
		return r;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// Patient r=(Patient)super.clone();
		Patient r = new Patient();
		r.id = this.id;
		r.name = this.name;
		return r;
	}

}// end class Patient

public class ProgMain {

	public static void main(String[] args) {
		Patient objP1 = new Patient(12, "Ion");
		Patient objP2 = new Patient(12, "Dan");
		objP1.print();
		objP2.print();

		Patient objP3 = null;
		try {
			objP3 = (Patient) objP2.clone();
			objP3.print();
		} catch (CloneNotSupportedException cnse) {
			cnse.printStackTrace();
		}

		if (objP3 == objP2) {
			System.out.println(" == TRUE");
		}
		if (objP3.equals(objP2)) {
			System.out.println("\n equals TRUE");
		}
		// Patient objP3 = (Patient)objP2.clone();
		
		List<Patient> listP = new LinkedList<>(); //new ArrayList<>();
		listP.add(objP1);
		listP.add(objP2);// listP.add(objP3);
		for (int i = 0; i < 3; i++) {
			// Patient objPT=new Patient(25+i,"Name "+i);
			// listP.add(objPT);
			listP.add(new Patient(25 + i, "Name " + i));
		}
		// display 1
		long start = System.nanoTime();
		for (var i = 0; i < listP.size(); i++) {
			Patient temp = listP.get(i);
			temp.print();
		}
		long stop = System.nanoTime();
		System.out.println("\n display 1 ns = " + (stop - start));
		
		// display 2
		start = System.nanoTime();
		for (Patient objP : listP)
			objP.print();
		stop = System.nanoTime();
		System.out.println("\n display 2 ns = " + (stop - start));
		
		// display 3
		start = System.nanoTime();
		for (Iterator<Patient> itp = listP.iterator(); itp.hasNext();) {
			Patient temp = itp.next();
			temp.print();
		}
		stop = System.nanoTime();
		System.out.println("\n display 3 ns = " + (stop - start));
	}// end method main

}// end class main
