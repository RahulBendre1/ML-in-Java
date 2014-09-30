package net.ruangtedy.ml.util;


import org.apache.commons.math3.linear.RealMatrix;

public class LinearRegression {
	public static RealMatrix GradientDescent(RealMatrix X, RealMatrix Y, RealMatrix theta, double alpha, int num_iters){
		double m = Y.getRowDimension();

		for(int i=0;i<num_iters;i++){
			RealMatrix h = X.multiply(theta);
			RealMatrix error=(h.subtract(Y)).transpose();
			
			RealMatrix sum0=error.multiply(X.getColumnMatrix(0));
			RealMatrix sum1=error.multiply(X.getColumnMatrix(1));
			
			double temp0=theta.getEntry(0, 0)-((sum0.getEntry(0, 0))*alpha)/(m);
			double temp1=theta.getEntry(1, 0)-((sum1.getEntry(0, 0))*alpha)/(m);
			

			theta.setEntry(0, 0, temp0);
			theta.setEntry(1, 0, temp1);
			
			double J=LinearRegression.ComputeCost(X, Y, theta);
			//System.out.println(theta);

			

		}

		return theta;
		
	}

	public static double ComputeCost(RealMatrix X, RealMatrix Y,
			RealMatrix theta) {

		double m = Y.getRowDimension();
		RealMatrix h = X.multiply(theta);
		RealMatrix e = h.subtract(Y);
		RealMatrix sum = (e.transpose()).multiply(e);
		double sumvalue = sum.getEntry(0, 0);
		double J = sumvalue / (2 * m);
	

		return J;

	}
	
	public static void featureNormalize(){
		
	}
}
