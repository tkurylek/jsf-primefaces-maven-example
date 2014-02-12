package pl.kurylek.linechart.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.primefaces.model.chart.CartesianChartModel;

import pl.kurylek.linechart.domain.Diagram;
import pl.kurylek.linechart.service.DiagramService;

@ManagedBean
@RequestScoped
public class DiagramController {

	@ManagedProperty("#{diagramService}")
	private DiagramService diagramService;

	public List<Diagram> getDiagrams() {
		return diagramService.getAllDiagrams();
	}

	public CartesianChartModel getLinearModel() {
		return diagramService.getCartesianChartModel();
	}

	public void setDiagramService(DiagramService diagramService) {
		this.diagramService = diagramService;
	}
}
