package net.ruangtedy.ml.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.stat.StatUtils;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

public class Data {
	
	public static RealMatrix featureNormalize(RealMatrix X){
		RealMatrix X_norm=X.copy();
		RealMatrix mu=new Array2DRowRealMatrix(Matrix.Zeros(1,2));
		System.out.println(mu);
		RealMatrix sigma=new Array2DRowRealMatrix(Matrix.Zeros(1,2));

		for(int i=0; i<X.getColumnDimension();i++ ){
			RealMatrix feature=X.getColumnMatrix(i);
			mu.setEntry(0, i, StatUtils.mean(feature.getColumn(0)));
			sigma.setEntry(0, i, Math.sqrt(StatUtils.variance(feature.getColumn(0))));
			X_norm.setColumnMatrix(i,(feature.scalarAdd(-1*mu.getEntry(0, i))).scalarMultiply(1/(sigma.getEntry(0, i))));
		}
		System.out.println(X_norm);
		return X_norm;
		
		
	}
	public static double[][] convertToMatrix2D(List<Double[]> data, int coloumn) {
		
		double[][] mtx = new double[data.size()][coloumn];
		int i = 0;

		for (Double[] d : data) {
			for(int j=0;j<coloumn;j++){
				mtx[i][j] = d[j].doubleValue();

			}
			i++;
		}
		return mtx;

	}

	public static double[] convertToVector(List<Double[]> data, int coloumn) {
		double[] v = new double[data.size()];
		int i = 0;

		for (Double[] d : data) {
			v[i] = d[coloumn].doubleValue();

			i++;
		}
		return v;

	}

	public static List<Double[]> load(final String filename) {
		List<Double[]> dataSource = new ArrayList<Double[]>();

		try {

			final FileInputStream stream = new FileInputStream(filename);
			final BufferedReader reader = new BufferedReader(
					new InputStreamReader(stream));
			String data = "";
			int i = 0;
			do {
				data = reader.readLine();
				if (data == null || data.trim().length() == 0) {
					continue;
				} 
				else {
					final String[] line = data.split(",");
					Double[] d=new Double[line.length];
					for(int j=0;j<line.length;j++) {
						try {
							
							d[j] = Double.parseDouble(line[j]);
							
						} catch (final NumberFormatException e) {
							System.out.println(e);
						}
					}
					dataSource.add(d);
					
				} // End of the if //
			} while (data != null);
			System.out.println("INFO: data loaded : " + filename);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataSource;
	}
}
