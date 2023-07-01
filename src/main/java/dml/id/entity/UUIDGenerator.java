package dml.id.entity;

import java.util.UUID;

public abstract class UUIDGenerator implements IdGenerator<String> {

    @Override
    public String generateId() {
        return UUID.randomUUID().toString();
    }

}
