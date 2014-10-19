package net.ruangtedy.ml.logisticregression;

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

import net.ruangtedy.ml.linearregression.ex1;
import net.ruangtedy.ml.util.Chart2D;
import net.ruangtedy.ml.util.Data;
import net.ruangtedy.ml.util.Matrix;

public class ex2 extends ApplicationFrame {

	public ex2(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 7942296739948365363L;

	public static void main(String[] args) {
		List<Double[]> data = Data.load("data2/ex2data1.txt");
		RealMatrix mtx = new Array2DRowRealMatrix(Data.convertToMatrix2D(data, 3));
		
		RealMatrix X = new Array2DRowRealMatrix(mtx.getRowDimension(), 2);
		X.setColumn(0,mtx.getColumn(0));
		X.setColumn(1,mtx.getColumn(1));
		RealMatrix Y=mtx.getColumnMatrix(2);
		
		/*We start the exercise by first plotting the data to understand the 
		 *the problem we are working with.
		 */
		plotData(X, Y);
		
		/* ============ Part 2: Compute Cost and Gradient ============
		 * In this part of the exercise, you will implement the cost and gradientfor logistic regression. 
		 * Setup the data matrix appropriately, and add ones for the intercept term
		 * 
		 */
		RealMatrix X_temp=X.copy();
		X=new Array2DRowRealMatrix(mtx.getRowDimension(), 3);
		X.setColumn(0, Matrix.Ones(X_temp.getRowDimension()));
		X.setColumn(1, X_temp.getColumn(0));
		X.setColumn(2, X_temp.getColumn(1));

		System.out.println(X);


	}

	private static void plotData(RealMatrix X, RealMatrix Y) {
		XYSeries series1 = new XYSeries("Admitted");
		XYSeries series2 = new XYSeries("Not Admitted");
		
		
		for (int m = 0; m < X.getRowDimension(); m++) {
			if (Y.getEntry(m, 0)==1){
				series1.add(X.getEntry(m, 0), X.getEntry(m, 1));
			}else{
				series2.add(X.getEntry(m, 0), X.getEntry(m, 1));

			}


		}
		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(series1);
		dataset.addSeries(series2);

		JFreeChart chart = Chart2D.createScatteredChart(dataset, "Data");
		JPanel jpanel = new ChartPanel(chart);

		jpanel.setPreferredSize(new Dimension(640, 480));

		ex2 ex = new ex2("Machine Learning week 02");
		ex.add(jpanel);
		ex.pack();
		RefineryUtilities.centerFrameOnScreen(ex);
		ex.setVisible(true);
	}
}
