package pl.kurylek.linechart.infrastructure;

import static pl.jsolve.sweetener.collection.Collections.newArrayList;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import pl.kurylek.linechart.domain.AftRecord;
import pl.kurylek.linechart.domain.Diagram;
import pl.kurylek.linechart.domain.FwdRecord;

@ManagedBean
@ApplicationScoped
public class DiagramRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	public List<Diagram> findAllDiagrams() {
		List<Diagram> diagrams = newArrayList();
		diagrams.add(createFirstDiagram());
		diagrams.add(createSecondDiagram());
		return diagrams;
	}

	private Diagram createFirstDiagram() {
		Diagram diagram = new Diagram("Diagram 1");

		diagram.addAftRecord(new AftRecord(63.04, 37.230));
		diagram.addAftRecord(new AftRecord(68.21, 47.500));
		diagram.addAftRecord(new AftRecord(83.15, 57.900));
		diagram.addAftRecord(new AftRecord(90.94, 69.500));
		diagram.addAftRecord(new AftRecord(92.68, 72.100));
		diagram.addAftRecord(new AftRecord(84.67, 77.000));

		diagram.addFwdRecord(new FwdRecord(40.77, 37.230));
		diagram.addFwdRecord(new FwdRecord(34.81, 49.080));
		diagram.addFwdRecord(new FwdRecord(33.16, 53.000));
		diagram.addFwdRecord(new FwdRecord(34.25, 63.000));
		diagram.addFwdRecord(new FwdRecord(31.23, 72.000));
		diagram.addFwdRecord(new FwdRecord(36.58, 73.500));
		diagram.addFwdRecord(new FwdRecord(65.07, 77.000));
		return diagram;
	}

	private Diagram createSecondDiagram() {
		Diagram diagram = new Diagram("Diagram 2");

		diagram.addAftRecord(new AftRecord(70.87, 37.230));
		diagram.addAftRecord(new AftRecord(88.88, 62.500));

		diagram.addFwdRecord(new FwdRecord(42.41, 37.230));
		diagram.addFwdRecord(new FwdRecord(37.09, 47.800));
		diagram.addFwdRecord(new FwdRecord(36.83, 48.420));
		diagram.addFwdRecord(new FwdRecord(37.4, 53.650));
		diagram.addFwdRecord(new FwdRecord(36.72, 55.670));
		diagram.addFwdRecord(new FwdRecord(36.41, 62.500));
		return diagram;
	}
}