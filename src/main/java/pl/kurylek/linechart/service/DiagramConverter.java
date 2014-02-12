package pl.kurylek.linechart.service;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.LineChartSeries;

import pl.kurylek.linechart.domain.Diagram;
import pl.kurylek.linechart.domain.Record;

@ManagedBean
@ApplicationScoped
public class DiagramConverter implements Serializable {

	private static final long serialVersionUID = 1L;

	public CartesianChartModel convertToCartesianChartModel(List<Diagram> diagrams) {
		CartesianChartModel linearModel = new CartesianChartModel();
		for (Diagram diagram : diagrams) {
			linearModel.addSeries(convertToLineChartSeries(diagram));
		}
		return linearModel;
	}

	private LineChartSeries convertToLineChartSeries(Diagram diagram) {
		LineChartSeries series = new LineChartSeries();
		series.setLabel(diagram.getName());
		setAllSeries(series, diagram.getSortedAftRecords());
		setAllSeries(series, diagram.getSortedFwdRecords());
		return series;
	}

	private void setAllSeries(LineChartSeries series, List<? extends Record> records) {
		for (Record record : records) {
			series.set(record.getIndex(), record.getWeight());
		}
	}
}
