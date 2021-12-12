package dml.common.id.aggr;

import java.util.UUID;

public class UUIDIdGenerator implements IdGenerator<String> {

	@Override
	public String generateId() {
		return UUID.randomUUID().toString();
	}

}
