package dml.common.id;

public class LongIdGenerator implements IdGenerator {

	private long idValue;

	public LongIdGenerator() {
	}

	public LongIdGenerator(long minIdValue) {
		idValue = minIdValue;
	}

	@Override
	public String generateId() {
		return String.valueOf(idValue++);
	}

}
