package pl.kurylek.linechart.domain;

public class AftRecord extends Record implements Comparable<AftRecord> {

	public AftRecord(Double index, Double weight) {
		super(index, weight);
	}

	@Override
	public int compareTo(AftRecord o) {
		return getWeight().compareTo(o.getWeight());
	}
}