package dml.common.id;

public class LongIdGenerator implements IdGenerator<Long> {

	private long idValue;

	public LongIdGenerator() {
	}

	public LongIdGenerator(long minIdValue) {
		idValue = minIdValue;
	}

	@Override
	public Long generateId() {
		return idValue++;
	}

}
