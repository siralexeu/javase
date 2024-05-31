package eu.deic.oop;

public class ProgMainArrSOop {

	public static void main(String[] args) {
		Student[] objSS = new Student[2];
		objSS[0] = new Student(11, "Ion", new int[] {10, 4, 9});
		objSS[1] = new Student(11, "Daria", new int[] {5, 5, 6});
		
		for (var k = 0; k < objSS.length; k++) 
			System.out.printf("\n avg[%d]=%f", k, objSS[k].getAvg());
	}

}
