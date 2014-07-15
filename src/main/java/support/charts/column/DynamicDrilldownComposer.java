package support.charts.column;

import java.util.*;
import java.util.Map.Entry;

import org.zkoss.chart.*;
import org.zkoss.chart.model.*;
import org.zkoss.chart.plotOptions.ColumnPlotOptions;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.*;

import support.charts.column.Browser.GROUP;


public class DynamicDrilldownComposer extends SelectorComposer<Component> {

	@Wire
	Charts chart;

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);

		chart.getXAxis().setType("category");

		chart.getYAxis().setTitle("Total percent market share");

		chart.getLegend().setEnabled(false);

		chart.getPlotOptions().getSeries().setBorderWidth(0);
		chart.getPlotOptions().getSeries().getDataLabels().setEnabled(true);
		chart.getPlotOptions().getSeries().getDataLabels().setFormat("{point.y:.1f}%");

		chart.getTooltip().setHeaderFormat("<span style=\"font-size:11px\">{series.name}</span><br>");
		chart.getTooltip().setPointFormat("<span style=\"color:{point.color}\">{point.name}" +
				"</span>: <b>{point.y:.2f}%</b> of total<br/>");

		initSeries();
	}

	private void initSeries() {
		Series series = chart.getSeries();
		List<Series> drilldowns = new ArrayList<Series>();
		series.setName("Brands");
		ColumnPlotOptions plotOptions = new ColumnPlotOptions();
		plotOptions.setColorByPoint(true);
		series.setPlotOptions(plotOptions);
		Iterator<Entry<Browser.GROUP, Double>> iterator =
				BrowserMarketShare.getBrands().entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<Browser.GROUP, Double> entry = iterator.next();
			Point point = new Point(entry.getKey().name(), entry.getValue());
			point.setDrilldown(true); //enable drilldown for each point
			series.addPoint(point);
		}
		chart.getDrilldown().setSeries(new LinkedList());
	}

	//clear series and add
//	@Listen("onPlotClick = #chart")
//	public void drillDown(ChartsEvent e){
//		String pointName = e.getPoint().getName();
//		System.out.println("drill down "+pointName);
//		//load drill down data of clicked point if exists
//		Series series = chart.getSeries();
//		series.getData().clear();
//		List<Browser> browsers = BrowserMarketShare.getVersions(GROUP.valueOf(pointName.toUpperCase()));
//		if (!browsers.isEmpty()) {
//			series.setName(pointName);
//			for (Browser browser: browsers) {
//				Point p = new Point(browser.getVersion(), browser.getPercentage());
//				series.addPoint(p);
//			}
//		}
//	}

	//add drilldown series for clicked point
	@Listen("onPlotDrillDown = #chart")
	public void addDrillDown(ChartsEvent e){
		String pointName = e.getPoint().getName();
		System.out.println("drill down "+pointName);
		//load drill down data of clicked point if exists
		e.getPoint().setDrilldown(pointName);
		Series series = new Series();
		List<Browser> browsers = BrowserMarketShare.getVersions(GROUP.valueOf(pointName.toUpperCase()));
		if (!browsers.isEmpty()) {
			for (Browser browser: browsers) {
				Point p = new Point(browser.getVersion(), browser.getPercentage());
				series.addPoint(p);
			}
		}
		chart.addSeriesAsDrilldown(e.getPoint(), series);
	}

}
