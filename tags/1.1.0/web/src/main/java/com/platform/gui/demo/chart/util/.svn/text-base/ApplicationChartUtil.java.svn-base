package com.platform.gui.demo.chart.util;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Calendar;
import java.util.Date;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.DateTickUnit;
import org.jfree.chart.plot.ValueMarker;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.renderer.xy.XYStepAreaRenderer;
import org.jfree.data.time.TimeTableXYDataset;
import org.jfree.data.xy.TableXYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class ApplicationChartUtil extends ApplicationFrame{
	
	private static final long serialVersionUID = 1L;
	
	private Date startDate;
	
	private Date endDate;
	
	public JFreeChart getChart(String type){
		JFreeChart jfreeChart = ChartFactory.createTimeSeriesChart("", "Date", "Value", this.getDataset(), true, true, false);
		
		XYPlot xyplot = jfreeChart.getXYPlot();
		xyplot.setRenderer(this.getPlotRender(type));
		xyplot.setForegroundAlpha(0.5F);
		ValueMarker marker = new ValueMarker(50D);
		marker.setPaint(Color.red);
		xyplot.addRangeMarker(marker);
		
		DateAxis dateAxis = (DateAxis)xyplot.getDomainAxis();
		dateAxis.setRange(startDate, endDate);
		return jfreeChart;
	}

	private XYItemRenderer getPlotRender(String type){
		XYItemRenderer render = new StandardXYItemRenderer();
		if(type != null){
			if(type.equalsIgnoreCase("step-area")){
				render = new XYStepAreaRenderer();
			}
			else if(type.equalsIgnoreCase("line-shape")){
				render = new XYLineAndShapeRenderer();
			}
		}
		return render;
	}
	
	private TableXYDataset getDataset(){
		TimeTableXYDataset timetablexydataset = new TimeTableXYDataset();
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY , 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		
		startDate = cal.getTime();
		for(int i=0;i<30;i++){
			//0:00
			cal.set(Calendar.HOUR_OF_DAY, 0);
			timetablexydataset.add(new UniversalTimePeriod(cal.getTime(), 5, DateTickUnit.MINUTE), 20D, "Application1");
			timetablexydataset.add(new UniversalTimePeriod(cal.getTime(), 5, DateTickUnit.MINUTE), 40D, "Application2");
			timetablexydataset.add(new UniversalTimePeriod(cal.getTime(), 5, DateTickUnit.MINUTE), 40D, "Application3");
			
			//8:00		
			cal.set(Calendar.HOUR_OF_DAY, 8);
			timetablexydataset.add(new UniversalTimePeriod(cal.getTime(), 5, DateTickUnit.MINUTE), 10D, "Application1");
			timetablexydataset.add(new UniversalTimePeriod(cal.getTime(), 5, DateTickUnit.MINUTE), 20D, "Application2");
			timetablexydataset.add(new UniversalTimePeriod(cal.getTime(), 5, DateTickUnit.MINUTE), 50D, "Application3");
			
			//20:00
			cal.set(Calendar.HOUR_OF_DAY, 20);
			timetablexydataset.add(new UniversalTimePeriod(cal.getTime(), 5, DateTickUnit.MINUTE), 20D, "Application1");
			timetablexydataset.add(new UniversalTimePeriod(cal.getTime(), 5, DateTickUnit.MINUTE), 40D, "Application2");
			timetablexydataset.add(new UniversalTimePeriod(cal.getTime(), 5, DateTickUnit.MINUTE), 40D, "Application3");

			//24:00
			cal.set(Calendar.HOUR_OF_DAY, 24);
			timetablexydataset.add(new UniversalTimePeriod(cal.getTime(), 5, DateTickUnit.MINUTE), 20D, "Application1");
			timetablexydataset.add(new UniversalTimePeriod(cal.getTime(), 5, DateTickUnit.MINUTE), 40D, "Application2");
			timetablexydataset.add(new UniversalTimePeriod(cal.getTime(), 5, DateTickUnit.MINUTE), 40D, "Application3");
		
		}
		
		endDate = cal.getTime();
		timetablexydataset.setDomainIsPointsInTime(true);
		return timetablexydataset;
	}

	public ApplicationChartUtil(String s){
		super(s);
	}
	
	public static void main(String args[]){
		ApplicationChartUtil demo = new ApplicationChartUtil("Stacked Area Chart Demo");
		JFreeChart jfreechart = demo.getChart(null);
		ChartPanel chartpanel = new ChartPanel(jfreechart);
		chartpanel.setPreferredSize(new Dimension(500, 270));
		demo.setContentPane(chartpanel);
		
		demo.pack();
		RefineryUtilities.positionFrameOnScreen(demo , 100D, 100D);
		demo.setVisible(true);
	}
}