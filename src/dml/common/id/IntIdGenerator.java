package dml.common.id;

public class IntIdGenerator implements IdGenerator<Integer> {

	private int idValue;

	public IntIdGenerator() {
	}

	public IntIdGenerator(int minIdValue) {
		idValue = minIdValue;
	}

	@Override
	public Integer generateId() {
		return idValue++;
	}

}
