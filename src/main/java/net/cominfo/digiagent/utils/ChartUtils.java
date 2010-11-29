package net.cominfo.digiagent.utils;

import java.awt.Font;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;

public class ChartUtils {

	public static JFreeChart generateChart(String title, DefaultPieDataset data) {
		JFreeChart chart = ChartFactory.createPieChart("每天访问前十名分布", // chart
				// title
				data, // data
				true, // include legend
				true, false);

		Font font = new Font("SimSun", 10, 20);
		TextTitle txtTitle = null;
		txtTitle = chart.getTitle();
		txtTitle.setFont(font);

		chart.getLegend().setItemFont(font);
		PiePlot plot = (PiePlot) chart.getPlot();
		plot.setLabelFont(font);
		plot.setNoDataMessage("No data available");
		plot.setCircular(false);
		plot.setLabelGap(0.02);
		plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{2}",
				NumberFormat.getNumberInstance(), new DecimalFormat("0.00%")));
		return chart;
	}
	
	public static DefaultPieDataset generateData(String valueKey, String nameKey, List<HashMap> dataList) {
		DefaultPieDataset dataset = new DefaultPieDataset();
		if(dataList!=null & dataList.size()>0){
			Iterator<HashMap> iterator = dataList.iterator();
			HashMap data = null;
			String name = null;
			Long value = null;
			while(iterator.hasNext()){
				data = iterator.next();
				name = (String)data.get(nameKey);
				value = (Long)data.get(valueKey);
				dataset.setValue(name, value.doubleValue());
			}
		}
		return dataset;
	}
	
	public static DefaultPieDataset generateSupplierData(List<HashMap> dataList) {
		return generateData("COUNT","SUPPLIER",dataList);
	}

}
