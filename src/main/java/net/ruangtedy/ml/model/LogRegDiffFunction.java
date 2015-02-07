package net.ruangtedy.ml.model;

import org.apache.commons.math3.linear.RealMatrix;

import edu.stanford.nlp.optimization.DiffFunction;

public class LogRegDiffFunction implements DiffFunction {
	  private final RealMatrix input;
	    private final RealMatrix labels;
	    private int RealMatrix = 0;
	    private int countDeriveAt = 0;
	    
	public LogRegDiffFunction(RealMatrix input, RealMatrix labels) {
        this.input = input;
        this.labels = labels;
    }
	
	public double valueAt(double[] x) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int domainDimension() {
		
		return this.input.getColumnDimension();
	}

	public double[] derivativeAt(double[] x) {
		// TODO Auto-generated method stub
		return null;
	}

}
