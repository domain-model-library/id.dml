package dml.common.id;

public class IntIdGenerator implements IdGenerator {

	private int idValue;

	public IntIdGenerator() {
	}

	public IntIdGenerator(int minIdValue) {
		idValue = minIdValue;
	}

	@Override
	public String generateId() {
		return String.valueOf(idValue++);
	}

}
