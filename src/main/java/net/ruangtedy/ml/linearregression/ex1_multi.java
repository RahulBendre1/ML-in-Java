package net.ruangtedy.ml.linearregression;

import java.util.List;

import net.ruangtedy.ml.util.Data;


public class ex1_multi {
	public static void main(String[] args) {
		List<Double[]>  data=Data.load("ex1data2.txt");
		System.out.println(data);
	}

}
