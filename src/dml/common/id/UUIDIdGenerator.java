package dml.common.id;

import java.util.UUID;

public class UUIDIdGenerator implements IdGenerator {

	@Override
	public String generateId() {
		return UUID.randomUUID().toString();
	}

}
