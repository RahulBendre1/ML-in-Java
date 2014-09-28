package net.ruangtedy.ml.util;

import java.awt.Color;
import java.awt.Shape;
import java.util.List;


import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.util.ShapeUtilities;

public class Chart2D {
	
	public static JFreeChart createChart(XYDataset dataset, String title) {
		
		// create the chart...
		JFreeChart chart = ChartFactory.createXYLineChart(
		title, // chart title
		"X", // x axis label
		"Y", // y axis label
		dataset, // data
		PlotOrientation.VERTICAL,
		true, // include legend
		true, // tooltips
		false // urls
		);
		
		// NOW DO SOME OPTIONAL CUSTOMISATION OF THE CHART...
		chart.setBackgroundPaint(Color.white);
		
		// get a reference to the plot for further customisation...
		XYPlot plot = (XYPlot) chart.getPlot();
		plot.setDomainCrosshairVisible(true);
		plot.setRangeCrosshairVisible(true);

		
		XYLineAndShapeRenderer renderer= (XYLineAndShapeRenderer) plot.getRenderer();
		
		renderer.setSeriesLinesVisible(0, true);
		renderer.setSeriesShapesVisible(0, false);

		renderer.setSeriesLinesVisible(1, false);
		renderer.setSeriesShapesVisible(1, true);

		Shape cross = ShapeUtilities.createDiagonalCross(3, 0);
		renderer.setSeriesShape(1, cross);
		
		renderer.setSeriesPaint(0, Color.blue);
		renderer.setSeriesPaint(1, Color.red);

		
		// change the auto tick unit selection to integer units only...
		NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
		rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		// OPTIONAL CUSTOMISATION COMPLETED.
		return chart;
	}
	private static JFreeChart createScatteredChart(XYSeriesCollection xyseries) {
		JFreeChart jfreechart = ChartFactory.createScatterPlot(
				"Scatter Plot Demo", "X", "Y", xyseries,
				PlotOrientation.VERTICAL, true, true, false);
		Shape cross = ShapeUtilities.createDiagonalCross(3, 0);
		XYPlot xyPlot = (XYPlot) jfreechart.getPlot();
		xyPlot.setDomainCrosshairVisible(true);
		xyPlot.setRangeCrosshairVisible(true);
		XYItemRenderer renderer = xyPlot.getRenderer();
		renderer.setSeriesShape(0, cross);
		renderer.setSeriesPaint(0, Color.red);
		return jfreechart;
	}

	

	public static JFreeChart Scatteredplot(List<Double[]> data) {
		XYSeriesCollection xySeriesCollection = new XYSeriesCollection();
		XYSeries series = new XYSeries("Random");
		for (Double[] d : data) {
			series.add(d[0], d[1]);

		}

		xySeriesCollection.addSeries(series);
		JFreeChart chart = createScatteredChart(xySeriesCollection);
		return chart;

	}

}
