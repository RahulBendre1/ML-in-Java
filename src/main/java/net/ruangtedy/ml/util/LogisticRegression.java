package net.ruangtedy.ml.util;


import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.stat.StatUtils;
import org.apache.commons.math3.util.FastMath;

public class LogisticRegression {
	public static double costFunction(RealMatrix theta, RealMatrix X, RealMatrix y){
		RealMatrix z=X.multiply(theta);
		RealMatrix h=sigmoid(z);
		double[] cost=new double[h.getRowDimension()];

		int m=X.getRowDimension();
		double mdouble=(double) m;
		for (int j = 0; j < X.getRowDimension(); j++) {
			if (y.getEntry(j, 0)==1){
					cost[j]=-FastMath.log(h.getEntry(j, 0));
					
			}else{
				
				
					cost[j]=-FastMath.log(1-h.getEntry(j, 0));
				

			}
			

		}
		double J=StatUtils.sum(cost)/(X.getRowDimension());
		
		RealMatrix e_term=h.subtract(y);
		RealMatrix gradient=((e_term.transpose()).multiply(X)).scalarMultiply(1/mdouble);
		System.out.println(gradient);
		return J;
		
		
	}
	
	public static RealMatrix sigmoid(RealMatrix z){
		
		RealMatrix g=new Array2DRowRealMatrix(Matrix.Zeros(z.getRowDimension()));
		double[] result=new double[z.getRowDimension()];
		for(int m=0;m<z.getRowDimension();m++){
			 result[m]=1/(1+(Math.exp(-z.getEntry(m, 0))));
		}
		RealMatrix denom=new Array2DRowRealMatrix(result);
		
		return denom;
		
	}
//	public static void main(String[] args) {
//		double[] mtx={1,2,3};
//		RealMatrix z=new Array2DRowRealMatrix(mtx);
//		RealMatrix ans=LogisticRegression.sigmoid(z);
//		System.out.println(ans);
//	}

}
