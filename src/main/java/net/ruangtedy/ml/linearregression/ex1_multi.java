package net.ruangtedy.ml.linearregression;

import java.util.List;

import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;

import net.ruangtedy.ml.util.Data;
import net.ruangtedy.ml.util.LinearRegression;
import net.ruangtedy.ml.util.Matrix;


public class ex1_multi {
	public static void main(String[] args) {
		List<Double[]>  data=Data.load("ex1data2.txt");
		RealMatrix mtx = new Array2DRowRealMatrix(Data.convertToMatrix2D(data, 3));

		RealMatrix X = new Array2DRowRealMatrix(mtx.getRowDimension(), 2);
		X.setColumn(0,mtx.getColumn(0));
		X.setColumn(1,mtx.getColumn(1));
		
		
		RealMatrix Y=mtx.getColumnMatrix(2);
	    X=Data.featureNormalize(X);
	    RealMatrix X_Norm= new Array2DRowRealMatrix(mtx.getRowDimension(), 3);
	    X_Norm.setColumn(0, Matrix.Ones(X.getRowDimension()));
	    X_Norm.setColumn(1,X.getColumn(0));
	    X_Norm.setColumn(2,X.getColumn(1));

		RealMatrix theta = new Array2DRowRealMatrix(Matrix.Zeros(3));
		theta=LinearRegression.GradientDescentMulti(X_Norm, Y, theta, 0.01, 400);
	    System.out.println(theta);
	   
	    
		
		
		
	}

}
