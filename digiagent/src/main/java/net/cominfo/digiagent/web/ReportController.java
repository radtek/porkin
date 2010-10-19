package net.cominfo.digiagent.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/report")
public class ReportController {

	@RequestMapping(value = "/everyday", method = RequestMethod.GET)
	public ModelAndView everyday(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setContentType("image/jpeg");
		response.setCharacterEncoding("utf-8");
		DefaultPieDataset data = getDataSet();
		// JFreeChart chart = null;
		JFreeChart chart = ChartFactory.createPieChart("水果产量图", // chart title
				data, // data
				true, // include legend
				true, false);

		PiePlot plot = (PiePlot) chart.getPlot();
		plot.setNoDataMessage("No data available");
		plot.setCircular(false);
		plot.setLabelGap(0.02);

		ChartUtilities.writeChartAsJPEG(response.getOutputStream(), 1, chart,
				400, 300, null);

		return null;

	}

	@RequestMapping(value = "/weekly", method = RequestMethod.GET)
	public ModelAndView weekly(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setContentType("image/jpeg");
		response.setCharacterEncoding("utf-8");
		DefaultPieDataset data = getDataSet();
		// JFreeChart chart = null;
		JFreeChart chart = ChartFactory.createPieChart("水果产量图", // chart title
				data, // data
				true, // include legend
				true, false);

		PiePlot plot = (PiePlot) chart.getPlot();
		plot.setNoDataMessage("No data available");
		plot.setCircular(false);
		plot.setLabelGap(0.02);

		ChartUtilities.writeChartAsJPEG(response.getOutputStream(), 1, chart,
				400, 300, null);

		return null;

	}

	@RequestMapping(value = "/monthly", method = RequestMethod.GET)
	public ModelAndView monthly(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setContentType("image/jpeg");
		response.setCharacterEncoding("utf-8");
		DefaultPieDataset data = getDataSet();
		// JFreeChart chart = null;
		JFreeChart chart = ChartFactory.createPieChart("水果产量图", // chart title
				data, // data
				true, // include legend
				true, false);

		PiePlot plot = (PiePlot) chart.getPlot();
		plot.setNoDataMessage("No data available");
		plot.setCircular(false);
		plot.setLabelGap(0.02);

		ChartUtilities.writeChartAsJPEG(response.getOutputStream(), 1, chart,
				400, 300, null);

		return null;

	}

	private static DefaultPieDataset getDataSet() {
		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("苹果", 100);
		dataset.setValue("梨子", 200);
		dataset.setValue("葡萄", 300);
		dataset.setValue("香蕉", 400);
		dataset.setValue("荔枝", 500);
		return dataset;
	}

}
