package pl.kurylek.linechart.domain;

import static pl.jsolve.sweetener.collection.Collections.newLinkedList;

import java.util.Collections;
import java.util.List;

public class Diagram {

	private final String name;
	private final List<AftRecord> aftRecords = newLinkedList();
	private final List<FwdRecord> fwdRecords = newLinkedList();

	public Diagram(String name) {
		this.name = name;
	}

	public void addAftRecord(AftRecord record) {
		aftRecords.add(record);
	}

	public void addFwdRecord(FwdRecord record) {
		fwdRecords.add(record);
	}

	public String getName() {
		return name;
	}

	public List<AftRecord> getAftRecords() {
		return aftRecords;
	}

	public List<AftRecord> getSortedAftRecords() {
		Collections.sort(aftRecords);
		return aftRecords;
	}

	public List<FwdRecord> getFwdRecords() {
		return fwdRecords;
	}

	public List<FwdRecord> getSortedFwdRecords() {
		Collections.sort(fwdRecords);
		return fwdRecords;
	}
}