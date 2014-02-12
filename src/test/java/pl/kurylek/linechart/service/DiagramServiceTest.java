package pl.kurylek.linechart.service;

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
import pl.kurylek.linechart.infrastructure.DiagramRepository;

@RunWith(MockitoJUnitRunner.class)
public class DiagramServiceTest {

	private static final CartesianChartModel CARTESIAN_CHART_MODEL = new CartesianChartModel();
	private static final List<Diagram> EMPTY_DIAGRAM_LIST = newArrayList();
	private static final Diagram DIAGRAM_A = new Diagram("Diagram A");
	private static final Diagram DIAGRAM_B = new Diagram("Diagram B");

	@Mock
	DiagramRepository mockedDiagramRepository;

	@Mock
	DiagramConverter mockedDiagramConverter;

	@InjectMocks
	DiagramService diagramService;

	@Test
	public void shouldGetEmptyDiagrams() {
		// given
		given(mockedDiagramRepository.findAllDiagrams()).willReturn(EMPTY_DIAGRAM_LIST);

		// when
		List<Diagram> result = diagramService.getAllDiagrams();

		// then
		assertThat(result).isNotNull().isEmpty();
	}

	@Test
	public void shouldGetAllDiagrams() {
		// given
		given(mockedDiagramRepository.findAllDiagrams()).willReturn(newArrayList(DIAGRAM_A, DIAGRAM_B));

		// when
		List<Diagram> result = diagramService.getAllDiagrams();

		// then
		assertThat(result).containsOnly(DIAGRAM_A, DIAGRAM_B);
	}

	@Test
	public void shouldGetCartesianChartModel() {
		// given
		given(mockedDiagramRepository.findAllDiagrams()).willReturn(EMPTY_DIAGRAM_LIST);
		given(mockedDiagramConverter.convertToCartesianChartModel(EMPTY_DIAGRAM_LIST)).willReturn(CARTESIAN_CHART_MODEL);

		// when
		CartesianChartModel result = diagramService.getCartesianChartModel();

		// then
		assertThat(result).isNotNull().isEqualTo(CARTESIAN_CHART_MODEL);
	}
}
