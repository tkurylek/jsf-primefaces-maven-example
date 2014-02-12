package pl.kurylek.linechart.renderer;

import java.io.IOException;

import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.primefaces.component.chart.line.LineChart;
import org.primefaces.component.chart.line.LineChartRenderer;

public class DiagramLineChartRenderer extends LineChartRenderer {

	@Override
	protected void encodeOptions(FacesContext context, LineChart chart) throws IOException {
		super.encodeOptions(context, chart);
		appendSortData(context);
	}

	private void appendSortData(FacesContext context) throws IOException {
		ResponseWriter writer = context.getResponseWriter();
		writer.write(",sortData:false");
		writer.close();
	}
}
