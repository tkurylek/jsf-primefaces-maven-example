package pl.kurylek.linechart.service;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import org.primefaces.model.chart.CartesianChartModel;

import pl.kurylek.linechart.domain.Diagram;
import pl.kurylek.linechart.infrastructure.DiagramRepository;

@ManagedBean
@ApplicationScoped
public class DiagramService implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty("#{diagramRepository}")
	private DiagramRepository diagramRepository;

	@ManagedProperty("#{diagramConverter}")
	private DiagramConverter diagramConverter;

	public List<Diagram> getAllDiagrams() {
		return diagramRepository.findAllDiagrams();
	}

	public CartesianChartModel getCartesianChartModel() {
		return diagramConverter.convertToCartesianChartModel(getAllDiagrams());
	}

	public void setDiagramRepository(DiagramRepository diagramRepository) {
		this.diagramRepository = diagramRepository;
	}

	public void setDiagramConverter(DiagramConverter diagramConverter) {
		this.diagramConverter = diagramConverter;
	}
}
