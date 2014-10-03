package net.ruangtedy.ml.util;

public class Matrix {
	public static double[] Ones(int row) {

		double[] one = new double[row];
		for (int i = 0; i < row; i++) {
			one[i] = 1.0;
		}

		return one;

	}

	public static double[] Zeros(int row) {

		double[] one = new double[row];
		for (int i = 0; i < row; i++) {
			one[i] = 0.0;
		}

		return one;

	}

	public static double[][] Zeros(int row, int coloumns) {

		double[][] one = new double[row][coloumns];
		for (int i = 0; i < row; i++) {
			for(int j=0;j<coloumns;j++){
				one[i][j] = 0.0;

			}
		}

		return one;

	}

}
