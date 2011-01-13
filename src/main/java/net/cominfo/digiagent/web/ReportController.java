package net.cominfo.digiagent.web;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.cominfo.digiagent.service.HistoryService;
import net.cominfo.digiagent.utils.ChartUtils;

import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/report")
public class ReportController {
	
	@Autowired
	private HistoryService historyService;
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/rankList", method = RequestMethod.GET)
	public String rankList(Model model) throws Exception {
		List<HashMap> dayResult = historyService.getSupplierReportByDays(1);
		List<HashMap> weekResult = historyService.getSupplierReportByDays(7);
		List<HashMap> monthResult = historyService.getSupplierReportByDays(30);
		model.addAttribute("daily", dayResult);
		model.addAttribute("weekly", weekResult);
		model.addAttribute("monthly", monthResult);
	
		return "rankDetail";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/everyday", method = RequestMethod.GET)
	public ModelAndView everyday(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setContentType("image/jpeg");
		response.setCharacterEncoding("utf-8");
		List<HashMap> result = historyService.getSupplierReportByDays(1);
		DefaultPieDataset data = ChartUtils.generateSupplierData(result);
		JFreeChart chart = ChartUtils.generateChart("每天访问前十名分布", data);
		
		ChartUtilities.writeChartAsJPEG(response.getOutputStream(), 1, chart,
				600, 450, null);
		return null;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/weekly", method = RequestMethod.GET)
	public ModelAndView weekly(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setContentType("image/jpeg");
		response.setCharacterEncoding("utf-8");
		List<HashMap> result = historyService.getSupplierReportByDays(7);
		DefaultPieDataset data = ChartUtils.generateSupplierData(result);
		JFreeChart chart = ChartUtils.generateChart("每周访问前十名分布", data);
		
		ChartUtilities.writeChartAsJPEG(response.getOutputStream(), 1, chart,
				600, 450, null);
		return null;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/monthly", method = RequestMethod.GET)
	public ModelAndView monthly(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setContentType("image/jpeg");
		response.setCharacterEncoding("utf-8");
		List<HashMap> result = historyService.getSupplierReportByDays(30);
		DefaultPieDataset data = ChartUtils.generateSupplierData(result);
		JFreeChart chart = ChartUtils.generateChart("每月访问前十名分布", data);
		
		ChartUtilities.writeChartAsJPEG(response.getOutputStream(), 1, chart,
				600, 450, null);
		return null;
	}

	
}
