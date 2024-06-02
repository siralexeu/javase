package eu.deic.io;

public class Matrix {
    private int[][] data;
    private int rows;
    private int cols;

    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.data = new int[rows][cols];
    }

    public void set(int i, int j, int value) {
        data[i][j] = value;
    }

    public int get(int i, int j) {
        return data[i][j];
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public void print() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
            	System.out.printf("%4d", data[i][j]);
            }
            System.out.println();
        }
    }

    public static Matrix multiply(Matrix a, Matrix b) {
        if (a.getCols() != b.getRows()) {
            throw new IllegalArgumentException("Matricile nu se pot inmulti");
        }

        int rowsA = a.getRows();
        int colsA = a.getCols();
        int colsB = b.getCols();

        Matrix result = new Matrix(rowsA, colsB);

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                int sum = 0;
                for (int k = 0; k < colsA; k++) {
                    sum += a.get(i, k) * b.get(k, j);
                }
                result.set(i, j, sum);
            }
        }

        return result;
    }// end multiply
    
}//end class Matrix
