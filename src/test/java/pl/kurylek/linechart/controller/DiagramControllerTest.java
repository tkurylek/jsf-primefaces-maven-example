package pl.kurylek.linechart.controller;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static pl.jsolve.sweetener.collection.Collections.newArrayList;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.primefaces.model.chart.CartesianChartModel;

import pl.kurylek.linechart.domain.Diagram;
import pl.kurylek.linechart.service.DiagramService;

@RunWith(MockitoJUnitRunner.class)
public class DiagramControllerTest {

	private static final CartesianChartModel EMPTY_CARTESIAN_CHART_MODEL = new CartesianChartModel();
	private static final List<Diagram> EMPTY_DIAGRAM_LIST = newArrayList();

	@Mock
	DiagramService mockedDiagramService;

	@InjectMocks
	DiagramController diagramController;

	@Test
	public void shouldGetDiagrams() {
		// given
		given(mockedDiagramService.getAllDiagrams()).willReturn(EMPTY_DIAGRAM_LIST);

		// when
		List<Diagram> result = diagramController.getDiagrams();

		// then
		assertThat(result).isNotNull().isEmpty();
	}

	@Test
	public void shouldGetLinearModel() {
		// given
		given(mockedDiagramService.getCartesianChartModel()).willReturn(EMPTY_CARTESIAN_CHART_MODEL);

		// when
		CartesianChartModel result = diagramController.getLinearModel();

		// then
		assertThat(result).isNotNull().isEqualTo(EMPTY_CARTESIAN_CHART_MODEL);
	}
}
