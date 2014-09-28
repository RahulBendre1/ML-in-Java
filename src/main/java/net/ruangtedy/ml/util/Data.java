package net.ruangtedy.ml.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Data {
	public static double[][] convertToMatrix2D(List<Double[]> data) {
		double[][] mtx = new double[data.size()][2];
		int i = 0;

		for (Double[] d : data) {
			mtx[i][0] = d[0].doubleValue();
			mtx[i][1] = d[1].doubleValue();
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
				} else {
					final String[] line = data.split(",");
					if (line.length == 2) {
						try {
							final double a = Double.parseDouble(line[0]);
							final double b = Double.parseDouble(line[1]);
							final Double[] d = { a, b };
							dataSource.add(d);
						} catch (final NumberFormatException e) {
							System.out.println(e);
						}
					}
				} // End of the if //
			} while (data != null);
			System.out.println("INFO: data loaded : " + filename);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataSource;
	}
}
