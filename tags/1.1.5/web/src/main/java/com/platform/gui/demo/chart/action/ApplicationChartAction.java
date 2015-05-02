package com.platform.gui.demo.chart.action;

import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.servlet.ServletUtilities;

import com.platform.gui.demo.chart.util.ApplicationChartUtil;
import com.platform.gui.framework.smart.action.AbstractAction;

public class ApplicationChartAction extends AbstractAction{

	private static final long serialVersionUID = 1L;

	private String fileName;
	
	private String imageSrc;
	
	private ApplicationChartUtil util = new ApplicationChartUtil("");
	
	public String toChart() throws Exception{
		
		String chartType = this.getServletRequest().getParameter("chart");
		
		//Write the chart image to the temporary directory
		ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
		fileName = ServletUtilities.saveChartAsPNG(util.getChart(chartType), 500, 300, info, this.getSession());
	
		imageSrc = this.getServletRequest().getContextPath() + "/DisplayChart?filename=" + fileName;
		return SUCCESS;
	}

	/**
	 * Display all of the charts
	 * @return
	 * @throws Exception
	 */
	public String allCharts() throws Exception{
		return SUCCESS;
	}
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getImageSrc() {
		return imageSrc;
	}

	public void setImageSrc(String imageSrc) {
		this.imageSrc = imageSrc;
	}
}
