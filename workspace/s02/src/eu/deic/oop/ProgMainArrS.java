package eu.deic.oop;

public class ProgMainArrS {
	
	public static void main(String[] args) {
		int[][] sMarks = new int[][] {
			{10, 4, 9},
			{5, 5, 6}
		};
		float[] avg = new float[sMarks.length];
		
		int i = 0;
		while (i < sMarks.length) {
			avg[i] = 0.0f;
			int j = 0;
			while (j < sMarks[i].length) {
				avg[i] = avg[i] + sMarks[i][j];
				j++;
			}
			avg[i] = avg[i] / sMarks[i].length;
			i++;
		}
		for (var k = 0; k < avg.length; k++) {
			System.out.printf("\n avg[%d]=%f", k, avg[k]);
		}
	}
}
