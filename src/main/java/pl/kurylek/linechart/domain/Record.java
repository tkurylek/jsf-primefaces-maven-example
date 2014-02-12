package pl.kurylek.linechart.domain;

public class Record {

	private final Double weight;
	private final Double index;

	public Record(Double index, Double weight) {
		this.index = index;
		this.weight = weight;
	}

	public Double getWeight() {
		return weight;
	}

	public Double getIndex() {
		return index;
	}
}