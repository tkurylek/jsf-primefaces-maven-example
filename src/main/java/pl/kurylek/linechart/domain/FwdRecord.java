package pl.kurylek.linechart.domain;

public class FwdRecord extends Record implements Comparable<FwdRecord> {

	public FwdRecord(Double index, Double weight) {
		super(index, weight);
	}

	@Override
	public int compareTo(FwdRecord o) {
		return getWeight().compareTo(o.getWeight()) * (-1);
	}
}