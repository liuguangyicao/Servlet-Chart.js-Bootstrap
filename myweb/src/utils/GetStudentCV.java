package utils;

import java.util.List;

public class GetStudentCV {
	public static Double getStudentCV(List<Integer> integerChart) {
		double avgChart = 0;
		double sumChart = 0;
		for(int i = 0; i < integerChart.size(); i++) {
			avgChart  = avgChart + integerChart.get(i);
		}
		avgChart = avgChart / 12;
		for(int i = 0; i < integerChart.size(); i++) {
			sumChart = sumChart + (integerChart.get(i) - avgChart) * (integerChart.get(i) - avgChart);
		}
		sumChart =Math.sqrt(sumChart / 12);
		return sumChart;
	}
}