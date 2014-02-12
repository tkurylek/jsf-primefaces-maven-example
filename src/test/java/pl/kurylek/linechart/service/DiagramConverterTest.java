package pl.kurylek.linechart.service;

import static org.fest.assertions.Assertions.assertThat;
import static pl.jsolve.sweetener.collection.Collections.newArrayList;

import java.util.List;

import org.junit.Test;
import org.primefaces.model.chart.CartesianChartModel;

import pl.kurylek.linechart.domain.Diagram;

public class DiagramConverterTest {

	private static final String DIAGRAM_B_NAME = "Diagram B";
	private static final String DIAGRAM_A_NAME = "Diagram A";

	DiagramConverter diagramConverter = new DiagramConverter();

	@Test
	public void shouldConvertToCartesianChartModel() {
		// given
		List<Diagram> diagramsList = newArrayList(new Diagram(DIAGRAM_A_NAME), new Diagram(DIAGRAM_B_NAME));

		// when
		CartesianChartModel result = diagramConverter.convertToCartesianChartModel(diagramsList);

		// then
		assertThat(result.getSeries()).onProperty("label").contains(DIAGRAM_A_NAME, DIAGRAM_B_NAME);
	}
}