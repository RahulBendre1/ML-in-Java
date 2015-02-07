package net.ruangtedy.ml.linearregression;

import java.awt.Dimension;
import java.util.List;

import javax.swing.JPanel;


import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import net.ruangtedy.ml.util.Chart2D;
import net.ruangtedy.ml.util.Data;
import net.ruangtedy.ml.util.LinearRegression;
import net.ruangtedy.ml.util.Matrix;

public class ex1 extends ApplicationFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4590485200476886004L;

	public ex1(String title) {
		super(title);

	}

	public static void main(String[] args) {

		List<Double[]> data = Data.load("data1/ex1data1.txt");

		RealMatrix mtx = new Array2DRowRealMatrix(Data.convertToMatrix2D(data, 2));

		RealMatrix X = new Array2DRowRealMatrix(mtx.getRowDimension(), 2);
		X.setColumn(0, Matrix.Ones(mtx.getRowDimension()));
		X.setColumn(1, mtx.getColumn(0));

		RealMatrix Y = mtx.getColumnMatrix(1);

		RealMatrix theta = new Array2DRowRealMatrix(Matrix.Zeros(2));
		int iterations = 1500;
		double alpha = 0.01;
		theta = LinearRegression
				.GradientDescent(X, Y, theta, alpha, iterations);

		System.out.println(theta);
		RealMatrix h = X.multiply(theta);

		double[][] hdata = h.getData();
		double[][] xdata = X.getData();
		XYSeries series1 = new XYSeries("Linear Regression");
		XYSeries series2 = new XYSeries("Training Set");

		for (int i = 0; i < h.getRowDimension(); i++) {
			series1.add(xdata[i][1], hdata[i][0]);

		}

		for (Double[] d : data) {
			series2.add(d[0], d[1]);

		}
		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(series1);
		dataset.addSeries(series2);

		JFreeChart chart = Chart2D.createChart(dataset, "Gradient Descent For One Variable");
		JPanel jpanel = new ChartPanel(chart);

		jpanel.setPreferredSize(new Dimension(640, 480));

		ex1 ex = new ex1("Machine Learning week 01");
		ex.add(jpanel);
		ex.pack();
		RefineryUtilities.centerFrameOnScreen(ex);
		ex.setVisible(true);

	}
}
