package net.cominfo.digiagent.web;

import java.io.File;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jfree.chart.servlet.ChartDeleter;
import org.jfree.chart.servlet.ServletUtilities;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/chart")
public class ChartController {
	
	@RequestMapping(value = "/display/{filename}")
	public void display(@PathVariable String filename, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession();
		if (filename == null) {
			throw new ServletException("Parameter 'filename' must be supplied");
		}

		// Replace ".." with ""
		// This is to prevent access to the rest of the file system
		filename = ServletUtilities.searchReplace(filename, "..", "");

		// Check the file exists
		File file = new File(System.getProperty("java.io.tmpdir"), filename);
		if (!file.exists()) {
			throw new ServletException("File '" + file.getAbsolutePath()
					+ "' does not exist");
		}

		// Check that the graph being served was created by the current user
		// or that it begins with "public"
		boolean isChartInUserList = false;
		ChartDeleter chartDeleter = (ChartDeleter) session
				.getAttribute("JFreeChart_Deleter");
		if (chartDeleter != null) {
			isChartInUserList = chartDeleter.isChartAvailable(filename);
		}

		boolean isChartPublic = false;
		if (filename.length() >= 6) {
			if (filename.substring(0, 6).equals("public")) {
				isChartPublic = true;
			}
		}

		boolean isOneTimeChart = false;
		if (filename.startsWith(ServletUtilities.getTempOneTimeFilePrefix())) {
			isOneTimeChart = true;
		}

		if (isChartInUserList || isChartPublic || isOneTimeChart) {
			// Serve it up
			ServletUtilities.sendTempFile(file, response);
			if (isOneTimeChart) {
				file.delete();
			}
		} else {
			throw new ServletException("Chart image not found");
		}
		return;
	}
}
