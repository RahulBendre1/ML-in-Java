package net.ruangtedy.ml.util;



public class Matrix {
	public static double[] Ones(int row){
		
		
		double[] one=new double[row];
			for(int i=0;i<row;i++){
				one[i]=1.0;
			}
			
			
		
		return one;

	}
	
public static double[] Zeros(int row){
		
		
		double[] one=new double[row];
			for(int i=0;i<row;i++){
				one[i]=0.0;
			}
			
			
		
		return one;

	}

}
